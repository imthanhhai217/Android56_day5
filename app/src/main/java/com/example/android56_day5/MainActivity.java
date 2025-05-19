package com.example.android56_day5;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvDemo;
    private ArrayList<String> listData = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            listData.add("User " + i);
        }
    }

    private void initView() {
        lvDemo = findViewById(R.id.lvDemo);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listData);
        lvDemo.setAdapter(arrayAdapter);

    }
}