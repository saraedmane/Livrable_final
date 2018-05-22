package com.example.pierre.myapplication;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.io.IOException;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    public static Client user= new Client(33.472831, -112.066411);
    private Grid earth = new Grid();
    private int d = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main2);
            Bundle b = getIntent().getExtras();
            String message = b.getString("distance");
            String mess = b.getString("category");

            d = Integer.parseInt(message);
            lecture(mess);

            ArrayList<Restaurant> res = earth.listof(user, d);

            if (res.size() == 0) {
                Toast.makeText(Main2Activity.this, "No restaurant matches your research", Toast.LENGTH_SHORT).show();
            } else {
                MyAdapter myAdapter = new MyAdapter(d);
                myAdapter.setRestos(res);
                final RecyclerView rv = (RecyclerView) findViewById(R.id.list);
                rv.setLayoutManager(new LinearLayoutManager(this));
                rv.setAdapter(myAdapter);
            }
        }
    //cette methode prend en argument le mot-cle, parcourt le fichier json et rajoute dans le grid les restaurants qui correspondent
    public void lecture(String keyword) {
        Database data = new Database();
        ArrayList<Restaurant> services = null;
        try {
            Resources r = getResources();
            int id = r.getIdentifier("test", "raw", getPackageName());
            services = data.createDB(getResources().openRawResource(id));
        } catch (IOException e) {
            e.printStackTrace();
        }
        earth.makeBoxes();
        int i = 0;
        while (i < services.size()) {
            Restaurant r = services.get(i);
            if (keyword != null) {
                if (r.category(Lowercase(r.categories)).contains(keyword)){
                    earth.addRestaurant(r);}}
            else {
                earth.addRestaurant(r);}
            i++;
        }
    }
    //cette methode rend la partie du code relative aux mots cles insensible à la casse
    public static ArrayList<String> Lowercase(ArrayList<String> categories) {
        ArrayList<String> newcat=new ArrayList<String>();
        for (String key: categories) {
            newcat.add(key.toLowerCase());
        }
        return newcat;
    }
}