package com.example.training.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;

import com.example.training.R;

public class Lesson18 extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    SeekBar mSbWeight;
    Button mBtn1;
    Button mBtn2;
    LinearLayout.LayoutParams mLparams1;
    LinearLayout.LayoutParams mLparams2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson18);
        mSbWeight = (SeekBar) findViewById(R.id.sbWeight);
        mSbWeight.setOnSeekBarChangeListener(this);

        mBtn1 = (Button) findViewById(R.id.btn1);
        mBtn2 = (Button) findViewById(R.id.btn2);

        mLparams1 = (LinearLayout.LayoutParams) mBtn1.getLayoutParams();
        mLparams2 = (LinearLayout.LayoutParams) mBtn2.getLayoutParams();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int leftValue = progress;
        int rightValue = seekBar.getMax() - progress;

        mLparams1.weight = leftValue;
        mLparams2.weight = rightValue;

        mBtn1.setText(String.valueOf(leftValue));
        mBtn2.setText(String.valueOf(rightValue));
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}