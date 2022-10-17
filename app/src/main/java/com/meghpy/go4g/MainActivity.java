package com.meghpy.go4g;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CALL = 1;
    private TextView callText;
    private Button callButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        callText = findViewById(R.id.callText);
        callButton = findViewById(R.id.callButton);


        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallButton();
            }
        });

    }

    //------------------------------

    private void CallButton() {
        String number = callText.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }
    }

    //------------------------------

    //----------For automatic calling after granted the permission----------//

    //--------------------------------

//    @SuppressLint("MissingSuperCall")
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//
//        if (requestCode == REQUEST_CALL) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                CallButton();
//            } else {
//                Toast.makeText(this, "permission DENIED", Toast.LENGTH_SHORT).show();
//            }
//        }
//
//    }

    //-----------------------------

}



















