package users.players;

import users.UserRole;

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


    protected double getScore(){
        return this.score;
    }

    protected String getName(){
        return this.name;
    }

    protected int getVictories(){
        return this.victories;
    }

    protected int getAssistanceScore(){
        return this.assistanceScore;
    }

    protected int getTournamentVictories(){
        return this.tournamentVictories;
    }

    protected int getMoney(){
        return this.money;
    }

    public boolean isMatched(){
        return this.isMatched;
    }

    public void setMatch(boolean status){
        this.isMatched = status;
    }

    abstract protected void setNewScore(double score);

    protected void setScore(double score){
        this.score = score;
    }

}
