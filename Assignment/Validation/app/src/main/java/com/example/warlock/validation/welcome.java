package com.example.warlock.validation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class welcome extends AppCompatActivity {
    TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        username=findViewById(R.id.usrname);
        Intent i=getIntent();
        String s=i.getStringExtra("username");
        username.setText(s);

    }
}
