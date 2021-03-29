package com.example.training.fifth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

import com.example.training.R;

public class GridViewActivity extends AppCompatActivity {

    private String[] mData = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};

    private GridView mGvMain;
    private ArrayAdapter<String> mAdapter;


    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        mAdapter = new ArrayAdapter<String>(this, R.layout.item_adapter, R.id.tvText, mData);
        mGvMain = (GridView) findViewById(R.id.gvMain);
        mGvMain.setAdapter(mAdapter);
        adjustGridView();
    }

    private void adjustGridView() {
        mGvMain.setNumColumns(GridView.AUTO_FIT);
        mGvMain.setColumnWidth(80);
        mGvMain.setVerticalSpacing(5);
        mGvMain.setHorizontalSpacing(5);
        mGvMain.setStretchMode(GridView.NO_STRETCH);
    }
}