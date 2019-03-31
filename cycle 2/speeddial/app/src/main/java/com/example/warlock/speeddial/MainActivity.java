package com.example.warlock.speeddial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button sms,dial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sms=(Button)findViewById(R.id.button);
        dial=(Button)findViewById(R.id.button2);
        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new
                        Intent(getApplicationContext(),smspage.class);
                startActivity(i1);}
        });
        dial.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View view) {
                String phno = "8129414204";
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+phno));
                if (ActivityCompat.checkSelfPermission
                        (getApplicationContext(),
                                Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED) {
                    {
                        ActivityCompat.requestPermissions
                                (MainActivity.this, new String[]{
                                        Manifest.permission.CALL_PHONE}, 101);}
                }
                startActivity(callIntent);
                return true;
            }
        });
    }
}
