package com.example.jusfa.jusfa;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class ListFireActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_fire);

        ImageButton fire1 = (ImageButton) findViewById(R.id.fire1);
        ImageButton fire2 = (ImageButton) findViewById(R.id.fire2);
        ImageButton fire3 = (ImageButton) findViewById(R.id.fire3);
        ImageButton fire4 = (ImageButton) findViewById(R.id.fire4);
        ImageButton fire5 = (ImageButton) findViewById(R.id.fire5);


        fire1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Fire1Activity.class);
                startActivity(i);
            }
        });

        fire2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Fire2Activity.class);
                startActivity(i);
            }
        });

        fire3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Fire3Activity.class);
                startActivity(i);
            }
        });

        fire4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Fire4Activity.class);
                startActivity(i);
            }
        });

        fire5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Fire5Activity.class);
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
