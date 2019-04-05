package com.example.tutsix;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView dpt;
    String[] arr = { "MCA" , "MBA" ,"BTech"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dpt= (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String> (this,android.R.layout.select_dialog_item,arr);
        dpt.setThreshold(1);
        dpt.setAdapter(adapter);
    }
}
