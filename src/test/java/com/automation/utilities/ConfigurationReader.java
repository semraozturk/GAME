package com.automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static final Properties properties = new Properties();


    static{

        try{
            FileInputStream inputFile = new FileInputStream("configuration.properties");
            properties.load(inputFile);
            inputFile.close();
        } catch (IOException e){
            System.out.println("Properties file is not found");
        }

    }


    public static String getProperty(String key){
        return properties.getProperty(key);
    }




}
