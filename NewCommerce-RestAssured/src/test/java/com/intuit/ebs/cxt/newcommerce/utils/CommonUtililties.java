package com.intuit.ebs.cxt.newcommerce.utils;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Reporter;

public class CommonUtililties {
	
	
	
	public static String getPostPayload(String fileName) {

		String payloadString = null;

		String filePath = System.getProperty("user.dir") + "/src/test/resources/" + fileName
				+ ".xml";
		try {
			payloadString = readFile(filePath);
		} catch (IOException e) {
			Reporter.log("<br>" + e.getMessage());
		}
		return payloadString;
	}
	
		
	public static String readFile(String path) throws IOException

	{

		Charset encoding = StandardCharsets.UTF_8;
		byte[] encoded = Files.readAllBytes(Paths.get(path));
		return encoding.decode(ByteBuffer.wrap(encoded)).toString();
	}
	

}
