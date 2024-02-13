package com.example.screentranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File projectDir = getApplicationContext().getFilesDir();
        File newDir = new File(projectDir, "tessdata");
        newDir.mkdirs();
    }
}