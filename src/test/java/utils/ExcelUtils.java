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

    public int getRowCount() {
        int rowCount = sheetXLSX.getPhysicalNumberOfRows();
        System.out.println("Number of rows: " + rowCount);
        return rowCount;
    }

    public int getColCount() {
        int colCount = sheetXLSX.getRow(0).getPhysicalNumberOfCells();
        System.out.println("Number of columns: " + colCount);
        return colCount;
    }

    public static String getCellData(int rowNum, int cellNum) {
        String cellDataString;
        int cellDataNumberic;
        String message = "Data in row " + rowNum + ", in cell " + cellNum + " is: ";
        try {
            cellDataString = sheetXLSX.getRow(rowNum).getCell(cellNum).getStringCellValue();
//            System.out.println(message + cellDataString);
            return cellDataString;

        } catch (Exception e) {
            cellDataNumberic = (int) sheetXLSX.getRow(rowNum).getCell(cellNum).getNumericCellValue();
//            System.out.println(message + cellDataNumberic);
            return String.valueOf(cellDataNumberic);
        }

    }
}
