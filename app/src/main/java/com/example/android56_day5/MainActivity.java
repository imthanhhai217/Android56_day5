package com.example.android56_day5;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvDemo;
    private ImageView imgAdd;
    private ImageView imgMinus;
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

            listUser.add(getNewUser(i));
        }
    }
    private UserAdapter userAdapter;
    private void initView() {
        lvDemo = findViewById(R.id.lvDemo);
        imgAdd = findViewById(R.id.imgAdd);
        imgMinus = findViewById(R.id.imgMinus);

//        ArrayAdapter arrayAdapter = new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listData);
//        lvDemo.setAdapter(arrayAdapter);

        userAdapter = new UserAdapter(listUser);

        lvDemo.setAdapter(userAdapter);

        lvDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User user = listUser.get(position);
                //Update user name
                user.setUserName("User clicked "+position);
                listUser.set(position,user);
                userAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, user.getUserName(), Toast.LENGTH_SHORT).show();
            }
        });

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewUser();
            }
        });

        imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeUser();
            }
        });

    }

    private void removeUser() {
        if (!listUser.isEmpty()) {
            listUser.remove(listUser.size() - 1);
            userAdapter.notifyDataSetChanged();
        } else {
            Toast.makeText(this, "Khong co user de xoa!", Toast.LENGTH_SHORT).show();
        }
    }

    private void addNewUser() {
        User user = getNewUser(listUser.size());
        listUser.add(user);
        userAdapter.notifyDataSetChanged();
    }

    private User getNewUser(int position) {
        User user = new User();
        user.setAvatar("https://images.icon-icons.com/2643/PNG/512/male_man_people_person_avatar_white_tone_icon_159363.png");
        user.setUserName("User " + position);
        user.setPhoneNumber("012345678" + position);
        return user;
    }
}