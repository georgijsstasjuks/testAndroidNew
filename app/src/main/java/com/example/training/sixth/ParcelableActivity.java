package com.example.training.sixth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.training.R;

public class ParcelableActivity extends AppCompatActivity implements View.OnClickListener {

    private final String LOG_TAG = "myLogs";
    private Button mBtn;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcelable);
        mBtn = (Button) findViewById(R.id.button1);
        mBtn.setOnClickListener(this);
    }

    @Override public void onClick(View v) {
        MyObject myObj = new MyObject("text", 1);
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(MyObject.class.getCanonicalName(), myObj);
        Log.d(LOG_TAG, "startActivity");
        startActivity(intent);
    }
}