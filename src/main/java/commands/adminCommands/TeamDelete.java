package commands.adminCommands;

import app.Model;
import commands.Command;
import lists.PlayerList;

public class TeamDelete implements Command {
    private final static int NAME = 0;

    public void execute(String[] argument, Model target) {
        PlayerList teamList = (PlayerList) target;
        teamList.removeElement(argument[NAME]);
    }
}