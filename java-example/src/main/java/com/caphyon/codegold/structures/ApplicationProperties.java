package com.caphyon.codegold.structures;

import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ApplicationProperties {
    private Properties mProperties;

    private ApplicationProperties() {
    }

    public void Load() {
        int credentials = Integer.parseInt(System.getProperty("credentials"));
        String propsFile = null;

        if (credentials < 0) {
            System.exit(1);
        }

//        Do not use hardcoded values, always replace them with constants
        switch (credentials) {
            case 1:
                propsFile = "application.properties";
                break;
            case 2:
                propsFile = "application.online.properties";
                break;
            case 3:
                propsFile = "application.dev.properties";
                break;
            case 4:
                propsFile = "application.test.properties";
                break;
            default:
                System.exit(1);
                break;
        }

        try {
            mProperties = GetProperties(propsFile);
        } catch (Exception e) {
            System.exit(1);
        }
    }

    private Properties GetProperties(String aFileName) {
        if (aFileName == null)
            aFileName = "application.properties";

        Properties prop = new Properties();
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream(aFileName);
            prop.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop;
    }

    public String GetStringProperty(String aPropName) {
        return mProperties.getProperty(aPropName);
    }

    public int GetIntProperty(String aPropName) {
        return Integer.parseInt(mProperties.getProperty(aPropName));
    }

    public static void main(String[] args) {
        ApplicationProperties properties = new ApplicationProperties();
        properties.Load();
        properties.GetProperties("database.user");
    }
}
