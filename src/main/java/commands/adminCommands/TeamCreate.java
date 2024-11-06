package commands.adminCommands;

import commands.Command;
import users.players.PlayerList;
import users.players.Team;

public class TeamCreate implements Command {

    private static final int NAME = 0;

    public void execute(String[] argument, PlayerList playerList) {
        playerList.addPlayer(new Team(argument[NAME]));
    }

}
