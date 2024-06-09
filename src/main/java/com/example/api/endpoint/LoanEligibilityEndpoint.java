package com.example.api.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.api.service.LoanEligibilityService;
import com.sopatorest.spring.soap.api.loaneligibility.LoanEligibilityResponse;
import com.sopatorest.spring.soap.api.loaneligibility.LoanRequest;


@Endpoint
public class LoanEligibilityEndpoint {

 private static final String NAMESPACE="http://www.sopatorest.com/spring/soap/api/loanEligibility";

 @Autowired
 private LoanEligibilityService service;


 @PayloadRoot(namespace = NAMESPACE,localPart = "LoanRequest")
 @ResponsePayload
 public LoanEligibilityResponse getLoanStatus(@RequestPayload LoanRequest request){
    
    
    return service.checkLoanEligibility(request);

 }
}
