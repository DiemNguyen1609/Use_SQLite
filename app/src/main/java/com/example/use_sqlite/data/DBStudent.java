package com.example.use_sqlite.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.use_sqlite.Model.Student;


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

}
