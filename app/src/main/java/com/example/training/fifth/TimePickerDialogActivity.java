package com.example.training.fifth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.training.R;

public class TimePickerDialogActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int DIALOG_TIME = 1;
    private int myHour = 14;
    private int myMinute = 35;
    private TextView mTvTime;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker_dialog);
        mTvTime = (TextView) findViewById(R.id.tvTime);
        mTvTime.setOnClickListener(this);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_TIME) {
            TimePickerDialog tpd = new TimePickerDialog(this, myCallBack, myHour, myMinute, true);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    TimePickerDialog.OnTimeSetListener myCallBack = new TimePickerDialog.OnTimeSetListener() {
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            myHour = hourOfDay;
            myMinute = minute;
            mTvTime.setText("Time is " + myHour + " hours " + myMinute + " minutes");
        }
    };

    @Override public void onClick(View v) {
        showDialog(DIALOG_TIME);
    }
}