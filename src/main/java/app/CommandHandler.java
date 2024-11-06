package app;

import commands.Command;
import commands.adminCommands.CreatePlayer;
import commands.adminCommands.TeamCreate;
import users.CommonUser;
import users.User;
import users.UserRole;
import views.Input;

import java.util.HashMap;
import java.util.Map;

public class CommandHandler {
    private static final int COMMAND = 0;
    private static final int ARGUMENT = 1;

    private static final int PLAYER_LIST = 0;
    private static final int TEAM_LIST = 1;
    private static final int TOURNAMENT_LIST = 2;

    private Map<String, Command> playerCommands = new HashMap<>();
    private Map<String, Command> adminCommands = new HashMap<>();
    private Map<String, Command> commonCommands;
    private String[] input;
    private final Model[] elements;
    private User currentUser;

    public CommandHandler(Model[] elements, User currentUser){
        this.elements = elements;
        this.currentUser = currentUser;

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

    public void readCommand(){
        this.input = Input.readCommand();
        this.handleCommand();
    }

    public void handleCommand(){

        if (currentUser.getRole() == UserRole.ADMIN){

        } else if (currentUser.getRole() == UserRole.PLAYER){

        } else {

        }
    }


}
