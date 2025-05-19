package com.example.android56_day5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvDemo;
    private ArrayList<String> listData = new ArrayList<String>();
    private ArrayList<User> listUser = new ArrayList<User>();

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

            User user = new User();
            user.setAvatar("https://images.icon-icons.com/2643/PNG/512/male_man_people_person_avatar_white_tone_icon_159363.png");
            user.setUserName("User " + i);
            user.setPhoneNumber("012345678" + i);
            listUser.add(user);
        }
    }

    private void initView() {
        lvDemo = findViewById(R.id.lvDemo);

//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listData);
//        lvDemo.setAdapter(arrayAdapter);

        UserAdapter userAdapter = new UserAdapter(listUser);
        lvDemo.setAdapter(userAdapter);

        lvDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = listUser.get(position);
                Toast.makeText(MainActivity.this, user.getUserName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}