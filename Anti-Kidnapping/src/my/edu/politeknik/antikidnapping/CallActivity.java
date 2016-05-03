package my.edu.politeknik.antikidnapping;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class CallActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DatabaseHandler db = new DatabaseHandler(this);
		Bundle extras = getIntent().getExtras();
		List<Contact> entries = db.getAllContacts();
		String number = "tel:";
		if (entries.size() != 0) {
			Contact link = db.getContact(1);
			number = link.getName();
		}
		
		 try {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));  
		        startActivity(callIntent);
		        finish();
		   }
	       catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(CallActivity.this,"Call failed, please try again later!", Toast.LENGTH_SHORT).show();
     }
	 
	}
}
