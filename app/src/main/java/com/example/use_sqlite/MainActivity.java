package com.example.use_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.use_sqlite.Model.Student;
import com.example.use_sqlite.adapter.CustomAdapter;
import com.example.use_sqlite.data.DBStudent;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private EditText editName,editPhoneNumber,editEmail,editAddress;
    private Button btnSave,btnUpdate;
    private TextView tvID;
    private ListView lvStudent;
    private CustomAdapter customAdapter;
    private List<Student> studentList;
    private Student studentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final DBStudent dbStudent=new DBStudent(this);
        init();
        studentList=dbStudent.getAllStudent();
        setCustomAdapter();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student= createStudent();
                if(student !=null)
                {
                    dbStudent.addStudent(student);

                }
                studentList.clear();
                studentList.addAll(dbStudent.getAllStudent());
                setCustomAdapter();

            }
        });
        lvStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                studentItem=studentList.get(position);
                showItem(studentItem);
                btnSave.setClickable(false);
                btnUpdate.setClickable(true);
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Student student= createStudent();
                String id=String.valueOf(studentItem.getID());
                dbStudent.updateStudent(student,id);
                studentList.clear();
                studentList.addAll(dbStudent.getAllStudent());
                setCustomAdapter();
            }
        });






    }
    private void showItem(Student studentItem)
    {
        tvID.setText("ID: "+studentItem.getID());
        editName.setText(studentItem.getName());
        editAddress.setText(studentItem.getAddress());
        editPhoneNumber.setText(studentItem.getPhone_Number());
        editEmail.setText(studentItem.getEmail());
    }
    private void init()
    {
        editName=(EditText)findViewById(R.id.edit_Name);
        editPhoneNumber=(EditText)findViewById(R.id.edit_Number);
        editAddress=(EditText)findViewById(R.id.edit_Address);
        editEmail=(EditText)findViewById(R.id.edit_Email);
        btnSave=(Button)findViewById(R.id.btn_Save);
        lvStudent=(ListView) findViewById(R.id.lv_Student);
        tvID=(TextView)findViewById(R.id.tv_ID);
        btnUpdate=(Button)findViewById(R.id.btn_Update);
        studentItem=new Student();

    }
    private void setCustomAdapter()
    {
        if(customAdapter==null)
        {
            customAdapter=new CustomAdapter(this,R.layout.row_list_student,studentList);
            lvStudent.setAdapter(customAdapter);
        }else
        {
            customAdapter.notifyDataSetChanged();
            lvStudent.setSelection(customAdapter.getCount()-1);
        }

    }
    private Student createStudent()
    {
        String name=editName.getText().toString();
        String address=String.valueOf(editAddress.getText());
        String email=editEmail.getText().toString();
        String phoneNumber=editPhoneNumber.getText().toString();
        Student student = new Student(name,address,phoneNumber,email);
        return  student;
    }
}
