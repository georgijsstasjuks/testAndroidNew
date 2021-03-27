package com.example.training.fourth;

import android.app.Activity;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Fragment;
import com.example.training.R;


public class SecondFragment extends Fragment {

    public interface onSomeEventListener {
        public void someEvent(String s);
    }

    onSomeEventListener someEventListener;

    @Override  public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            someEventListener = (onSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }

    @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_second, null);

        Button button = (Button) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                someEventListener.someEvent("Test text to Fragment1");
            }
        });

        return v;
    }
}