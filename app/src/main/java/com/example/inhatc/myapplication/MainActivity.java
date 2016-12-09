package com.example.inhatc.myapplication;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int sum=0;
    int adult=0;
    int child=0;
    int older=0;

    String day=null;
    String time=null;

    FrameLayout frame;
    LinearLayout linearLayout1;
    LinearLayout linearLayout2;
    ImageView imgView;
    RadioGroup rg1;

    Switch swt;
    Chronometer chronometer;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 화면");

        frame = (FrameLayout)findViewById(R.id.frameLayout);
        linearLayout1 = (LinearLayout)findViewById(R.id.inLayout1);
        linearLayout2 = (LinearLayout)findViewById(R.id.inLayout2);

        chronometer = (Chronometer)findViewById(R.id.chronometer);
        setSwitch();
        setImageView();
        setRadioGroup();
    }
    void setSwitch(){
        swt = (Switch)findViewById(R.id.switch1);
        swt.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.start();
                    frame.setVisibility(View.VISIBLE);
                }
                else{
                    chronometer.setBase(SystemClock.elapsedRealtime());
                    chronometer.stop();
                    frame.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    void setImageView(){
        imgView = (ImageView)findViewById(R.id.imageView);
    }
    //라디오 버튼 선택 시 이미지 바뀌도록 기능 구현
    void setRadioGroup(){
        rg1 = (RadioGroup)findViewById(R.id.radioGroup1);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId==R.id.radioButton){
                    imgView.setImageResource(R.drawable.admin);
                }
                else if(checkedId==R.id.radioButton2){
                    imgView.setImageResource(R.drawable.admin1);
                }
                else{
                    imgView.setImageResource(R.drawable.admin3);
                }
            }
        });
    }

    void setButton(){
        btn1= (Button)findViewById(R.id.button1);
        btn2= (Button)findViewById(R.id.button2);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(adult==0 || child==0 || older==0){
                    Toast.makeText(getApplicationContext(),"인원을 입력해주세요",Toast.LENGTH_SHORT).show();
                }
                else
            }
        });
    }
}
