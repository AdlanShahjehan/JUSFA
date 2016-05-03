package my.edu.politeknik.antikidnapping;

import java.util.ArrayList;
import java.util.List;

import my.edu.politeknik.antikidnapping.AntiKidnapping.MyLocationListener;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler4 extends SQLiteOpenHelper {

	private static final int DATABASE_VERSION = 1;
	private static final String DATABASE_NAME = "sos6";
	private static final String TABLE_MEDICAL = "medicalnumber";
	private static final String KEY_ID = "id";
	private static final String KEY_NAME = "name";
	private static final String KEY_PH_NO = "medical_number";

	public DatabaseHandler4(Context myLocationListener) {
		super(myLocationListener, DATABASE_NAME, null, DATABASE_VERSION);
	}

	public DatabaseHandler4(MyLocationListener myLocationListener) {
		super(null, null, null, 0);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String CREATE_TABLE_MEDICAL = "CREATE TABLE " + TABLE_MEDICAL + "("
				+ KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
				+ KEY_PH_NO + " TEXT" + ")";
		db.execSQL(CREATE_TABLE_MEDICAL);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_MEDICAL);
		onCreate(db);
	}

	
	void addMedical(Medical contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getMedicalNumber());
		db.insert(TABLE_MEDICAL, null, values);
		db.close();
	}

	
	Contact getMedical(int id) {
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.query(TABLE_MEDICAL, new String[] { KEY_ID,
				KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
				new String[] { String.valueOf(id) }, null, null, null, null);
		if (cursor != null)
			cursor.moveToFirst();
		Contact medical = new Contact(Integer.parseInt(cursor.getString(0)),
		cursor.getString(1), cursor.getString(2));
		return medical;
	}

	
	public List<Medical> getAllMedical() {
		List<Medical> medicalList = new ArrayList<Medical>();
		String selectQuery = "SELECT * FROM " + TABLE_MEDICAL;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		if (cursor.moveToFirst()) {
			do {
				Medical contact = new Medical();
				contact.setID(Integer.parseInt(cursor.getString(0)));
				contact.setName(cursor.getString(1));
				contact.setMedicalNumber(cursor.getString(2));
				medicalList.add(contact);
			} while (cursor.moveToNext());
		}
		cursor.close();
		db.close();
		return medicalList;
	}


	
	public int updateMedical(Medical contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		int val = 1;
		ContentValues values = new ContentValues();
		values.put(KEY_NAME, contact.getName());
		values.put(KEY_PH_NO, contact.getMedicalNumber());
		return db.update(TABLE_MEDICAL, values, KEY_ID + " = ?",
				new String[] { String.valueOf(val) });
	}

	public void deleteMedical(Medical contact) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(TABLE_MEDICAL, KEY_ID + " = ?", new String[] { String.valueOf(contact.getID()) });
		db.close();
	}

	public int getMedicalCount() {
		String countQuery = "SELECT * FROM " + TABLE_MEDICAL;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(countQuery, null);
		cursor.close();
		return cursor.getCount();
	}

}
