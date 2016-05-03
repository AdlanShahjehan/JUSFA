package my.edu.politeknik.antikidnapping;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Toast;

public class FiremanActivity extends Activity {
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		DatabaseHandler3 db = new DatabaseHandler3(this);
		Bundle extras = getIntent().getExtras();
		List<Fireman> entries = db.getAllFireman();
		String number = "tel:";
		if (entries.size() != 0) {
			Contact link = db.getFireman(1);
			number = link.getName();
		}
		
		 try {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:"+number));  
		        startActivity(callIntent);
		        finish();
		   }
	       catch (android.content.ActivityNotFoundException ex) {
         Toast.makeText(FiremanActivity.this,"Call failed, please try again later!", Toast.LENGTH_SHORT).show();
     }
	 
	}
}
