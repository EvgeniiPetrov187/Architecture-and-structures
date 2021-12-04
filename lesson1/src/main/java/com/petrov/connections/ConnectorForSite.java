package com.petrov.connections;

import com.petrov.requests.RequestForSite;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

// соединения
public class ConnectorForSite {
    private Socket socket;

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    public void connect(RequestForSite requestForSite) throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\13zlo\\Desktop\\Works\\Architecture\\lesson1\\src\\main\\resources\\config.properties");
        properties.load(fileInputStream);

        try {
            ServerSocket serverSocket = new ServerSocket(Integer.parseInt(properties.getProperty(("host"))));
            System.out.println("Server started!");

            while (true) {
                socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(() -> requestForSite.handleRequest(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
