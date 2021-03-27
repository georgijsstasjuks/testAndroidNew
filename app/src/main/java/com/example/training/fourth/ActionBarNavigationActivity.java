package com.example.training.fourth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import com.example.training.R;

public class ActionBarNavigationActivity extends AppCompatActivity implements  ActionBar.OnNavigationListener {

    private String[] mData = new String[] { "one", "two", "three" };

    private final String LOG_TAG = "myLogs";

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action_bar_navigation);

        ActionBar bar = getActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_LIST);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, mData);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        bar.setListNavigationCallbacks(adapter, this);
    }

    @Override public boolean onNavigationItemSelected(int itemPosition, long itemId) {
        Log.d(LOG_TAG, "selected: position = " + itemPosition + ", id = "
                + itemId + ", " + mData[itemPosition]);
        return false;
    }
}