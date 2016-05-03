package my.edu.politeknik.antikidnapping;

import java.util.ArrayList;
import java.util.List;

import my.edu.politeknik.antikidnapping.AntiKidnapping.MyLocationListener;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler2 extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "sos4";
	private static final String TABLE_POLICE = "policenumber";
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_PH_NO = "police_number";

	public DatabaseHandler2(Context myLocationListener) {
		super(myLocationListener, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public DatabaseHandler2(MyLocationListener myLocationListener) {
		super(null, null, null, 0);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_POLICE_TABLE = "CREATE TABLE " + TABLE_POLICE + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ KEY_PH_NO + " TEXT" + ")";
		db.execSQL(CREATE_POLICE_TABLE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_POLICE);
		onCreate(db);
	}

	
	void addPolice(Police contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getPoliceNumber());
		db.insert(TABLE_POLICE, null, values);
		db.close();
	}

	
	Contact getPolice(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_POLICE, new String[] { KEY_ID,
				KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
		Contact police = new Contact(Integer.parseInt(cursor.getString(0)),
		cursor.getString(1), cursor.getString(2));
		return police;
	}

	
	public List<Police> getAllPolice() {
		List<Police> policeList = new ArrayList<Police>();
		String selectQuery = "SELECT * FROM " + TABLE_POLICE;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				Police contact = new Police();
				contact.setID(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setPoliceNumber(cursor.getString(2));
				policeList.add(contact);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		return policeList;
	}


	
	public int updatePolice(Police contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		int val = 1;
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getPoliceNumber());
		return db.update(TABLE_POLICE, values, KEY_ID + " = ?",
				new String[] { String.valueOf(val) });
	}

	public void deletePolice(Police contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_POLICE, KEY_ID + " = ?", new String[] { String.valueOf(contact.getID()) });
		db.close();
	}

	public int getPoliceCount() {
		String countQuery = "SELECT * FROM " + TABLE_POLICE;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();
		return cursor.getCount();
	}

}
