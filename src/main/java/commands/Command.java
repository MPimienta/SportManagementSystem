package commands;

import app.Model;

public interface Command {
    void execute(String[] arguments, Model model);
}