package com.example.christopher.mobileandubiquitouscomputingcoursework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Christopher on 27/11/2015.
 */
    public class CarParkDatabaseCreator extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "DB_NAME";
    protected static final String FIRST_TABLE_NAME = "FIRST_TABLE";
    protected static final String SECOND_TABLE_NAME = "SECOND_TABLE";
    protected static final String THIRD_TABLE_NAME = "THIRD_TABLE";
    protected static final String FORTH_TABLE_NAME = "FORTH_TABLE";
    protected static final String FIFTH_TABLE_NAME =  "FIFTH_TABLE";
    protected static final String SIXTH_TABLE_NAME = "SIXTH_TABLE";
    protected static final String SEVENTH_TABLE_NAME = "SEVENTH_TABLE";
    protected static final String EIGHTH_TABLE_NAME = "EIGHTH_TABLE";
    protected static final String NINTH_TABLE_NAME = "NINTH_TABLE";
    protected static final String TENTH_TABLE_NAME = "TENTH_TABLE";
    protected static final String ELEVENTH_TABLE_NAME = "ELEVENTH_TABLE";

    public static final String CREATE_FIRST_TABLE = "create table if not exists " + FIRST_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";
    public static final String CREATE_SECOND_TABLE = "create tble if not exists " + SECOND_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";
    public static final String CREATE_THIRD_TABLE = "create tble if not exists " + THIRD_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";
    public static final String CREATE_FORTH_TABLE = "create tble if not exists " + FORTH_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";
    public static final String CREATE_FIFTH_TABLE = "create tble if not exists " + FIFTH_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";
    public static final String CREATE_SIXTH_TABLE = "create tble if not exists " + SIXTH_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";
    public static final String CREATE_SEVENTH_TABLE = "create tble if not exists " + SEVENTH_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";
    public static final String CREATE_EIGHTH_TABLE = "create tble if not exists " + EIGHTH_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";
    public static final String CREATE_NINTH_TABLE = "create tble if not exists " + NINTH_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";
    public static final String CREATE_TENTH_TABLE = "create tble if not exists " + TENTH_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";
    public static final String CREATE_ELEVENTH_TABLE = "create tble if not exists " + ELEVENTH_TABLE_NAME + " ( _id integer primary key autoincrement, COL1  TEXT , COL2  TEXT , COL3 TEXT, COL4 TEXT, COL5 TEXT,"
            + "COL6 TEXT, COL7 TEXT, COL8 TEXT, COL9 TEXT);";


    public CarParkDatabaseCreator(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_FIRST_TABLE);
        db.execSQL(CREATE_SECOND_TABLE);
        db.execSQL(CREATE_THIRD_TABLE);
        db.execSQL(CREATE_FORTH_TABLE);
        db.execSQL(CREATE_FIFTH_TABLE);
        db.execSQL(CREATE_SIXTH_TABLE);
        db.execSQL(CREATE_SEVENTH_TABLE);
        db.execSQL(CREATE_EIGHTH_TABLE);
        db.execSQL(CREATE_NINTH_TABLE);
        db.execSQL(CREATE_TENTH_TABLE);
        db.execSQL(CREATE_ELEVENTH_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion){
        //Update Database
    }


}
