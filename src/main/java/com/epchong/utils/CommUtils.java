package com.epchong.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author epochong
 * @date 2019/9/5 15:34
 * @email epochong@163.com
 * @blog epochong.github.io
 * @describe
 */
public class CommUtils {
    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        InputStream in = CommUtils.class.getClassLoader().getResourceAsStream(fileName);
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static boolean strIsNull(String str) {
        return str == null || "".equals(str);
    }
}
