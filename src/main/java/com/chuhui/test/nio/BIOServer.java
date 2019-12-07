package com.chuhui.test.nio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class BIOServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9098);

        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            byte[] readBytes = new byte[1024];

            while (inputStream.read(readBytes) != -1) {
                System.err.println("from client data:" +
                        new String(readBytes, StandardCharsets.UTF_8));
            }
        }

    }

}
