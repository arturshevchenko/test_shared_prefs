package com.example.sharedpreferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.appspector.sdk.AppSpector;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class MainActivity extends Activity implements OnClickListener {

    EditText etText;
    Button btnSave, btnRead, btnLoad, btnCrash;

    SharedPreferences sPref;

    final String SAVED_TEXT = "saved_text";


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        etText = (EditText) findViewById(R.id.etText);

        btnSave = (Button) findViewById(R.id.btnSave);
        btnSave.setOnClickListener(this);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(this);

        btnLoad = (Button) findViewById(R.id.btnLoad);
        btnLoad.setOnClickListener(this);

        btnCrash = (Button) findViewById(R.id.btnCrash);
        btnCrash.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSave:
                saveText();
                break;
            case R.id.btnRead:
                readText();
                break;
            case R.id.btnLoad:
                loadText();
                break;
            case R.id.btnCrash:
                crashMe();
                break;
            default:
                break;
        }
    }

    void saveText() {
        Log.i("MyTag", "save button clicked");
        sPref = getPreferences(MODE_PRIVATE);
        Editor ed = sPref.edit();
        ed.putString(SAVED_TEXT, etText.getText().toString());
        ed.commit();
        Toast.makeText(this, "Text saved", Toast.LENGTH_SHORT).show();
        Log.v("MyTag", "verbose log example");
        Log.d("MyTag", "debug log example");
        Log.i("MyTag", "info log example");
        Log.w("MyTag", "warn log example");
        Log.e("MyTag", "error log example");
    }

    void readText() {
        sPref = getPreferences(MODE_PRIVATE);
        String text = sPref.getString("saved_text", "empty text");
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }

    void loadText() {


        Log.i("MyTag", "load button clicked");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("C:/dc_is_better_then_marvel.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            sPref = getPreferences(MODE_PRIVATE);
            String savedText = sPref.getString(SAVED_TEXT, "");
            etText.setText(savedText);
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    void crashMe(){
//        throw new RuntimeException("Some shitty code");
        Log.i("MyTag", "crash button clicked");
        int a = 6/0;
    }
}