package com.example.retailnav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button HelpMeShop_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelpMeShop_button=(Button) findViewById(R.id.HelpMeShop);
        HelpMeShop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMapActivity();
            }
        });
    }

    public void showMapActivity()
    {
        Intent intent_activity_map = new Intent(this, activity_map.class);
        startActivity(intent_activity_map);

    }
}
