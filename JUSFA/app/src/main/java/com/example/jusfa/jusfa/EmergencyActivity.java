package com.example.jusfa.jusfa;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.widget.Toast;

public class EmergencyActivity extends Activity {
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SmsManager sm = SmsManager.getDefault();
		DatabaseHandler db = new DatabaseHandler(this);
		Bundle extras = getIntent().getExtras();
		String message = "";
		if (extras != null) {
			message = extras.getString("message");
		}
		List<Contact> entries = db.getAllContacts();
		String number = "";
		if (entries.size() != 0) {
			Contact link = db.getContact(1);
			number = link.getName();
		}
		sm.sendTextMessage(number, null, message, null, null);
		Toast.makeText(EmergencyActivity.this, "SMS message was sent successfully",
				Toast.LENGTH_SHORT).show();
		Intent i = new Intent(getApplicationContext(), MainActivity.class);
		startActivity(i);
	}
}