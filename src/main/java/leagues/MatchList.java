package leagues;

import views.Message;
import java.util.Iterator;
import java.util.LinkedList;
import users.players.Player;

public class MatchList {
    private final LinkedList<Match> matchList;

    public MatchList(){
        this.matchList = new LinkedList<>();
    }

    public void clearMatchmake(){
        Iterator<Match> iterator = matchList.iterator();
        while(iterator.hasNext()){
            iterator.next().unmakeMatch();
        }
        matchList.clear();
    }

    public void showMatchmake(){
        Message.MATCH_LIST.writeln();
        Iterator<Match> iterator = this.matchList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public void matchMake(Player[] players){
        this.matchList.add(new Match(players));
    }
}
