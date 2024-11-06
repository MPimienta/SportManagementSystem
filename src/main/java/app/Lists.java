package app;

import users.players.Player;

public interface Lists extends Model{
    void addElement(Model element);
    void removeElement(String name);
    boolean elementExists(int index);
    int indexOfElement(String name);
    void showList();
    String toString();
}
