/**
 * 
 */
package com.opencart.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 
 */
public class ExcelUtils {

	private FileInputStream fileInput;
	private XSSFWorkbook workBook;
	private XSSFSheet sheet;
	private XSSFRow xssfRow;
	private XSSFCell xssfCell;
	public String path;

	// constructor
	public ExcelUtils(String path) {
		this.path = path;
	}

	// method return total rows
	public int getTotalRows(String sheetName) throws IOException {
		fileInput = new FileInputStream(path);
		workBook = new XSSFWorkbook(fileInput);
		sheet = workBook.getSheet(sheetName);
		int nrows = sheet.getLastRowNum();

		workBook.close();
		fileInput.close();
		return nrows;
	}

	// method return total cells
	public int getTotalCells(String sheetName, int row) throws IOException {
		fileInput = new FileInputStream(path);
		workBook = new XSSFWorkbook(fileInput);
		sheet = workBook.getSheet(sheetName);
		xssfRow = sheet.getRow(row);
		int ncells = xssfRow.getLastCellNum();

		workBook.close();
		fileInput.close();
		return ncells;
	}

	// method return cell data
	public String getCellData(String sheetName, int row, int cell) throws IOException {
		fileInput = new FileInputStream(path);
		workBook = new XSSFWorkbook(fileInput);
		sheet = workBook.getSheet(sheetName);
		xssfRow = sheet.getRow(row);
		xssfCell = xssfRow.getCell(cell);

		// data formater
		DataFormatter dataFormat = new DataFormatter();
		String data = dataFormat.formatCellValue(xssfCell);

		workBook.close();
		fileInput.close();
		return data;
	}
}