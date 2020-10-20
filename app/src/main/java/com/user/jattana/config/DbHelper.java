package com.user.jattana.config;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION=1;
    private String DATABASE_NAME;

    public DbHelper(Context context,String databaseName)
    {
        super(context,databaseName,null,DATABASE_VERSION);
        this.DATABASE_NAME=databaseName;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(TableDefinitions.SQL_CREATE_USER_TABLE);
        sqLiteDatabase.execSQL(TableDefinitions.SQL_CREATE_ESTATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(TableDefinitions.SQL_DELETE_USER_TABLE);
        sqLiteDatabase.execSQL(TableDefinitions.SQL_DELETE_ESTATE_TABLE);
        onCreate(sqLiteDatabase);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
    public String getDATABASE_NAME(){
        return DATABASE_NAME;
    }
}
