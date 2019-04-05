package com.example.tutfive;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

RadioGroup gendrg;
RadioButton radiosexbutton;
Button submit;
TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gendrg=(RadioGroup) findViewById(R.id.grp);
        submit=(Button) findViewById(R.id.submitbtn);
        result=(TextView)findViewById(R.id.txtview);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedid=gendrg.getCheckedRadioButtonId();
                radiosexbutton=(RadioButton)findViewById(selectedid);
                String gender=radiosexbutton.getText().toString();
                result.setText(gender);

            }
        });
    }
}
