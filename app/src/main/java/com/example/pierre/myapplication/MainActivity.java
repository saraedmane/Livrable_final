package com.example.pierre.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "distance";
    public final static String EXTRA_MESS = "category";

    EditText distance = null;
    EditText categorie = null;
    Button envoyer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        envoyer = (Button) findViewById(R.id.calcul);
        categorie = (EditText) findViewById(R.id.category);
        distance = (EditText) findViewById(R.id.distance);
        envoyer.setOnClickListener(envoyerListener);
        distance.addTextChangedListener(textWatcher);
        categorie.addTextChangedListener(textWatcher);
    }

    private OnClickListener envoyerListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            String d = distance.getText().toString();
            if (d.equals("")){
                Toast.makeText(MainActivity.this, "Please enter a distance", Toast.LENGTH_SHORT).show();}
            else {
                String category = categorie.getText().toString();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                Bundle b = new Bundle();
                Bundle c = new Bundle();
                c.putString(EXTRA_MESS, category);
                b.putString(EXTRA_MESSAGE, d);
                intent.putExtras(b);
                intent.putExtras(c);
                startActivity(intent);
            }
        }
    };

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }
        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}