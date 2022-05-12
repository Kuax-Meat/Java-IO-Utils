package org.kuax.lib.io;

import java.io.*;
import java.net.*;

public class SocketUtils {
    public static Socket makeConnection(String targetIp, int targetPort) throws IOException {
        Socket conn = new Socket(targetIp, targetPort);

        return conn;
    }

    public static BufferedReader getBufferedReaderFromSocket(Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    public static PrintWriter getPrintWriterFromSocket(Socket socket) throws IOException {
        return new PrintWriter(socket.getOutputStream(), true);
    }
}
