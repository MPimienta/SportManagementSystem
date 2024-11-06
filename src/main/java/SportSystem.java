import leagues.MatchList;
import users.CommonUser;
import users.User;
import users.UserRole;
import users.players.PlayerList;
import views.Message;

public class SportSystem {

    private final Command command;
    private final PlayerList singlePlayerList;
    private final PlayerList teamList;
    private final MatchList matchList;
    private User currentUser;

    public SportSystem(){
        this.singlePlayerList = new PlayerList();
        this.teamList = new PlayerList();
        this.matchList = new MatchList();
        this.currentUser = new CommonUser(UserRole.REGULAR);
        this.command = new Command(this.singlePlayerList, this.matchList);
    }

    private void start(){
        Message.TITLE.writeln();
        do{
            Message.ENTER_COMAND.write();
            this.command.readCommand();
        }while(true);
    }

    public void switchUser(User user){
        this.currentUser = user;
    }

    public static void main(String[] args) {
        new SportSystem().start();
    }
}
