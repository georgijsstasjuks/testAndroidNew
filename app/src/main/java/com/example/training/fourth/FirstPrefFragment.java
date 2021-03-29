package com.example.training.fourth;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.example.training.R;

public class FirstPrefFragment extends PreferenceFragment {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.first_pref);
    }

}
