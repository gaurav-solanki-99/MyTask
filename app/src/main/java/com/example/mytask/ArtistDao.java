package com.example.mytask;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class ArtistDao
{
    public static boolean save(Context context, Artist artist){
        boolean status = false;
        try {
            DatabaseHelper helper = new DatabaseHelper(context);
            SQLiteDatabase database = helper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("artist_name", artist.getName());
            values.put("artist_type", artist.getType());
            values.put("artist_award", artist.getAward());

            database.insert("artist", null, values);
            status = true;
        }
        catch (Exception ee){
            Toast.makeText(context, ""+ee, Toast.LENGTH_SHORT).show();
        }
        return status;
    }
}
