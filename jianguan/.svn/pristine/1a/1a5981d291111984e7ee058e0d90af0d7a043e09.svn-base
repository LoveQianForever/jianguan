package com.ncs.gsyt.core.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XSLTools {

	public static final String TITLE_STYLE = "TITLE_STYLE";

	public static final String HEADER_STYLE = "HEADER_STYLE";

	public static final String FOOTER_STYLE = "FOOTER_STYLE";

	public static final String BODY_STYLE = "BODY_STYLE";
	private HSSFWorkbook workbook;

	public XSLTools() {
	}

	public XSLTools(HSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public static List<String[]> studentFromXLS(InputStream is,
			String fileName) throws IOException {
		if (fileName.endsWith(".xls")) {
			return studentFromXLS2003(is);
		} else if (fileName.endsWith(".xlsx")) {
			return studentFromXLS2007(is);
		} else {
			return null;
		}
	}

	private static List<String[]> studentFromXLS2007(InputStream is) throws IOException {
		StringBuffer content = new StringBuffer();
		XSSFWorkbook workbook = new XSSFWorkbook(is); // 创建对Excel工作簿文件的引用
		List<String[]>  rtn = new ArrayList<String[]>();
		String[] arr = null;
		for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
			if (null != workbook.getSheetAt(numSheets)) {
				XSSFSheet aSheet = workbook.getSheetAt(numSheets); // 获得一个sheet

				
				for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet
						.getLastRowNum(); rowNumOfSheet++) {
					if (null != aSheet.getRow(rowNumOfSheet)) {
						XSSFRow aRow = aSheet.getRow(rowNumOfSheet); // 获得一行
						arr = new String[aRow.getLastCellNum()];
						for (int cellNumOfRow = 0; cellNumOfRow <= aRow
								.getLastCellNum(); cellNumOfRow++) {
							if (null != aRow.getCell(cellNumOfRow)) {
								XSSFCell aCell = aRow.getCell(cellNumOfRow); // 获得列值
								if (aCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									if (HSSFDateUtil.isCellDateFormatted(aCell)) {
										SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
										arr[cellNumOfRow] = sdf.format(HSSFDateUtil.getJavaDate(aCell.getNumericCellValue())).toString();
									} else {
										double value = aCell.getNumericCellValue();
										BigDecimal bb = new BigDecimal(aCell
												.getNumericCellValue());
										arr[cellNumOfRow] = bb.toString();
									}
									// 剔除错误的号码
								} else {
									String value = aCell.getStringCellValue();
									arr[cellNumOfRow] = aCell.getStringCellValue();
								}
								
							}
						}
						rtn.add(arr);
					}
				}
			}
		}

		return rtn;
	}

	private static List<String[]> studentFromXLS2003(InputStream is) throws IOException {
		StringBuffer content = new StringBuffer();
		HSSFWorkbook workbook = new HSSFWorkbook(is); // 创建对Excel工作簿文件的引用

		List<String[]>  rtn = new ArrayList<String[]>();
		String[] arr = null;
		for (int numSheets = 0; numSheets < workbook.getNumberOfSheets(); numSheets++) {
			if (null != workbook.getSheetAt(numSheets)) {
				HSSFSheet aSheet = workbook.getSheetAt(numSheets); // 获得一个sheet

				for (int rowNumOfSheet = 0; rowNumOfSheet <= aSheet
						.getLastRowNum(); rowNumOfSheet++) {
					if (null != aSheet.getRow(rowNumOfSheet)) {
						HSSFRow aRow = aSheet.getRow(rowNumOfSheet); // 获得一行
						arr = new String[aRow.getLastCellNum()];
						for (int cellNumOfRow = 0; cellNumOfRow <= aRow
								.getLastCellNum(); cellNumOfRow++) {
							if (null != aRow.getCell(cellNumOfRow)) {
								HSSFCell aCell = aRow.getCell(cellNumOfRow); // 获得列值
								if (aCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
									if (HSSFDateUtil.isCellDateFormatted(aCell)) {
										SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
										arr[cellNumOfRow] = sdf.format(HSSFDateUtil.getJavaDate(aCell.getNumericCellValue())).toString();
									} else {
										double value = aCell.getNumericCellValue();
										BigDecimal bb = new BigDecimal(aCell
												.getNumericCellValue());
										arr[cellNumOfRow] = bb.toString();
									}
									
									// 剔除错误的号码
								} else {
									String value = aCell.getStringCellValue();
									arr[cellNumOfRow] = aCell.getStringCellValue();
								}
							}
						}
						rtn.add(arr);
					}
				}
				
			}
		}

		return rtn;
	}
}