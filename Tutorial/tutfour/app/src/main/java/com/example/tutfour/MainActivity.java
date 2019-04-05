package com.example.tutfour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton togglebtn,togglebtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        togglebtn= (ToggleButton) findViewById(R.id.toggleButton);
        togglebtn2= (ToggleButton) findViewById(R.id.toggleButton2);

        togglebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Toggle Button selected!",25000).show();
            }
        });

    }
}
