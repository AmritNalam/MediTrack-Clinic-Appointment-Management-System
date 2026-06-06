package com.airtribe.meditrack.interfacepkg;

public interface Searchable {
    default void search(){
        System.out.println("Searching...");
    }
}