package spaceinvaders;

import java.util.ArrayList;


/**
 * 
 * Classe principal que rodará o jogo
 */
public class Game {
    
    private int numAliens;
    private Entidade canhao; //
    private char tela[][]; //matriz tela
    private ArrayList <Alien> Aliens; // Lista dos aliens
    private ArrayList <Barreira> barreiras; // Lista das barreiras
    // Futura ArrayList com os tiros
    private ArrayList listaRemocao = new ArrayList(); // Lista que armazena os elementos a serem removidos
    private boolean game = true; // boleano que controla o loop principal
    
    /**
     * declara variaveis e as inicia
     * @throws InterruptedException - para usar delay
     */
    public void startGame()throws InterruptedException { 
 
        tela = new char[24][51];
        Aliens = new ArrayList<>();
        barreiras = new ArrayList<>();
        // Declarar lista dos Tiros
        inicializaEntidades();
        
        while (game){ // loop principal do jogo, enquanto o boleano jogo for true ele continuará

            zerarTela(); // zera a tela 
            printTela(); // printa a tela
            movimento();//Atualizar posições
            checagemGameover(); // checa condições para o fim do jogo
            Thread.sleep(250); // delay simples para observar a movimentação
        }
    }
    
    /**
     * inicializa a barreira colocando-a no arraylist
     * @param pX - coordenada x da barreira
     * @param pY - coordenada y da barreira
     */
    private void inicializaBarreira(int pX, int pY){
        for (int i=0; i<4; i++){
            barreiras.add(new Barreira(pX, pY+i, 2, 'B')); // BBBB
        }
        barreiras.add(new Barreira(pX+1, pY, 2, 'B'));// B
        barreiras.add(new Barreira(pX+1, pY+3, 2, 'B')); // --B  
    }
    
    /**
     * inicializa o canhao, alien e barreira nos seus devidos lugares
     */
    private void inicializaEntidades(){
        
        canhao = new Canhao(22, 7, 3, 'M'); //inicializa o canhao em um canto
        
        for (int i=0;i<5;i++) {
            for (int j=0; j<11; j++) {
                Aliens.add(new Alien(3+i, 4+j, 1, '$', 2, 1));// inicializa os aliens
                numAliens++;
            }
        }
        
        for (int i=8; i<48; i+=10){
            inicializaBarreira( 19, i); //inicializar barreira
        } 
        
    }
    /**
     * função de print da tela inteira principal
     */    
    public void printTela(){
        
        Entidade aux; //entidade auxiliar para armazenar na matriz tela[][]
        
        //Desenha Barreira
        for (int i=0; i < barreiras.size(); i++){ 
            aux = barreiras.get(i);
            tela[aux.x][aux.y] = aux.getsimb();
        }
        
        //Adiciona os Aliens na matriz tela[][]
        for (int i=0; i < Aliens.size(); i++){ 
            aux = Aliens.get(i);
            tela[aux.x][aux.y] = aux.getsimb();
        }
        
        //Adiciona os Tiros na matriz tela[][]
        /*
        for (int i=0; i < tiros.size(); i++){ 
            aux = tiros.get(i);
            tela[aux.x][aux.y] = aux.getsimb();
        }
        */
        
        //Adiciona o player (canhao) na matriz tela[][]
        tela[canhao.x][canhao.y] = canhao.getsimb();
        
        //Desenha o mapa
        for(int j=0; j<51; j++){ // parte de cima e parte de baixo do mapa
            tela [0][j] = '=';
            tela [23][j] = '=';
        }
        
        for (int j=0; j<24; j++){ // parte da esquerda e da direita
            tela[j][0] = '|';
            tela[j][50] = '|';
        }
        
        // Espaço entre prints
        System.out.print("\n\n\n");
        
        //Print da matriz Tela[][]
        for (int i=0; i<24; i++){
            for (int j=0; j<51; j++){
                System.out.print(tela[i][j]);
            }
            System.out.print("\n");
        }

    }
    
    /**
     * função que move os aliens dependendo do sentido
     */
    public void moverAliens(){
        Alien auxMov;
        for (int i=0; i < Aliens.size(); i++){ 
            auxMov = Aliens.get(i);
            if (auxMov.getSentido() == 2){ // indo para direita
                auxMov.setPos(auxMov.x,auxMov.y+1);
            } else{ // indo para esquerda
                auxMov.setPos(auxMov.x,auxMov.y-1);
            } 
        }   
    }
    
    /**
     * função que atualiza o movimento de todas as entidades do jogo
     */
    public void movimento(){
        
        Alien aux;
        Alien auxInv;
        
        //Checar colisao
        checaColisao();
        
        //Movimentação dos aliens
        for (int i=0; i < Aliens.size(); i++){ 
            aux = Aliens.get(i);
            if ((aux.y == 49) || (aux.y == 1)){ // prestes a colidir
                for (int j=0; j < Aliens.size(); j++){ 
                    auxInv = Aliens.get(j);
                    auxInv.inverterSentido();
                    auxInv.setPos(auxInv.x+1, auxInv.y);
                }
                moverAliens();
                return;
            } else if (aux.x == 22){ // chegou na linha da nave
                game = false; // fim do loop
                System.out.println("\nAcabou o jogo, você perdeu :( ");
                return;
            } 
        }
        
        moverAliens();
        
        //Movimentação do player
        
        //->Area dedicada a processar o WASD ou setas 
        
        //Movimentação dos tiros
        
        //->Atualizar a posicao dos tiros
        
    }
    
    /**
     * função que checa colisão entre entidades
     */
    public void checaColisao(){
        
        // checa colisao Tiro-Alien
        
        // checa colisao Tiro-Player
        
        // checa colisao Alien-Barreira
        
    }
    
    /**
     * função que zera a tela[][] inteira
     */
    public void zerarTela(){ 
        for (int i=0; i<24; i++){
            for (int j=0; j<51; j++){
                tela[i][j] = ' '; // espaço em branco na matriz inteira
            }
        }
    }
    
    /**
     * metodo de remoção de entidades, futuramente será implementado em conjunto com as colisoes funcionando
     * @param entidade - entidade a ser removida
     */
    public void removerEntidade(Entidade entidade){
        listaRemocao.add(entidade); // adicionar a entidade na lista para futura remoção
    }
    
    /**
     * função que checa se uma condição de fim de jogo foi atendida
     */
    private void checagemGameover(){
        if (numAliens==0){ // player venceu fim de jogo
            System.out.println("\nAcabou o jogo, você VENCEU !! :) ");
            game = false; // sai do loop principal
            return;
        }
        if (canhao.hp==0){ // checa se a
            System.out.println("\nAcabou o jogo, você perdeu :( ");
            game = false; // sai do loop principal
        }
    }
    
}
