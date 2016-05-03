package com.example.jusfa.jusfa;

import java.util.List;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
		Button save = (Button) findViewById(R.id.save);
		
		final EditText phone = (EditText) findViewById(R.id.number);
		final DatabaseHandler db = new DatabaseHandler(this);
		List<Contact> entries = db.getAllContacts();
		if (entries.size() != 0) {
			Contact link = db.getContact(1);
			String number1 = link.getName();
			phone.setText(number1);
		}

				save.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				
				String number2 = phone.getText().toString();
				
				if (number2.length()  == 0) {
					Toast.makeText(SettingActivity.this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
				} else {
					List<Contact> entries2 = db.getAllContacts();
					if (entries2.size() == 0) {
						db.addContact(new Contact("123", ""));
					}
					db.updateContact(new Contact(number2, ""));
					Toast.makeText(SettingActivity.this, "Emergency contact has been saved",
							Toast.LENGTH_SHORT).show();
				}
				finish();
			}
		});
		
	}
}
