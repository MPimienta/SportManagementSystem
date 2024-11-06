package app;

import lists.TournamentList;
import users.CommonUser;
import users.User;
import users.UserRole;
import lists.PlayerList;
import views.Message;

public class SportSystem {

    private final CommandHandler commandHandler;
    private Model[] elements;
    private User currentUser;

    public SportSystem(){
        this.elements = new Model[]{new PlayerList(), new PlayerList(), new TournamentList()};
        this.currentUser = new CommonUser(UserRole.REGULAR);

        this.commandHandler = new CommandHandler(this.elements, this.currentUser);
    }

    private void start(){
        Message.TITLE.writeln();
        do{
            Message.ENTER_COMAND.write();
            this.commandHandler.readCommand();
        }while(true);
    }

    public static void main(String[] args) {
        new SportSystem().start();
    }
}
