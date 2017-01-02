package com.ris;

/**
 * Created by teodor on 01/01/17.
 */
public interface UserService {

    User updatePoints(String id);

    User updatePointsByUsername(String username);

    boolean verifyUsernameIsFree(String username);

    void addUser(User user);

    void deleteAllUsers();

    boolean verifyUsernameIsRegistered(String username);
}
