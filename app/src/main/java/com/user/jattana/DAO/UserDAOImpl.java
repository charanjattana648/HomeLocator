package com.user.jattana.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.user.jattana.Model.User;
import com.user.jattana.config.DbHelper;
import com.user.jattana.config.TableDefinitions;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    DbHelper db_helper;
    Context context;
    public UserDAOImpl(Context context,String databaseName){
        db_helper=new DbHelper(context, databaseName);
        this.context=context;
    }
    @Override
    public long addUser(User user) {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TableDefinitions.USER_FIELDS[0],user.getEmail());
        values.put(TableDefinitions.USER_FIELDS[1],user.getFName());
        values.put(TableDefinitions.USER_FIELDS[2],user.getLName());
        values.put(TableDefinitions.USER_FIELDS[3],user.getUserType());
        values.put(TableDefinitions.USER_FIELDS[4],user.getPassword());
        long newRowId=db.insert(TableDefinitions.USER_TABLE,null,values);
        Log.d(">>>>>>>>user added", "addUser: "+newRowId);
        if(newRowId>0)
        {
                Toast.makeText(context, "Registration Successful!!", Toast.LENGTH_SHORT).show();
        }
        return newRowId;
    }

    @Override
    public int updateUser(User user,String email) {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TableDefinitions.USER_FIELDS[1],user.getFName());
        values.put(TableDefinitions.USER_FIELDS[2],user.getLName());
        values.put(TableDefinitions.USER_FIELDS[3],user.getUserType());
        values.put(TableDefinitions.USER_FIELDS[4],user.getPassword());
        String selection=TableDefinitions.USER_FIELDS[0]+ " =?";
        String[] selectionArgs={email};
        int count=db.update(TableDefinitions.USER_TABLE,values,selection,selectionArgs);
        if(count>0)
        {
            Toast.makeText(context,"Updated User Details!!",Toast.LENGTH_SHORT).show();
            return 1;
        }
        return 0;
    }

    @Override
    public long deleteUser(String email) {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        String selection=TableDefinitions.USER_FIELDS[0]+" =?";
        String[] selectionArgs={email};
        int count=db.delete(TableDefinitions.USER_TABLE,selection,selectionArgs);
        if(count>0)
        {
            Toast.makeText(context,"User account deleted successful",Toast.LENGTH_SHORT);
            return 1;
        }
        return 0;
    }

    @Override
    public User getUser(String email) {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        String[] projection={TableDefinitions.USER_FIELDS[0],
                             TableDefinitions.USER_FIELDS[1],
                             TableDefinitions.USER_FIELDS[2],
                             TableDefinitions.USER_FIELDS[3],
                             TableDefinitions.USER_FIELDS[4]};

        String selection=TableDefinitions.USER_FIELDS[0]+"=?";
        String[] selectionArgs={email};
        Cursor cursor=db.query(
                TableDefinitions.USER_TABLE,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        User u=new User();
        while (cursor.moveToNext()){
            u.setEmail(cursor.getString(0));
            u.setFName(cursor.getString(1));
            u.setLName(cursor.getString(2));
            u.setUserType(cursor.getString(3));
            u.setPassword(cursor.getString(4));
        }
        return u;
    }

    @Override
    public List<User> getUserList() {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        String[] projection={TableDefinitions.USER_FIELDS[0],
                             TableDefinitions.USER_FIELDS[1],
                             TableDefinitions.USER_FIELDS[2],
                             TableDefinitions.USER_FIELDS[3],
                             TableDefinitions.USER_FIELDS[4]};

        String selection="";
        String[] selectionArgs={};
        Cursor cursor=db.query(
                TableDefinitions.USER_TABLE,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );

        List<User> userList=new ArrayList<User>();
        while (cursor.moveToNext()){
            User u=new User();
            u.setEmail(cursor.getString(0));
            u.setFName(cursor.getString(1));
            u.setLName(cursor.getString(2));
            u.setUserType(cursor.getString(3));
            u.setPassword(cursor.getString(4));
            userList.add(u);
        }
        return userList;
    }
}
