//Victorianna Manocchio
//Assignment 4
//Database to store synonym/antonym pairs

package com.example.resnet.findsynonymantonym;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class SynDBHelper extends SQLiteOpenHelper {


    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "synant.db";
    private static final String TABLE_NAME = "synant";
    private static final String COLUMN_TERM = "term";
    private static final String COLUMN_PAIR = "match";
    SQLiteDatabase db;

    private static final String TABLE_CREATE = "create table synant (term text not null, match text not null)";

    public SynDBHelper(Context context){

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void insertPair(Pair p){

        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_TERM, p.getTerm());
        values.put(COLUMN_PAIR, p.getMatch());

        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    public String searchTerm(String term){

        db = this.getWritableDatabase();
        String query = "select term, match from " + TABLE_NAME;
        Cursor cursor = db.rawQuery(query, null);
        String a, b;
        b = "Word not found";

        if(cursor.moveToFirst()){

            do{
                a = cursor.getString(0);

                if(a.equals(term)){
                    b = cursor.getString(1);
                    break;
                }
            }while(cursor.moveToNext());
        }

        return b;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_CREATE);
        this.db = db;

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String query = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(query);
        this.onCreate(db);

    }
}
