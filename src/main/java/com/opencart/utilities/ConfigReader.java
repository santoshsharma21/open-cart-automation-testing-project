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

	private Properties pro;

	// constructor
	public ConfigReader() {
		File file = new File(System.getProperty("user.dir") + "/configurations/config.properties");
		try {
			FileInputStream inpuStream = new FileInputStream(file);
			pro = new Properties();
			pro.load(inpuStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getUrl() {
		return pro.getProperty("url");
	}

	public String getEmailId() {
		return pro.getProperty("email");
	}

	public String getPassword() {
		return pro.getProperty("password");
	}
}