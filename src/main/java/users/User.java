package users;

abstract public class User {
    private final String userName;
    private final String password;


    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    protected abstract void handleCommand();

    protected String getUserName(){
        return this.userName;
    }

    protected String getPassword(){
        return this.password;
    }
}
