package my.edu.politeknik.antikidnapping;

import java.util.Date;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class AntiKidnapping extends Activity implements OnClickListener {

	
	private ImageButton call;
	private ImageButton police_call;
	private ImageButton medical_call;
	private ImageButton fireman_call;
	private boolean gps_enabled = false;
	private boolean network_enabled = false;
	public LocationManager locManager;
	private LocationListener locListener = new MyLocationListener();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Button sos = (Button) findViewById(R.id.sos);
		Button setting = (Button) findViewById(R.id.setting);
		call = (ImageButton) findViewById(R.id.call); 
		police_call = (ImageButton) findViewById(R.id.police_call);
		medical_call = (ImageButton) findViewById(R.id.medical_call); 
		fireman_call = (ImageButton) findViewById(R.id.fireman_call); 
		locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		
		setting.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				Intent i = new Intent(getApplicationContext(), Phone.class);
				startActivity(i);
			}
		});
	
		sos.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				try {
					gps_enabled = locManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
				} catch (Exception ex) {
				}
				try {
					network_enabled = locManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
				} catch (Exception ex) {
				}
				if (network_enabled) {
					locManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locListener);
				}
				if (gps_enabled) {
					locManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locListener);
				}
			}
		});
			 
		call.setOnClickListener(new View.OnClickListener() {	
			 public void onClick(View v) { 
					Intent i = new Intent(getApplicationContext(), CallActivity.class);
					startActivity(i);
			 }});
		
		police_call.setOnClickListener(new View.OnClickListener() {

			 public void onClick(View v) { 
					Intent i = new Intent(getApplicationContext(), PoliceActivity.class);
					startActivity(i);
			 }});
		
		medical_call.setOnClickListener(new View.OnClickListener() {

			 public void onClick(View v) { 
					Intent i = new Intent(getApplicationContext(), MedicalActivity.class);
					startActivity(i);
			 }});
		
		fireman_call.setOnClickListener(new View.OnClickListener() {

			 public void onClick(View v) { 
					Intent i = new Intent(getApplicationContext(), FiremanActivity.class);
					startActivity(i);
			 }});
	}

	

	
	public void onClick(DialogInterface arg0, int which) {
		if (which == DialogInterface.BUTTON_NEUTRAL) {
			// editTextShowLocation.setText("Sorry, location is not determined. To fix this please enable location providers");
		} else if (which == DialogInterface.BUTTON_POSITIVE) {
			startActivity(new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS));
		}
	}

	class MyLocationListener implements LocationListener {
		public void onLocationChanged(Location location) {
			if (location != null) {
				locManager.removeUpdates(locListener);
				String londitude = "\nLongitude: " + location.getLongitude();
				String latitude = "\nLatitude: " + location.getLatitude();
				String altitiude = "\nAltitude: " + location.getAltitude();
				String accuracy = "\nAccuracy: " + location.getAccuracy();
				Date date = new Date();
				java.text.DateFormat dateFormat = android.text.format.DateFormat.getTimeFormat(getApplicationContext());
				String time = "\nTime: " + dateFormat.format(date);
				String message = "Help Me!!! Emergency calling. My current location is:" + latitude + londitude + altitiude + accuracy + time;
				Intent i = new Intent(getApplicationContext(), sendsms.class);
				i.putExtra("message", message);
				startActivity(i);
			}
		}

		public void onProviderDisabled(String provider) {

		}

		public void onProviderEnabled(String provider) {

		}

		public void onStatusChanged(String provider, int status, Bundle extras) {

		}
	}
	
	@Override
	public void onBackPressed() {
	   moveTaskToBack(true); 
	   AntiKidnapping.this.finish();
	}
	
}
