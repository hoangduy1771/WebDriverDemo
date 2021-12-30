package utils;

public class ExcelUtilsUse {
    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");
        ExcelUtils excel = new ExcelUtils(projectPath + "/excel/data.xlsx", "Sheet1");
        excel.getRowCount();
        excel.getCellData(0, 0);
        excel.getCellData(1, 1);


    }
}
