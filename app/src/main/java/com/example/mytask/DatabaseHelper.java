package com.example.mytask;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper
{

    Context context;
    public DatabaseHelper(@Nullable Context context) {
        super(context, "user.db", null, 1);
        this.context=context;

    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String sql= "create table user(user_id integer primary key AUTOINCREMENT,user_first varchar(100),user_second varchar(100),password varchar(20),dateofbirth varchar(20),user_email varchar(100))";
        db.execSQL(sql);


        sql = "create table artist(artist_name varchar(50),artist_type varchar(10),artist_award varchar(10))";
        db.execSQL(sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
