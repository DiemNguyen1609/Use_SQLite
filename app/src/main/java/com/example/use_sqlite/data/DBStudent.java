package com.example.use_sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.ListView;

import com.example.use_sqlite.Model.Student;

import java.util.ArrayList;
import java.util.List;


public class DBStudent extends SQLiteOpenHelper {
    private final String TAG ="DBManager";
    private static final String DATABASE_NAME="student_manager";
    private static final String TABLE_NAME="students";
    private static final String ID="id";
    private static final String NAME="name";
    private static final String ADDRESS="address";
    private static final String EMAIL="email";
    private static final String PHONE_NUMBER="phone";
    private static final int VERSION=1;

    private Context context;
    private String SQLQuery="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+
            ID+" integer primary key, "+
            NAME+" TEXT, "+
            EMAIL+" TEXT, "+
            PHONE_NUMBER+ " TEXT, "+
            ADDRESS+" TEXT)";
    public DBStudent( Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context=context;
        Log.d(TAG,"DBManager");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
        Log.d(TAG,"onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG,"onUpgrade");
    }
    public void addStudent(Student student)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(NAME,student.getName());
        values.put(ADDRESS,student.getAddress());
        values.put(PHONE_NUMBER,student.getPhone_Number());
        values.put(EMAIL,student.getEmail());

        db.insert(TABLE_NAME,null,values);
        db.close();
        Log.d(TAG,"Successful");
    }

    public List<Student> getAllStudent()
    {
        List<Student> studentList=new ArrayList<>();

        String selectQuery ="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db= this.getWritableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        if(cursor.moveToFirst())
        {
            do{
                Student student= new Student();
                student.setID(cursor.getInt(0));
                student.setName(cursor.getString(1));
                student.setEmail(cursor.getString(2));
                student.setPhone_Number(cursor.getString(3));
                student.setAddress(cursor.getString(4));
                studentList.add(student);
            }while (cursor.moveToNext());
        }
            db.close();
        return studentList;
    }
}
