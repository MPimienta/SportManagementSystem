public class Player {
    private final String name;
    private double score;
    private boolean isMatched;

    public Player(String name){
        this.name = name;
        this.score = 0.0;
        this.isMatched = false;
    }

    public void setNewScore(double score){
        if(score < -999999.0){
            views.Error.INVALID_SCORE.writeln();
        } else {
            this.score = score;
        }
    }

    public double getScore(){
        return this.score;
    }

    public String getName(){
        return this.name;
    }

    public String toString(){
        return this.name + " (" + this.score + ")";
    }

    public boolean isMatched(){
        return this.isMatched;
    }

    public void changeStatus(boolean isMatched){
        this.isMatched = isMatched;
    }
}
