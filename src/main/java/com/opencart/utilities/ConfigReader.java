/**
 * 
 */
package com.opencart.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Santosh Sharma
 *
 */
public class ConfigReader {

	private Properties properties;

	// constructor
	public ConfigReader() {
		File file = new File(System.getProperty("user.dir") + "/src/test/resources/config/config.properties");
		try {
			FileInputStream inpuStream = new FileInputStream(file);
			properties = new Properties();
			properties.load(inpuStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}
}