import views.Input;
import views.Error;
import views.Message;

import java.util.LinkedList;

public class Command {

    private final static int COMMAND = 0;
    private final static int ARGUMENT = 1;
    private final PlayerList playerList;
    private final MatchList matchList;
    private String[] input;

    public Command(PlayerList playerList, MatchList matchList){
        this.playerList = playerList;
        this.matchList = matchList;
        this.initialize();
    }

    public void readCommand(){
        this.input = Input.readCommand();
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
                matchList.showMatchmake();
                break;
            case "clear_matchmake":
                matchList.clearMatchmake();
                break;
            case "matchmake":
                this.handleMatchmake();
                break;
            case "random_matchmake":
                this.handleRandomMatchmake();
                break;
            default:
                views.Error.INVALID_COMMAND.writeln();
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
                    views.Error.INVALID_ARGUMENT.writeln();
                }
            } else{
                views.Error.INVALID_ARGUMENT.writeln();
            }
        }
    }

    private void handleMatchmake(){
        if(this.isValidArgument()){
            String[] arguments = input[ARGUMENT].split(";");
            if(arguments.length == 2){
                int[] indexes = new int[arguments.length];
                for (int i = 0; i < indexes.length; i++) {
                    indexes[i] = playerList.playerIndex(arguments[i]);
                }
                if (playerList.playerExists(indexes[0]) || playerList.playerExists(indexes[0])){
                    views.Error.PLAYER_DOES_NOT_EXIST.writeln();
                } else {
                    Player[] matchPlayers = new Player[arguments.length];
                    for (int i = 0; i < arguments.length; i++) {
                        matchPlayers[i] = playerList.getPlayer(indexes[i]);
                    }
                    this.matchList.matchMake(matchPlayers);
                }
            } else{
                views.Error.WRONG_AMOUNT_OF_PLAYERS.writeln();
            }
        }
    }

    private boolean isValidArgument(){
        if(input.length != 2){
            views.Error.INVALID_ARGUMENT.writeln();
            return false;
        } else {
            return true;
        }
    }

    private void handleRandomMatchmake(){
        if(this.playerList.getPlayersAmount() % 2 != 0){
            views.Error.UNEVEN_PLAYER_AMOUNT.writeln();
        } else {
            final int PLAYERS_IN_MATCH = 2;
            this.matchList.clearMatchmake();
            LinkedList<Player> auxList = playerList.makeAuxList();
            int matchListSize = auxList.size() / 2;
            for (int i = 0; i < matchListSize; i++) {
                Player[] randomMatches = new Player[PLAYERS_IN_MATCH];
                for (int j = 0; j < PLAYERS_IN_MATCH; j++) {
                    int index = playerList.getRandomPlayer(auxList);
                    randomMatches[j] = auxList.get(index);
                    auxList.remove(index);
                }
                matchList.matchMake(randomMatches);
            }
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
