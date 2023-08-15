package com.example.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelGenerator {
	  private List <Customer> customerList;
	    private XSSFWorkbook workbook;
	    private XSSFSheet sheet;

	    public ExcelGenerator(List <Customer> customerList) {
	        this.customerList = customerList;
	        workbook = new XSSFWorkbook();
	    }
	    private void writeHeader() {
	        sheet = workbook.createSheet("Customer");
	        Row row = sheet.createRow(0);
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setBold(true);
	        font.setFontHeight(16);
	        style.setFont(font);
	        createCell(row, 0, "ID", style);
	        createCell(row, 1, "customer Name", style);
	        createCell(row, 2, "Age", style);
	        createCell(row, 3, "Purchase Value", style);
	        createCell(row, 4, "Contact No", style);
	        createCell(row, 5, "Email", style);
	    }
	    private void createCell(Row row, int columnCount, Object valueOfCell, CellStyle style) {
	        sheet.autoSizeColumn(columnCount);
	        Cell cell = row.createCell(columnCount);
	        if (valueOfCell instanceof Integer) {
	            cell.setCellValue((Integer) valueOfCell);
	        } else if (valueOfCell instanceof Long) {
	            cell.setCellValue((Long) valueOfCell);
	        } else if (valueOfCell instanceof String) {
	            cell.setCellValue((String) valueOfCell);
	        } else {
	            cell.setCellValue((Boolean) valueOfCell);
	        }
	        cell.setCellStyle(style);
	    }
	    private void write() {
	        int rowCount = 1;
	        CellStyle style = workbook.createCellStyle();
	        XSSFFont font = workbook.createFont();
	        font.setFontHeight(14);
	        style.setFont(font);
	        for (Customer record: customerList) {
	            Row row = sheet.createRow(rowCount++);
	            int columnCount = 0;
	            createCell(row, columnCount++, record.getId(), style);
	            createCell(row, columnCount++, record.getName(), style);
	            createCell(row, columnCount++, record.getAge(), style);
	            createCell(row, columnCount++, record.getPurchase_value(), style);
	            createCell(row, columnCount++, record.getContactNumber(), style);
	            createCell(row, columnCount++, record.getEmail(), style);
	        }
	    }
	    public void generateExcelFile(HttpServletResponse response) throws IOException {
	        writeHeader();
	        write();
	        ServletOutputStream outputStream = response.getOutputStream();
	        workbook.write(outputStream);
	        workbook.close();
	        outputStream.close();
	    }

}
