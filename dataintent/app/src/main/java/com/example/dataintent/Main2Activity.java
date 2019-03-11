package com.example.dataintent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         t=(TextView)findViewById(R.id.textView);
        Bundle bundle = getIntent().getExtras();
        String result = bundle.getString("name1");
        t.setText(result);
    }

}
