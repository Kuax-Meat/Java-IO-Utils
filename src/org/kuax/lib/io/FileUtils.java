package org.kuax.lib.io;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class FileUtils {

    /*
     * Java IO (Before JDK 6)
     */

    public static BufferedReader fileReader(String filePath) throws IOException {
        return new BufferedReader(new FileReader(filePath));
    }

    public static String readLineFromFile(BufferedReader bufferedReader) throws IOException {
        return bufferedReader.readLine();
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

    /* JDK 8 */
    public static String makeStringFromFile(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath)).collect(Collectors.joining(System.lineSeparator()));
    }

    /* JDK 7 */
    public static List<String> makeListFromFile(String filePath) throws IOException {
        return Files.readAllLines(Paths.get(filePath));
    }
}
