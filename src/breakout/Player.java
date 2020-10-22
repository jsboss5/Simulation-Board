/**
 * @author Liam Clark, Josh Boss
 * @Class Player
 * @Purpose To store data pertaining to every new instance of a player, namely the players score and the lives they have remaining
 * @Assumptions Players start the game with 3 lives and a score of zero, and the players score is incremented by 10 every time it
 * does damage to a block
 * @Dependencies breakout package
 * @Example create a new player with Player myPlayer = new Player(), then change information about the player using a method like
 * myPlayer.loseLife() or myPlayer.addLife()
 */
package breakout;



public class Player {
    private int livesLeft;
    private int score;
    private static final int SCORE_INCREMENT = 10;
    private static final int OG_SCORE = 0;
    public Player(){
        /**
         * creates player object with default number of lives
         */
        livesLeft = 3;
        score = 0;
    }

    public int getScore(){
        return score;
    }
    public int getLivesLeft(){
        return livesLeft;
    }

    public void addLife(){
        livesLeft++;
    }
    public void loseLife(){
        livesLeft--;
    }
    public void resetScore(){
        score = OG_SCORE;
    }
    public void addScore(){
        score += SCORE_INCREMENT;
    }
}
