package com.example.sharepreferenceltmtk12t;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvCount;
    private int count;
    // Can luu tru tin so dem cuoi cung
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvCount = findViewById(R.id.tvCount);
        // Init
        sharedPreferences = this.getSharedPreferences("Counter", Context.MODE_PRIVATE);

        // Lay gia tri cuoi
        count = sharedPreferences.getInt("number",0);
        // Set count cho tv
        tvCount.setText(String.valueOf(count));

        // Su kien onClick
        tvCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count ++;
                tvCount.setText(String.valueOf(count));
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        sharedPreferences.edit().putInt("number", count).apply();
    }
}