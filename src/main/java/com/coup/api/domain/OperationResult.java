package com.coup.api.domain;

public class OperationResult {
    private int fleet_engineers;

    public OperationResult(int fleet_engineers){
        this.fleet_engineers = fleet_engineers;
    }

    public int getFleet_engineers() {
        return fleet_engineers;
    }
}
