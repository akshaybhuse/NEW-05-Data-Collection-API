package com.ab.service;

import com.ab.dto.request.CitizenChildDetailsRequest;
import com.ab.dto.request.CitizenEducationRequest;
import com.ab.dto.request.CitizenIncomeRequest;
import com.ab.dto.request.PlanSelectionRequest;
import com.ab.dto.response.DcSummeryResponse;
import com.ab.entity.*;
import com.ab.repo.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DcServiceImpl implements DcService {

    @Autowired
    private DcCasesRepo dcCaseRepo;

    @Autowired
    private PlansRepo plansRepo;

    @Autowired
    private DcIncomeRepo incomeRepo;

    @Autowired
    private DcEducationRepo educationRepo;

    @Autowired
    private DcChildrensRepo childrensRepo;

    @Autowired
    private OfficeVisitedCitizenRepo visitedCitizenRepo;

    @Override
    public Long loadCaseNumber(Integer ofcVisitedCitizenAppId) {

        Optional<OfficeVisitedCitizenDataEntity> visitedCitizenData =
                visitedCitizenRepo.findById(ofcVisitedCitizenAppId);

        return visitedCitizenData
                .map(ofcVisitedDataEntity -> {
                    DcCasesEntity entity = new DcCasesEntity();
                    entity.setVisitedCitizenAppId(ofcVisitedCitizenAppId);
                    return dcCaseRepo.save(entity).getCaseNumber();
                })
                .orElse(0L);

        /*DcCasesEntity visitedCitizenAppId = dcCaseRepo.
                findByVisitedCitizenAppId(ofcVisitedCitizenAppId);

        return Optional.ofNullable(visitedCitizenAppId)
                .map(DcCasesEntity::getCaseNumber)
                .orElseThrow(() -> new RuntimeException("Office Visited Citizen ID not found"));*/

    }

    @Override
    public Map<Integer, String> getPlanNames() {

        return plansRepo.findAll()
                .stream()
                .collect(Collectors.toMap(
                        PlansEntity::getPlanId, PlansEntity::getPlanName));
    }

    @Override
    public Long savePlanSelection(PlanSelectionRequest planSelectionRequest) {

        return dcCaseRepo.findById(planSelectionRequest.getCaseNumber().intValue())
                .map(dcCaseEntity -> {
                    dcCaseEntity.setPlanId(planSelectionRequest.getPlanId());
                    dcCaseRepo.save(dcCaseEntity);
                    return planSelectionRequest.getCaseNumber();
                })
                .orElseThrow(() -> new RuntimeException("Case Number not found with ID: " + planSelectionRequest.getCaseNumber()));
    }

    @Override
    public Long saveIncomeDetails(CitizenIncomeRequest citizenIncomeRequest) {

        DcIncomeEntity incomeEntity = new DcIncomeEntity();
        BeanUtils.copyProperties(citizenIncomeRequest, incomeEntity);

        return Optional.ofNullable(incomeRepo.save(incomeEntity))
                //.map(DcIncomeEntity::getCaseNumber)
                .map(income -> {
                    return citizenIncomeRequest.getCaseNumber();
                })
                .orElseThrow(() -> new RuntimeException("Case number not found"));
    }

    @Override
    public Long saveEducationDetails(CitizenEducationRequest citizenEducationRequest) {

        DcEducationEntity educationEntity = new DcEducationEntity();
        BeanUtils.copyProperties(citizenEducationRequest, educationEntity);

        DcEducationEntity savedEducation = educationRepo.save(educationEntity);

        return Optional.ofNullable(savedEducation)
                .map(DcEducationEntity::getCaseNumber)
                .orElseThrow(() -> new RuntimeException("Case number not found"));
    }

    @Override
    public Long saveChildrensDetails(List<CitizenChildDetailsRequest> citizenChildDetailsRequest) {

        return citizenChildDetailsRequest
                .stream()
                .findFirst()
                .map(children -> {

                    DcChildrensEntity childrenEntity = new DcChildrensEntity();
                    BeanUtils.copyProperties(citizenChildDetailsRequest, childrenEntity);
                    childrensRepo.save(childrenEntity);
                    return childrenEntity.getCaseNumber();
                })
                .orElseThrow(() -> new RuntimeException("No child data found"));
    }

    @Override
    public DcSummeryResponse getSummery(Long caseNumber) {
        DcIncomeEntity incomeData = incomeRepo.findByCaseNumber(caseNumber);
        DcEducationEntity educationData = educationRepo.findByCaseNumber(caseNumber);
        List<DcChildrensEntity> childrenData = childrensRepo.findByCaseNumber(caseNumber);

        String planName = "";
        Optional<DcCasesEntity> casesEntity = dcCaseRepo.findById(caseNumber.intValue());
        if (casesEntity.isPresent()) {
            Integer planId = casesEntity.get().getPlanId();

            Optional<PlansEntity> plansEntity = plansRepo.findById(planId);
            if (plansEntity.isPresent()) {
                planName = plansEntity.get().getPlanName();
            }
        }

        DcSummeryResponse summeryResponse = new DcSummeryResponse();

        CitizenIncomeRequest incomeSummery = new CitizenIncomeRequest();
        BeanUtils.copyProperties(incomeData, incomeSummery);

        CitizenEducationRequest educationSummery = new CitizenEducationRequest();
        BeanUtils.copyProperties(educationData, educationSummery);

        List<CitizenChildDetailsRequest> childrenSummery = new ArrayList<>();
        for (DcChildrensEntity childData : childrenData) {
            CitizenChildDetailsRequest childSummery = new CitizenChildDetailsRequest();
            BeanUtils.copyProperties(childData, childSummery);
            childrenSummery.add(childSummery);
        }
        summeryResponse.setCitizenChildDetailsRequest(childrenSummery);

        summeryResponse.setPlanNames(planName);
        return summeryResponse;
    }
}
