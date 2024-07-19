package com.sparta.demothread;

import java.io.*;

public class FileService {

    static String fileUrl = "./output.txt";

    // Read
    public static String read() {
        String result = "";
        try {
            FileReader file = new FileReader(fileUrl);
            BufferedReader bufferedReader = new BufferedReader(file);

            int data = 0;
            while((data = bufferedReader.read()) != -1){
                System.out.print((char)data);
            }
            file.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    // Write
    public static void write(String content) {
        try{
            FileWriter fileWriter = new FileWriter(fileUrl, true);
            fileWriter.write(content);
            fileWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}