package users;

public class CommonUser implements User {
    private final String userName;
    private final String password;
    private final UserRole role;

    public CommonUser(UserRole role){
        this.userName = "commonUser";
        this.password = "";
        this.role = role;
    }

    public String getUserName() {
        return this.userName;
    }

    public String getPassword() {
        return this.password;
    }

    public UserRole getRole(){
        return this.role;
    }
}
