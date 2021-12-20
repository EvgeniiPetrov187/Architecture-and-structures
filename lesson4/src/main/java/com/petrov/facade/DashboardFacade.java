package com.petrov.facade;

//facade
public class DashboardFacade {

    private DashBoard dashboard;

    public DashboardFacade(DashBoard dashboard) {
        this.dashboard = dashboard;
    }

    public void ignitionOn(){
        dashboard.chargeOn();
        dashboard.airbagOn();
        dashboard.checkEngineOn();
    }
    public void ignitionOff(){
        dashboard.chargeOff();
        dashboard.airbagOff();
        dashboard.checkEngineOff();
    }
}
