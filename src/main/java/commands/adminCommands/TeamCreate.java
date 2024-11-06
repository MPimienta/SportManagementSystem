package commands.adminCommands;

import app.Model;
import commands.Command;
import lists.PlayerList;
import users.players.Team;

public class TeamCreate implements Command {

    private static final int NAME = 0;

    public void execute(String[] arguments, Model target){
        PlayerList teamList = (PlayerList) target;
        teamList.addElement(new Team(arguments[NAME]));
    }

}
