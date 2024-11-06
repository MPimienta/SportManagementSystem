package commands;

import commands.adminCommands.CreatePlayer;
import commands.adminCommands.TeamCreate;
import users.User;
import users.UserRole;
import views.Input;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private static final int COMMAND = 0;
    private static final int ARGUMENT = 1;

    private Map<String, Command> playerCommands = new HashMap<>();
    private Map<String, Command> adminCommands = new HashMap<>();
    private Map<String, Command> commonCommands;
    private User currentUser;
    private String[] input;

    public CommandHandler(){
        this.playerCommands = new HashMap<>();
        this.adminCommands = new HashMap<>();
        this.commonCommands = new HashMap<>();

        this.addAdminCommands();
        this.addCommonCommands();
        this.addPlayerCommands();
    }

    private void addAdminCommands(){
        adminCommands.put("player_create", new CreatePlayer());
        adminCommands.put("player_delete", new TeamCreate());
        adminCommands.put("team_create", new CreatePlayer());
        adminCommands.put("team_delete", new TeamCreate());
    }

    private void addPlayerCommands(){

    }

    private void addCommonCommands(){

    }

    public void handleCommand(){
        this.input = Input.readCommand();
        if (currentUser.getRole() == UserRole.ADMIN){

        } else if (currentUser.getRole() == UserRole.PLAYER){

        } else {

        }
    }


}
