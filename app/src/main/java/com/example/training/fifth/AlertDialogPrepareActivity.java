package com.example.training.fifth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.training.R;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AlertDialogPrepareActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String LOG_TAG = "myLogs";
    private final int DIALOG = 1;
    private SimpleDateFormat mSdf = new SimpleDateFormat("HH:mm:ss");
    private Button mBtnPrp;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_prepare);
        mBtnPrp = (Button) findViewById(R.id.btnPrp);
        mBtnPrp.setOnClickListener(this);
    }

    protected Dialog onCreateDialog(int id) {
        Log.d(LOG_TAG, "onCreateDialog");
        if (id == DIALOG) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle("Текущее время");
            adb.setMessage(mSdf.format(new Date(System.currentTimeMillis())));
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    protected void onPrepareDialog(int id, Dialog dialog) {
        super.onPrepareDialog(id, dialog);
        Log.d(LOG_TAG, "onPrepareDialog");
        if (id == DIALOG) {
            ((AlertDialog)dialog).setMessage(mSdf.format(new Date(System.currentTimeMillis())));
        }
    }

    @Override public void onClick(View v) {
        showDialog(DIALOG);
    }
}