package users;

public class Admin implements User{

    private final String userName;
    private final String password;
    private final UserRole role;

    public Admin(String userName, String password, UserRole role){
        this.userName = userName;
        this.password = password;
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

    public String toString(){
        return ("user_name: " + this.userName + "\npassword: " + this.password + "\nrole: admin");
    }
}
