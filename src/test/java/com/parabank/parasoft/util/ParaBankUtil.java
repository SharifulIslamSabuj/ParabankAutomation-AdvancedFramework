package com.parabank.parasoft.util;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.IOException;

public class ParaBankUtil {

    public static final int WAIT_TIME = 10;
    public static final String TITLE = "ParaBank | Welcome | Online Banking";

    public static Object[][] getTestData(String sheetName) {

        String path = System.getProperty("user.dir") + "/src/test/resources/data/ddt.xlsx";

        try (FileInputStream file = new FileInputStream(path);
             Workbook book = WorkbookFactory.create(file)) {

            Sheet sheet = book.getSheet(sheetName);

            Object[][] data = new Object[
                    sheet.getLastRowNum()
                    ][sheet.getRow(0).getLastCellNum()];

            for (int i = 0; i < sheet.getLastRowNum(); i++) {
                for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                    data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                }
            }

            return data;

        } catch (IOException e) {
            throw new RuntimeException("Failed to read test data from Excel", e);
        }
    }

    public static String generateUniqueUsername(String baseUsername) {
        return baseUsername + "_" + System.currentTimeMillis();
    }
}