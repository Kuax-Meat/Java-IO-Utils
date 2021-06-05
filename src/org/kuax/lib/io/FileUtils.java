package org.kuax.lib.io;

import java.io.*;

public class FileUtils {

    /*
     * Classic Java IO
     */

    public static BufferedReader fileReader(String filePath) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));

        return bufferedReader;
    }

    public static String readLineFromFile(BufferedReader bufferedReader) throws IOException {
        String lineStr = bufferedReader.readLine();

        return lineStr;
    }

    public static BufferedWriter fileWriter(String filePath) throws IOException {
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));

        return bufferedWriter;
    }

    /*
     * Java NIO
     */
}
