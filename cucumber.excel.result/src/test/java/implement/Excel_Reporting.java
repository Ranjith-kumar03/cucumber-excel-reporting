package implement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Reporting {
	static Workbook workbook;
	static Sheet sheet;
	Font font;
	String [] Header_Heading= {"Username", "Password", "Status"};
	static int rownum=1;
	
	public Excel_Reporting() {
		
		System.out.println("Iam getting Initalised");
		
		workbook=new XSSFWorkbook();
		sheet= workbook.createSheet("Testing");
		font = workbook.createFont();
		font.setBoldweight((short) 30);
		font.setFontHeightInPoints((short) 20);
		font.setColor(IndexedColors.BRIGHT_GREEN.getIndex());
		
		
		 CellStyle Header_style =workbook.createCellStyle();
		 Header_style.setFont(font);
		 
		Row Header_row=sheet.createRow(0);
		
		
		for(int i=0; i<Header_Heading.length;i++)
		{
			Cell cell=Header_row.createCell(i);
			cell.setCellValue(Header_Heading[i]);
			cell.setCellStyle(Header_style);
		}
		System.out.println("Iam got Initalised");
	}
	
	public void logging_data() {
		
		System.out.println("preparing tolog data");
		
		Row row =sheet.createRow(rownum++);
		System.out.println("moved to next row");
		row.createCell(0).setCellValue(LogIn_Implement.User_Name);
		System.out.println("stored user name--"+LogIn_Implement.User_Name);
		row.createCell(1).setCellValue(LogIn_Implement.Pass_word);
		System.out.println("stored password"+LogIn_Implement.Pass_word);
		row.createCell(2).setCellValue(LogIn_Implement.Status);
		System.out.println("stored password"+LogIn_Implement.Status);
		
	}
	public void closing() throws IOException
	{
		FileOutputStream fos= new FileOutputStream("TestResult.xlsx");
		System.out.println("created file xlsx file");
		workbook.write(fos);
		System.out.println("closed work book");
		fos.close();
		System.out.println("fos closed");
	}
	
	public void column_auto_spacing() {
		
		for(int i=0; i<Header_Heading.length;i++)
		{
		sheet.autoSizeColumn(i);
		}
		
	}

}
