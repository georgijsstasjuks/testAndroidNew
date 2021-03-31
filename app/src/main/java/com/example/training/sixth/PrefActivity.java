package com.example.training.sixth;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceCategory;

import com.example.training.R;

public class PrefActivity extends PreferenceActivity {

    private CheckBoxPreference mChb3;
    private PreferenceCategory mCateg2;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.pref);

        mChb3 = (CheckBoxPreference) findPreference("chb3");
        mCateg2  = (PreferenceCategory) findPreference("categ2");
        mCateg2.setEnabled(mChb3.isChecked());

        mChb3.setOnPreferenceClickListener(preference -> {
            mCateg2.setEnabled(mChb3.isChecked());
            return false;
        });
    }
}