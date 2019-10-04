package com.example.use_sqlite.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;


public class DBStudent extends SQLiteOpenHelper {
    private static final String DATABASE_NAME="students_manager";
    private static final String TABLE_NAME="students";
    private static final String ID="id";
    private static final String NAME="name";
    private static final String ADDRESS="address";
    private static final String EMAIL="email";
    private static final String PHONE_NUMBER="phone";
    private static final int VERSION=1;

    private Context context;
    private String SQLQuery="CREATE TABLE "+TABLE_NAME+" ("+
            ID+" integer primary key, "+
            NAME+" TEXT, "+
            EMAIL+" TEXT"+
            PHONE_NUMBER+ "TEXT, "+
            ADDRESS+" TEXT)";
    public DBStudent( Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQLQuery);
        this.context=context;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void hello(){
        Toast.makeText(context,"test",Toast.LENGTH_SHORT).show();
    }
}
