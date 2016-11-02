package com.intuit.ebs.cxt.newcommerce.generic.tests;

import static org.hamcrest.Matchers.equalTo;

import java.util.ArrayList;
import java.util.Map;

import com.intuit.ebs.cxt.newcommerce.utils.CommonUtililties;
import com.intuit.ebs.cxt.newcommerce.utils.Configurations;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class RestResourcesUtils {
	public Map<String, String> headers;
	public Map<String, String> queryParams;

	public RestResourcesUtils(Map<String, String> headers, Map<String, String> queryParams) {
		this.headers = headers;
		this.queryParams = queryParams;
	}

	void validateTheResponse(Response res, String validationProperty) {
		// TODO Auto-generated method stub
		
	    String validationPropertyString = validationProperty + ".validations";
		
		String validationPropertyStringValue = restResources.Configurations.getProperty(validationPropertyString);
		
		String[] validationPropertyStringValueArray = validationPropertyStringValue.split(";");
		
		
		for(int i=0; i + 1 <= validationPropertyStringValueArray.length; i++) {
			String[] validationPropertyValues = validationPropertyStringValueArray[i].split(",");
	     	res.then().assertThat().content(validationPropertyValues[0], equalTo(validationPropertyValues[1])).log();	
		}	
		
	}

	RequestSpecification setQueryParametersforGetRquest(restResources restResources, RequestSpecification reqSpec, String queryString) {
		// TODO Auto-generated method stub
		
		System.out.println("In queryParamters Method");
		
		queryString = queryString + ".queryParameters";
		
		String queryStrings = restResources.Configurations.getProperty(queryString);
		
		String[] queryKeypares = queryStrings.split(";");	
		
		
		for(int i=0; i + 1 <= queryKeypares.length; i++) {
			String[] singleQuery = queryKeypares[i].split(",");
	     	queryParams.put(singleQuery[0], singleQuery[1]);		
		}
		
	    return reqSpec.queryParameters(queryParams);   	
	}

	RequestSpecification SetHeadersforGetRequest(restResources restResources, RequestSpecification reqSpec, String headStrings) {
		
		// TODO Auto-generated method stub
		
		System.out.println("In setHeaders Method");
		
		headStrings = headStrings + ".headers";
		
		String headerString = restResources.Configurations.getProperty(headStrings);
		
		String[] HeadersKeypares = headerString.split(";");
		
		System.out.println("length is : " + HeadersKeypares.length);
		
		
	  for(int i=0; i + 1 <= HeadersKeypares.length; i++) {
			System.out.println("Header pair read is: " + HeadersKeypares[i]);
			String[] singleHeader = HeadersKeypares[i].split(",");
			System.out.println("Single Header read is: " + singleHeader[0]);
			System.out.println("Single Header read is: " + singleHeader[1]);			
	     	headers.put(singleHeader[0], singleHeader[1]);		
		}
		
	    return reqSpec.headers(headers);   		
		
	}

	public RequestSpecification setPayloadforPost(restResources restResources, RequestSpecification reqSpec,
			String testCaseId) {
		// TODO Auto-generated method stub		
		
		System.out.println("In set payload method " + testCaseId + ".payload");
		
		String payloadObjString = testCaseId + ".payload";
		
	  // System.out.println("Payload file name is:" + Configurations.getProperty(payloadObjString));
		reqSpec = reqSpec.body(CommonUtililties.getPostPayload(restResources.Configurations.getProperty(payloadObjString)));
		return reqSpec;
	}
}