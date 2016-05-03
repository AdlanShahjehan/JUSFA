package com.example.jusfa.jusfa;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageButton;

public class ListFoodActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);

        ImageButton food1 = (ImageButton) findViewById(R.id.food1);
        ImageButton food2 = (ImageButton) findViewById(R.id.food2);
        ImageButton food3 = (ImageButton) findViewById(R.id.food3);
        ImageButton food4 = (ImageButton) findViewById(R.id.food4);
        ImageButton food5 = (ImageButton) findViewById(R.id.food5);

        food1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Food1Activity.class);
                startActivity(i);
            }
        });

        food2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Food2Activity.class);
                startActivity(i);
            }
        });

        food3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Food3Activity.class);
                startActivity(i);
            }
        });

        food4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Food4Activity.class);
                startActivity(i);
            }
        });

        food5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Food5Activity.class);
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
