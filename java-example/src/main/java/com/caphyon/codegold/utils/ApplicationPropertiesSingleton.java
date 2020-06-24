package com.caphyon.codegold.utils;

import com.caphyon.codegold.database.DBConnection;
import com.caphyon.codegold.logging.ApplicationLogger;

import java.io.InputStream;
import java.util.Properties;

public class ApplicationPropertiesSingleton {
    private static ApplicationPropertiesSingleton mInstance;
    private Properties mProperties;

    private ApplicationPropertiesSingleton() {
    }

    private void Load() {
        String credentials = System.getProperty("credentials");
        String propsFile = null;

        if (credentials == null) {
            System.exit(1);
        }

        switch (credentials) {
            case Constants.LOCAL:
                propsFile = "application.properties";
                break;
            case Constants.ONLINE:
                propsFile = "application.online.properties";
                break;
            case Constants.DEVELOPMENT:
                propsFile = "application.dev.properties";
                break;
            case Constants.TEST:
                propsFile = "application.test.properties";
                break;
            default:
                System.out.println("Credentials property not set!");
                ApplicationLogger.getInstance().LogError("Credentials property not set!", null);
                //    SOLID: Example of Single responsibility principle
                DBConnection con = new DBConnection(
                        ApplicationPropertiesSingleton.GetInstance().GetStringProperty("database.host"),
                        Integer.parseInt(ApplicationPropertiesSingleton.GetInstance().GetStringProperty("database.port")),
                        ApplicationPropertiesSingleton.GetInstance().GetStringProperty("database.user"),
                        ApplicationPropertiesSingleton.GetInstance().GetStringProperty("database.password")
                );
                con.Connect();
                con.saveError();
                System.exit(1);
                break;
        }

        mProperties = GetProperties(propsFile);
    }

    private Properties GetProperties(String aFileName) {
        if (aFileName == null)
            aFileName = "application.properties";

        Properties prop = new Properties();
        try {
            InputStream input = getClass().getClassLoader().getResourceAsStream(aFileName);
            prop.load(input);
        } catch (Exception e) {
            System.out.println("Could not read property: " + aFileName + ". Error message: " + e.getMessage());
        }

        return prop;
    }

    public String GetStringProperty(String aPropName) {
        return mProperties.getProperty(aPropName);
    }

    public int GetIntProperty(String aPropName) {
        return Integer.parseInt(mProperties.getProperty(aPropName));
    }

    public static ApplicationPropertiesSingleton GetInstance() {
        if (mInstance != null)
            return mInstance;

        synchronized (ApplicationPropertiesSingleton.class) {
            if (mInstance == null) {
                mInstance = new ApplicationPropertiesSingleton();
                mInstance.Load();
            }
        }

        return mInstance;
    }

    public static void main(String[] args) {
        ApplicationPropertiesSingleton.GetInstance().GetIntProperty("database.user");
    }
}