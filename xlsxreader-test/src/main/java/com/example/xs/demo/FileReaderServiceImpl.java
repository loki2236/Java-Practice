package com.example.xs.demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileReaderServiceImpl implements FileReaderService{

    @Override
    public Workbook openFile(String file) throws IOException{
        
        try (InputStream inp = new FileInputStream("workbook.xls")) {
                Workbook wb = WorkbookFactory.create(inp);
                Sheet sheet = wb.getSheetAt(0);
                Row row = sheet.getRow(0);
                Cell cell = row.getCell(0);
                
                return wb;
                /*
                if (cell == null)
                    cell = row.createCell(3);
                cell.setCellType(CellType.STRING);
                cell.setCellValue("a test");
                
                // Write the output to a file
                try (OutputStream fileOut = new FileOutputStream("workbook.xls")) {
                    wb.write(fileOut);
                }*/
            } catch (Exception e) {
                /* Fail? Break? Close? How should I handle an IO Exception here? */
                
            }
        return null;

    }

    public Cell readCell(Workbook wb, Integer s, Integer r, Integer c) throws Exception{
        Sheet sheet = wb.getSheetAt(s);
        Row row = sheet.getRow(r);
        Cell cell = row.getCell(c);
        
        return cell;
    }

}
