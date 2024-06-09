package com.example.api.service;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sopatorest.spring.soap.api.loaneligibility.LoanEligibilityResponse;
import com.sopatorest.spring.soap.api.loaneligibility.LoanRequest;


@Service
public class LoanEligibilityService {


public LoanEligibilityResponse checkLoanEligibility(LoanRequest request){

    LoanEligibilityResponse response = new LoanEligibilityResponse();

    List<String> mismatchCriteria  = response.getCriteriaMismatch();

    if(!(request.getAge() > 21 && request.getAge() <=58)){
        mismatchCriteria.add("Person age should be in between 21 and 58");
    }

    if(! (request.getYearlyIncome() > 200000)){

        mismatchCriteria.add("Minimum yearly income should be greater than 2L");
    }

    if(! (request.getCibilScore() > 600)){

        mismatchCriteria.add("Your cibil is low, kindly apply after 6 months");
    }

    if(mismatchCriteria.size() > 0){

        response.setApprovedAmount(0);
        response.setIsEligible(false);
    }else{

        response.setApprovedAmount(300000);
        response.setIsEligible(true);
    }

    //Write code to call Rest endpoint with json payload
    //Http Method type POST, PUT, Delete etc
    try{
    ObjectMapper mapper = new ObjectMapper();
    mapper.writeValue(System.out, request);
    }catch(Exception e){

        System.out.println(e.getMessage());
    }

    return response;

}


}