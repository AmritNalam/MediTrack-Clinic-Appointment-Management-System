package com.airtribe.meditrack.util;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVUtil {

    public static void saveData(
        String fileName,
        List<String> data){

        try(BufferedWriter writer =
            new BufferedWriter(
                new FileWriter(fileName))){

            for(String line : data){
                writer.write(line);
                writer.newLine();
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static List<String[]> loadData(
        String fileName){

        List<String[]> rows =
            new ArrayList<>();

        try(BufferedReader reader =
            new BufferedReader(
                new FileReader(fileName))){

            String line;

            while((line=reader.readLine())!=null){
                rows.add(line.split(","));
            }

        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        return rows;
    }
}