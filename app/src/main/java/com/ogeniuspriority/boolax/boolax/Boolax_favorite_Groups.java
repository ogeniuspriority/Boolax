package com.ogeniuspriority.boolax.boolax;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import mehdi.sakout.fancybuttons.FancyButton;

public class Boolax_favorite_Groups extends AppCompatActivity {

    ListView boo_groups;
    FancyButton Boolax_normal_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolax_favorite__groups);
        // Initilization
        getSupportActionBar().hide();
        //---------------------------------
        boo_groups = (ListView) findViewById(R.id.boo_groups);
        Boolax_normal_login = (FancyButton) findViewById(R.id.Boolax_normal_login);
        //--------------------
    }
}
