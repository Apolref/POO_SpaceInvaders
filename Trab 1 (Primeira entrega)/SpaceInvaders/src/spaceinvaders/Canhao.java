package spaceinvaders;

/**
 * classe do canhao, o player
 * @author alexa
 */
public class Canhao extends Entidade {
    
    public int score;
    
    Canhao(int x, int y, int hp, char simb) {
        super(x, y, hp, simb);
        this.score = 0;
    }
    /**
     * metodo de atirar que será futuramente implementado
     */
    public void Atirar() {
        // METODO ATIRAR
    }
    /**
     * metodo de score, cada alien morto é +10
     */
    public void aumenScore(){
        score += 10;
    }
    
    /**
     * getter de score padrao
     * @return - score
     */
    public int getScore(){
        return score;
    }
}