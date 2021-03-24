package com.example.training.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.training.R;

public class Lesson9 extends AppCompatActivity {

    private TextView mTvOut;
    private Button mBtnOk;
    private Button mBtnCancel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson9);

        mTvOut = (TextView) findViewById(R.id.tvOut);
        mBtnOk = (Button) findViewById(R.id.btnOk);
        mBtnCancel = (Button) findViewById(R.id.btnCancel);
        View.OnClickListener oclBtnOk = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTvOut.setText("Нажата кнопка ОК");
            }
        };
        mBtnOk.setOnClickListener(oclBtnOk);

        View.OnClickListener oclBtnCancel = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mTvOut.setText("Нажата кнопка Cancel");
            }
        };

        mBtnCancel.setOnClickListener(oclBtnCancel);

    }
}