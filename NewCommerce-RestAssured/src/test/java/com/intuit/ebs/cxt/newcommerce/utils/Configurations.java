package com.intuit.ebs.cxt.newcommerce.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.testng.Reporter;


/**
 * Util for reading properties file.
 * @author Durga Seelamsetti
 *
 */
public class Configurations {
	/*private static final Properties Configurations;
	private static final Properties Saleslocator;
	private static final Properties ServiceLocator;
	private static final Properties ServiceLocatorsys;
	private static final Properties SalesLocatorSYS;
	private static final Properties SalesTestData;
	private static final Properties ServiceTestData;
	
	private static final String SALES_LOCATORS_FILES_DEV = "/properties/Sales.Locators.dev.properties";
	private static final String SALES_LOCATORS_FILES_FUNC = "/properties/Sales.Locators.func.properties";
	private static final String SALES_LOCATORS_FILES_SYS = "/properties/Sales.Locators.sys.properties";
	private static final String SALES_LOCATORS_FILES_STG = "/properties/Sales.Locators.stg.properties";
	private static final String SALES_LOCATORS_FILES_PRF = "/properties/Sales.Locators.prf.properties";
	
	static{

		Configurations = new Properties();
		InputStream isConfig = Configurations.class.getResourceAsStream("/properties/Config.properties");

		Saleslocator = new Properties();
		InputStream isSalesLocator = Configurations.class.getResourceAsStream("/properties/Sales.or.properties");
		
		ServiceLocator = new Properties();
		InputStream isServiceLocator = Configurations.class.getResourceAsStream("/properties/Service.or.properties");
		
		ServiceLocatorsys = new Properties();
		InputStream isServiceLocatorsys = Configurations.class.getResourceAsStream("/properties/Service.or.sys.properties");
		
		SalesLocatorSYS = new Properties();
		InputStream isSalesLocatorSYS = Configurations.class.getResourceAsStream("/properties/Sales.or.sys.properties");
		
		SalesTestData = new Properties();
		InputStream isSalesTestData = Configurations.class.getResourceAsStream("/testdata/salescloud.properties");
		
		ServiceTestData =  new Properties();
		InputStream isServiceTestData = Configurations.class.getResourceAsStream("/testdata/servicecloud.properties");
	
		try{
			Configurations.load(isConfig);
			Saleslocator.load(isSalesLocator);
			ServiceLocator.load(isServiceLocator);
			ServiceLocatorsys.load(isServiceLocatorsys);
			SalesLocatorSYS.load(isSalesLocatorSYS);
			SalesTestData.load(isSalesTestData);
			ServiceTestData.load(isServiceTestData);
		}catch(Exception e){
			System.out.println("here:" + e.getMessage());
		}
	}
	
	*//**
	 * Purpose: Retrieves the property value based on the property name
	 * @param inputData
	 * @return property value
	 *//*
	public static String getProprty(String locatorName){
		return Configurations.getProperty(locatorName);
	}

	*//**
	 * Purpose: Retrieves the property value based on the property name
	 * @param locatorName
	 * @return property value
	 *//*
	public static String getSalesLocator(String locatorName) {
		String property =System.getProperty("environment");
		
		if(property.equalsIgnoreCase("FUNC") || property==null){
		return Saleslocator.getProperty(locatorName);
		}else
		{
			if(SalesLocatorSYS.getProperty(locatorName)!=null){
				return SalesLocatorSYS.getProperty(locatorName);
			} else {
				return Saleslocator.getProperty(locatorName);
			}
		
		}
	}
	
	*//**
	 * Purpose: Retrieves the property value based on the property name
	 * @param locatorName
	 * @return property value
	 *//*
	public static String getServiceLocator(String locatorName){
		String property =System.getProperty("environment");
		
		if(property.equalsIgnoreCase("FUNC") || property==null){
		return ServiceLocator.getProperty(locatorName);
		}else
		{
			return ServiceLocatorsys.getProperty(locatorName);
		}
	}
	
	*//**
	 * Purpose: Retrieves the property value based on the property name
	 * @param locatorName
	 * @return property value
	 *//*
	public static String getSalesLocatorSYS(String locatorName){
		return SalesLocatorSYS.getProperty(locatorName);
	}
	
	*//**
	 * Purpose: Retrieves the property value based on the property name
	 * @param locatorName
	 * @return property value
	 *//*
	public static String getSalesTestData(String locatorName){
		return SalesTestData.getProperty(locatorName);
	}
	
	*//**
	 * Purpose: Retrieves the property value based on the property name
	 * @param locatorName
	 * @return property value
	 *//*
	public static String getServiceTestData(String locatorName){
		return ServiceTestData.getProperty(locatorName);
	}	
	
	*//**
	 * Loads a property file and returns the properties object.
	 * @param propFile - the path to the property file to load.
	 * @return the property file loaded into a Properties object
	 *//*
	public static Properties loadPropertyFile(String propFile)
	{
		// Properties object
		Properties prop = new Properties();
		
		try {
			// Load
			prop.load(new FileInputStream(propFile));
		} catch (FileNotFoundException e) {
			Reporter.log("Can't find properties file: " + propFile + " Exception - " + e.toString(), true);
		} catch (IOException e) {
			Reporter.log("Error reading properties file: " + propFile + " Exception - " + e.toString(), true);
		}
		
		// Return the properties
		return prop;
	}
	
	*//**
	 * Returns the locators property file for sales
	 * @param environment - which environments' property file to load
	 * @return the property file loaded into a Properties object
	 *//*
	public static Properties loadSalesLocatorsPropertyFile(String environment)
	{
		// Properties object
		Properties prop = new Properties();
		
		// Empty property file path
		String propFile;
		
		// Determine the environment to load
		if(environment.equalsIgnoreCase("dev"))    		
			propFile = SALES_LOCATORS_FILES_DEV;
    	else if(environment.equalsIgnoreCase("func"))    		
    		propFile = SALES_LOCATORS_FILES_FUNC;
    	else if(environment.equalsIgnoreCase("sys"))    		
    		propFile = SALES_LOCATORS_FILES_SYS;
    	else if(environment.equalsIgnoreCase("perf"))    		
    		propFile = SALES_LOCATORS_FILES_PRF;
    	else if(environment.equalsIgnoreCase("stg"))    		
    		propFile = SALES_LOCATORS_FILES_STG;
    	else // Default to FUNCTIONAL; likely this is a TestNG local run
    		propFile = SALES_LOCATORS_FILES_FUNC;
		
		try {
			// Load
			prop.load(Configurations.class.getResourceAsStream(propFile));
		} catch (FileNotFoundException e) {
			Reporter.log("Can't find properties file: " + propFile + " Exception - " + e.toString(), true);
		} catch (IOException e) {
			Reporter.log("Error reading properties file: " + propFile + " Exception - " + e.toString(), true);
		}
		
		// Return the properties
		return prop;
	}*/
}
