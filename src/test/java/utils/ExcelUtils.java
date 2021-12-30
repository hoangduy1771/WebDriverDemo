package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
    static XSSFWorkbook workbookXLSX;
    static XSSFSheet sheetXLSX;

    public ExcelUtils(String excelPath, String sheetName) {
        try {
            //        find xlsx Excel file
            workbookXLSX = new XSSFWorkbook(excelPath);
            //        find worksheet
            sheetXLSX = workbookXLSX.getSheet(sheetName);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.getCause();
            e.printStackTrace();
        }
    }

//    public static void main(String[] args) {
//        getRowCount();
//        getCellDataString(0, 0);
//    }

    public static void getRowCount() {
        int rowCount = sheetXLSX.getPhysicalNumberOfRows();
        System.out.println("Number of rows: " + rowCount);
    }

    public static void getCellData(int rowNum, int cellNum) {
        String cellDataString;
        double cellDataNumberic;
        String message = "Data in row " + rowNum + ", in cell " + cellNum + " is: ";
        try {
            cellDataString = sheetXLSX.getRow(rowNum).getCell(cellNum).getStringCellValue();
            System.out.println(message + cellDataString);
        } catch (Exception e) {
            cellDataNumberic = sheetXLSX.getRow(rowNum).getCell(cellNum).getNumericCellValue();
            System.out.println(message + (int) cellDataNumberic);
        }
    }
}
