package com.petrov;

import com.petrov.connections.ConnectorForSite;
import com.petrov.requests.RequestForSite;

import java.io.IOException;

// приготовление для старта
public class PrepareToStartApp {

    public static void startApp() {
        ConnectorForSite connectorForSite = new ConnectorForSite();
        RequestForSite requestForSite = new RequestForSite();

        try {
            connectorForSite.connect(requestForSite);
        } catch (IOException e) {
            e.printStackTrace();
        }
        requestForSite.handleRequest(connectorForSite.getSocket());
    }
}
