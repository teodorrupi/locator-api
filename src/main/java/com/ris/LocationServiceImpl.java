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

    @Override
    public void updateLocation(Location currentLocation) {
        Location lastLocation = locationRepository.findByUsername(currentLocation.getUsername());
        if(lastLocation != null){
            lastLocation.setDate(currentLocation.getDate());
            lastLocation.setLatitude(currentLocation.getLatitude());
            lastLocation.setLongitude(currentLocation.getLongitude());
            locationRepository.save(lastLocation);
        }else {
            locationRepository.save(currentLocation);
        }
    }

    @Override
    public void deleteAllLocations() {
        locationRepository.deleteAll();
    }
}
