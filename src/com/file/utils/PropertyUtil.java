package com.file.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by dadisdad on 2017/3/15.
 */
public class PropertyUtil {

    public static Properties getProperties(String propertiesName) throws IOException {
            InputStream stream = PropertyUtil.class.getClassLoader().getResource(propertiesName).openStream();
            Properties properties = new Properties();
            properties.load(stream);
            return properties;
    }

}
