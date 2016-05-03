package com.example.jusfa.jusfa;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

public class DbHelper extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "login.db";
	private static final int DATABASE_VERSION = 1;
    public static final String ACTIVEPRESENTER_TABLE_NAME = "login";
	private static final String ACTIVEPRESENTER_TABLE_CREATE =
	                "CREATE TABLE " + ACTIVEPRESENTER_TABLE_NAME + "(" +
	                "_id INTEGER PRIMARY KEY AUTOINCREMENT,"+
	                "username TEXT NOT NULL, password TEXT NOT NULL, email TEXT NOT NULL);";
	private static final String ACTIVEPRESENTER_DB_ADMIN = "INSERT INTO "+ACTIVEPRESENTER_TABLE_NAME+"values(1, admin, password, admin@gmail.com);";
	
	
	public DbHelper(Context context) {
		
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		System.out.println("In constructor");
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		try{
			//Create Database
			db.execSQL(ACTIVEPRESENTER_TABLE_CREATE);
			
			//create admin account
			db.execSQL(ACTIVEPRESENTER_DB_ADMIN);
			System.out.println("In onCreate");
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
		

	}

}
