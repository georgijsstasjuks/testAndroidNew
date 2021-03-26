package com.example.training.fourth;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.example.training.R;

public class FragmentDynamicActivity extends AppCompatActivity {

    private LeftFragment mFrag1;
    private RightFragment mFrag2;
    private FragmentTransaction mFTrans;
    private CheckBox mChbStack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_dynamic);

        mFrag1 = new LeftFragment();
        mFrag2 = new RightFragment();

        mChbStack = (CheckBox)findViewById(R.id.chbStack);
    }

    public void onClick(View v) {
        mFTrans = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.btnAdd:
                mFTrans.add(R.id.frgmCont, mFrag1);
                break;
            case R.id.btnRemove:
                mFTrans.remove(mFrag1);
                break;
            case R.id.btnReplace:
                mFTrans.replace(R.id.frgmCont, mFrag2);
            default:
                break;
        }
        if (mChbStack.isChecked()) mFTrans.addToBackStack(null);
        mFTrans.commit();
    }
}