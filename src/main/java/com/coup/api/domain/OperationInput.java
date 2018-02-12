package com.coup.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OperationInput implements Serializable {

    private ArrayList<Integer> scooters;
    public Integer C;
    public Integer P;

    public OperationInput(){

    }


    public OperationInput(ArrayList<Integer> scooters, Integer C, Integer P){
        this.scooters = scooters;
        this.C = C;
        this.P = P;
    }

    public ArrayList<Integer> getScooters(){
        return this.scooters;
    }

    public void setScooters(ArrayList<Integer> scooters) {
        this.scooters = scooters;
    }


    public Integer getC(){
        return this.C;
    }

    public Integer getP(){
        return this.P;
    }

}
