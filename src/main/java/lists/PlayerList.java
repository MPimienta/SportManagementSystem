package lists;

import app.Lists;
import app.Model;
import users.players.Player;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class PlayerList implements Lists {
    private final LinkedList<Player> players;

    public PlayerList(){
        this.players = new LinkedList<>();
    }

    public void addElement(Model element){
        Player player = (Player) element;
        int index = this.indexOfElement(player.getName());

        if(!this.elementExists(index)){
            players.add(index, player);
        } else {
            views.Error.PLAYER_ALREADY_EXISTS.writeln();
        }
    }

    public boolean elementExists(int index){
        if(index == this.players.size()){
            return false;
        } else {
            return true;
        }
    }

    public int indexOfElement(String name){
        assert name != null;

        int i = 0;
        while(i < this.players.size() && !this.players.get(i).getName().equals(name)){
            i++;
        }

        return i;
    }

    public Player getPlayer(int index){
        return this.players.get(index);
    }

    public void showList(){
        System.out.println(this);
    }

    public String toString(){
        String list = "";
        Iterator<Player> iterator = this.players.iterator();
        while(iterator.hasNext()){
            list = list + "\n" + iterator.next();
        }
        return list;
    }

    public void removeElement(String name){
        int index = this.indexOfElement(name);

        if(!this.elementExists(index)){
            views.Error.PLAYER_DOES_NOT_EXIST.writeln();
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

    public void setNewPlayerScore(String name, double newScore){
        int index = this.indexOfElement(name);

        if(!this.elementExists(index)){
            views.Error.PLAYER_DOES_NOT_EXIST.writeln();
        } else {
            this.players.get(index).setNewScore(newScore);
        }
    }

    public int getRandomPlayer(LinkedList<Player> auxList){
        Random random = new Random();

        int randomPlayerIndex;
        do{
            randomPlayerIndex = random.nextInt(auxList.size());
        }while(auxList.get(randomPlayerIndex).isMatched());

        return randomPlayerIndex;
    }

    public LinkedList<Player> makeAuxList(){
        LinkedList<Player> auxList = new LinkedList<>();
        Iterator<Player> iterator = this.players.iterator();
        while(iterator.hasNext()){
            auxList.add(iterator.next());
        }
        return auxList;
    }

    public int getPlayersAmount(){
        return players.size();
    }




}
