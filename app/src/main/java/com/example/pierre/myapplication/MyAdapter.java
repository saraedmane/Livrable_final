package com.example.pierre.myapplication;
import android.support.v4.app.SupportActivity.ExtraData.*;
import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Pair<String, String>> restos = new ArrayList<>();//Arrays.asList(Pair.create("Subwayddddddddd","10"),Pair.create("Mcdo","8"));

    private int d = 0;

    public MyAdapter(int d) {
        this.d = d;

    }

    @Override
    public int getItemCount() {
        return restos.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.list_cell, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Pair<String, String> pair = restos.get(position);
        holder.display(pair);
    }

    public void setRestos(ArrayList<Restaurant> res) {

        Log.i("Ajout des restaurants", "Taille: "+res.size());

        //this.restos = Arrays.asList(cRes);

        int i = 0;
        while (i < res.size()) {
            Restaurant r = res.get(i);
            Log.i("Mon res: ", r.getName());
            Pair<String, String> cRes = Pair.create(r.getName(),r.getStars() + "/5" + System.getProperty("line.separator")+ r.getAddress());
            this.restos.add(cRes);
            i++;
        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView name;
        private final TextView description;

        private Pair<String, String> currentPair;

        public MyViewHolder(final View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            description = (TextView) itemView.findViewById(R.id.description);

        }

        public void display(Pair<String, String> pair) {
            currentPair = pair;
            name.setText(pair.first);
            description.setText(pair.second);

        }
    }
}