package users.players;

abstract public class Player {

    private final String name;
    private double score;
    private int victories;
    private int assistanceScore;
    private int tournamentVictories;
    private int money;
    private boolean isMatched;

    public Player(String name){
        this.name = name;
        this.score = 0;
        this.victories = 0;
        this.assistanceScore = 0;
        this.tournamentVictories = 0;
        this.money = 0;
        this.isMatched = false;
    }


    public double getScore(){
        return this.score;
    }

    public String getName(){
        return this.name;
    }

    public int getVictories(){
        return this.victories;
    }

    public int getAssistanceScore(){
        return this.assistanceScore;
    }

    public int getTournamentVictories(){
        return this.tournamentVictories;
    }

    public int getMoney(){
        return this.money;
    }

    public boolean isMatched(){
        return this.isMatched;
    }

    public void setMatch(boolean status){
        this.isMatched = status;
    }

    abstract public void setNewScore(double score);

    public void setScore(double score){
        this.score = score;
    }

}
