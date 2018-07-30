package com.ogeniuspriority.boolax.boolax;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tomergoldst.tooltips.ToolTip;
import com.tomergoldst.tooltips.ToolTipsManager;

public class Boolax_favorite_Quick_boos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolax_favorite_quick_boos);
        // Initilization
        getSupportActionBar().hide();
        //--------------------Navigate through other tabs-----------
        final ImageView boo_favorite_booers_boos_find = (ImageView) findViewById(R.id.boo_favorite_booers_boos_find);
        ImageView boo_favorite_events_find = (ImageView) findViewById(R.id.boo_favorite_events_find);
        ImageView boo_favorite_groups_find = (ImageView) findViewById(R.id.boo_favorite_groups_find);
        final ImageView boo_favorite_quick_boos_find = (ImageView) findViewById(R.id.boo_favorite_quick_boos_find);
        //----------------------------------------------
        boo_favorite_booers_boos_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent i = new Intent(Boolax_favorite_Boo_Booers.this, Boolax_favorite_Boo_Booers.class);
                // startActivity(i);
                Intent i = new Intent(Boolax_favorite_Quick_boos.this, Boolax_favorite_Boo_Booers.class);
                startActivity(i);
            }
        });
        boo_favorite_events_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_favorite_Quick_boos.this, Boolax_favorite_Boo_Events.class);
                startActivity(i);

            }
        });
        boo_favorite_groups_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_favorite_Quick_boos.this, Boolax_favorite_Groups.class);
                startActivity(i);

            }
        });
        boo_favorite_quick_boos_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ToolTipsManager mToolTipsManager;
                mToolTipsManager = new ToolTipsManager();
                RelativeLayout theTeste = (RelativeLayout) findViewById(R.id.theTeste);
                ToolTip.Builder builder = new ToolTip.Builder(Boolax_favorite_Quick_boos.this, boo_favorite_quick_boos_find, theTeste, "Get a date/Quick Boo! See above!", ToolTip.POSITION_LEFT_TO);
                builder.setAlign(ToolTip.ALIGN_LEFT);
                builder.setGravity(ToolTip.GRAVITY_RIGHT);
                builder.setTextSize(12);
                mToolTipsManager.show(builder.build());
            }
        });

    }
}
