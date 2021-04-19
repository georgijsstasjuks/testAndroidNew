package com.example.training.constraint;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.transition.TransitionManager;

import android.os.Bundle;
import android.widget.Button;
import com.example.training.R;

public class ConstraintSetActivity extends AppCompatActivity {

    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_set);
        Button btn = findViewById(R.id.btnConst);
        mConstraintLayout = findViewById(R.id.container);
        btn.setOnClickListener(e -> onButtonClick());
    }

    private void onButtonClick() {
        ConstraintSet set = new ConstraintSet();
        set.clone(mConstraintLayout);

        changeConstraints(set);
        TransitionManager.beginDelayedTransition(mConstraintLayout);

        set.applyTo(mConstraintLayout);
    }

    private void changeConstraints(ConstraintSet set) {
        set.clear(R.id.textView3, ConstraintSet.LEFT);
        set.clear(R.id.textView3, ConstraintSet.TOP);

        set.connect(R.id.textView3, ConstraintSet.LEFT, R.id.textView2, ConstraintSet.LEFT);
        set.connect(R.id.textView3, ConstraintSet.BOTTOM, R.id.textView2, ConstraintSet.TOP, 1);
    }



}