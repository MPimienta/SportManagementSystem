import views.Message;

public class SportSystem {

    private final Command command;
    private final PlayerList playerList;
    private final MatchList matchList;

    public SportSystem(){
        this.playerList = new PlayerList();
        this.matchList = new MatchList();
        this.command = new Command(playerList, matchList);
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
