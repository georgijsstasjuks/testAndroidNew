package com.example.training.fifth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.training.R;

public class DatePickerDialogActivity extends AppCompatActivity {

    private static final int DIALOG_DATE = 1;
    private int mMyYear = 2021;
    private int mMyMonth = 03;
    private int mMyDay = 29;
    private TextView mTvDate;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker_dialog);
        mTvDate = (TextView) findViewById(R.id.tvDate);
    }

    public void onclick(View view) {
        showDialog(DIALOG_DATE);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, mMyYear, mMyMonth, mMyDay);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            mMyYear = year;
            mMyMonth = monthOfYear;
            mMyDay = dayOfMonth;
            mTvDate.setText("Today is " + mMyDay + "/" + mMyMonth + "/" + mMyYear);
        }
    };

}