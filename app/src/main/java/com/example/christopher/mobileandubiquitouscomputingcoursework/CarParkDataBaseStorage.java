package com.example.christopher.mobileandubiquitouscomputingcoursework;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.view.View;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Christopher on 07/12/2015.
 */
public class CarParkDataBaseStorage extends SQLiteOpenHelper {

    private static final String DB_PATH = "data/data/com.example.christopher.mobileandubiquitouscomputingcoursework/databases/";
    private static final String DB_NAME =  "CarParkDatabase3.s3db";
    private static final String TBL_CARPARKDATA = "CarParkData";
    private static  final String COL_CARPARKID = "CarparkID";
    private static final String COL_CARPARKNAME= "CarParkName";
    private static final String COL_CAPACITY = "Capacity";
    private static final String COL_LATITUDE = "Latitude";
    private static final String COL_LONGITUDE = "Longitude";

    private final Context appContext;

    public CarParkDataBaseStorage(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
        this.appContext = context;
    }


    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String CREATE_CARPARK_TABLE = "CREATE TABLE IF NOT EXISTS " + TBL_CARPARKDATA + "(" + COL_CARPARKID + "  INTEGER PRIMARY KEY, "
                + COL_CARPARKNAME + " TEXT, " + COL_CAPACITY + " TEXT," +  COL_LATITUDE + " DOUBLE," + COL_LONGITUDE + " DOUBLE" +")";
        db.execSQL(CREATE_CARPARK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if(newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TBL_CARPARKDATA);
            onCreate(db);
        }
    }

    public void dbCreate() throws IOException
    {
        boolean dbExist = dbCheck();

        if(!dbExist)
        {
            this.getWritableDatabase();
            try{
                copyDBFromAssets();
            }
            catch (IOException e)
            {
                throw new Error("Error Copying Database");
            }
        }

    }

    private boolean dbCheck(){
        SQLiteDatabase db = null;

        try{
            String dbPath = DB_PATH + DB_NAME;
            db = SQLiteDatabase.openDatabase(dbPath, null, SQLiteDatabase.OPEN_READWRITE);
            db.setLocale(Locale.getDefault());
            db.setVersion(1);
        }
        catch(SQLiteException e)
        {
            Log.e("SQLHelper", "Database Not Found");
        }

        if(db!=null)
        {
            db.close();
        }

        return db != null ? true : false;
    }

    private void copyDBFromAssets()  throws IOException{
        InputStream dbInput = null;
        OutputStream dbOutput =null;
        String dbfileName = DB_PATH + DB_NAME;

      //  String string[] = appContext.getAssets().list("");


        try {
            dbInput = appContext.getAssets().open(DB_NAME);
            dbOutput = new FileOutputStream(dbfileName);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = dbInput.read(buffer))>0) {
                dbOutput.write(buffer,0, length);
            }
            dbOutput.flush();
            dbOutput.close();
            dbInput.close();

        }

        catch (IOException e)
        {
            throw new Error ("Problems Copying Database!");
        }
    }

    public void addCarInfo(CarParkInfo info)
    {
        ContentValues values = new ContentValues();
        values.put(COL_CARPARKNAME, info.getCarParkName());
        values.put(COL_CAPACITY, info.getCapacity());
        values.put(COL_LATITUDE, info.getLatitude());
        values.put(COL_LONGITUDE, info.getLongitude());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TBL_CARPARKDATA, null, values);
        db.close();
    }

    public CarParkInfo findData(String data)
    {

        String query = "Select * FROM " + TBL_CARPARKDATA + " WHERE " + COL_CARPARKNAME + " =  \"" + data + "\"";

        SQLiteDatabase db = this.getReadableDatabase();



        Cursor cursor = db.rawQuery(query, null);

        CarParkInfo carParkInfo = new CarParkInfo();

        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            carParkInfo.setCarParkID(Integer.parseInt(cursor.getString(0)));
            carParkInfo.setCarParkName(cursor.getString(1));
            carParkInfo.setCapacity(cursor.getString(2));
            carParkInfo.setLatitude(Double.parseDouble(cursor.getString(3)));
            carParkInfo.setLongitude(Double.parseDouble(cursor.getString(4)));
            cursor.close();
        }
        else {
            carParkInfo = null;
        }
        db.close();
        return  carParkInfo;
    }

    public List<CarParkInfo> findAllData()
    {

        String query = "Select * FROM " + TBL_CARPARKDATA;
        List<CarParkInfo> mapList = new ArrayList<CarParkInfo>();

        SQLiteDatabase db = this.getReadableDatabase();



        Cursor cursor = db.rawQuery(query, null);

        CarParkInfo carParkInfo;

        if (cursor.moveToFirst()) {
            while (cursor.isAfterLast() == false) {
                carParkInfo = new CarParkInfo();
                carParkInfo.setCarParkID(Integer.parseInt(cursor.getString(0)));
                carParkInfo.setCarParkName(cursor.getString(1));
                carParkInfo.setCapacity(cursor.getString(2));
                carParkInfo.setLatitude(Double.parseDouble(cursor.getString(3)));
                carParkInfo.setLongitude(Double.parseDouble(cursor.getString(4)));
                mapList.add(carParkInfo);
                cursor.moveToNext();
            }

        }else {
            mapList.add(null);
        }

        db.close();
        return mapList;
    }





}
