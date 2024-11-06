import leagues.MatchList;
import users.players.PlayerList;
import views.Message;

public class SportSystem {

    private final Command command;
    private final PlayerList singlePlayerList;
    private final PlayerList teamList;
    private final MatchList matchList;

    public SportSystem(){
        this.singlePlayerList = new PlayerList();
        this.teamList = new PlayerList();
        this.matchList = new MatchList();
        this.command = new Command(this.singlePlayerList, matchList);
    }

    private void start(){
        Message.TITLE.writeln();
        do{
            Message.ENTER_COMAND.write();
            this.command.readCommand();
        }while(true);
    }

    public static void main(String[] args) {
        new SportSystem().start();
    }
}
