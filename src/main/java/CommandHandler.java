import java.util.Scanner;

public class CommandHandler {

    private final static int COMMAND = 0;
    private final static int ARGUMENT = 1;
    private final PlayerList playerList;
    private String[] input;

    public CommandHandler(){
        this.playerList = new PlayerList();
    }

    public void readCommand(){
        Scanner scanner = new Scanner(System.in);
        this.input = scanner.nextLine().split(" ");
        if(this.input.length > 2){
            Error.TOO_MANY_ARGUMENTS.writeln();
        } else {
            this.handleCommand();
        }
    }

    private void handleCommand(){
        switch(this.input[COMMAND]){
            case "create":
                this.handleCreate();
                break;
            case "show":
                playerList.showList();
                break;
            case "remove":
                this.handleRemove();
                break;
            case "rank":
                playerList.rankPlayers();
                break;
            case "score":
                this.handleScore();
                break;
            case "show_matchmake":
                playerList.showMatchList();
                break;
            case "clear_matchmake":
                playerList.clearMatchList();
                break;
            case "matchmake":
                this.handleMatchmake();
                break;
            case "random_matchmake":
                playerList.randomMatchmake();
                break;
            default:
                Error.INVALID_COMMAND.writeln();
        }
    }

    private void handleCreate(){
        if(this.isValidArgument()){
            this.playerList.addPlayer(input[ARGUMENT]);
        }
    }

    private void handleRemove(){
        if(this.isValidArgument()){
            this.playerList.removePlayer(input[ARGUMENT]);
        }
    }

    private void handleScore(){
        if(this.isValidArgument()){
            String[] arguments = input[ARGUMENT].split(";");
            if(arguments.length == 2){
                String name = arguments[0];
                try{
                    double newScore = Double.parseDouble(arguments[1]);
                    this.playerList.setNewPlayerScore(name, newScore);
                } catch(NumberFormatException error){
                    Error.INVALID_ARGUMENT.writeln();
                }
            } else{
                Error.INVALID_ARGUMENT.writeln();
            }
        }
    }

    private void handleMatchmake(){
        if(this.isValidArgument()){
            String[] arguments = input[ARGUMENT].split(";");
            if(arguments.length == 2){
                this.playerList.makeMatch(arguments);
            } else{
                Error.WRONG_AMOUNT_OF_PLAYERS.writeln();
            }
        }
    }

    private boolean isValidArgument(){
        if(input.length != 2){
            Error.INVALID_ARGUMENT.writeln();
            return false;
        } else {
            return true;
        }
    }

    public void initialize(){
        playerList.addPlayer("Luisa");
        playerList.addPlayer("Manuel");
        playerList.addPlayer("Kurt");
        playerList.addPlayer("Sofia");
        playerList.addPlayer("Robert");

        playerList.setNewPlayerScore("Luisa", 4.5);
        playerList.setNewPlayerScore("Manuel", 2.7);
        playerList.setNewPlayerScore("Kurt", 4.0);
        playerList.setNewPlayerScore("Sofia", 3.8);
        playerList.setNewPlayerScore("Robert", 3.8);
    }
}
