package com.example.training.fourth;

import android.preference.PreferenceActivity;

import com.example.training.R;

import java.util.List;

public class PreferenceFragmentActivity extends PreferenceActivity  {

    public void onBuildHeaders(List<PreferenceActivity.Header> target) {
        loadHeadersFromResource(R.xml.head_pref, target);
    }
}