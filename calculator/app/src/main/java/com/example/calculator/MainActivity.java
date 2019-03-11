package com.example.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b0,badd,bsub,bmul,bdiv,bdot,beq,bdel;
EditText et;
float f1,f2;
boolean add,sub,mul,div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.but1);
        b2=(Button)findViewById(R.id.but2);
        b3=(Button)findViewById(R.id.but3);
        b4=(Button)findViewById(R.id.but4);
        b5=(Button)findViewById(R.id.but5);
        b6=(Button)findViewById(R.id.but6);
        b7=(Button)findViewById(R.id.but7);
        b8=(Button)findViewById(R.id.but8);
        b9=(Button)findViewById(R.id.but9);
        b0=(Button)findViewById(R.id.butzero);
        badd=(Button)findViewById(R.id.butplus);
        bsub=(Button)findViewById(R.id.butsub);
        bmul=(Button)findViewById(R.id.butmul);
        bdiv=(Button)findViewById(R.id.butdiv);
        bdot=(Button)findViewById(R.id.butdot);
        beq=(Button)findViewById(R.id.butequal);
        bdel=(Button)findViewById(R.id.butdel);
        et=(EditText)findViewById(R.id.textview);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"2");
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"8");
            }
        });


        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"9");
            }
        });


        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+"0");
            }
        });
        bdot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText(et.getText()+".");
            }
        });
        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et == null)
                {
                    et.setText("");
                }
                else
                {
                    f1=Float.parseFloat(et.getText()+ " ");
                    add=true;
                    et.setText("");
                }
            }
        });
        bsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    f1=Float.parseFloat(et.getText()+ " ");
                    sub= true;
                    et.setText("");

            }
        });
        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et == null)
                {
                    et.setText("");
                }
                else
                {
                    f1=Float.parseFloat(et.getText()+ " ");
                    mul=true;
                    et.setText("");
                }
            }
        });
        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et == null)
                {
                    et.setText("");
                }
                else
                {
                    f1=Float.parseFloat(et.getText()+ " ");
                    div=true;
                    et.setText("");
                }
            }
        });

        bdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et.setText("");
            }
        });
        beq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            f2=Float.parseFloat(et.getText()+"");
            if(add==true)
            {
                et.setText(f1+f2+"");
                add=false;
            }

                 if(sub==true)
                {
                    et.setText(f1-f2+"");
                    sub=false;
                }
               if(mul==true)
                {
                    et.setText(f1*f2+"");
                    mul=false;
                }
                if(div==true)
                {
                    et.setText(f1/f2+"");
                    div=false;
                }

            }
        });

    }
}
