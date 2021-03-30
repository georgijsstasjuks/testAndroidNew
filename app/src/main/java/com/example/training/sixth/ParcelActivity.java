package com.example.training.sixth;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;

import com.example.training.R;

public class ParcelActivity extends AppCompatActivity {

    private final String LOG_TAG = "myLogs";
    private Parcel mP;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcel);
        writeParcel();
        readParcel();
    }

    private void writeParcel() {
        mP = Parcel.obtain();

        byte b = 1;
        int i = 2;
        long l = 3;
        float f = 4;
        double d = 5;
        String s = "abcdefgh";

        logWriteInfo("before writing");
        mP.writeByte(b);
        logWriteInfo("byte");
        mP.writeInt(i);
        logWriteInfo("int");
        mP.writeLong(l);
        logWriteInfo("long");
        mP.writeFloat(f);
        logWriteInfo("float");
        mP.writeDouble(d);
        logWriteInfo("double");
        mP.writeString(s);
        logWriteInfo("String");
    }

    private void logWriteInfo(String txt) {
        Log.d(LOG_TAG, txt + ": " + "dataSize = " + mP.dataSize());
    }

    private void readParcel() {
        logReadInfo("before reading");
        mP.setDataPosition(0);
        logReadInfo("byte = " + mP.readByte());
        logReadInfo("int = " + mP.readInt());
        logReadInfo("long = " + mP.readLong());
        logReadInfo("float = " + mP.readFloat());
        logReadInfo("double = " + mP.readDouble());
        logReadInfo("string = " + mP.readString());
    }

    private void logReadInfo(String txt) {
        Log.d(LOG_TAG, txt + ": " + "dataPosition = " + mP.dataPosition());
    }
}