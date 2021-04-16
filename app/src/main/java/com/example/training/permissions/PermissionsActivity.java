package com.example.training.permissions;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.training.R;

import java.util.ArrayList;
import java.util.List;

public class PermissionsActivity extends AppCompatActivity {

    public static final int MULTIPLE_PERMISSIONS = 100;

    private String[] mPermissions;

    private Button mBtnCheckPermissionContacts;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_permissions);
        mBtnCheckPermissionContacts = findViewById(R.id.bt_request_contacts);
        mBtnCheckPermissionContacts.setOnClickListener(e -> checkPermissions());
        mPermissions = new String[] {
                Manifest.permission.READ_CONTACTS,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CAMERA
        };
    }

    private void checkPermissions() {
        int result;
        List<String> listPermissionsNeeded = new ArrayList<>();
        for (String permission : mPermissions) {
            result = ContextCompat.checkSelfPermission(this, permission);
            if (result != PackageManager.PERMISSION_GRANTED) {
                listPermissionsNeeded.add(permission);
            }
        }
        if (!listPermissionsNeeded.isEmpty()) {
                new AlertDialog.Builder(this)
                        .setTitle("Need Multiple Permissions")
                        .setMessage("This app needs multiple permissions")
                        .setPositiveButton("Grant", (DialogInterface.OnClickListener) (dialog, which) -> {
                            ActivityCompat.requestPermissions(this, listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), MULTIPLE_PERMISSIONS);
                        })
                        .setNegativeButton("Cancel", (dialog, which) -> {
                            Toast.makeText(PermissionsActivity.this, "To continue work you need to grant permissions", Toast.LENGTH_LONG).show();
                        })
                        .show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for(int i = 0; i<grantResults.length; i++){
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i])
                    && grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                new AlertDialog.Builder(this)
                    .setTitle("Need all permissions")
                    .setMessage("This action require all permissions")
                    .setPositiveButton("Grant permissions", (dialog, which) -> checkPermissions())
                    .setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss())
                    .show();
            }
        }
        Toast.makeText(this, "All permissions are granted!", Toast.LENGTH_LONG)
             .show();
    }


}

