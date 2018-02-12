package com.coup.api.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static jdk.nashorn.internal.objects.Global.println;


@Service
public class OperationService {

    public OperationService(){

    }

    public int calculateMinimumNumberOfFleetEngineers(ArrayList<Integer> scooters, int P, int C){
        // Check, if list is bigger than zero
        if(scooters.size() == 0) return 0;

        // Sort the list, so that the district where the FM has the highest impact is at the beginning
        scooters.sort(((o1, o2) -> Math.abs(o2 - C) % P - Math.abs(o1 - C) % P));

        // Remove the district where the FM is working and calculate the number of scooter left over.
        int first_element = scooters.get(0) - C;
        scooters.remove(0);
        if(first_element > 0){
            scooters.add(first_element);
        }

        // Calculate the numbers of FE to maintain the rest
        int fleet_engineers = 0;
        for (int scooter: scooters) {
            fleet_engineers += Math.ceil(scooter/(double)P);
        }

        return fleet_engineers;
    }
}
