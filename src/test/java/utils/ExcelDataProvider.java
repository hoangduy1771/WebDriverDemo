package utils;

import static org.apache.poi.hssf.usermodel.HeaderFooter.file;

public class ExcelDataProvider {

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        testData(projectPath + "/excel/data.xlsx", "Sheet1");
    }

    
    public static Object[][] testData(String excelPath, String sheetName) {

        ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount - 1][colCount];

//        get data from excel file
        for (int row = 1; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                String cellValue = excel.getCellData(row, col);
                System.out.print(cellValue + " | ");
                data[row - 1][col] = cellValue;

            }
            System.out.print("");
        }
        return data;
    }

}
