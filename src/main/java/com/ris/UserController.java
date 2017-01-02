package com.ris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by teodor on 01/01/17.
 */
@RequestMapping(Mappings.USER)
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    LocationService locationService;

    @RequestMapping(value = Mappings.VERIFY, method = RequestMethod.GET, produces = "application/json")
    public boolean verifyUsername(@RequestParam("username") String username, Model model) {
        boolean status = userService.verifyUsernameIsFree(username.toLowerCase().trim());
        if(status){
            User user = new User();
            user.setUsername(username);
            user.setPoints(0);
            Date date = new Date();
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
            String dateFormatted = formatter.format(date);
            user.setCreationDate(dateFormatted);
            userService.addUser(user);
            return true;
        }
        return false;
//        model.addAttribute("venue", venue);
//        model.addAttribute(REGISTER_VENUE, "index_user_add_second_page");
//        return TilesDefinition.USER_EDIT_VENUE;
    }

    @RequestMapping(value = Mappings.ADD_LOCATION, method = RequestMethod.GET, produces = "application/json")
    public boolean addLocation(@RequestParam("username") String username, @RequestParam("latitude") String latitude, @RequestParam("longitude") String longitude, Model model) {
        boolean status = userService.verifyUsernameIsRegistered(username.toLowerCase().trim());
        if(status){
            Location location = new Location();
            location.setUsername(username);
            location.setLatitude(latitude);
            location.setLongitude(longitude);
            Date date = new Date();
            DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd-HH:mm:ss");
            String dateFormatted = formatter.format(date);
            location.setDate(dateFormatted);
            locationService.addLocation(location);
            return true;
        }
        return false;
//        model.addAttribute("venue", venue);
//        model.addAttribute(REGISTER_VENUE, "index_user_add_second_page");
//        return TilesDefinition.USER_EDIT_VENUE;
    }

    @RequestMapping(Mappings.USERNAME + Mappings.REWARD)
    public User rewardUser(@PathVariable("username") String username, Model model) {
        return userService.updatePointsByUsername(username);
//        model.addAttribute("venue", venue);
//        model.addAttribute(REGISTER_VENUE, "index_user_add_second_page");
//        return TilesDefinition.USER_EDIT_VENUE;
    }

    @RequestMapping(Mappings.DELETE_ALL)
    public void deleteAllUsers(Model model) {
        userService.deleteAllUsers();
    }

}
