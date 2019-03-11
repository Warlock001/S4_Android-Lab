package com.example.activitybuttonclick;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public abstract class MainActivity extends AppCompatActivity {
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

   // button1=(Button)findViewById(R.id.b);
      button1=(Button)findViewById()

    public void buttonclick(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Moved to next activity";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        Intent i = new Intent(MainActivity.this,Main2Activity.class);
        startActivity(i);

    }


}
