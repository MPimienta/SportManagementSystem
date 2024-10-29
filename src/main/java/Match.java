public class Match {
    private static final int PLAYERS_IN_MATCH = 2;
    private final Player[] matches;

    public Match(Player[] players){
        this.matches = new Player[PLAYERS_IN_MATCH];
        this.createMatch(players);
    }

    public String toString(){
        return matches[0] + " : " + matches[1];
    }

    private void createMatch(Player[] players){
        if(players[0].isMatched() && players[1].isMatched()){
            views.Error.ALREADY_EXISTING_MATCH.writeln();
        } else {
            for (int i = 0; i < PLAYERS_IN_MATCH; i++) {
                this.matches[i] = players[i];
                players[i].changeStatus(true);
            }
        }

    }

    public void unmakeMatch(){
        for (int i = 0; i < PLAYERS_IN_MATCH; i++) {
            this.matches[i].changeStatus(false);
        }
    }
}
