package commands;

import app.Model;
import users.CommonUser;
import users.User;
import users.UserRole;

public class Logout implements Command {
    public void execute(String[] arguments, Model target){
        User currentUser = (User) target;
        currentUser = new CommonUser(UserRole.REGULAR);
    }
}
