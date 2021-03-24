package com.example.training.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.training.R;

public class ViewActivity extends AppCompatActivity {

    TextView mTvView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        mTvView = (TextView) findViewById(R.id.tvView);
        Intent intent = getIntent();
        String fName = intent.getStringExtra("fname");
        String lName = intent.getStringExtra("lname");
        mTvView.setText("Your name is: " + fName + " " + lName);
    }
}