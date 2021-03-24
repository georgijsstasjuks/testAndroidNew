package com.example.training.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.training.R;

public class IntentExtras extends AppCompatActivity implements View.OnClickListener {

    EditText mEtFName;
    EditText mEtLName;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_extras);
        mEtFName = (EditText) findViewById(R.id.etFName);
        mEtLName = (EditText) findViewById(R.id.etLName);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ViewActivity.class);
        intent.putExtra("fname", mEtFName.getText().toString());
        intent.putExtra("lname", mEtLName.getText().toString());
        startActivity(intent);
    }
}