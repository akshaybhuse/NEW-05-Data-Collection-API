package com.ab.dto.response;

import com.ab.dto.request.CitizenChildDetailsRequest;
import com.ab.dto.request.CitizenEducationRequest;
import com.ab.dto.request.CitizenIncomeRequest;
import lombok.Data;

import java.util.List;

@Data
public class DcSummeryResponse {

    private CitizenIncomeRequest citizenIncomeRequest;

    private CitizenEducationRequest citizenEducationRequest;

    private List<CitizenChildDetailsRequest> citizenChildDetailsRequest;

    private String planNames;

}
