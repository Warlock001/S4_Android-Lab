package com.example.tutorial2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView t1,t2,t3;
    CheckBox c1,c2,c3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         t1=(TextView)findViewById(R.id.textView);
        t2=(TextView)findViewById(R.id.textView2);
        t3=(TextView)findViewById(R.id.textView3);

        c1=(CheckBox)findViewById(R.id.checkbox);
        c2=(CheckBox)findViewById(R.id.checkbox2);
        c3=(CheckBox)findViewById(R.id.checkbox3);

        c1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                t1.setText("Pakistan");

                                               }
                                           }
        );


        c2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                              t2.setText("India");

                                          }
                                      }
        );

        c3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

                                          @Override
                                          public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {
                                              t3.setText("Sri Lanka");

                                          }
                                      }
        );
    }
}
