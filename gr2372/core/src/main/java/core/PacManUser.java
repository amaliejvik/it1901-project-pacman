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

    /**
    * Empty constructor for a new player
    **/
    public PacManUser() {
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

    /**
     * Input validation on username, e.g. no spaces or empty strings
     * 
     * @param name username from player
     * @return true if the username is valid, else false
     */
    public static boolean validateUsername(String name) {
        if (name.contains(" ")) {
            return false;
        } else if (name.equals("")) {
            return false;
        } else if (name.length() <= 2) {
            return false;
        }
        return true;
    }

    //toString method to give PacManUser-objects a text-representation
    @Override
    public String toString() {
        return "Username=" + getUsername() + ", Score=" + getScore() + "\n";
    }

}
