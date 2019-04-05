package com.example.tutorial3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edittext1;
    CheckBox c1,c2,c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        c1=(CheckBox)findViewById(R.id.checkBox);
        c2=(CheckBox)findViewById(R.id.checkBox2);
        c3=(CheckBox)findViewById(R.id.checkBox3);
        edittext1=(EditText)findViewById(R.id.editText1);


        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                              c2.setChecked(false);
                                              c3.setChecked(false);
                                              edittext1.setText("India");

                                          }
                                      }
        );

        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                              c1.setChecked(false);
                                              c3.setChecked(false);
                                              edittext1.setText("Srilanka");

                                          }
                                      }
        );

        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                              c2.setChecked(false);
                                              c1.setChecked(false);
                                              edittext1.setText("Pakistan");

                                          }
                                      }
        );



    }
}
