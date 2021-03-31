package com.example.training.sixth;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import com.example.training.R;

public class PrefActivity extends PreferenceActivity {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);
    }
}