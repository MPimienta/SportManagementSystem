package users.players;

import java.util.LinkedList;

public class Team extends Player {

    public Team( String teamName){
        super(teamName);
    }

    public String getUserName() {
        return null;
    }

    public String getPassword() {
        return null;
    }

    public double getScore() {
        return super.getScore();
    }

    public String getName() {
        return super.getName();
    }

    public int getVictories() {
        return super.getVictories();
    }

    public int getAssistanceScore() {
        return super.getAssistanceScore();
    }

    public int getTournamentVictories() {
        return super.getTournamentVictories();
    }

    public int getMoney() {
        return super.getMoney();
    }


    public void setNewScore(double score) {
        
    }
}
