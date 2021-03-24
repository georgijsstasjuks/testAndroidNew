package com.example.training.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.training.R;

public class ColorActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtnRed;
    Button mBtnGreen;
    Button mBtnBlue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color);

        mBtnRed = (Button) findViewById(R.id.btnRed);
        mBtnGreen = (Button) findViewById(R.id.btnGreen);
        mBtnBlue = (Button) findViewById(R.id.btnBlue);

        mBtnRed.setOnClickListener(this);
        mBtnGreen.setOnClickListener(this);
        mBtnBlue.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnRed:
                intent.putExtra("color", Color.RED);
                break;
            case R.id.btnGreen:
                intent.putExtra("color", Color.GREEN);
                break;
            case R.id.btnBlue:
                intent.putExtra("color", Color.BLUE);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}