package com.ab.service;

import com.ab.dto.request.CitizenChildDetailsRequest;
import com.ab.dto.request.CitizenEducationRequest;
import com.ab.dto.request.CitizenIncomeRequest;
import com.ab.dto.request.PlanSelectionRequest;
import com.ab.dto.response.DcSummeryResponse;

import java.util.List;
import java.util.Map;

public interface DcService {

    Long loadCaseNumber(Integer ofcVisitedCitizenAppId);

    Map<Integer,String> getPlanNames();

    Long savePlanSelection(PlanSelectionRequest planSelectionRequest);

    Long saveIncomeDetails(CitizenIncomeRequest citizenIncomeRequest);

    Long saveEducationDetails(CitizenEducationRequest citizenEducationRequest);

    Long saveChildrensDetails(List<CitizenChildDetailsRequest> citizenChildDetailsRequest);

    DcSummeryResponse getSummery(Long caseNumber);
}
