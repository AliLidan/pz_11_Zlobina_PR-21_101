package com.example.pr_11;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;


import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public boolean Started = false;
    public boolean Finished = false;
    Button start, drive1, drive2;
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            this.getSupportActionBar().hide();
        } catch (NullPointerException e) {
            setContentView(R.layout.activity_main);
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            start=findViewById(R.id.btnStart);
            start.setOnClickListener(this);
            drive1=findViewById(R.id.btnDrive1);
            drive1.setOnClickListener(this);
            drive2=findViewById(R.id.btnDrive2);
            drive2.setOnClickListener(this);
            result = findViewById(R.id.tvResult);

        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnStart:
                if (!Finished) {
                    if (!Started) {
                        start.setBackgroundColor(Color.RED); //red
                        start.setText("Пауза");
                        Started = true;
                    } else {
                        start.setBackgroundColor(Color.GREEN); //green
                        start.setText("Старт");
                        Started = false;}
                }else {
                        Intent intent = new Intent(MainActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                break;
            case R.id.btnDrive1:
                View Car = findViewById(R.id.Car1);
                if(Started && !Finished){
                    ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car. getLayoutParams();
                    margin. leftMargin += 50;
                    Car.requestLayout();
                    if(margin.leftMargin >= 800){
                        result.setText("Победа 1 игрока");
                        start.setText("Заново");
                        result.setTextColor(0xffe91E63);
                        Finished = true;
                        Started = false;
                    }
                }
                break;
            case R.id.btnDrive2:
                View Car2 = findViewById(R.id.Car2);
                if(Started && !Finished){
                    ViewGroup.MarginLayoutParams margin = (ViewGroup.MarginLayoutParams)Car2.getLayoutParams();
                    margin.leftMargin += 50;

                    Car2. requestLayout();
                    if(margin.leftMargin >= 800){
	                    result.setText("Победа 2 игрока");
                        start.setText("Заново");
                        result.setTextColor(0xfff00000);
                        Finished = true;
                        Started = false;
                    }
                }
                break;
            }

        }

    }
