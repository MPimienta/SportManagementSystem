package users;

import app.Model;

public interface User extends Model {

    String getUserName();
    String getPassword();
    UserRole getRole();
}
