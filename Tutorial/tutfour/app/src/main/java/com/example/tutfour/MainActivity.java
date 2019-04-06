package com.example.tutfour;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton togglebtn,togglebtn2;
    Button dispbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        togglebtn= (ToggleButton) findViewById(R.id.toggleButton);
        togglebtn2= (ToggleButton) findViewById(R.id.toggleButton2);
        dispbtn=(Button) findViewById(R.id.button);
        dispbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             StringBuffer result= new StringBuffer();
             result.append("Togglebutton1: ").append(togglebtn.getText());
             result.append("\n");
             result.append("Togglebutton2: ").append(togglebtn2.getText());
             Toast.makeText(MainActivity.this,result.toString(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
