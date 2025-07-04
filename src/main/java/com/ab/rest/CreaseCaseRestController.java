package com.ab.rest;

import com.ab.dto.response.CreateCaseResponse;
import com.ab.service.DcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class CreaseCaseRestController {

    @Autowired
    private DcService service;

    @GetMapping("/create-case/{ofcVistitedAppId}")
    public ResponseEntity<CreateCaseResponse> createCase(@PathVariable Integer ofcVistitedAppId){
        Long caseNumber = service.loadCaseNumber(ofcVistitedAppId);
        Map<Integer, String> planNames = service.getPlanNames();

        CreateCaseResponse response=new CreateCaseResponse();
        response.setCaseNumber(caseNumber);
        response.setPlanNames(planNames);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
