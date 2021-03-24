package com.example.training.first;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.training.R;

public class Lesson17 extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLlMain;
    private RadioGroup mRgGravity;
    private EditText mEtName;
    private Button mBtnCreate;
    private Button mBtnClear;
    private int mWrapContent = LinearLayout.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson17);

        mLlMain = (LinearLayout) findViewById(R.id.llMain);
        mRgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        mEtName = (EditText) findViewById(R.id.etName);

        mBtnCreate = (Button) findViewById(R.id.btnCreate);
        mBtnCreate.setOnClickListener(this);

        mBtnClear = (Button) findViewById(R.id.btnClear);
        mBtnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreate:

                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(
                        mWrapContent, mWrapContent);
                int btnGravity = Gravity.LEFT;
                switch (mRgGravity.getCheckedRadioButtonId()) {
                    case R.id.rbLeft:
                        btnGravity = Gravity.LEFT;
                        break;
                    case R.id.rbCenter:
                        btnGravity = Gravity.CENTER_HORIZONTAL;
                        break;
                    case R.id.rbRight:
                        btnGravity = Gravity.RIGHT;
                        break;
                }
                lParams.gravity = btnGravity;
                Button btnNew = new Button(this);
                btnNew.setText(mEtName.getText().toString());
                mLlMain.addView(btnNew, lParams);
                break;
            case R.id.btnClear:
                mLlMain.removeAllViews();
                Toast.makeText(this, "Удалено", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}