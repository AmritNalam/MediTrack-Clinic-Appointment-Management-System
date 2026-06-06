package com.airtribe.meditrack.util;

import java.util.*;

public class DataStore<T> {
    private List<T> data = new ArrayList<>();

    public void add(T item){
        data.add(item);
    }

    public List<T> getAll(){
        return data;
    }
}