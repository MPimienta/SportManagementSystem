package commands.adminCommands;

import commands.Command;
import users.players.PlayerList;


public class PlayerDelete implements Command {

    private final static int NAME = 0;

    public void execute(String[] argument, PlayerList playerList) {
        playerList.removePlayer(argument[NAME]);
    }
}