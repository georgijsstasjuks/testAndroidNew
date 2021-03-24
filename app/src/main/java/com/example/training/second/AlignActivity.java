package com.example.training.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import com.example.training.R;

public class AlignActivity extends AppCompatActivity  implements View.OnClickListener {

    Button mBtnLeft;
    Button mBtnCenter;
    Button mBtnRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_align);

        mBtnLeft = (Button) findViewById(R.id.btnLeft);
        mBtnCenter = (Button) findViewById(R.id.btnCenter);
        mBtnRight = (Button) findViewById(R.id.btnRight);

        mBtnLeft.setOnClickListener(this);
        mBtnCenter.setOnClickListener(this);
        mBtnRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        switch (v.getId()) {
            case R.id.btnLeft:
                intent.putExtra("alignment", Gravity.LEFT);
                break;
            case R.id.btnCenter:
                intent.putExtra("alignment", Gravity.CENTER);
                break;
            case R.id.btnRight:
                intent.putExtra("alignment", Gravity.RIGHT);
                break;
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}