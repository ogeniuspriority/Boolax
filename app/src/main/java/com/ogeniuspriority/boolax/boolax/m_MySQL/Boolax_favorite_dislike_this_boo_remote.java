package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Toast;

import com.marcoscg.dialogsheet.DialogSheet;
import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import es.dmoral.toasty.Toasty;

/**
 * Created by USER on 2/6/2017.
 */
public class Boolax_favorite_dislike_this_boo_remote extends AsyncTask<Void, Void, String> {
    Context c;
    String myRemoteId;
    String theRemoteUrl;
    String TheOtherParty;
    View view;
    DialogSheet MyBoos_popup;

    public Boolax_favorite_dislike_this_boo_remote(Context c, String theRemoteUrl, String myRemoteId, String TheOtherParty, View view, DialogSheet MyBoos_popup) {
        this.c = c;
        //---------------
        this.myRemoteId = myRemoteId;
        this.TheOtherParty = TheOtherParty;
        this.theRemoteUrl = theRemoteUrl;
        this.view = view;
        this.MyBoos_popup = MyBoos_popup;

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
        if (jsonData == null) {
            Toasty.error(c, "No internet connection!", Toast.LENGTH_SHORT, true).show();

        } else {
            if (jsonData.contains("1000")) {
                //----------Dislike the temp boo-----
                NDS_boolax_db_adapter thDb;
                thDb = new NDS_boolax_db_adapter(c);
                thDb.openToWrite();

                if (thDb.update_THIS_TEMP_BOO_VISIBILITY(TheOtherParty)) {
                    MyBoos_popup.dismiss();
                    TranslateAnimation animate = new TranslateAnimation(0, -view.getWidth(), 0, 0);
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
                            //view.setVisibility(View.GONE);
                            ((Activity)c).recreate();
                        }
                    });
                    Log.w("likestatus","dislike ..Okay "+TheOtherParty);

                }

            } else {

            }

        }
    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_favorite_dislike_this_boo_connect.connect(theRemoteUrl, myRemoteId, TheOtherParty);
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
