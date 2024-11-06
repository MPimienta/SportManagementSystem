package commands.adminCommands;

import app.Model;
import commands.Command;
import users.UserRole;
import users.players.PlayerList;
import users.players.SinglePlayer;


public class CreatePlayer implements Command {

    private final static int NAME = 0;
    private final static int LASTNAME = 1;
    private final static int USERNAME = 2;
    private final static int PASSWORD = 3;

    public void execute(String[] arguments, Model target){
        PlayerList singlePlayerList = (PlayerList) target;
        singlePlayerList.addElement(new SinglePlayer(arguments[NAME], arguments[LASTNAME],
                                    arguments[USERNAME], arguments[PASSWORD], UserRole.PLAYER));

    }

}