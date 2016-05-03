package com.example.jusfa.jusfa;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class ListFirstAidActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_first);

        ImageButton first1 = (ImageButton) findViewById(R.id.first1);
        ImageButton first2 = (ImageButton) findViewById(R.id.first2);
        ImageButton first3 = (ImageButton) findViewById(R.id.first3);
        ImageButton first4 = (ImageButton) findViewById(R.id.first4);
        ImageButton first5 = (ImageButton) findViewById(R.id.first5);


        first1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FirstAid1Activity.class);
                startActivity(i);
            }
        });

        first2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FirstAid2Activity.class);
                startActivity(i);
            }
        });

        first3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FirstAid3Activity.class);
                startActivity(i);
            }
        });

        first4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FirstAid4Activity.class);
                startActivity(i);
            }
        });

        first5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), FirstAid5Activity.class);
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
