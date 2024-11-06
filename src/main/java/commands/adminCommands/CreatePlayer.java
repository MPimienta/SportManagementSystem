package commands.adminCommands;

import commands.adminCommands.AdminCommands;
import users.lists.PlayerList;
import users.players.SinglePlayer;

public class CreatePlayer extends AdminCommands {

    private final static int NAME = 0;
    private final static int LASTNAME = 1;
    private final static int USERNAME = 2;
    private final static int PASSWORD = 3;

    public CreatePlayer(String arguments, PlayerList playerList){
        String[] data = arguments.split(";");
        playerList.addPlayer(new SinglePlayer(data[USERNAME], data[PASSWORD], data[NAME], data[LASTNAME]));
    }


}