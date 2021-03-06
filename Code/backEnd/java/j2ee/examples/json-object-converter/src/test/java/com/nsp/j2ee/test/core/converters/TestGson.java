package com.nsp.j2ee.test.core.converters;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.nsp.j2ee.core.converters.api.ConverterService;
import com.nsp.j2ee.core.converters.api.DeserializationException;
import com.nsp.j2ee.core.converters.api.SerializationException;
import com.nsp.j2ee.core.converters.impl.GsonConverterServiceImpl;


public class TestGson {
	final static Logger logger = Logger.getLogger(TestGson.class);
  @Test
  public void testFile() {
	  String result = getFile("json/employee.json");
	  System.out.println(result);

  }
  
  @Test
  public void testJavaToJsonUsingGson() throws DeserializationException{
	  ConverterService gsonConverter = new GsonConverterServiceImpl();
	  Employee e = gsonConverter.bind(getFile("json/employee.json"), Employee.class);
	  assertEquals("Narsingh",e.getName());
	  
  }
  
  @Test
  public void testJsonToJavaUsingGson() throws SerializationException{
	  ConverterService gsonConverter = new GsonConverterServiceImpl();
	  Employee e = new Employee("Narsingh", 31, "Developer", 25000, "java,python".split(",") );
	  String s = gsonConverter.serialize(e);
	  logger.info(s);
	  
  }
  
	
  private String getFile(String fileName) {
		StringBuilder result = new StringBuilder("");
		//Get file from resources folder
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				result.append(line).append("\n");
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result.toString();
	  }
}