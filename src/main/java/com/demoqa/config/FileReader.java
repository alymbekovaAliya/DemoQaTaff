package com.demoqa.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileReader {

   private static Properties properties;

   static {
       //Здесь статический блок загружает конфигурации из файла при старте программы и инициализирует properties,
       //чтобы потом все классы могли использовать эти настройки без повторного чтения файла.
       try {
           String path = "src/main/resources/app.properties";
           FileInputStream inputStream = new FileInputStream(path);
           properties = new Properties();
           properties.load(inputStream);
           inputStream.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

   public static String getValue(String key) {
       return properties.getProperty(key).trim();
   }

    public static void main(String[] args) {
        System.out.println(getValue("browser"));
    }

}
