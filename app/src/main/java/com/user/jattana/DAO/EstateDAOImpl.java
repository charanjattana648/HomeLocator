package com.user.jattana.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.user.jattana.Model.EstateProperty;
import com.user.jattana.Model.User;
import com.user.jattana.config.DbHelper;
import com.user.jattana.config.TableDefinitions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class EstateDAOImpl implements EstateDAO {

    DbHelper db_helper;
    Context context;
    private final String DATABASE_NAME="Estate_property_db";

    public EstateDAOImpl(Context context,String databaseName){
        db_helper=new DbHelper(context, databaseName);
        this.context=context;
    }
    public EstateDAOImpl(Context context){
        db_helper=new DbHelper(context, DATABASE_NAME);
        this.context=context;
    }
    @Override
    public long addEstateProperty(EstateProperty estateProperty) {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TableDefinitions.ESTATE_FIELDS[1],estateProperty.getEmail());
        values.put(TableDefinitions.ESTATE_FIELDS[2],estateProperty.getPropertyName());
        values.put(TableDefinitions.ESTATE_FIELDS[3],estateProperty.getPropertyNumber());
        values.put(TableDefinitions.ESTATE_FIELDS[4],estateProperty.getType());
        values.put(TableDefinitions.ESTATE_FIELDS[5],estateProperty.getLeaseType());
        values.put(TableDefinitions.ESTATE_FIELDS[6],estateProperty.getLocation());
        values.put(TableDefinitions.ESTATE_FIELDS[7],estateProperty.getNum_of_bedrooms());
        values.put(TableDefinitions.ESTATE_FIELDS[8],estateProperty.getNum_of_bathrooms());
        values.put(TableDefinitions.ESTATE_FIELDS[9],estateProperty.getSize());
        values.put(TableDefinitions.ESTATE_FIELDS[10],estateProperty.getAskingPrice());
        values.put(TableDefinitions.ESTATE_FIELDS[11],estateProperty.getLocalAmenities());
        values.put(TableDefinitions.ESTATE_FIELDS[12],estateProperty.getDescription());
        long newRowId=db.insert(TableDefinitions.ESTATE_TABLE,null,values);
        Log.d(">>>>>>>>user added", "addUser: "+newRowId);
        return newRowId;
    }

    @Override
    public int updateEstateProperty(EstateProperty estateProperty) {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(TableDefinitions.ESTATE_FIELDS[1],estateProperty.getEmail());
        values.put(TableDefinitions.ESTATE_FIELDS[2],estateProperty.getPropertyName());
        values.put(TableDefinitions.ESTATE_FIELDS[3],estateProperty.getPropertyNumber());
        values.put(TableDefinitions.ESTATE_FIELDS[4],estateProperty.getType());
        values.put(TableDefinitions.ESTATE_FIELDS[5],estateProperty.getLeaseType());
        values.put(TableDefinitions.ESTATE_FIELDS[6],estateProperty.getLocation());
        values.put(TableDefinitions.ESTATE_FIELDS[7],estateProperty.getNum_of_bedrooms());
        values.put(TableDefinitions.ESTATE_FIELDS[8],estateProperty.getNum_of_bathrooms());
        values.put(TableDefinitions.ESTATE_FIELDS[9],estateProperty.getSize());
        values.put(TableDefinitions.ESTATE_FIELDS[10],estateProperty.getAskingPrice());
        values.put(TableDefinitions.ESTATE_FIELDS[11],estateProperty.getLocalAmenities());
        values.put(TableDefinitions.ESTATE_FIELDS[12],estateProperty.getDescription());
        String selection=TableDefinitions.ESTATE_FIELDS[0]+ " =?";
        String[] selectionArgs={estateProperty.getId()+""};
        int count=db.update(TableDefinitions.ESTATE_TABLE,values,selection,selectionArgs);
        Log.d(">>>>>>>update Estate", "count : "+count+"updateEstateProperty: "+estateProperty.toString());
        if(count>0)
        {
            Toast.makeText(context,"Estate Property Data is Updated!!",Toast.LENGTH_SHORT).show();
            return 1;
        }
        Toast.makeText(context,"Error while updating Estate Property Data!!",Toast.LENGTH_SHORT).show();
        return 0;
    }

    @Override
    public int deleteEstateProperty(int id) {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        String selection=TableDefinitions.ESTATE_FIELDS[0]+" =?";
        String[] selectionArgs={id+""};
        int count=db.delete(TableDefinitions.ESTATE_TABLE,selection,selectionArgs);
        if(count>0)
        {
            Toast.makeText(context,"Estate Property deleted successfully",Toast.LENGTH_SHORT).show();
            return 1;
        }
        Toast.makeText(context,"Error while deleting Estate Property",Toast.LENGTH_SHORT).show();
        return 0;
    }

    @Override
    public List<EstateProperty> getEstatePropertyListByEmail(String email) {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        String[] projection=getProjection();

        String selection=TableDefinitions.ESTATE_FIELDS[1]+"=?";
        String[] selectionArgs={email};
        Cursor cursor=db.query(
                TableDefinitions.ESTATE_TABLE,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return getList(cursor);
    }

    @Override
    public EstateProperty getEstateProperty(int id) {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        String[] projection=getProjection();
        String selection=TableDefinitions.ESTATE_FIELDS[0]+"=?";
        String[] selectionArgs={id+""};
        Cursor cursor=db.query(
                TableDefinitions.ESTATE_TABLE,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        EstateProperty estateProperty=new EstateProperty();
        while (cursor.moveToNext()){
            Log.d(">>>>>>>cursor", "getEstateProperty: "+cursor.toString());
            estateProperty.setId(cursor.getInt(0));
            estateProperty.setEmail(cursor.getString(1));
            estateProperty.setPropertyName(cursor.getString(2));
            estateProperty.setPropertyNumber(cursor.getString(3));
            estateProperty.setType(cursor.getString(4));
            estateProperty.setLeaseType(cursor.getString(5));
            estateProperty.setLocation(cursor.getString(6));
            estateProperty.setNum_of_bedrooms(cursor.getInt(7));
            estateProperty.setNum_of_bathrooms(cursor.getInt(8));
            estateProperty.setSize(cursor.getString(9));
            estateProperty.setAskingPrice(cursor.getDouble(10));
            estateProperty.setLocalAmenities(cursor.getString(11));
            estateProperty.setDescription(cursor.getString(12));
        }
        return estateProperty;
    }


    @Override
    public ArrayList<EstateProperty> getEstatePropertyList() {
        SQLiteDatabase db=db_helper.getWritableDatabase();
        String[] projection=getProjection();
        Cursor cursor=db.query(
                TableDefinitions.ESTATE_TABLE,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return getList(cursor);
    }

    private String[] getProjection() {
        String[] projection={TableDefinitions.ESTATE_FIELDS[0],
                TableDefinitions.ESTATE_FIELDS[1],
                TableDefinitions.ESTATE_FIELDS[2],
                TableDefinitions.ESTATE_FIELDS[3],
                TableDefinitions.ESTATE_FIELDS[4],
                TableDefinitions.ESTATE_FIELDS[5],
                TableDefinitions.ESTATE_FIELDS[6],
                TableDefinitions.ESTATE_FIELDS[7],
                TableDefinitions.ESTATE_FIELDS[8],
                TableDefinitions.ESTATE_FIELDS[9],
                TableDefinitions.ESTATE_FIELDS[10],
                TableDefinitions.ESTATE_FIELDS[11],
                TableDefinitions.ESTATE_FIELDS[12]};
        return projection;
    }

    public ArrayList<EstateProperty> getList(Cursor cursor)
    {
        ArrayList<EstateProperty> estateProperty_list=new ArrayList<EstateProperty>();
        while (cursor.moveToNext()){
            EstateProperty estateProperty=new EstateProperty();

            estateProperty.setId(cursor.getInt(0));
            estateProperty.setEmail(cursor.getString(1));
            estateProperty.setPropertyName(cursor.getString(2));
            estateProperty.setPropertyNumber(cursor.getString(3));
            estateProperty.setType(cursor.getString(4));
            estateProperty.setLeaseType(cursor.getString(5));
            estateProperty.setLocation(cursor.getString(6));
            estateProperty.setNum_of_bedrooms(cursor.getInt(7));
            estateProperty.setNum_of_bathrooms(cursor.getInt(8));
            estateProperty.setSize(cursor.getString(9));
            estateProperty.setAskingPrice(cursor.getDouble(10));
            estateProperty.setLocalAmenities(cursor.getString(11));
            estateProperty.setDescription(cursor.getString(12));

            estateProperty_list.add(estateProperty);
        }
        return estateProperty_list;
    }
}
