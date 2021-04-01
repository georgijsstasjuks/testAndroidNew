package com.example.training.sixth;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import com.example.training.R;

public class FilesActivity extends AppCompatActivity {

    private Button mBtnWrite;
    private Button mBtnRead;
    private Button mBtnWriteSD;
    private Button mBtnReadSD;

    private Files mFile;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_files);
        mFile = new Files(getApplicationContext());
        setupViews();
        setupListeners();
    }

    private void setupViews() {
        mBtnWrite = (Button) findViewById(R.id.btnWrite);
        mBtnRead = (Button) findViewById(R.id.btnRead);
        mBtnWriteSD = (Button) findViewById(R.id.btnWriteSD);
        mBtnReadSD = (Button) findViewById(R.id.btnReadSD);
    }

    private void setupListeners() {
        mBtnWrite.setOnClickListener( v -> {
            mFile.writeFile();
        });
        mBtnRead.setOnClickListener(v -> {
            mFile.readFile();
        });
        mBtnWriteSD.setOnClickListener(v -> {
            mFile.writeFileSD();
        });
        mBtnReadSD.setOnClickListener(v -> {
            mFile.readFileSD();
        });
    }

}