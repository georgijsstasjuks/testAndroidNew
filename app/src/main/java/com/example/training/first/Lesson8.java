package com.example.training.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.training.R;

public class Lesson8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson8);
        TextView myTextView = (TextView) findViewById(R.id.myText);
        myTextView.setText("New text in TextView");
        Button myBtn = (Button) findViewById(R.id.myBtn);
        myBtn.setText("My button");
        myBtn.setEnabled(false);
        CheckBox myChb = (CheckBox) findViewById(R.id.myChb);
        myChb.setChecked(true);
    }
}