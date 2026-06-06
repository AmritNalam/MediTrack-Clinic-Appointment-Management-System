package com.airtribe.meditrack.observer;

public class ConsoleNotifier
        implements AppointmentObserver {

    @Override
    public void update(String message){

        System.out.println(
                "NOTIFICATION: " + message
        );
    }
}