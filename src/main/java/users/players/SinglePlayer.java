package users.players;

import users.User;
import users.UserRole;

public class SinglePlayer extends Player implements User  {

    private final String userName;
    private final String password;
    private final String lastName;
    private final UserRole role;


    public SinglePlayer(String userName, String password, String name, String lastName, UserRole role){
        super(name);
        this.userName = userName;
        this.password = password;
        this.lastName = lastName;
        this.role = role;

    }

    public void setNewScore(double score){
        if(score < -999999.0){
            views.Error.INVALID_SCORE.writeln();
        } else {
            super.setScore(score);
        }
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
        String fullName = super.getName() + this.lastName;
        return fullName;
    }

    public UserRole getRole(){
        return this.role;
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
}
