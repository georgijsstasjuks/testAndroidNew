package com.example.training.tasks1_20;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.training.R;

public class Lesson15 extends AppCompatActivity {
    TextView mTvColor, mTvSize;

    final int MENU_COLOR_RED = 1;
    final int MENU_COLOR_GREEN = 2;
    final int MENU_COLOR_BLUE = 3;

    final int MENU_SIZE_22 = 4;
    final int MENU_SIZE_26 = 5;
    final int MENU_SIZE_30 = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson15);

        mTvColor = (TextView) findViewById(R.id.tvColor);
        mTvSize = (TextView) findViewById(R.id.tvSize);

        registerForContextMenu(mTvColor);
        registerForContextMenu(mTvSize);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        switch (v.getId()) {
            case R.id.tvColor:
                menu.add(0, MENU_COLOR_RED, 0, "Red");
                menu.add(0, MENU_COLOR_GREEN, 0, "Green");
                menu.add(0, MENU_COLOR_BLUE, 0, "Blue");
                break;
            case R.id.tvSize:
                menu.add(0, MENU_SIZE_22, 0, "22");
                menu.add(0, MENU_SIZE_26, 0, "26");
                menu.add(0, MENU_SIZE_30, 0, "30");
                break;
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            // пункты меню для tvColor
            case MENU_COLOR_RED:
                mTvColor.setTextColor(Color.RED);
                mTvColor.setText("Text color = red");
                break;
            case MENU_COLOR_GREEN:
                mTvColor.setTextColor(Color.GREEN);
                mTvColor.setText("Text color = green");
                break;
            case MENU_COLOR_BLUE:
                mTvColor.setTextColor(Color.BLUE);
                mTvColor.setText("Text color = blue");
                break;
            case MENU_SIZE_22:
                mTvSize.setTextSize(22);
                mTvSize.setText("Text size = 22");
                break;
            case MENU_SIZE_26:
                mTvSize.setTextSize(26);
                mTvSize.setText("Text size = 26");
                break;
            case MENU_SIZE_30:
                mTvSize.setTextSize(30);
                mTvSize.setText("Text size = 30");
                break;
        }
        return super.onContextItemSelected(item);
    }

}