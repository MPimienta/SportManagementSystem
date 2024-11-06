package commands;

import users.Admin;
import users.User;
import users.UserRole;
import users.players.PlayerList;
import users.players.SinglePlayer;

public class Login implements Command{
    private static final int USERNAME = 0;
    private static final int PASSWORD = 1;
    private static final int NAME = 2;
    private static final int LAST_NAME = 3;
    private static final int ROLE = 4;

    public void execute(String[] arguments, PlayerList playerList){
        if (arguments[ROLE].equals("player")){
            SinglePlayer user = new SinglePlayer(arguments[USERNAME], arguments[PASSWORD], arguments[NAME],
                                                    arguments[LAST_NAME],UserRole.PLAYER);

        } else if (arguments[ROLE].equals("admin")){
            Admin user = new Admin(arguments[USERNAME], arguments[PASSWORD],UserRole.PLAYER);
        } else {
            //rol no válido
        }
    }
}
