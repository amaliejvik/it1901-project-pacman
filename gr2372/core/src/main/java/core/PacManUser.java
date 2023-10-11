package core;

/**
 * Handles userdata s.a. username and score
 */
public class PacManUser {

    private String username;
    private double score;

    /**
    * Constructor for a new player
    * @param String username of player
    * @param double Score of player at gameover
    **/
    public PacManUser(String username, double score) {
        this.username = username;
        this.score = score;
    }

    //Various getters and setters
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    //toString method to give PacManUser-objects a text-representation
    @Override
    public String toString() {
        return "Username=" + getUsername() + ", Score=" + getScore() + "\n";
    }

}
