package com.example.training.third;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import com.example.training.R;

public class SqliteQueryActivity extends AppCompatActivity implements View.OnClickListener {

    private final String LOG_TAG = "myLogs";

    private String mName[] = { "Китай", "США", "Бразилия", "Россия", "Япония",
            "Германия", "Египет", "Италия", "Франция", "Канада" };
    private int mPeople[] = { 1400, 311, 195, 142, 128, 82, 80, 60, 66, 35 };
    private String mRegion[] = { "Азия", "Америка", "Америка", "Европа", "Азия",
            "Европа", "Африка", "Европа", "Европа", "Америка" };

    private View mBtnAll;
    private Button mBtnFunc;
    private Button mBtnPeople;
    private Button mBtnSort;
    private Button mBtnGroup;
    private Button mBtnHaving;
    private EditText mEtFunc, mEtPeople, mEtRegionPeople;
    private RadioGroup mRgSort;

    private DBHelper mDbHelper;
    private SQLiteDatabase mDb;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite_query);
        setupViews();
        setupListeners();

        mDbHelper = new DBHelper(this);
        mDb = mDbHelper.getWritableDatabase();


        Cursor c = mDb.query("mytable", null, null, null, null, null, null);
        if (c.getCount() == 0) {
            ContentValues cv = new ContentValues();
            for (int i = 0; i < 10; i++) {
                cv.put("name", mName[i]);
                cv.put("people", mPeople[i]);
                cv.put("region", mRegion[i]);
                Log.d(LOG_TAG, "id = " + mDb.insert("mytable", null, cv));
            }
        }
        c.close();
        mDbHelper.close();
        onClick(mBtnAll);
    }

    private void setupViews() {
        mBtnHaving = (Button) findViewById(R.id.btnHaving);
        mBtnGroup = (Button) findViewById(R.id.btnGroup);
        mBtnSort = (Button) findViewById(R.id.btnSort);
        mBtnPeople = (Button) findViewById(R.id.btnPeople);
        mBtnFunc = (Button) findViewById(R.id.btnFunc);
        mBtnAll = (Button) findViewById(R.id.btnAll);
        mEtFunc = (EditText) findViewById(R.id.etFunc);
        mEtPeople = (EditText) findViewById(R.id.etPeople);
        mEtRegionPeople = (EditText) findViewById(R.id.etRegionPeople);
        mRgSort = (RadioGroup) findViewById(R.id.rgSort);
    }

    private void setupListeners() {
        mBtnAll.setOnClickListener(this);
        mBtnFunc.setOnClickListener(this);
        mBtnPeople.setOnClickListener(this);
        mBtnSort.setOnClickListener(this);
        mBtnGroup.setOnClickListener(this);
        mBtnHaving.setOnClickListener(this);
    }

    public void onClick(View v) {
        mDb = mDbHelper.getWritableDatabase();
        String sFunc = mEtFunc.getText().toString();
        String sPeople = mEtPeople.getText().toString();
        String sRegionPeople = mEtRegionPeople.getText().toString();

        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        Cursor c = null;

        switch (v.getId()) {

            case R.id.btnAll:
                Log.d(LOG_TAG, "--- Все записи ---");
                c = mDb.query("mytable", null, null, null, null, null, null);
                break;

            case R.id.btnFunc:
                Log.d(LOG_TAG, "--- Функция " + sFunc + " ---");
                columns = new String[] { sFunc };
                c = mDb.query("mytable", columns, null, null, null, null, null);
                break;

            case R.id.btnPeople:
                Log.d(LOG_TAG, "--- Население больше " + sPeople + " ---");
                selection = "people > ?";
                selectionArgs = new String[] { sPeople };
                c = mDb.query("mytable", null, selection, selectionArgs, null, null,
                        null);
                break;

            case R.id.btnGroup:
                Log.d(LOG_TAG, "--- Население по региону ---");
                columns = new String[] { "region", "sum(people) as people" };
                groupBy = "region";
                c = mDb.query("mytable", columns, null, null, groupBy, null, null);
                break;

            case R.id.btnHaving:
                Log.d(LOG_TAG, "--- Регионы с населением больше " + sRegionPeople
                        + " ---");
                columns = new String[] { "region", "sum(people) as people" };
                groupBy = "region";
                having = "sum(people) > " + sRegionPeople;
                c = mDb.query("mytable", columns, null, null, groupBy, having, null);
                break;

            case R.id.btnSort:

                switch (mRgSort.getCheckedRadioButtonId()) {

                    case R.id.rName:
                        Log.d(LOG_TAG, "--- Сортировка по наименованию ---");
                        orderBy = "name";
                        break;

                    case R.id.rPeople:
                        Log.d(LOG_TAG, "--- Сортировка по населению ---");
                        orderBy = "people";
                        break;

                    case R.id.rRegion:
                        Log.d(LOG_TAG, "--- Сортировка по региону ---");
                        orderBy = "region";
                        break;
                }
                c = mDb.query("mytable", null, null, null, null, null, orderBy);
                break;
        }

        if (c != null) {
            if (c.moveToFirst()) {
                String str;
                do {
                    str = "";
                    for (String cn : c.getColumnNames()) {
                        str = str.concat(cn + " = "
                                + c.getString(c.getColumnIndex(cn)) + "; ");
                    }
                    Log.d(LOG_TAG, str);

                } while (c.moveToNext());
            }
            c.close();
        } else
            Log.d(LOG_TAG, "Cursor is null");

        mDbHelper.close();
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "myDB", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement," + "name text,"
                    + "people integer," + "region text" + ");");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}