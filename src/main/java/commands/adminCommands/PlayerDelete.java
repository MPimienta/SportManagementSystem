package commands.adminCommands;

import app.Model;
import commands.Command;
import lists.PlayerList;


public class PlayerDelete implements Command {

    private final static int USER_NAME = 0;

    public void execute(String[] argument, Model target) {
        PlayerList playerList = (PlayerList) target;
        playerList.removeElement(argument[USER_NAME]);
    }
}