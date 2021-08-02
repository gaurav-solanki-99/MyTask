package com.example.mytask;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDao
{
    public static  boolean saveUser(Context context, User user)
    {
        boolean status =false;

        DatabaseHelper helper = new DatabaseHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        //~~~~~~~~~~~~~~~~~~~~~~~~~Insert in Sqlite~~~~~~~~~~~~


        ContentValues values = new ContentValues();
        values.put("user_first",user.getFirstname());
        values.put("user_second",user.getSecondname());
        values.put("password",user.getPassword());
        values.put("dateofbirth",user.getDob());
        values.put("user_email",user.getEmail());


        long x= database.insert("user",null,values);

        if(x!=0)
        {
            status=true;
        }


        return status;

    }

    //~~~~~~~~~~~~~~~~~~~~~~~~~Authentication in Sqlite~~~~~~~~~~~~

    public static boolean authenticateUser(Context context,User user){
        boolean status = false;
        // check in database table whether user exit or not
        DatabaseHelper helper= new DatabaseHelper(context);
        SQLiteDatabase database = helper.getReadableDatabase();
        Cursor c = database.rawQuery("select * from user where user_email=? and password = ?",new String[]{user.getEmail(),user.getPassword()});
        if(c.moveToNext())
            status = true;
        return status;
    }


}
