package com.ogeniuspriority.boolax.boolax;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.awesomedialog.blennersilva.awesomedialoglibrary.AwesomeNoticeDialog;
import com.awesomedialog.blennersilva.awesomedialoglibrary.interfaces.Closure;
import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheWrapper;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_favorite_booers_download_actual_lovers;
import com.tomergoldst.tooltips.ToolTip;
import com.tomergoldst.tooltips.ToolTipsManager;

import java.io.File;

public class Boolax_favorite_Boo_Booers extends AppCompatActivity {


    // Tab titles
    private String[] tabs = {"BOO", "BOOERS"};
    public static TextView span_count;
    //------------
    String username = "";
    String avatar = "";
    String remote_id_me = "";
    private static volatile String temp_boos_ids = "";
    String gender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolax_favorite__boo__booers);
        //--------------------

        // Initilization
        getSupportActionBar().hide();
        //---the user creds---------
        final NDS_boolax_db_adapter thDb;
        thDb = new NDS_boolax_db_adapter(Boolax_favorite_Boo_Booers.this);
        thDb.openToWrite();

        Cursor allUsersSaved = thDb.GET_USER_DATA();

        if (allUsersSaved.moveToLast()) {
            for (int i = 0; i < allUsersSaved.getCount(); i++) {
                avatar = allUsersSaved.getString(21);
                remote_id_me = allUsersSaved.getString(22);
                username = allUsersSaved.getString(5);
                gender = allUsersSaved.getString(3);

            }

        }
        //------------The navigation buttons--
        handlerRecycleActivity.postDelayed(runnableRecycleActivity, 1000);


        //-----------------------------
        new AwesomeNoticeDialog(Boolax_favorite_Boo_Booers.this)
                .setTitle(R.string.app_name)
                .setMessage("Hi! New Boos waiting!.")
                .setColoredCircle(R.color.dialogNoticeBackgroundColor)
                .setDialogIconAndColor(R.drawable.ic_favorite_black_24dp, R.color.white)
                .setCancelable(true)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setButtonBackgroundColor(R.color.dialogNoticeBackgroundColor)
                .setButtonText(getString(R.string.dialog_ok_button))
                .setNoticeButtonClick(new Closure() {
                    @Override
                    public void exec() {
                        // click
                    }
                })
                .show();

        //------

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("BOOS"));
        tabLayout.addTab(tabLayout.newTab().setText("BOOERS"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        //------------Tab manipulation----------
        for (int i = 0; i < 2; i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            View tabView = ((ViewGroup) tabLayout.getChildAt(0)).getChildAt(i);
            tabView.requestLayout();

            if (i == 0) {
                View view = LayoutInflater.from(this).inflate(R.layout.boolax_boos_navigate_tab, null);
                tab.setCustomView(view);
                tab.setText("BOOS");
                //------------------Handle thee  views--------
            } else if (i == 1) {
                tab.setText("BOOERS");
                View view = LayoutInflater.from(this).inflate(R.layout.boolax_boos_navigate_tab_1, null);
                tab.setCustomView(view);
                //-----------------
                span_count = (TextView) view.findViewById(R.id.span_count);

            }


        }
        //------------
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final boolax_boos_adapter adapter = new boolax_boos_adapter
                (getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                //--------------------
                final int position = tab.getPosition();
                //-----------
                switch (position) {
                    case 0:
                        new AwesomeNoticeDialog(Boolax_favorite_Boo_Booers.this)
                                .setTitle(R.string.app_name)
                                .setMessage("Find new Boos")
                                .setColoredCircle(R.color.dialogNoticeBackgroundColor)
                                .setDialogIconAndColor(R.drawable.ic_favorite_black_24dp, R.color.white)
                                .setCancelable(true)
                                .setButtonText(getString(R.string.dialog_ok_button))
                                .setButtonBackgroundColor(R.color.dialogNoticeBackgroundColor)
                                .setButtonText(getString(R.string.dialog_ok_button))
                                .setNoticeButtonClick(new Closure() {
                                    @Override
                                    public void exec() {
                                        // click
                                    }
                                })
                                .show();
                        break;
                    case 1:
                        new AwesomeNoticeDialog(Boolax_favorite_Boo_Booers.this)
                                .setTitle(R.string.app_name)
                                .setMessage("Acknowledge your Booers(Likers)")
                                .setColoredCircle(R.color.dialogNoticeBackgroundColor)
                                .setDialogIconAndColor(R.drawable.ic_favorite_black_24dp, R.color.white)
                                .setCancelable(true)
                                .setButtonText(getString(R.string.dialog_ok_button))
                                .setButtonBackgroundColor(R.color.dialogNoticeBackgroundColor)
                                .setButtonText(getString(R.string.dialog_ok_button))
                                .setNoticeButtonClick(new Closure() {
                                    @Override
                                    public void exec() {
                                        // click
                                    }
                                })
                                .show();
                        break;
                }


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        //--------------------Navigate through other tabs-----------
        final ImageView boo_favorite_booers_boos_find = (ImageView) findViewById(R.id.boo_favorite_booers_boos_find);
        ImageView boo_favorite_events_find = (ImageView) findViewById(R.id.boo_favorite_events_find);
        ImageView boo_favorite_groups_find = (ImageView) findViewById(R.id.boo_favorite_groups_find);
        ImageView boo_favorite_quick_boos_find = (ImageView) findViewById(R.id.boo_favorite_quick_boos_find);
        //----------------------------------------------
        boo_favorite_booers_boos_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Intent i = new Intent(Boolax_favorite_Boo_Booers.this, Boolax_favorite_Boo_Booers.class);
                // startActivity(i);
                ToolTipsManager mToolTipsManager;
                mToolTipsManager = new ToolTipsManager();
                RelativeLayout theTeste = (RelativeLayout) findViewById(R.id.theTeste);
                ToolTip.Builder builder = new ToolTip.Builder(Boolax_favorite_Boo_Booers.this, boo_favorite_booers_boos_find, theTeste, "Find Boos and Booers! See above!", ToolTip.POSITION_ABOVE);
                builder.setAlign(ToolTip.ALIGN_LEFT);
                builder.setGravity(ToolTip.GRAVITY_RIGHT);
                builder.setTextSize(12);
                mToolTipsManager.show(builder.build());
            }
        });
        boo_favorite_events_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_favorite_Boo_Booers.this, Boolax_favorite_Boo_Events.class);
                startActivity(i);

            }
        });
        boo_favorite_groups_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_favorite_Boo_Booers.this, Boolax_favorite_Groups.class);
                startActivity(i);

            }
        });
        boo_favorite_quick_boos_find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_favorite_Boo_Booers.this, Boolax_favorite_Quick_boos.class);
                startActivity(i);
            }
        });
        //-------The navigation tabs--------------
        final ImageView btn_boolax_boo_booers = (ImageView) findViewById(R.id.btn_boolax_boo_booers);
        ImageView btn_boolax_boo_chats = (ImageView) findViewById(R.id.btn_boolax_boo_chats);
        ImageView btn_boolax_boo_profile = (ImageView) findViewById(R.id.btn_boolax_boo_profile);
        ImageView btn_boolax_boo_search = (ImageView) findViewById(R.id.btn_boolax_boo_search);
        ImageView boolax_boo_settings = (ImageView) findViewById(R.id.boolax_boo_settings);
        //--------------------
        btn_boolax_boo_booers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolTipsManager mToolTipsManager;
                mToolTipsManager = new ToolTipsManager();
                RelativeLayout theTeste = (RelativeLayout) findViewById(R.id.theTeste);
                ToolTip.Builder builder = new ToolTip.Builder(Boolax_favorite_Boo_Booers.this, btn_boolax_boo_booers, theTeste, "Find Boos and Booers! Below!", ToolTip.POSITION_RIGHT_TO);
                builder.setAlign(ToolTip.ALIGN_LEFT);
                builder.setBackgroundColor(Color.parseColor("#cdcdcd"));
                builder.setGravity(ToolTip.GRAVITY_RIGHT);
                builder.setTextColor(Color.parseColor("#333333"));
                builder.setTextSize(12);
                mToolTipsManager.show(builder.build());

            }
        });
        btn_boolax_boo_chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_favorite_Boo_Booers.this, Boolax_favorite_Boo_Booers_chats.class);
                startActivity(i);

            }
        });
        btn_boolax_boo_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_favorite_Boo_Booers.this, Boolax_profile.class);
                startActivity(i);

            }
        });
        btn_boolax_boo_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(Boolax_favorite_Boo_Booers.this, SearchableActivity.class);
                startActivity(i);


            }
        });
        boolax_boo_settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Boolax_favorite_Boo_Booers.this, Boolax_settings.class);
                startActivity(i);

            }
        });


    }

    //-----the background handler---
    Handler handlerRecycleActivity = new Handler();
    Runnable runnableRecycleActivity = new Runnable() {
        public void run() {
            //----------find the lastid to be inserted--
            new Thread(new Runnable() {
                @Override
                public void run() {
                    final NDS_boolax_db_adapter thDb;
                    thDb = new NDS_boolax_db_adapter(Boolax_favorite_Boo_Booers.this);
                    thDb.openToWrite();
                    Cursor all_boos = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_ACTUAL_LOVERS_ALL();
                    if (all_boos.moveToLast()) {
                        for (int i = 0; i < all_boos.getCount(); i++) {
                            String curr_id = all_boos.getString(20);
                            if (temp_boos_ids.equalsIgnoreCase("")) {
                                temp_boos_ids = temp_boos_ids + curr_id;

                            } else {
                                temp_boos_ids = temp_boos_ids + "~" + curr_id;
                            }
                            all_boos.moveToPrevious();
                        }
                    }
                    //----------------------
                    new Boolax_favorite_booers_download_actual_lovers(Boolax_favorite_Boo_Booers.this, Config.BOOLAX_ACCOUNT_LOAD_THE_ACTUAL_LOVERS.toString(), remote_id_me, temp_boos_ids).execute();

                }
            }).start();
            handlerRecycleActivity.postDelayed(this, 15000);

        }
    };

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}