package com.ogeniuspriority.boolax.boolax;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import mehdi.sakout.fancybuttons.FancyButton;

public class Boolax_splashscreen extends AppCompatActivity {

    NDS_boolax_db_adapter thDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolax_splashscreen);
        getSupportActionBar().hide();
        //-----
        FancyButton Boolax_normal_login = (FancyButton) findViewById(R.id.Boolax_normal_login);
        //---------------------
        Boolax_normal_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_splashscreen.this, Boolax_login.class);
                startActivity(i);
            }
        });
        //-------------
        thDb = new NDS_boolax_db_adapter(Boolax_splashscreen.this);
        try {
            if (new database_enablers(Boolax_splashscreen.this).findIfUserCreated()) {
                //Toasty.success(Boolax_splashscreen.this,"Fuck..", Toast.LENGTH_SHORT).show();


            } else {
                //----------
                if (new database_enablers(Boolax_splashscreen.this).findIfThereIsCompleteAccount()) {
                    Intent i = new Intent(Boolax_splashscreen.this, Boolax_favorite_Boo_Booers.class);
                    Boolax_splashscreen.this.startActivity(i);

                } else if (new database_enablers(Boolax_splashscreen.this).findIfSocialMediaWasUsed()) {
                    Intent i = new Intent(Boolax_splashscreen.this, Boolax_favorite_Boo_Booers.class);
                    Boolax_splashscreen.this.startActivity(i);

                } else {
                    Intent i = new Intent(Boolax_splashscreen.this, boolax_basic_profile.class);
                    startActivity(i);
                }


            }
        } catch (Exception ff) {
            //Toasty.success(Boolax_splashscreen.this,"Fuck.."+ff.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}
