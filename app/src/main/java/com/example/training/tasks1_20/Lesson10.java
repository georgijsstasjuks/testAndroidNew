package com.example.training.tasks1_20;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.training.R;

public class Lesson10 extends AppCompatActivity implements View.OnClickListener {

    private TextView mTvOut;
    private Button mBtnOk;
    private Button mBtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson10);
        mTvOut = (TextView) findViewById(R.id.tvOut);
        mBtnOk = (Button) findViewById(R.id.btnOk);
        mBtnCancel = (Button) findViewById(R.id.btnCancel);
        mBtnOk.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOk:
                mTvOut.setText("Нажата кнопка ОК");
                break;
            case R.id.btnCancel:
                mTvOut.setText("Нажата кнопка Cancel");
                break;
        }
    }
}