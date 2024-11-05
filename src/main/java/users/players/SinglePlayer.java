package users.players;

import users.players.Player;

public class SinglePlayer extends Player {
    private final String lastName;
    private double score;
    private int victories;
    private int assistanceScore;
    private int tournamentVictories;
    private int money;

    public SinglePlayer(String userName, String password, String name, String lastName){
        super(userName, password, name);
        this.lastName = lastName;
    }

    public void handleCommand() {

    }

}
