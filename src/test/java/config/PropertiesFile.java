package config;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    static Properties prop = new Properties();
    static String projectPath = System.getProperty("user.dir");

    public static void main(String[] args) {
//        getProperties();
//        setProperties();
    }

    public static void getProperties() {
        try {
            InputStream input = new FileInputStream(projectPath + "/src/test/java/config/config.properties");
            prop.load(input);
            String browser = prop.getProperty("browser");
            System.out.println(browser);
            testscripts.Test3_ConfigFiles.browserName = browser;

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            exp.getCause();
            exp.printStackTrace();
        }
    }

    public static void setProperties() {
        try {
            OutputStream output = new FileOutputStream(projectPath + "/src/test/java/config/config.properties");
            prop.setProperty("result", "pass");
            prop.store(output, "config file modified");

        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            exp.getCause();
            exp.printStackTrace();

        }
    }

}
