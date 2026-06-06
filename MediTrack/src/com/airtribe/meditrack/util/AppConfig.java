package com.airtribe.meditrack.util;

public class AppConfig {

    private static AppConfig instance =
            new AppConfig();

    private AppConfig(){}

    public static AppConfig getInstance(){

        return instance;
    }

    public void showConfig(){

        System.out.println(
                "Application Config Loaded"
        );
    }
}