package users.players;


import users.User;

abstract class Player extends User {
    private final String name;

    public Player(String userName, String password, String name){
        super(userName, password);
        this.name = name;
    }

    protected abstract void handleCommand();

    protected String getName(){
        return this.name;
    }
}
