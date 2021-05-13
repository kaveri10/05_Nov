package com.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIOTest {

	public static void main(String[] args) throws Exception {
		writeIntoFile();
		//readFromFile();
	}

	public static void readFromFile() throws Exception {
		File file = new File("abc.txt");
		FileInputStream fis = new FileInputStream(file);
		int x = 0;
		StringBuilder sb = new StringBuilder("");
		do {
			x = fis.read(); //blocking call
			if(x != -1) { //-1 represents EOF
				sb.append((char)x);
			}
		}while(x != -1);
		System.out.println("File contents: " + sb.toString());
		
	}
	
	public static void writeIntoFile() throws Exception {
		File file = new File("abc.txt");
		FileOutputStream fos = new FileOutputStream(file);
		String message = "I am from Capgemini";
		fos.write(message.getBytes());
		fos.flush();
		fos.close();
		System.out.println("Message written into abc.txt");
	}
}
