
package com.airtribe.meditrack.util;

public class IdGenerator {

    private static IdGenerator instance;

    private int id = 1000;

    private IdGenerator(){}

    public static IdGenerator getInstance(){

        if(instance == null){

            instance = new IdGenerator();
        }

        return instance;
    }

    public int nextId(){

        return ++id;
    }
}
