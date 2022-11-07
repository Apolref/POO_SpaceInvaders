package spaceinvaders;

/**
 * classe dos tiros, tanto dos aliens quando canhao
 * @author alexa
 */
public class Tiro extends Entidade {
    
    public int Velocidade;
    /**
     * Construtor padrao com super da classe entidade
     * @param x
     * @param y
     * @param hp
     * @param simb
     * @param Velocidade 
     */
    Tiro(int x, int y, int hp, char simb, int Velocidade) {
        super(x, y, hp, simb);
        this.Velocidade = Velocidade;
    }
}