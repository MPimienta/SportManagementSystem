package commands.adminCommands;

import commands.adminCommands.AdminCommands;
import users.lists.PlayerList;
import users.players.Team;

public class TeamCreate extends AdminCommands {

    public TeamCreate(String argument, PlayerList playerList) {
        playerList.addPlayer(new Team(argument));
    }



}
