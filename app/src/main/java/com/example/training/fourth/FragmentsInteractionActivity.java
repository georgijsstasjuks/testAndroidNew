package com.example.training.fourth;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.training.R;

public class FragmentsInteractionActivity extends AppCompatActivity implements SecondFragment.onSomeEventListener {

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragments_interaction);

        SecondFragment frag2 = new SecondFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.add(R.id.fragmentSecond, frag2);
        ft.commit();
    }

    public void onClick(View v) {
        Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView) frag1.getView().findViewById(R.id.textView))
                .setText("Access to Fragment 1 from Activity");

        Fragment frag2 = getFragmentManager().findFragmentById(R.id.fragmentSecond);
        ((TextView) frag2.getView().findViewById(R.id.textView))
                .setText("Access to Fragment 2 from Activity");

    }

    @Override public void someEvent(String s) {
        Fragment frag1 = getFragmentManager().findFragmentById(R.id.fragment1);
        ((TextView)frag1.getView().findViewById(R.id.textView)).setText("Text from Fragment 2:" + s);
    }
}