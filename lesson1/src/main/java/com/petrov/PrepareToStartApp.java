package com.petrov;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// приготовление для старта
public class PrepareToStartApp {

    public static void startApp() {
        try (ServerSocket serverSocket = new ServerSocket(Config.PORT)) {
            System.out.println("Server started!");
            RequestParser requestParser = new RequestParser();

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                new Thread(new RequestHandler(new SocketService(socket), requestParser)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
