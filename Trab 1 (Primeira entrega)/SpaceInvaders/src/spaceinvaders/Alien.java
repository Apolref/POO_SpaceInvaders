package spaceinvaders;

/**
 * classe alien
 * @author alexa
 */
public class Alien extends Entidade {
    
    public int Sentido;
    public int Velocidade;

    /**
     * Construtor padrao com super da classe entidade
     * @param x
     * @param y
     * @param hp
     * @param simb
     * @param Sentido
     * @param Velocidade 
     */
    Alien(int x, int y, int hp, char simb, int Sentido, int Velocidade) {
        super(x, y, hp, simb);
        this.Sentido = Sentido;
        this.Velocidade = Velocidade;
    }

    /**
     * sentido no qual os aliens estao atualmente andando, 1 é esquerda e 2 direita
     * @return 
     */
    public int getSentido() {
        return Sentido;
    }
    
    /**
     * inverte o sentido
     */
    public void inverterSentido() {
        if (this.Sentido == 1){ // indo para esquerda
            this.Sentido = 2;
        } else { // indo para direita
            this.Sentido = 1;
        }
    }

}