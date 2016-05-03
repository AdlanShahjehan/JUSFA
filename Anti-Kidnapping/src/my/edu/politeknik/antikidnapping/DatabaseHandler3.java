package my.edu.politeknik.antikidnapping;

import java.util.ArrayList;
import java.util.List;

import my.edu.politeknik.antikidnapping.AntiKidnapping.MyLocationListener;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler3 extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "sos5";
	private static final String TABLE_FIREMAN = "firemannumber";
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_PH_NO = "fireman_number";

	public DatabaseHandler3(Context myLocationListener) {
		super(myLocationListener, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public DatabaseHandler3(MyLocationListener myLocationListener) {
		super(null, null, null, 0);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_FIREMAN_TABLE = "CREATE TABLE " + TABLE_FIREMAN + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ KEY_PH_NO + " TEXT" + ")";
		db.execSQL(CREATE_FIREMAN_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_FIREMAN);
		onCreate(db);
	}

	
	void addFireman(Fireman contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getFiremanNumber());
		db.insert(TABLE_FIREMAN, null, values);
		db.close();
	}

	Contact getFireman(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_FIREMAN, new String[] { KEY_ID,
				KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
		Contact fireman = new Contact(Integer.parseInt(cursor.getString(0)),
		cursor.getString(1), cursor.getString(2));
		return fireman;
	}

	
	public List<Fireman> getAllFireman() {
		List<Fireman> firemanList = new ArrayList<Fireman>();
		String selectQuery = "SELECT * FROM " + TABLE_FIREMAN;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				Fireman contact = new Fireman();
				contact.setID(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setFiremanNumber(cursor.getString(2));
				firemanList.add(contact);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		return firemanList;
	}


	
	public int updateFireman(Fireman contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		int val = 1;
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getFiremanNumber());
		return db.update(TABLE_FIREMAN, values, KEY_ID + " = ?",
				new String[] { String.valueOf(val) });
	}

	public void deleteFireman(Fireman contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_FIREMAN, KEY_ID + " = ?", new String[] { String.valueOf(contact.getID()) });
		db.close();
	}

	public int getFiremanCount() {
		String countQuery = "SELECT * FROM " + TABLE_FIREMAN;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();
		return cursor.getCount();
	}

}
