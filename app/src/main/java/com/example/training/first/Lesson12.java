package com.example.training.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.training.R;

public class Lesson12 extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "myLogs";

    private TextView mTvOut;
    private Button mBtnOk;
    private Button mBtnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson12);
        Log.d(TAG, "найдем View-элементы");
        mTvOut = (TextView) findViewById(R.id.tvOut);
        mBtnOk = (Button) findViewById(R.id.btnOk);
        mBtnCancel = (Button) findViewById(R.id.btnCancel);
        Log.d(TAG, "присваиваем обработчик кнопкам");
        mBtnOk.setOnClickListener(this);
        mBtnCancel.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Log.d(TAG, "по id определяем кнопку, вызвавшую этот обработчик");
        switch (v.getId()) {
            case R.id.btnOk:
                Log.d(TAG, "кнопка ОК");
                mTvOut.setText("Нажата кнопка ОК");
                Toast.makeText(this, "Нажата кнопка ОК", Toast.LENGTH_LONG).show();
                break;
            case R.id.btnCancel:
                Log.d(TAG, "кнопка Cancel");
                mTvOut.setText("Нажата кнопка Cancel");
                Toast.makeText(this, "Нажата кнопка Cancel", Toast.LENGTH_LONG).show();
                break;
        }
    }
}