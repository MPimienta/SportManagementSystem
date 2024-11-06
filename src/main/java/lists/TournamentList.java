package lists;

import app.Lists;
import app.Model;
import leagues.Tournament;
import users.players.Player;

import java.util.Iterator;
import java.util.LinkedList;

public class TournamentList implements Lists {
    private final LinkedList<Tournament> tournamentList;

    public TournamentList(){
        this.tournamentList = new LinkedList<>();
    }

    public void addElement(Model element){
        Tournament tournament = (Tournament) element;
        int index = this.indexOfElement(tournament.getName());

        if(!this.elementExists(index)){
            tournamentList.add(index, tournament);
        } else {
            views.Error.PLAYER_ALREADY_EXISTS.writeln();//nuevo mensaje
        }
    }

    public void removeElement(String name){
        int index = this.indexOfElement(name);

        if(!this.elementExists(index)){
            views.Error.PLAYER_DOES_NOT_EXIST.writeln();//nuevo mensaje
        } else {
            this.tournamentList.remove(index);
        }
    }

    public boolean elementExists(int index){
        if(index == this.tournamentList.size()){
            return false;
        } else {
            return true;
        }
    }

    public int indexOfElement(String name){
        assert name != null;

        int i = 0;
        while(i < this.tournamentList.size() && !this.tournamentList.get(i).getName().equals(name)){
            i++;
        }

        return i;
    }

    public Tournament getTournament(int index){
        return this.tournamentList.get(index);
    }

    public void showList(){
        System.out.println(this);
    }

    public String toString(){
        String list = "";
        Iterator<Tournament> iterator = this.tournamentList.iterator();
        while(iterator.hasNext()){
            list = list + "\n" + iterator.next();
        }
        return list;
    }
}
