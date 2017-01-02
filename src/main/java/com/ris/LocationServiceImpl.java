package com.ris;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by teodor on 01/01/17.
 */
//@Slf4j
@Service
public class LocationServiceImpl implements  LocationService{

    @Autowired
    LocationRepository locationRepository;

    @Override
    public void addLocation(Location location) {
        locationRepository.save(location);
    }
}
