package com.example.jusfa.jusfa;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class ListShelterActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_shelter);

        ImageButton shelt1 = (ImageButton) findViewById(R.id.shelt1);
        ImageButton shelt2 = (ImageButton) findViewById(R.id.shelt2);
        ImageButton shelt3 = (ImageButton) findViewById(R.id.shelt3);
        ImageButton shelt4 = (ImageButton) findViewById(R.id.shelt4);
        ImageButton shelt5 = (ImageButton) findViewById(R.id.shelt5);

        shelt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Shelter1Activity.class);
                startActivity(i);
            }
        });

        shelt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Shelter2Activity.class);
                startActivity(i);
            }
        });

        shelt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Shelter3Activity.class);
                startActivity(i);
            }
        });

        shelt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Shelter4Activity.class);
                startActivity(i);
            }
        });

        shelt5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Shelter5Activity.class);
                startActivity(i);
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
}
