package com.example.training.fourth;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;
import android.view.View;

import com.example.training.R;

public class DialogFragmentActivity extends AppCompatActivity {

    private DialogFirstFragment mDlg1;
    private DialogSecondFragment mDlg2;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
        mDlg1 = new DialogFirstFragment();
        mDlg2 = new DialogSecondFragment();
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnDlg1:
                mDlg1.show(getFragmentManager(), "dlg1");
                break;
            case R.id.btnDlg2:
                mDlg2.show(getFragmentManager(), "dlg2");
                break;
            default:
                break;
        }

    }
}