package com.cd.stmty.util;

import java.io.*;
import java.util.Base64;

public class UtilBase64Image {

	public static String encoder(String imagePath) {
		File file = new File(imagePath);
		try (FileInputStream imageInFile = new FileInputStream(file)) {
			// Reading a Image file from file system
			byte imageData[] = new byte[(int) file.length()];
			imageInFile.read(imageData);
			String base64Image = Base64.getEncoder().encodeToString(imageData);
			return base64Image;
		} catch (FileNotFoundException e) {
			System.out.println("Image not found" + e);
		} catch (IOException e) {
			System.out.println("Exception while reading the Image " + e);
		}
		return null;
	}

}
