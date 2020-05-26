package com.example.retailnav;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class activity_map extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // To get names of all files inside the "Files" folder
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open("positions.txt")));
            // do reading, usually loop until end of file reading
            String mLine;
            while ((mLine = reader.readLine()) != null) {
                System.out.println("\n*****\n*******\n*****\n****\n"+mLine);
                String node_details[]=mLine.split(",");
                create_nodes(node_details);
            }
        } catch (IOException e) {
            //log the exception
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

    }

    protected void create_nodes(String node_details[])
    {
        int node_id=Integer.parseInt(node_details[0]);
        int node_x=Integer.parseInt(node_details[2]);
        int node_y=Integer.parseInt(node_details[3]);
        System.out.println(node_id+","+node_details[1]+","+node_x+","+node_y);
        RelativeLayout map_layout;
        map_layout = (RelativeLayout) findViewById(R.id.activity_map);
        TextView node= new TextView(this);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        params.setMargins(node_x*20,0,0,node_y*20);
        node.setLayoutParams(params);
        node.setBackgroundColor(Color.YELLOW);
        node.setPadding(2,2,2,2);
        node.setId(node_id);
        node.setText(node_details[1]);
        node.setHeight(80);
        node.setWidth(200);

        if (map_layout != null){
            map_layout.addView(node);
        }
    }
}
