package com.example.retailnav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> shoppinglist=new ArrayList<String>();
    private Button HelpMeShop_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        HelpMeShop_button= findViewById(R.id.HelpMeShop);
        HelpMeShop_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayshoppingList();
                showMapActivity();
            }
        });
    }

    public void displayshoppingList()
    {
        /*Iterator<String> shopListItr = shoppinglist.iterator();
        while (shopListItr.hasNext()) {
            System.out.println("\n.......................... "+shopListItr.next()+" ...........................................");
        }*/
        Set<String> hashSet = new LinkedHashSet(shoppinglist);
        shoppinglist = new ArrayList<String>(hashSet);

       /* shopListItr = shoppinglist.iterator();
        while (shopListItr.hasNext()) {
            System.out.println("\n.......................... "+shopListItr.next()+" ...........................................");
        }*/
    }
    public void modifyShoppingList(View v)
    {
        CheckBox checkBox = (CheckBox)v;
        String idString = v.getResources().getResourceEntryName(v.getId());
        idString = idString.replaceAll("[0123456789]","");
        if(checkBox.isChecked())
        {
            if(!shoppinglist.contains(idString))
            {
                shoppinglist.add(idString);
            }
        }
        else
        {
            if(shoppinglist.contains(idString))
            {
                shoppinglist.remove(idString);
            }
        }
    }

    public void showMapActivity()
    {
        Intent intent_activity_map = new Intent(this, activity_map.class);
        intent_activity_map.putExtra("shoppinglist", shoppinglist);
        startActivity(intent_activity_map);
    }
}
