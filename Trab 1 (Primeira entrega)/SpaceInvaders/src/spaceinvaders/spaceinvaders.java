package spaceinvaders;


/**
 * classe "main" do codigo
 * @author alexa
 */
public class spaceinvaders {
    /**
     * função main que chama a classe game
     * @param args
     * @throws InterruptedException - uso de delay
     */
    public static void main(String[] args) throws InterruptedException {
        
        Game g = new Game();
        g.startGame();
    }

}