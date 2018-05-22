package com.example.pierre.myapplication;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

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
        //on utilise configure pour que le parser ne prenne pas en compte les attributs qui ne sont pas listes dans les attributs de la classe Restaurant
        while (input.hasNextLine()) {
            //lecture ligne à ligne du fichier
            String jsonInString1 = input.nextLine();
            //a chaque iteration on met la ligne qui correspond a un objet json dans un string
           Restaurant resto=mapper.readValue(jsonInString1, Restaurant.class);
           //on transforme l objet json en un objet java
            restaurants.add(resto);
            //on ajoute le nouveau restaurant dans la liste
        }
        return restaurants;
    }
}
