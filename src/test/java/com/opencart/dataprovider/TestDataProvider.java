/**
 * 
 */
package com.opencart.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.opencart.utilities.ExcelUtils;

/**
 * 
 */
public class TestDataProvider {

	// test data file
	private String path = System.getProperty("user.dir") + "/src/test/resources/testdata/login_data.xlsx";

	// get data
	@DataProvider(name = "valid_email_password")
	public String[][] getLoginData1() throws IOException {

		ExcelUtils excel = new ExcelUtils(path);
		int nrows = excel.getTotalRows("Sheet2");
		int ncells = excel.getTotalCells("Sheet2", 1);

		// 2-dim String object
		String[][] data = new String[nrows][ncells];
		// get data from sheet
		for(int row = 1; row <= nrows; row++) {
			for(int cell = 0; cell < ncells; cell++) {
				data[row-1][cell] = excel.getCellData("Sheet2", row, cell);
			}
		}
		return data;
	}
	
	@DataProvider(name = "valid_email_invalid_password")
	public String[][] getLoginData2() throws IOException {

		ExcelUtils excel = new ExcelUtils(path);
		int nrows = excel.getTotalRows("Sheet3");
		int ncells = excel.getTotalCells("Sheet3", 1);

		// 2-dim String object
		String[][] data = new String[nrows][ncells];
		// get data from sheet
		for(int row = 1; row <= nrows; row++) {
			for(int cell = 0; cell < ncells; cell++) {
				data[row-1][cell] = excel.getCellData("Sheet3", row, cell);
			}
		}
		return data;
	}
	
	@DataProvider(name = "invalid_email_valid_password")
	public String[][] getLoginData3() throws IOException {

		ExcelUtils excel = new ExcelUtils(path);
		int nrows = excel.getTotalRows("Sheet4");
		int ncells = excel.getTotalCells("Sheet4", 1);

		// 2-dim String object
		String[][] data = new String[nrows][ncells];
		// get data from sheet
		for(int row = 1; row <= nrows; row++) {
			for(int cell = 0; cell < ncells; cell++) {
				data[row-1][cell] = excel.getCellData("Sheet4", row, cell);
			}
		}
		return data;
	}
	
	@DataProvider(name = "invalid_email_password")
	public String[][] getLoginData4() throws IOException {

		ExcelUtils excel = new ExcelUtils(path);
		int nrows = excel.getTotalRows("Sheet5");
		int ncells = excel.getTotalCells("Sheet5", 1);

		// 2-dim String object
		String[][] data = new String[nrows][ncells];
		// get data from sheet
		for(int row = 1; row <= nrows; row++) {
			for(int cell = 0; cell < ncells; cell++) {
				data[row-1][cell] = excel.getCellData("Sheet5", row, cell);
			}
		}
		return data;
	}
}
