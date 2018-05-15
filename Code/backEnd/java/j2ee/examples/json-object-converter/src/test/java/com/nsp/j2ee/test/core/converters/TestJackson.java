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
import com.nsp.j2ee.core.converters.impl.JacksonConverterServiceImpl;


public class TestJackson {
	final static Logger logger = Logger.getLogger(TestJackson.class);

  @Test
  public void testFile() {
	  String result = getFile("json/employee.json");
	  System.out.println(result);

  }
  
  @Test
  public void testJavaToJsonUsingJackson() throws DeserializationException{
	  ConverterService jacksonConverter = new JacksonConverterServiceImpl();
	  Employee e = jacksonConverter.bind(getFile("json/employee.json"), Employee.class);
	  assertEquals("Narsingh",e.getName());
	  
  }
  
  @Test
  public void testJsonToJavaUsingJackson() throws SerializationException{
	  ConverterService jacksonConverter = new JacksonConverterServiceImpl();
	  Employee e = new Employee("Narsingh", 31, "Developer", 25000, "java,python".split(",") );
	  String s = jacksonConverter.serialize(e);
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