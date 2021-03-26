package com.example.training.third;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.training.R;

public class SharedPreferencesActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtText;
    private Button mBtnSave, mBtnLoad;
    private SharedPreferences mSpref;

    private final String SAVED_TEXT = "saved_text";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_activity);
        setupView();
        setupListeners();
        loadText();
    }

    @Override public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            default:
                break;
        }
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        saveText();
    }

    private void setupView() {
        mEtText = (EditText) findViewById(R.id.etText);
        mBtnSave = (Button) findViewById(R.id.btnSave);
        mBtnLoad = (Button) findViewById(R.id.btnLoad);
    }

    private void setupListeners() {
        mBtnSave.setOnClickListener(this);
        mBtnLoad.setOnClickListener(this);
    }

   private void saveText() {
        mSpref = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = mSpref.edit();
        ed.putString(SAVED_TEXT, mEtText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
    }

    private void loadText() {
        mSpref = getPreferences(MODE_PRIVATE);
        String savedText = mSpref.getString(SAVED_TEXT, "");
        mEtText.setText(savedText);
        Toast.makeText(this, "Text loaded", Toast.LENGTH_SHORT).show();
    }

}