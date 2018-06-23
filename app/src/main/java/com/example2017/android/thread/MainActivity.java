package com.example2017.android.thread;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    Handler handler;
    boolean mStop=false;
    int count =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);




        Log.i("sdsd","thread is "+Thread.currentThread().getId());


        handler = new Handler(getApplicationContext().getMainLooper());



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStop=true;

                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        while(mStop)
                        {


                            try {
                                Thread.sleep(1000);
                                count++;
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }


                            handler.post(new Runnable() {
                                @Override
                                public void run()
                                {

                                textView.setText(String.valueOf(count));
                                Log.i("sdsd","thread is "+Thread.currentThread().getId());

                                }
                            });

                        }



                    }
                }).start();














            }
        });



    }}