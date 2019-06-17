package com.cd.stmty.util;

import java.io.*;
import java.util.Base64;

public class UtilBase64Image {

    public static String encoder(String imagePath) {
        File file = new File(imagePath);
        try {
            FileInputStream stream = new FileInputStream(file);
            // Reading a Image file from file system
            String base64Image = "";
            byte imageData[] = new byte[(int) imagePath.length()];
            stream.read(imageData);
            base64Image = Base64.getEncoder().encodeToString(imageData);
            return base64Image;
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
        return null;
    }

    public static void decoder(String base64Image, String pathFile) {
        try {
            FileOutputStream stream = new FileOutputStream(pathFile);
            // Converting a Base64 String into Image byte array
            byte[] imageByArray = Base64.getDecoder().decode(base64Image);
            stream.write(imageByArray);
        } catch (FileNotFoundException e) {
            e.getStackTrace();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
