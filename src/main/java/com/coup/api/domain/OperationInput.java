package com.coup.api.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OperationInput implements Serializable {

    @NotNull
    private ArrayList<Integer> scooters;
    @Min(1)
    @Max(999)
    private final int C;
    @Min(1)
    @Max(1000)
    private final int P;


    @JsonCreator
    public OperationInput(@JsonProperty("scooters")ArrayList<Integer> scooters, @JsonProperty("C") Integer C, @JsonProperty("P") Integer P){
        this.scooters = scooters;
        this.C = C;
        this.P = P;
    }

    public ArrayList<Integer> getScooters(){
        return this.scooters;
    }


    public Integer getC(){
        return this.C;
    }

    public Integer getP(){
        return this.P;
    }

}
