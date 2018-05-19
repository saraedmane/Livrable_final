package com.example.pierre.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnKeyListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;


public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "distance";//"com.example.pierre.myapplication.MESSAGE";
    public final static String EXTRA_MESS = "categorie";
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
            Editable cat = categorie.getText();
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            Bundle b = new Bundle();
            b.putString(EXTRA_MESSAGE,d);
            intent.putExtras(b);
            startActivity(intent);
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