package com.example.use_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.use_sqlite.Model.Student;
import com.example.use_sqlite.data.DBStudent;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText editName,editPhoneNumber,editEmail,editAddress;
    private Button btnSave;
    private ListView lvStudent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBStudent dbStudent=new DBStudent(this);
        init();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student= createStudent();
                if(student !=null)
                {
                    dbStudent.addStudent(student);
                }

            }
        });




    }
    private void init()
    {
        editName=(EditText)findViewById(R.id.edit_Name);
        editPhoneNumber=(EditText)findViewById(R.id.edit_Number);
        editAddress=(EditText)findViewById(R.id.edit_Address);
        editEmail=(EditText)findViewById(R.id.edit_Email);
        btnSave=(Button)findViewById(R.id.btn_Save);
    }
    private Student createStudent()
    {
        String name=editName.getText().toString();
        String address=String.valueOf(editAddress.getText());
        String email=editEmail.getText().toString();
        String phoneNumber=editPhoneNumber.getText()+"";
        Student student = new Student(name,address,phoneNumber,email);
        return  student;

    }
}