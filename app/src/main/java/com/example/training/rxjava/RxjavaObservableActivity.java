package com.example.training.rxjava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import com.example.training.R;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class RxjavaObservableActivity extends AppCompatActivity {


    private static final String TAG = "TEST";

    private Button mBtnTest;

    private CompositeDisposable mDisposableBag = new CompositeDisposable();

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxjava_observable);

        mBtnTest = findViewById(R.id.btnTest);
        mBtnTest.setOnClickListener( v -> {
            Log.e(TAG,"clicked!");
        });

        Disposable dispose  =  dataSource()
                .subscribeOn(Schedulers.newThread())
                .filter(item -> { return item % 2 == 0;})
                .map(item -> { return item/=2; })
                .buffer(2)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(value -> {
                    Log.e(TAG, "next value: " + value);
                },
                throwable -> {
                    Log.e(TAG, throwable.getLocalizedMessage());
                });

        mDisposableBag.add(dispose);
    }

    @Override protected void onDestroy() {
        mDisposableBag.clear();
        super.onDestroy();
    }

    public Observable<Integer> dataSource() {
        return Observable.create(subscriber -> {
            for (int i =0; i<100; i++) {
                Thread.sleep(100);
                subscriber.onNext(i);
            }
            subscriber.onComplete();
        });
    }



}