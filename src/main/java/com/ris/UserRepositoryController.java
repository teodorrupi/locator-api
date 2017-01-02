package com.ris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by teodor on 01/01/17.
 */
@RepositoryRestController
public class UserRepositoryController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    @ResponseBody
    public void addUser(@RequestBody User user) {
        if(userService.verifyUsernameIsFree(user.getUsername())){
            userService.addUser(user);
            //return ResponseEntity.ok().build();
        }
        //return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
    }

    @ModelAttribute
    protected void logging(HttpServletRequest request, HttpServletResponse response) {
        System.out.println(request.getHeaderNames().toString());
        System.out.println(response);
    }
}
