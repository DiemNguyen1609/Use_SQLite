package com.example.use_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.use_sqlite.data.DBStudent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBStudent dbStudent=new DBStudent(this);
        dbStudent.hello();
    }
}
