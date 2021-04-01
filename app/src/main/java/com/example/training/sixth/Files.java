package com.example.training.sixth;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Files {

    private final String LOG_TAG = "myLogs";

    private final String FILENAME = "file";

    private final String DIR_SD = "MyFiles";
    private final String FILENAME_SD = "fileSD";

    private final Context mContext;

    public Files(Context context) {
        mContext = context;
    }

    public void writeFile() {
        try {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
                    mContext.openFileOutput(FILENAME, Context.MODE_PRIVATE)));
            bw.write("Содержимое файла");
            bw.close();
            Log.d(LOG_TAG, "Файл записан");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFile() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    mContext.openFileInput(FILENAME)));
            String str = "";
            while ((str = br.readLine()) != null) {
                Log.d(LOG_TAG, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFileSD() {
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        java.io.File sdPath = Environment.getExternalStorageDirectory();
        sdPath = new java.io.File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        sdPath.mkdirs();
        java.io.File sdFile = new java.io.File(sdPath, FILENAME_SD);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
            bw.write("Содержимое файла на SD");
            bw.close();
            Log.d(LOG_TAG, "Файл записан на SD: " + sdFile.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readFileSD() {
        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            Log.d(LOG_TAG, "SD-карта не доступна: " + Environment.getExternalStorageState());
            return;
        }
        java.io.File sdPath = Environment.getExternalStorageDirectory();
        sdPath = new java.io.File(sdPath.getAbsolutePath() + "/" + DIR_SD);
        java.io.File sdFile = new java.io.File(sdPath, FILENAME_SD);
        try {
            BufferedReader br = new BufferedReader(new FileReader(sdFile));
            String str = "";
            while ((str = br.readLine()) != null) {
                Log.d(LOG_TAG, str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
