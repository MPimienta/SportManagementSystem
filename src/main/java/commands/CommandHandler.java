package commands;

import commands.adminCommands.CreatePlayer;
import commands.adminCommands.TeamCreate;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private Map<String, Command> playerCommands = new HashMap<>();
    private Map<String, Command> adminCommands = new HashMap<>();

    public CommandHandler(){
        adminCommands.put("player_create", new CreatePlayer());
        adminCommands.put("player_delete", new TeamCreate());
        adminCommands.put("team_create", new CreatePlayer());
        adminCommands.put("team_delete", new TeamCreate());
    }
}
