package com.example.training.fifth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;

import com.example.training.R;

public class AlertDialogItemsActivity extends AppCompatActivity implements View.OnClickListener {

    private final String LOG_TAG = "myLogs";

    private final int DIALOG_ITEMS = 1;
    private final int DIALOG_ADAPTER = 2;
    private final int DIALOG_CURSOR = 3;
    private int mCnt = 0;
    private DB mDb;
    private Cursor mCursor;

    private Button mBtnItems;
    private Button mBtnAdapter;
    private Button mBtnCursor;

    private String mData[] = { "one", "two", "three", "four" };

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog_items);

        mDb = new DB(this);
        mDb.open();
        mCursor = mDb.getAllData();
        startManagingCursor(mCursor);
        setupViews();
        setupListeners();
    }

    private void setupViews() {
        mBtnItems = (Button) findViewById(R.id.btnItems);
        mBtnAdapter = (Button) findViewById(R.id.btnAdapter);
        mBtnCursor = (Button) findViewById(R.id.btnCursor);
    }

    private void setupListeners() {
        mBtnItems.setOnClickListener(this);
        mBtnAdapter.setOnClickListener(this);
        mBtnCursor.setOnClickListener(this);
    }

    protected Dialog onCreateDialog(int id) {
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        switch (id) {
            case DIALOG_ITEMS:
                adb.setTitle(R.string.items);
                adb.setItems(mData, myClickListener);
                break;
            case DIALOG_ADAPTER:
                adb.setTitle(R.string.adapter);
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                        android.R.layout.select_dialog_item, mData);
                adb.setAdapter(adapter, myClickListener);
                break;
            case DIALOG_CURSOR:
                adb.setTitle(R.string.cursor);
                adb.setCursor(mCursor, myClickListener, DB.COLUMN_TXT);
                break;
        }
        return adb.create();
    }

    protected void onPrepareDialog(int id, Dialog dialog) {
        AlertDialog aDialog = (AlertDialog) dialog;
        ListAdapter lAdapter = aDialog.getListView().getAdapter();

        switch (id) {
            case DIALOG_ITEMS:
            case DIALOG_ADAPTER:
                if (lAdapter instanceof BaseAdapter) {
                    BaseAdapter bAdapter = (BaseAdapter) lAdapter;
                    bAdapter.notifyDataSetChanged();
                }
                break;
            default:
                break;
        }
    };

    DialogInterface.OnClickListener myClickListener = (dialog, which) -> {
        Log.d(LOG_TAG, "which = " + which);
    };

    private void changeCount() {
        mCnt++;
        mData[3] = String.valueOf(mCnt);
        mDb.changeRec(4, String.valueOf(mCnt));
        mCursor.requery();
    }

    @Override protected void onDestroy() {
        super.onDestroy();
        mDb.close();
    }

    @Override public void onClick(View v) {
        changeCount();
        switch (v.getId()) {
            case R.id.btnItems:
                showDialog(DIALOG_ITEMS);
                break;
            case R.id.btnAdapter:
                showDialog(DIALOG_ADAPTER);
                break;
            case R.id.btnCursor:
                showDialog(DIALOG_CURSOR);
                break;
            default:
                break;
        }
    }
}