package ru.omsu.imit.utils.spring;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {
    private static int restHttpPort; //Порт, на котором работает REST-сервер


    public ConfigUtils(String propFileName) {
        Properties prop = new Properties();
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName)) {
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
            }

            restHttpPort = Integer.parseInt(prop.getProperty("rest_http_port"));

        } catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }

    public static int getRestHttpPort() {
        return restHttpPort;
    }

}