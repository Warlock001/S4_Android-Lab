package com.example.warlock.validation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    EditText email,pass;
    Button loginbtn;
    Pattern p;
    String mail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        loginbtn=findViewById(R.id.loginbtn);

        loginbtn.setEnabled(false);

        p=Pattern.compile(".+@.+\\.[a-z]+");

        email.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                mail="alfinwilliam@gmail.com";
                String mailcheck=email.getText().toString();
                Matcher match=p.matcher(mailcheck);
                if(match.matches() && mailcheck.equals(mail))
                {
                    Toast.makeText(getApplicationContext(),"Email verified",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Invalid Email",Toast.LENGTH_SHORT).show();
                }
            }
        });

        pass.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                String pasa="admin@123";
                String pasb=pass.getText().toString();
                if(pasb.equals(pasa)){
                    Toast.makeText(getApplicationContext(),"Password verified",Toast.LENGTH_SHORT).show();
                    loginbtn.setEnabled(true);

                }
            }
        });

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,welcome.class);
                intent.putExtra("username",mail);
                startActivity(intent);
            }
        });
    }
}
