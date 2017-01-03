package com.ris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;

/**
 * Created by teodor on 01/01/17.
 */
//@Slf4j
@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    UserRepository userRepository;

    public User updatePoints(String id){
        try {
            User user = userRepository.findById(id);
            user.setPoints(user.getPoints() + 1);
            userRepository.save(user);
            return user;
        } catch (Exception e){
            e.printStackTrace();
            return new User();
        }
    }

    @Override
    public boolean updatePointsByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if(user!= null){
            user.setPoints(user.getPoints() + 1);
            userRepository.save(user);
            return true;
        }
        return false;
    }

    @Override
    public boolean verifyUsernameIsFree(String username) {
        User user =  userRepository.findByUsername(username);
        if(user != null){
            return false;
        }
        return true;
    }

    @Override
    public void addUser(User user) {
        user.setUsername(user.getUsername().toLowerCase().trim());
        userRepository.save(user);
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
    }

    @Override
    public boolean verifyUsernameIsRegistered(String username) {
        User user =  userRepository.findByUsername(username);
        if(user != null){
            return true;
        }
        return false;
    }
}
