package commands;

import users.players.PlayerList;

public interface Command {

    void execute(String[] arguments, PlayerList playerList);

}