package com.example.dataintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public  class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void passmethod(View view) {
      //  Button b;
        EditText t;
       // b=(Button)findViewById(R.id.but);
        t=(EditText)findViewById(R.id.editText);
     Intent i  = new Intent(MainActivity.this,Main2Activity.class);

        String getrec=t.getEditableText().toString();

//Create th

//Add your data to bundle
       i.putExtra("name1",getrec);

//Add the bundle to the intent

//Fire that second activity
        startActivity(i);
    }
    }


