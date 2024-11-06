package commands.adminCommands;

import commands.adminCommands.AdminCommands;
import users.lists.PlayerList;

public class TeamDelete extends AdminCommands {

    public TeamDelete(String argument, PlayerList playerList) {
        playerList.removePlayer(argument);
    }
}