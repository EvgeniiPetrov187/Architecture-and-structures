package com.petrov;

import com.petrov.config.Config;
import com.petrov.handler.MethodHandlerFactory;
import com.petrov.handler.RequestHandler;
import com.petrov.service.*;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

// приготовление для старта
public class PrepareToStartApp {

    public static void startApp(Config config) {
        try (ServerSocket serverSocket = new ServerSocket(config.getPort())) {
            System.out.printf("Server started at port %d!%n", config.getPort());

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("New client connected!");

                SocketService socketService = SocketServiceFactory.createSocketService(socket);
                ResponseSerializer responseSerializer = ResponseSerializerFactory.createResponseSerializer();

                new Thread(new RequestHandler(
                        socketService,
                        RequestParserFactory.createRequestParser(),
                        MethodHandlerFactory.create(socketService, responseSerializer, config))
                ).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
