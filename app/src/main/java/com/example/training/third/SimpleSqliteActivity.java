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

import com.example.training.R;

import org.w3c.dom.Text;

public class SimpleSqliteActivity extends AppCompatActivity  implements View.OnClickListener {

    final String LOG_TAG = "myLogs";

    private Button mBtnAdd, mBtnRead, mBtnClear;
    private EditText mEtName;
    private EditText mEtEmail;

    private DBHelper mDbHelper;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_sqlite);
        setupViews();
        setupListeners();
        mDbHelper = new DBHelper(this);
    }

    @Override public void onClick(View v) {
        ContentValues cv = new ContentValues();

        String name = mEtName.getText().toString();
        String email = mEtEmail.getText().toString();

        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        switch (v.getId()) {
            case R.id.btnAdd:
                Log.d(LOG_TAG, "--- Insert in mytable: ---");
                cv.put("name", name);
                cv.put("email", email);

                long rowID = db.insert("mytable", null, cv);
                Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                break;
            case R.id.btnRead:
                Log.d(LOG_TAG, "--- Rows in mytable: ---");

                Cursor c = db.query("mytable", null, null, null, null, null, null);

                if (c.moveToFirst()) {

                    int idColIndex = c.getColumnIndex("id");
                    int nameColIndex = c.getColumnIndex("name");
                    int emailColIndex = ((Cursor) c).getColumnIndex("email");

                    do {
                        Log.d(LOG_TAG,
                                "ID = " + c.getInt(idColIndex) +
                                        ", name = " + c.getString(nameColIndex) +
                                        ", email = " + c.getString(emailColIndex));

                    } while (c.moveToNext());
                } else
                    Log.d(LOG_TAG, "0 rows");
                c.close();
                break;
            case R.id.btnClear:
                Log.d(LOG_TAG, "--- Clear mytable: ---");
                int clearCount = db.delete("mytable", null, null);
                Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                break;
        }
        mDbHelper.close();
    }

    private void setupViews() {
        mBtnAdd = (Button) findViewById(R.id.btnAdd);
        mBtnRead = (Button) findViewById(R.id.btnRead);
        mBtnClear = (Button) findViewById(R.id.btnClear);
        mEtName = (EditText) findViewById(R.id.etName);
        mEtEmail = (EditText) findViewById(R.id.etEmail);
    }

    private void setupListeners() {
        mBtnAdd.setOnClickListener(this);
        mBtnRead.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "myDB", null, 1);
        }

        @Override public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "email text" + ");");
        }

        @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}