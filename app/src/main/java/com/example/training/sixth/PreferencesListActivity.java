package com.example.training.sixth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.training.R;

public class PreferencesListActivity extends AppCompatActivity {

    private TextView mTvInfo;
    private SharedPreferences mSp;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences_list);
        mTvInfo = (TextView) findViewById(R.id.tvInfo);
        mSp = PreferenceManager.getDefaultSharedPreferences(this);
    }

    @Override protected void onResume() {
        String listValue = mSp.getString("list", "не выбрано");
        mTvInfo.setText("Значение списка - " + listValue);
        super.onResume();
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuItem mi = menu.add(0, 1, 0, "Preferences");
        mi.setIntent(new Intent(this, PrefActivity.class));
        return super.onCreateOptionsMenu(menu);
    }
}