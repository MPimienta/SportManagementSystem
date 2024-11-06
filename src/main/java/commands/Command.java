package commands;

import app.Model;
import users.players.PlayerList;

public interface Command {
    void execute(String[] arguments, Model model);
}