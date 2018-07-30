package com.ogeniuspriority.boolax.boolax;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Boolax_settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolax_settings);
        getSupportActionBar().hide();
        //----------
        TextView boolax_set_account = (TextView) findViewById(R.id.boolax_set_account);
        TextView boolax_set_notifications = (TextView) findViewById(R.id.boolax_set_notifications);
        TextView boolax_set_chats = (TextView) findViewById(R.id.boolax_set_chats);
        TextView boolax_set_datausage = (TextView) findViewById(R.id.boolax_set_datausage);
        TextView boolax_set_privacy = (TextView) findViewById(R.id.boolax_set_privacy);
        TextView boolax_set_help = (TextView) findViewById(R.id.boolax_set_help);
        //----------------
        boolax_set_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_settings.this, Boolax_account.class);
                startActivity(i);

            }
        });
        boolax_set_notifications.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_settings.this, Boolax_notifications.class);
                startActivity(i);
            }
        });
        boolax_set_chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_settings.this, Boolax_chats.class);
                startActivity(i);
            }
        });
        boolax_set_datausage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_settings.this, Boolax_Data_usage.class);
                startActivity(i);
            }
        });
        boolax_set_privacy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_settings.this, Boolax_privacy.class);
                startActivity(i);
            }
        });
        boolax_set_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_settings.this, Privacy_help.class);
                startActivity(i);
            }
        });
    }
}
