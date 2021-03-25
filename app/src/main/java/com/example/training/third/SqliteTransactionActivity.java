package com.example.training.third;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.util.Log;

public class SqliteTransactionActivity extends AppCompatActivity {

   private  final String LOG_TAG = "myLogs";

   private  DBHelper mDbh;
   private SQLiteDatabase mDb;

    @Override  public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(LOG_TAG, "--- onCreate Activity ---");
        mDbh = new DBHelper(this);
        myActions();
    }

    void myActions() {
        mDb = mDbh.getWritableDatabase();
        SQLiteDatabase db2 = mDbh.getWritableDatabase();
        Log.d(LOG_TAG, "db = db2 - " + mDb.equals(db2));
        Log.d(LOG_TAG, "db open - " + mDb.isOpen() + ", db2 open - " + db2.isOpen());
        db2.close();
        Log.d(LOG_TAG, "db open - " + mDb.isOpen() + ", db2 open - " + db2.isOpen());
    }

    void insert(SQLiteDatabase db, String table, String value) {
        Log.d(LOG_TAG, "Insert in table " + table + " value = " + value);
        ContentValues cv = new ContentValues();
        cv.put("val", value);
        db.insert(table, null, cv);
    }

    void read(SQLiteDatabase db, String table) {
        Log.d(LOG_TAG, "Read table " + table);
        Cursor c = db.query(table, null, null, null, null, null, null);
        if (c != null) {
            Log.d(LOG_TAG, "Records count = " + c.getCount());
            if (c.moveToFirst()) {
                do {
                    Log.d(LOG_TAG, c.getString(c.getColumnIndex("val")));
                } while (c.moveToNext());
            }
            c.close();
        }
    }

    void delete(SQLiteDatabase db, String table) {
        Log.d(LOG_TAG, "Delete all from table " + table);
        db.delete(table, null, null);
    }

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, "myDB", null, 1);
        }

        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");

            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "val text"
                    + ");");
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }
}