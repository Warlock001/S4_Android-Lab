package com.example.tutorial3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.HashSet;

public class MainActivity extends AppCompatActivity {
    HashSet<String> hash = new HashSet<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = findViewById(R.id.text);

        final CheckBox chk1 = findViewById(R.id.checkBox1);
        final CheckBox chk2 = findViewById(R.id.checkBox2);
        final CheckBox chk3 = findViewById(R.id.checkBox3);

        chk1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    hash.add(chk1.getText().toString());
                    changeText(tv);
                }
                else
                {
                    hash.remove(chk1.getText().toString());
                    changeText(tv);
                }
            }
        });


        chk2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    hash.add(chk2.getText().toString());
                    changeText(tv);
                }
                else
                {
                    hash.remove(chk2.getText().toString());
                    changeText(tv);
                }
            }
        });


        chk3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {
                    hash.add(chk3.getText().toString());
                    changeText(tv);
                }
                else
                {
                    hash.remove(chk3.getText().toString());
                    changeText(tv);
                }
            }
        });

    }

    private void changeText(TextView tv)
    {

        tv.setText(hash.toString().replace("[","").replace("]",""));
    }
}




