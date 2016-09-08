package com.ttyooyu.market.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.ttyooyu.market.core.Constant;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2016-07-26.
 */
public class TTYooYuOpenHelper extends SQLiteOpenHelper {


    private static TTYooYuOpenHelper instance;
    private final ReentrantLock mLock = new ReentrantLock(true);

    public ReentrantLock getLock(){
        return mLock;
    }

    public static TTYooYuOpenHelper getInstance(Context context){
        if(instance == null){
            instance = new TTYooYuOpenHelper(context);
        }
        return instance;
    }





    private TTYooYuOpenHelper(Context context) {
        super(context, Constant.SQLITE_NAME, null, Constant.SQLITE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table user(uid String primary key autoincrement,tel char(20),money char(10), saapay char(10),head char(255))");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
