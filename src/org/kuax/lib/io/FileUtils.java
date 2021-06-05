package org.kuax.lib.io;

import java.io.*;

public class FileUtils {

    public static BufferedReader fileReader(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        return bufferedReader;
    }

    public static String readLineFromFile(BufferedReader bufferedReader) throws IOException {
        String lineStr = bufferedReader.readLine();

        return lineStr;
    }

    public static BufferedWriter fileWriter(String filePath) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath));

        return bufferedWriter;
    }

}
