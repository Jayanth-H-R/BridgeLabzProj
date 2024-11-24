package com.generic.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
    public FileUtility(){

    }

    public String readData(String key) throws IOException {
        FileInputStream fis= new FileInputStream("./src/test/resources/CommonData.properties");

        Properties prop=new Properties();
        prop.load(fis);
        String value=prop.getProperty(key);
        return value;
    }

}
