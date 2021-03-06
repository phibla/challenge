package com.coup.api.web;

import com.coup.api.domain.OperationInput;
import com.coup.api.domain.OperationResult;
import com.coup.api.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.awt.*;

@RestController
@RequestMapping("/operation")
public class OperationController {
    @Autowired
    private OperationService operationService;


    @RequestMapping(value="/calculateMinimumNumberOfFleetEngineers", method = RequestMethod.POST, produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> calculateMinimumNumberOfFleetEngineers(@Valid @RequestBody OperationInput operationInput){
        int fleet_engineers = operationService.calculateMinimumNumberOfFleetEngineers(operationInput.getScooters(),
                operationInput.getP(), operationInput.getC());
        OperationResult operationResult = new OperationResult(fleet_engineers);
        return new ResponseEntity<>(operationResult, HttpStatus.OK);
    }

}
