package com.petrov.facade;

//facade
public class Main {
    public static void main(String[] args) {
        DashboardFacade dashboardFacade = new DashboardFacade(new DashBoard());
        dashboardFacade.ignitionOn();
        dashboardFacade.ignitionOff();
    }
}
