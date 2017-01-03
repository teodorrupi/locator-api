package com.ris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by teodor on 01/01/17.
 */
@RequestMapping(Mappings.LOCATION)
@RestController
public class LocationController {

    @Autowired
    UserService userService;

    @Autowired
    LocationService locationService;

    @RequestMapping(Mappings.DELETE_ALL)
    public void deleteAllLocations(Model model) {
        locationService.deleteAllLocations();
    }

}
