package com.example.pierre.myapplication;

import org.junit.Test;

import java.util.ArrayList;

import static com.example.pierre.myapplication.Main2Activity.Lowercase;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {

    public static void testMakeBoxes() {
        Grid earth=new Grid();
        earth.makeBoxes();
        assertEquals(360*180, earth.boxes.size());
    }
    public static void testAddRestau() {
        Restaurant resto=new Restaurant(48.12311,2.12131);
        Grid earth= new Grid();
        earth.makeBoxes();
        earth.addRestaurant(resto);
        assertEquals(false, earth.boxes.get((90+48)*360 + 180 + 2).liste.isEmpty());
    }
    public static void testLowerCase() {
        ArrayList<String> input=new ArrayList<String>();
        input.add("ChieNN");
        input.add("ChIot");
        ArrayList<String> expected=new ArrayList<String>();
        expected.add("chienn");
        expected.add("chiot");
        assertEquals(expected ,Lowercase(input));
    }
    @Test
    public void testDistance() {
        Client client=new Client(0,180);
        Restaurant resto=new Restaurant(0,0);
        double d=6378 * (Math.PI/2 - Math.asin(Math.sin(Math.PI*client.latitude/180) * Math.sin(Math.PI*resto.latitude/180) + Math.cos(Math.PI*client.longitude/180 - Math.PI*resto.longitude/180) * Math.cos(Math.PI*client.latitude/180) * Math.cos(Math.PI*resto.latitude)));
        //On test si la formule nous donne bien la moitié du perimètre de la terre par exemple.
        assertEquals(6378*Math.PI,d,0.2 );
    }
    public void testLecture() {

    }
}