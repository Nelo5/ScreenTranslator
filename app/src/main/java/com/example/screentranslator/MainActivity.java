package com.example.screentranslator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.loader.AssetsProvider;
import android.os.Bundle;

import com.googlecode.tesseract.android.TessBaseAPI;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File projectDir = getApplicationContext().getFilesDir();
        File newDir = new File(projectDir, "tessdata");
        FileOutputStream fos
        TessBaseAPI tess = new TessBaseAPI();
        String dataPath = new File(getFilesDir(), "tesseract").getAbsolutePath();
        if (!tess.init(dataPath, "rus")) { // could be multiple languages, like "eng+deu+fra"
            tess.recycle();
            return;
        }
        new Thread(()-> {
            tess.setImage();
            String text = tess.getUTF8Text();
            tess.recycle();
        });
    }
}