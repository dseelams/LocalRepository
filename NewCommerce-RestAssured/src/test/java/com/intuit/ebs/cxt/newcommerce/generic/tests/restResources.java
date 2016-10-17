package com.intuit.ebs.cxt.newcommerce.generic.tests;

import static com.jayway.restassured.RestAssured.given;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

import org.json.JSONObject;
import org.json.XML;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.intuit.ebs.cxt.newcommerce.utils.CommonUtililties;
import com.intuit.ebs.cxt.newcommerce.utils.Configurations;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.config.EncoderConfig;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;


public class restResources {
  private RestResourcesUtils data = new RestResourcesUtils(new HashMap<String, String>(), new HashMap<String, String>());
  static final Properties Configurations;
  
 
	static{

		Configurations = new Properties();
		InputStream isConfig = Configurations.class.getResourceAsStream("/properties/Config.properties");
		
		try{
			Configurations.load(isConfig);
		}catch(Exception e){
			System.out.println("here:" + e.getMessage());
		}
		
	}

@Test(dataProvider = "dp")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  @BeforeClass
  public void beforeClass() {
	  
	  RestAssured.registerParser("text/plain", Parser.TEXT);
	  
  }

  @Test(enabled=false)
  public void getResourceTest() {
	  
	  
	 System.out.println("reading configuration file :" + Configurations.getProperty("resource.account.url"));
	  
	 RestAssured ra = new RestAssured();
	  
	// Response rs =  ra.given().get("http://rtb2.shop.turbotax.intuit.com/tto/internal/cobranding_info.jsp?priorityCode=3468345257");
	 
	 Response rs = ra.given().baseUri(Configurations.getProperty("resource.account.url")).basePath(Configurations.getProperty("resource.account.URI")).get();
	 
	 System.out.println(rs.asString());	 
	 
	 System.out.println(rs.getContentType());
	 
	 System.out.println(rs.getHeaders().asList().get(1));
	 
	 System.out.println("Response body is :" + rs.getBody().asString());
	 	
	 
	// System.out.println(rs1.getHeaders().asList().get(1));
	 
	 
	 //following code shows how to read response headers by parameter name and value

		 
		 for (int i = 0; i < rs.getHeaders().size(); i++) {
				System.out.println("header is :" + rs.getHeaders().asList().get(i).getName());
				System.out.println("header is :" + rs.getHeaders().asList().get(i).getValue());
				
		}
		 
		 
    //Following code shows how to check what response content type is
			if (rs.contentType().equals("applicaton/json")) {
				System.out.println("Response content type is applicaton Json");
			} else if (rs.contentType().contains("text/xml"))
			{
				System.out.println("xml content type is " + rs.contentType().toString());
			}else {
				System.out.println("durga " + rs.contentType().toString());
			}
				
  }
  
  
  
  @Test(enabled=false)
   public void postResourceTest(){
	  
	 // RestAssured ra1 = new RestAssured();
	  
	 // EncoderConfig ec= new EncoderConfig();
	  //ec.appendDefaultContentCharsetToContentTypeIfUndefined(false);
	  
	  //ra1.config();
	  
	    
	  String postBody = CommonUtililties.getPostPayload("OrderGateway");
	  
  
	 // headers.put("Content-Type", ContentType.create("text/xml"));
	  
	 // System.out.println(headers.toString());	  
	  
	  //RequestSpecification reqSpec1 = rs1.headers(headers).when();	
	  
	 // given().con
	  
	 String responseString = given().
	    config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToStreamingContentTypeIfUndefined(false))).
	    baseUri(Configurations.getProperty("resource.ordergateway.url")).
	    contentType("text/xml").body(postBody).
	    log().all().
	    post().prettyPrint();
	 
	 System.out.println("\n" + "\n" + responseString);
	  
	  
	  
	 // RequestSpecification rs1 = given().config(RestAssured.config().encoderConfig(ec.appendDefaultContentCharsetToStreamingContentTypeIfUndefined(false))).baseUri(Configurations.getProperty("resource.ordergateway.url"));
	  
	  
		  
	/*//  Response ps1 = rs1.given().
			             header("Authorization", "Intuit_IAM_Authentication intuit_appid=Intuit.platform.ebpiproductcatalogproject.enterpriseproductcatalog9-2.testapp, intuit_app_secret=preprd6LRDaGGhiO8pyzDxO2p18Dgtf4nRL70UME").
			             and().header("Cache-Control", "no-cache").and().body(postBody).post();*/
	  
	  //RequestLogSpecification ls1 = rs1.given().header("Content-Type","text/xml").body(postBody).log();
	  
	  //System.out.println("Request log specification is " + ls1.all());
	  
	 
	  //Response ps1 = rs1.given().body(postBody).post();
			  
			    

	  //System.out.println("Post Response string is :" + "\n" + ps1.asString());
	  
	  //System.out.println("Post Response Content type is :" + "\n" + ps1.getContentType());
	  
	  //System.out.println("Post Response Status is :" + "\n" + ps1.getStatusCode());
	  
	  
	  
	 // System.out.println(reqSpec1.given().toString());
	  
	  //Response rs = RestAssured.given().headers(headers).body("test").when().post("https://productcatalog9-2-tax-e2e.api.intuit.com/v1/pricing");
	   
	  
	//  System.out.println(rs.asString());	   
	  
	  
  }
  
    
  @Test(enabled=false)
  public void postResourceWithAuthTest(){
	  
	  int PRETTY_PRINT_INDENT_FACTOR = 4;
	  
	  RestAssured ra1 = new RestAssured();	  
	  
	  RequestSpecification rs1 = ra1.given().baseUri(Configurations.getProperty("resource.pricing.url"));
	  
	  String postBody = CommonUtililties.getPostPayload("PricingBody"); 
	  
	//  System.out.println("Body Read is :" + postBody);
	  
	 data.headers.put("Authorization", Configurations.getProperty("header.pricing.Authentication"));
	 data.headers.put("Cache-Control", Configurations.getProperty("header.pricing.cache"));	  
	  
	 // System.out.println(headers.toString());	  
	  
	  //RequestSpecification reqSpec1 = rs1.headers(headers).when();	
	  
	  
	  //RequestLogSpecification ls1 = rs1.given().headers(headers).body(postBody).log();
	  
	 // System.out.println("Request log specification is " + "\n" + ls1.all());
	  
	 
	  Response ps1 = rs1.given().headers(data.headers).body(postBody).log().all().post(); //rs1.given().post();
	  
	  System.out.println("Post Response string is :" + "\n" + ps1.asString());
	  
	  JSONObject xmlJSONObj = XML.toJSONObject(ps1.asString());
      String jsonPrettyPrintString = xmlJSONObj.toString(PRETTY_PRINT_INDENT_FACTOR);
      System.out.println(jsonPrettyPrintString);
      
     // System.out.println("json object is :" + xmlJSONObj.get("transactionId"));
      			  
      ps1.then().statusCode(200);	
	  
	 // System.out.println("Post Response Content type is :" + "\n" + ps1.getContentType());
	  
	 // System.out.println("Post Response Status is :" + "\n" + ps1.getStatusCode());  
 	  
 } 
  
  @Test(enabled=false)
  public void getSyntheticPersonData(){
	  
	  System.out.println("Starting get Synthetic Person data test case");
	  
	  
		 RestAssured ra = new RestAssured();
		  
		 Response rs = ra.given().baseUri(Configurations.getProperty("synthetic.party.person.data.url")).queryParams("key", "new").log().all().get();
		 
		 System.out.println("Synthetic party response is :"  + rs.getBody().prettyPrint());	 
		 
		 System.out.println("Synthetic party response content type is :" + rs.getContentType());
		 
		 //System.out.println(rs.getHeaders().asList().get(1));
		 
		// System.out.println("Response body is :" + rs.getBody().asString());
		 
     System.out.println("completed get Synthetic Person data test case");
	  
  }
  
	@Test(enabled = true,  dataProvider = "dptest")
	public void buildGetRequest(String testCaseId) {
		
	   // Initiate/use static instance of RestAssured (RA)			

		RequestSpecification reqSpec = given();

		// set the baseURI

		reqSpec = reqSpec.baseUri(Configurations.getProperty(testCaseId));

		// Setup the headers (custom and standard-headers one necessary for
		// Authentication too)

		reqSpec = data.SetHeadersforGetRequest(this, reqSpec, testCaseId);

		// Add the query parameters

		reqSpec = data.setQueryParametersforGetRquest(this, reqSpec, testCaseId);

		// log the request specification

		reqSpec.log().all();

		// Submit GET request

		Response res = reqSpec.get();
		
		System.out.println("Content type of response is: " + res.getContentType());
		System.out.println("Content type of response is: " + res.body().asString());
		
/*		try{
		  System.out.println("Response for ReqSpec is :" + res.prettyPrint());
		}finally{
			System.out.println("Response for ReqSpec is could not be parsed as string");
		} */
		

		// Parse the response and perform validations

		data.validateTheResponse(res, testCaseId);

	}
	
	
	
	  @DataProvider
	  public Object[][] dptest() {
	    return new Object[][] {
/*	      new Object[] { "resource.test.url" },
	      new Object[] { "resource.test.url1" },*/
	      new Object[] { "resource.test.url2" },
	    };
	  }


  
}
