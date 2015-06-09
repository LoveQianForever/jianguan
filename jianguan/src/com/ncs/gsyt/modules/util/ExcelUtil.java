package com.ncs.gsyt.modules.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;

import jxl.Cell;
import jxl.SheetSettings;
import jxl.Workbook;
import jxl.format.CellFormat;
import jxl.format.UnderlineStyle;
import jxl.write.DateFormat;
import jxl.write.DateTime;
import jxl.write.Label;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class ExcelUtil {

	public String filename;

	public String filename1;

	public WritableWorkbook wb;

	public WritableSheet ws;

	public WritableCellFormat headerFormat;

	public WritableCellFormat titleFormat;

	public WritableCellFormat detFormat;

	public WritableCellFormat priceFormat;

	public WritableCellFormat dateFormat;
	
	public String message = "";

	Label l = null;

	jxl.write.Number n = null;

	jxl.write.DateTime d = null;

	public SheetSettings ss;
	
	/**
	 * 构造子注解。
	 */
	public ExcelUtil(String filename, String filename1) throws IOException {
		try {

			this.filename = filename;
			File file = new File(filename);
			InputStream input = new FileInputStream(file);
			
			this.filename1 = filename1;			
			File file1 = new File(filename1);
			
			/*判断文件时否已存在,存在先删除*/
			if (file1.exists()){
				file1.delete();
				}
			file1 = new File(filename1);
			
			//创建只读的Excel工作薄的对象
			jxl.Workbook rw = Workbook.getWorkbook(input);

			//创建可写入的Excel工作薄对象
			wb = Workbook.createWorkbook(file1, rw);
			//读取第一张工作表
			ws = wb.getSheet(0);
			
			/**
			 * add by zengsb 20060713
			 * */
			ss = ws.getSettings();
			/*add end*/
			
			//预定义的一些字体和格式
			WritableFont headerFont = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLUE);
			headerFormat = new WritableCellFormat(headerFont);
			WritableFont titleFont = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.RED);
			titleFormat = new WritableCellFormat(titleFont);
			WritableFont detFont = new WritableFont(WritableFont.ARIAL, 10,
					WritableFont.NO_BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK);
			detFormat = new WritableCellFormat(detFont);
			NumberFormat nf = new NumberFormat("0.00000"); //用于Number的格式
			priceFormat = new WritableCellFormat(detFont, nf);
			DateFormat df = new DateFormat("yyyy-MM-dd");//用于日期的
			dateFormat = new WritableCellFormat(detFont, df);
			message = "";			
		} catch (FileNotFoundException e1) {
			message = "生成报表文件失败，可能是"+filename+"不存在，请与管理员联系，谢谢！";
			e1.printStackTrace();					
		} catch (Exception e) {
			message = "生成报表文件失败，可能是"+filename+"不存在，"+"或目标文件的路径不存在"+filename1+",请与管理员联系，谢谢！";
			e.printStackTrace();			
		}
	}

	/**
	 * 设置页眉
	 * add by liwl on 20061109
	 * @param header
	 * @param pos 位置
	 */
	public void setHeader(String header, String fontName, 
			String fontSize, String style, String pos){
		jxl.HeaderFooter.Contents contents = null;
		if(pos.equalsIgnoreCase("center")){
			contents = ss.getHeader().getCentre();
		}
		else if(pos.equalsIgnoreCase("left")){
			contents = ss.getHeader().getLeft();
		}
		else{
			contents = ss.getHeader().getRight();
		}
		contents.clear();
		contents.append(header);
		if(!fontName.equals("")){
			contents.setFontName(fontName);
		}
		if(!fontSize.equals("")){
			contents.setFontSize(Integer.parseInt(fontSize));
		}
		if(style.equalsIgnoreCase("Bold")){
			contents.toggleBold();
		}
		else if(style.equalsIgnoreCase("Italics")){
			contents.toggleItalics();
		}
		else if(style.equalsIgnoreCase("Outline")){
			contents.toggleOutline();
		}
		else if(style.equalsIgnoreCase("Shadow")){
			contents.toggleShadow();
		}
		else if(style.equalsIgnoreCase("Underline")){
			contents.toggleUnderline();
		}
		else if(style.equalsIgnoreCase("DoubleUnderline")){
			contents.toggleDoubleUnderline();
		}
	}
	
	/**
	 * 设置页眉
	 * add by liwl on 20061109
	 * @param header
	 * @param pos 位置
	 */
	public void addHeader(String header, String pos){
		jxl.HeaderFooter.Contents contents = null;
		if(pos.equalsIgnoreCase("center")){
			contents = ss.getHeader().getCentre();
		}
		else if(pos.equalsIgnoreCase("left")){
			contents = ss.getHeader().getLeft();
		}
		else{
			contents = ss.getHeader().getRight();
		}
		contents.append(header);
	}
	
	/**
	 * 设置页脚
	 * add by liwl on 20061109
	 * @param footer
	 */
	public void setFooter(String footer){
		jxl.HeaderFooter.Contents contents = null;
		contents = ss.getFooter().getCentre();
		contents.clear();
		contents.append(footer + " Invoice Page ");
		contents.appendPageNumber();
		contents.append(" of ");
		contents.appendTotalPages();
	}
	
	public void writeCellLable(int introw, int intcol, String value)
			throws IOException {
		try {
			l = new Label(intcol, introw, value + "");
			ws.addCell(l);
		} catch (Exception e) {
			System.out.println(" writeCellString   introw=" + introw
					+ "  intcol=" + intcol + " value=" + value);
			e.printStackTrace();
		}
	}

	public void writeCellLableValue(int introw, int intcol, String value)
			throws IOException {
		try {
			l = new Label(intcol, introw, value);
			ws.addCell(l);
		} catch (Exception e) {
			System.out.println(" writeCellString   introw=" + introw
					+ "  intcol=" + intcol + " value=" + value);
			e.printStackTrace();
		}
	}

	public void writeCellDateValue(int introw, int intcol, Date value)
			throws IOException {
		try {
			d = new DateTime(intcol, introw, value);
			ws.addCell(d);
		} catch (Exception e) {
			System.out.println(" writeCellDate   introw=" + introw
					+ "  intcol=" + intcol + " value=" + value);
			e.printStackTrace();
		}
	}

	public void writeCellNumberValue(int introw, int intcol, double value)
			throws IOException {
		try {
			n = new jxl.write.Number(intcol, introw, value);
			ws.addCell(n);
		} catch (Exception e) {
			System.out.println(" writeCellNumber   introw=" + introw
					+ "  intcol=" + intcol + " value=" + value);
			e.printStackTrace();
		}
	}

	/** *设置单元格样式**** */
	public void setCellStyle(int introw1, int intcol1, int introw2, int intcol2)
			throws IOException {
		try {
			//获得第一个单元格对象
			jxl.write.WritableCell wc = ws.getWritableCell(intcol1, introw1);
			Cell rc2 = ws.getCell(intcol2, introw2);
			if (rc2.getCellFormat() != null)
				wc.setCellFormat(rc2.getCellFormat());
		} catch (Exception e) {
			System.out.println(" setCellStyle   introw=" + introw1
					+ "  column=" + intcol1);
			e.printStackTrace();
		}
	}

	/** *更新单元格内容**** */
	public void writeCell(int introw, int intcol, String value)
			throws IOException {
		try {
			jxl.write.WritableCell updatecell = ws.getWritableCell(intcol,
					introw);
			updatecell.getContents();
			Label templ;
			if (updatecell.getType().toString().equals("Empty")) {
				templ = new Label(intcol, introw, value);
				ws.addCell(templ);
			} else {
				templ = (Label) updatecell;
				templ.setString(value);
			}
		} catch (Exception e) {
			System.out.println(" writeCell  introw=" + introw + "  column="
					+ intcol);
			e.printStackTrace();
		}
	}

	/** *更新单元格内容**** */
	public void writeFormatCell(int introw, int intcol, String value,String format)
			throws IOException {
		try {
			jxl.write.WritableCell updatecell = ws.getWritableCell(intcol,
					introw);
			updatecell.getContents();
			Label templ;
			
			CellFormat fm = updatecell.getCellFormat();
			if (fm != null) {
				if ("S".equalsIgnoreCase(format)) {
					templ = new Label(intcol, introw, value);
					templ.setCellFormat(fm);
					ws.addCell(templ);
				} else if ("N".equalsIgnoreCase(format)) {
					n = new jxl.write.Number(intcol, introw, Double
							.parseDouble(value));
					n.setCellFormat(fm);
					ws.addCell(n);
				} else if ("D".equalsIgnoreCase(format)) {
					java.text.SimpleDateFormat df = new java.text.SimpleDateFormat(
					"yyyy-MM-dd hh:mm:ss");
					Date date = df.parse(value);
					d = new DateTime(intcol, introw, date);
					d.setCellFormat(fm);
					ws.addCell(d);
				}
			} else {
				updatecell.getCellFormat();
				templ = (Label) updatecell;
				templ.setString(value);
			}
			
		} catch (Exception e) {
			System.out.println(" writeCell  introw=" + introw + "  column="
					+ intcol);
			e.printStackTrace();
		}
	}
	
	/**
	 * author tangqy
	 * 2007-1-16
	 * TODO   写定制格式的单元格
	 * @param introw
	 * @param intcol
	 * @param value
	 * @param format  
	 * @throws IOException
	 */
	public void writeFormatCell(int introw, int intcol, String value,CellFormat format)
	throws IOException 
	{
		try 
		{
			Label templ;
			templ = new Label(intcol,introw,value,format);	
			ws.addCell(templ);
		} catch (RowsExceededException e) {
			System.out.println("写Excel单元格异常");
			e.printStackTrace();
		} catch (WriteException e) {
			System.out.println("写Excel单元格异常");
			e.printStackTrace();
		}
	
}
	/*****写报表表头*****************************************/
	
	public CellFormat getHeadCellWithCenter()
	{
		try {
			WritableFont header_Font = new WritableFont(WritableFont.ARIAL, 12,
					WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE,
					jxl.format.Colour.BLACK);
			WritableCellFormat format = null;
			format = new WritableCellFormat(header_Font);
			format.setAlignment(jxl.format.Alignment.CENTRE);
			format.setVerticalAlignment(jxl.format.VerticalAlignment.CENTRE);
			return format;
			
		} catch (Exception e) {
			// TODO: handle exception
		}	
		return null;
		 
	}
	
	
	/**
	 * 插入行
	 * 
	 * @param introw
	 * @throws IOException
	 */
	public void InsertRow(int introw) throws IOException {
		try {
			ws.insertRow(introw);
		} catch (Exception e) {
			System.out.println(" insertRow   introw=" + introw);
			e.printStackTrace();
		}
	}

	/**
	 * 删除行
	 */
	public void removeRow(int introw) throws IOException {
		try {
			ws.removeRow(introw);
		} catch (Exception e) {
			System.out.println(" removeRow   introw=" + introw);
			e.printStackTrace();
		}
	}

	/**
	 * 删除列
	 */
	public void removeColumn(int intcol) throws IOException {
		try {
			ws.removeColumn(intcol);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 插入列
	 * */
	public void InsertColumn(int intcol) throws IOException {
		try {
			ws.insertColumn(intcol);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 合并单元格
	 */
	public void mergeCells(int arg0, int arg1, int arg2, int arg3)
			throws IOException {
		try {
			ws.mergeCells(arg0, arg1, arg2, arg3);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//写入Exel工作表 && 关闭Excel工作薄对象
	public void writeClose() {
		try {
			wb.write();
			wb.close();
		} catch (Exception e) {
			System.out.println(" writeFile errors  name= writeClose()");
			e.printStackTrace();
		}
	}

	/**
	 * 格式化金额值
	 * 
	 * @param inMoney
	 * @return
	 */
	public String FormatMoney(double inMoney) {
		BigDecimal b1 = new BigDecimal(inMoney);
		BigDecimal b2 = new BigDecimal(Float.toString(Float.parseFloat("1.00")));
		float s = b1.divide(b2, 2, BigDecimal.ROUND_HALF_UP).floatValue();
		String outMoney = new BigDecimal(s).setScale(2, 4) + "";
		return outMoney;

	}
	
}
