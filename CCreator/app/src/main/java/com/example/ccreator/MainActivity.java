package com.example.ccreator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Create(View view) {
        Intent chat = new Intent(MainActivity.this, Creator.class);
        overridePendingTransition(0,0);
        startActivity(chat);
    }
}