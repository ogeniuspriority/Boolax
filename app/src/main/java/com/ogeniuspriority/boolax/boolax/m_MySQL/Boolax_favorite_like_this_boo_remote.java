package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.marcoscg.dialogsheet.DialogSheet;
import com.ogeniuspriority.boolax.boolax.Config;
import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.R;
import com.ogeniuspriority.boolax.boolax.boolax_boos;
import com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_boos;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import es.dmoral.toasty.Toasty;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by USER on 2/6/2017.
 */
public class Boolax_favorite_like_this_boo_remote extends AsyncTask<Void, Void, String> {
    Context c;
    //----------------
    String myRemoteId;
    String theRemoteUrl;
    String TheOtherParty;
    View view;
    DialogSheet MyBoos_popup;
    String tag;
    SwipeRefreshLayout pull_to_refresh;
    static volatile String temp_boos_ids = "";
    static volatile String avatar;
    static volatile String remote_id_me;
    static volatile String username;
    static volatile String gender;

    public Boolax_favorite_like_this_boo_remote(Context c, String theRemoteUrl, String myRemoteId, String TheOtherParty, View view, DialogSheet MyBoos_popup, String tag, SwipeRefreshLayout pull_to_refresh) {
        this.c = c;
        //---------------
        this.myRemoteId = myRemoteId;
        this.TheOtherParty = TheOtherParty;
        this.theRemoteUrl = theRemoteUrl;
        this.view = view;
        this.MyBoos_popup = MyBoos_popup;
        this.tag = tag;
        this.pull_to_refresh = pull_to_refresh;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {

        try {
            return this.downloadData();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        Log.w("x34545",""+jsonData);

        MyBoos_popup.dismiss();
        if (jsonData == null) {
            Toasty.error(c, "No internet connection!", Toast.LENGTH_SHORT, true).show();

        } else {
            if (jsonData.contains("1000") && !TheOtherParty.isEmpty()) {
                //----------like the temp boo-----
                final NDS_boolax_db_adapter thDb;
                thDb = new NDS_boolax_db_adapter(c);
                thDb.openToWrite();


                if (thDb.update_THIS_TEMP_BOO_VISIBILITY(TheOtherParty)) {
                    MyBoos_popup.dismiss();
                    TranslateAnimation animate = new TranslateAnimation((tag.equalsIgnoreCase("0")) ? -view.getWidth() : view.getWidth(), 0, 0, 0);

                    animate.setDuration(500);
                    animate.setFillAfter(true);


                    view.startAnimation(animate);
                    animate.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {
                            // TODO Auto-generated method stub
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {
                            // TODO Auto-generated method stub
                        }

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            // TODO Auto-generated method stub
                            // view.setVisibility(View.GONE);
                            FancyButton request_sent = (FancyButton) view.findViewById(R.id.request_sent);
                            request_sent.setTag("done");
                            request_sent.setVisibility(View.VISIBLE);
                            //((Activity) c).recreate();
                            if (tag.equalsIgnoreCase("1")) {
                                view.setBackgroundColor(Color.parseColor("#F1AD9F"));
                                view.setTag(new custom_adapter_for_boos.ViewHolder(view));
                            } else {
                                view.setBackgroundColor(Color.parseColor("#6D6665"));
                                view.setTag(new custom_adapter_for_boos.ViewHolder(view));
                            }
                            pull_to_refresh.post(new Runnable() {
                                @Override
                                public void run() {
                                    pull_to_refresh.setRefreshing(true);
                                    // directly call onRefresh() method
                                    Cursor allUsersSaved = thDb.GET_USER_DATA();

                                    if (allUsersSaved.moveToLast()) {
                                        for (int i = 0; i < allUsersSaved.getCount(); i++) {
                                            avatar = allUsersSaved.getString(21);
                                            remote_id_me = allUsersSaved.getString(22);
                                            username = allUsersSaved.getString(5);
                                            gender = allUsersSaved.getString(3);

                                        }

                                    }
                                    //--------Find all ids in temp boos table----------------------------------------
                                    Cursor all_temp_boos = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_ALL();
                                    if (all_temp_boos.moveToLast()) {
                                        for (int i = 0; i < all_temp_boos.getCount(); i++) {
                                            String curr_id = all_temp_boos.getString(21);

                                            if (temp_boos_ids.equalsIgnoreCase("")) {
                                                temp_boos_ids = temp_boos_ids + "0~" + curr_id;

                                            } else {
                                                temp_boos_ids = temp_boos_ids + "~" + curr_id;
                                            }
                                            all_temp_boos.moveToPrevious();

                                        }

                                    }
                                    //--------Find all ids in  booers table----------------------------------------
                                    Cursor all_booers = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_ALL();
                                    if (all_booers.moveToLast()) {
                                        for (int i = 0; i < all_booers.getCount(); i++) {
                                            String curr_id = all_booers.getString(20);
                                            if (temp_boos_ids.equalsIgnoreCase("")) {
                                                temp_boos_ids = temp_boos_ids + curr_id;
                                            } else {
                                                temp_boos_ids = temp_boos_ids + "~" + curr_id;
                                            }
                                            all_booers.moveToPrevious();
                                        }
                                    }
                                    //--------Find all ids in  boos table----------------------------------------
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
                                    new Boolax_favorite_booers_download_boos(c, Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS, gender, remote_id_me, boolax_boos.boolax_boos_list, pull_to_refresh, temp_boos_ids).execute();


                                }
                            });
                        }
                    });
                    Log.w("likestatus", "Like---Okay" + TheOtherParty);

                }

            } else {

            }

        }
    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_favorite_like_this_boo_connect.connect(theRemoteUrl, myRemoteId, TheOtherParty, tag);
        if (con == null) {
            return null;
        }
        try {
            InputStream is = new BufferedInputStream(con.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuffer jsonData = new StringBuffer();
            while ((line = br.readLine()) != null) {
                jsonData.append(line + "\n");
            }
            // Send post request

            br.close();
            is.close();


            return jsonData.toString();


        } catch (IOException e) {
            e.printStackTrace();


        }


        return null;
    }
}
