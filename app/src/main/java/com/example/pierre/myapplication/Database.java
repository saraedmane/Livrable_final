package com.example.pierre.myapplication;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.channels.AsynchronousFileChannel;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Database {
    Database data;

    public ArrayList<Restaurant> createDB(InputStream file) throws IOException {
        return parse(new Scanner(file));
    }

    public ArrayList<Restaurant> createDB(File file) throws IOException {
        return parse(new Scanner(file));
    }

    private ArrayList<Restaurant> parse(Scanner input) throws IOException {
        ArrayList<Restaurant> restaurants=new ArrayList<Restaurant>();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure( DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        while (input.hasNextLine()) {
            //lecture ligne à ligne du fichier
            String jsonInString1 = input.nextLine();
           Restaurant resto=mapper.readValue(jsonInString1, Restaurant.class);
            restaurants.add(resto);
        }
        return restaurants;

    }

}
