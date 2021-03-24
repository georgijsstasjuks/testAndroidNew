package com.example.training.second;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.training.R;

public class UriIntentActivity extends AppCompatActivity implements View.OnClickListener {

    Button mBtnWeb;
    Button mBtnMap;
    Button mBtnCall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uri_untent);
        mBtnWeb = (Button) findViewById(R.id.btnWeb);
        mBtnMap = (Button) findViewById(R.id.btnMap);
        mBtnCall = (Button) findViewById(R.id.btnCall);

        mBtnWeb.setOnClickListener(this);
        mBtnMap.setOnClickListener(this);
        mBtnCall.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.btnWeb:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://developer.android.com"));
                startActivity(intent);
                break;
            case R.id.btnMap:
                intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("geo:55.754283,37.62002"));
                startActivity(intent);
                break;
            case R.id.btnCall:
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:12345"));
                startActivity(intent);
                break;
        }
    }
}