package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

	private Properties prop;

	public Properties init_prop() {
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			System.out.println("configreader");
			prop.load(ip);
			System.out.println("prop loaded");
		
		} catch (FileNotFoundException e) {
			System.err.println(e.getMessage());
		} catch (IOException IO) {
			System.err.println(IO.getMessage());
		}
		
		return prop;
	}
	
	

}
