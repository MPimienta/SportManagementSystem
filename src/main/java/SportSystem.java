import views.Message;

public class SportSystem {

    private final Command command;
    private PlayerList playerList;
    private MatchList matchList;

    public SportSystem(){
        this.command = new Command(playerList, matchList);
        this.playerList = new PlayerList();
        this.matchList = new MatchList();
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
