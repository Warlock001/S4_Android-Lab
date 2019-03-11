package com.example.a30797.androidclock;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.speech.tts.TextToSpeech;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


   /* private int[] imageIds = new int[]{
            R.drawable.bac_1,
            R.drawable.bac_2,
            R.drawable.bac_3,
            R.drawable.bac_4
    };*/

    private int num = 1;         //n
    private boolean flagI = true;//i
    private ImageView imageView;
    private TextView textView;
    private TextView textViewDate;
    Button b1,b2;
    TextToSpeech t1,t2;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");// HH:mm:ss
            //获取当前时间
            Date date = new Date(System.currentTimeMillis());
            textView.setText("" + simpleDateFormat.format(date));
            simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");// HH:mm:ss
            textViewDate.setText("" + simpleDateFormat.format(date));
        }
    };

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        transparency();
        textView = (TextView) findViewById(R.id.txt);
        b1 = (Button) findViewById(R.id.button);
               // imageView = (ImageView) findViewById(R.id.background);
        textViewDate = (TextView) findViewById(R.id.date);
        refreshTime();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
            t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        t1.setLanguage(Locale.UK);
                    }
                }
            });
            t2 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int status) {
                    if (status != TextToSpeech.ERROR) {
                        t2.setLanguage(Locale.UK);
                    }
                }
            });

            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String texttospeechv = textView.getText().toString();
                    String texttospeechv1 = textViewDate.getText().toString();
                   // Toast.makeText(getApplicationContext(), texttospeechv1, Toast.LENGTH_SHORT).show();
                   // Toast.makeText(getApplicationContext(), texttospeechv, Toast.LENGTH_SHORT).show();
                    t1.speak(texttospeechv, TextToSpeech.QUEUE_FLUSH, null);
                    t2.speak(texttospeechv1, TextToSpeech.QUEUE_FLUSH, null);
                }
            });

    }





    private void refreshTime(){
        new Thread(){//每秒更新时间
            @Override
            public void run() {
                while (true){
                    Message meg  = new Message();
                    handler.sendMessage(meg);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }

    public void show(View view){
        if(flagI) {
            textViewDate.setVisibility(View.GONE);
            flagI = false;
        }
    }

  /*  public void change(View view){
        imageView.setImageResource(imageIds[num++]);
        num %= 4;
        textViewDate.setVisibility(View.VISIBLE);
        flagI = true;
    } */


    private void transparency(){
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
    }

    /*public void butspeak(View view) {
    String speaktime=textView.getText().toString();
    String speakdate=textViewDate.getText().toString();
    tts.speak(speaktime,TextToSpeech.QUEUE_FLUSH,null);
    tts.speak(speakdate,TextToSpeech.QUEUE_FLUSH,null);

    }*/
    public void onPause() {
        if (t1 != null) {
            t1.stop();
            t1.shutdown();
        }
        super.onPause();
    }
}