package com.example.jusfa.jusfa;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public LocationManager locManager;
    private LocationListener locListener = new MyLocationListener();
    private boolean gps_enabled = false;
    private boolean network_enabled = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button unlock = (Button) findViewById(R.id.unlock);
        Button locked = (Button) findViewById(R.id.locked);
        final Button sos = (Button) findViewById(R.id.sos);
        Button setting = (Button) findViewById(R.id.setting);
        Button fire = (Button) findViewById(R.id.fire);
        Button food = (Button) findViewById(R.id.food);
        Button shelter = (Button) findViewById(R.id.shelter);
        Button firstaid = (Button) findViewById(R.id.firstaid);
        Button logout = (Button) findViewById(R.id.logout);
        locManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        setting.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SettingActivity.class);
                startActivity(i);
            }
        });

        fire.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListFireActivity.class);
                startActivity(i);
            }
        });

        food.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListFoodActivity.class);
                startActivity(i);
            }
        });

        shelter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListShelterActivity.class);
                startActivity(i);
            }
        });

        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), DatabaseActivity.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(), "Logout Successfully", Toast.LENGTH_SHORT).show();
                MainActivity.this.finish();
            }
        });

        firstaid.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ListFirstAidActivity.class);
                startActivity(i);
            }
        });

        unlock.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sos.setEnabled(true);

            }
        });

        locked.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sos.setEnabled(false);

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
                Intent i = new Intent(getApplicationContext(), EmergencyActivity.class);
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
        MainActivity.this.finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
