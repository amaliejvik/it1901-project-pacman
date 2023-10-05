package core;

public class PacManUser {
    
    private String username;
    private double score;

    public PacManUser(String username, double score) {
        this.username = username;
        this.score = score;
    }

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

    @Override
    public String toString() {
        return
            "Username=" + getUsername() + ", Score=" + getScore() + "\n";
    }
    
}
