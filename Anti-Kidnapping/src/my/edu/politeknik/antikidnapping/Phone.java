package my.edu.politeknik.antikidnapping;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Phone extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main2);
		Button save = (Button) findViewById(R.id.save);
		
		final EditText phone = (EditText) findViewById(R.id.phone);
		final DatabaseHandler db = new DatabaseHandler(this);
		List<Contact> entries = db.getAllContacts();
		if (entries.size() != 0) {
			Contact link = db.getContact(1);
			String number1 = link.getName();
			phone.setText(number1);
		}
		final EditText police = (EditText) findViewById(R.id.police);
		final DatabaseHandler2 db1 = new DatabaseHandler2(this);
		List<Police> entriesP = db1.getAllPolice();
		if (entriesP.size() != 0) {
			Contact link1 = db1.getPolice(1);
			String numberP = link1.getName();
			police.setText(numberP);
		}
		final EditText fireman = (EditText) findViewById(R.id.fireman);
		final DatabaseHandler3 db2 = new DatabaseHandler3(this);
		List<Fireman> entriesF = db2.getAllFireman();
		if (entriesF.size() != 0) {
			Contact link1 = db2.getFireman(1);
			String numberF = link1.getName();
			fireman.setText(numberF);
		}
		final EditText medical = (EditText) findViewById(R.id.medical);
		final DatabaseHandler4 db3 = new DatabaseHandler4(this);
		List<Medical> entriesM = db3.getAllMedical();
		if (entriesM.size() != 0) {
			Contact link1 = db3.getMedical(1);
			String numberP = link1.getName();
			medical.setText(numberP);
		}
		save.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				
				String number2 = phone.getText().toString();
				String number3 = police.getText().toString();
				String number4 = fireman.getText().toString();
				String number5 = medical.getText().toString();
				
				if (number2.length()  == 0) {
					Toast.makeText(Phone.this, "Please enter a phone number", Toast.LENGTH_SHORT).show();
				} else {
					List<Contact> entries2 = db.getAllContacts();
					if (entries2.size() == 0) {
						db.addContact(new Contact("123", ""));
					}
					db.updateContact(new Contact(number2, ""));
					Toast.makeText(Phone.this, "Emergency contact has been saved",
							Toast.LENGTH_SHORT).show();
					
				}
				if (number3.length()  == 0) {
					Toast.makeText(Phone.this, "Please enter a police number", Toast.LENGTH_SHORT).show();
				} else {
					List<Police> entries3 = db1.getAllPolice();
					if (entries3.size() == 0) {
						db1.addPolice(new Police("123", ""));
					}
					db1.updatePolice(new Police(number3, ""));
					Toast.makeText(Phone.this, "Emergency contact has been saved",
							Toast.LENGTH_SHORT).show();
					
				}
				if (number4.length()  == 0) {
					Toast.makeText(Phone.this, "Please enter a fireman number", Toast.LENGTH_SHORT).show();
				} else {
					List<Fireman> entries4 = db2.getAllFireman();
					if (entries4.size() == 0) {
						db2.addFireman(new Fireman("123", ""));
					}
					db2.updateFireman(new Fireman(number4, ""));
					Toast.makeText(Phone.this, "Emergency contact has been saved",
							Toast.LENGTH_SHORT).show();
					
				}
				if (number5.length()  == 0) {
					Toast.makeText(Phone.this, "Please enter a medical number", Toast.LENGTH_SHORT).show();
				} else {
					List<Medical> entries5 = db3.getAllMedical();
					if (entries5.size() == 0) {
						db3.addMedical(new Medical("123", ""));
					}
					db3.updateMedical(new Medical(number5, ""));
					Toast.makeText(Phone.this, "Emergency contact has been saved",
							Toast.LENGTH_SHORT).show();
					
				}
				finish();
			}
		});
		
	}
}
