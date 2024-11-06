package commands.adminCommands;

import commands.adminCommands.AdminCommands;
import users.lists.PlayerList;


public class PlayerDelete extends AdminCommands {

    private final static int NAME = 0;
    private final static int LASTNAME = 1;

    public PlayerDelete(String arguments, PlayerList playerList){
        String[] data = arguments.split(";");
        String fullName = data[NAME] + data[LASTNAME];
        playerList.removePlayer(fullName);
    }
}