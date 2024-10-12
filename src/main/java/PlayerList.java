import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class PlayerList {
    private final LinkedList<Player> players;
    private final Matchmaking matchmaking;

    public PlayerList(){
        this.players = new LinkedList<>();
        this.matchmaking = new Matchmaking();
    }

    public void addPlayer(String name){
        int index = this.playerIndex(name);

        if(!this.playerExists(name, index)){
            this.players.add(index,new Player(name));
        } else {
            Error.PLAYER_ALREADY_EXISTS.writeln();
        }
    }

    public void showList(){
        Iterator<Player> iterator = this.players.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next().getName());
        }
    }

    public void removePlayer(String name){
        int index = this.playerIndex(name);

        if(!this.playerExists(name, index)){
            Error.PLAYER_DOES_NOT_EXIST.writeln();
        } else {
            this.players.remove(index);
        }
    }

    public void rankPlayers(){
        Player[] ranking = new Player[this.players.size()];
        for (int i = 0; i < this.players.size(); i++) {
            ranking[i] = this.players.get(i);
        }

        this.sort(ranking);

        for (int i = 0; i < ranking.length; i++) {
            System.out.println(ranking[i]);
        }
    }

    public void setNewPlayerScore(String name, double newScore){
        int index = this.playerIndex(name);

        if(!this.playerExists(name, index)){
            Error.PLAYER_DOES_NOT_EXIST.writeln();
        } else {
            this.players.get(index).setNewScore(newScore);
        }
    }

    public void clearMatchList(){
        this.matchmaking.clearMatchmake();

    }

    public void showMatchList(){
        this.matchmaking.showMatchmake();
    }

    public void makeMatch(String[] playerNames){
        Player[] matchPlayers = new Player[2];
        for (int i = 0; i < playerNames.length; i++) {
            int index = this.playerIndex(playerNames[i]);
            assert this.playerExists(playerNames[i], index);
            matchPlayers[i] = this.players.get(index);
        }
        this.matchmaking.matchMake(matchPlayers);

    }

    public void randomMatchmake(){
        if(this.players.size() % 2 != 0){
            Error.UNEVEN_PLAYER_AMOUNT.writeln();
        } else {
            this.makeRandomMatchmake();
        }
    }

    private void makeRandomMatchmake(){
        this.clearMatchList();
        LinkedList<Player> auxList = this.makeAuxList();
        int size = this.players.size() / 2;
        for (int i = 0; i < size; i++) {
            Player[] randomMatches = new Player[2];
            for (int j = 0; j < 2; j++) {
                int index = this.getRandomPlayer(auxList);
                randomMatches[j] = auxList.get(index);
                auxList.remove(index);
            }
            this.matchmaking.matchMake(randomMatches);
        }
    }

    private int getRandomPlayer(LinkedList<Player> auxList){
        Random random = new Random();

        int randomPlayerIndex;
        do{
            randomPlayerIndex = random.nextInt(auxList.size());
        }while(auxList.get(randomPlayerIndex).isMatched());

        return randomPlayerIndex;
    }

    private LinkedList<Player> makeAuxList(){
        LinkedList<Player> auxList = new LinkedList<>();
        Iterator<Player> iterator = this.players.iterator();
        while(iterator.hasNext()){
            auxList.add(iterator.next());
        }
        return auxList;
    }

    private boolean playerExists(String name, int index){
        if(index == this.players.size() || !this.players.get(index).getName().equals(name)){
            return false;
        } else {
            return true;
        }
    }

    private int playerIndex(String name){
        assert name != null;
        int i = 0;
        while(i < this.players.size() && this.players.get(i).getName().compareTo(name) > 0){
            i++;
        }
        return i;
    }

    private void sort(Player[] ranking){
        for (int i=1; i < ranking.length; i++) {
            Player aux = ranking[i];
            int j = i;
            while (j > 0 && ranking[j-1].getScore() < aux.getScore()){
                ranking[j] = ranking[j-1];
                j--;
            }
            ranking[j]=aux;
        }
    }
}
