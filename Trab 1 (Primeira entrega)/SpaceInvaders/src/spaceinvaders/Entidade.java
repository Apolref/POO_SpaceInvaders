package spaceinvaders;

/**
 * classe entidade que será herdada por tiro alien canhao e barreira
 * @author alexa
 */
public class Entidade {
    public int x; // coordenada x
    public int y; // coordenada y
    public int hp;
    public char simb;
    /**
     * construtor de entidades generico, posteriormente usado em supers nas classes
     * @param x - coord x
     * @param y - coord y
     * @param hp - hp da entidade
     * @param simb - simbolo da entidade
     */
    Entidade(int x, int y, int hp, char simb) {
        this.x = x;
        this.y = y;
        this.hp = hp;
        this.simb = simb;
    }
    
    /**
     * 
     * @return - o hp da entidade
     */
    public int gethp() {
        return hp;
    }
    /**
     * 
     * @return  - simbolo da entidade
     */
    public char getsimb() {
        return simb;
    }
    
    /**
     *  muda a posicao de uma entidade
     * @param px - posição x nova
     * @param py - posição y nova 
     */
    public void setPos(int px, int py) {
        this.x = px;
        this.y = py;
    }

}