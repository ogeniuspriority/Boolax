package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.marcoscg.dialogsheet.DialogSheet;
import com.ogeniuspriority.boolax.boolax.Boolax_favorite_Boo_Booers;
import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import es.dmoral.toasty.Toasty;

/**
 * Created by USER on 2/6/2017.
 */
public class boolax_resend_finalize_log extends AsyncTask<Void, Void, String> {
    Context c;
    //----------------
    String myRemoteId;
    String theRemoteUrl;
    //-------------
    String emailOrPhone_local;
    String emailOrPhone_Data_local;
    DialogSheet theDialog_local;

    public boolax_resend_finalize_log(Context c, String theRemoteUrl, String myRemoteId,
                                      String emailOrPhone,
                                      String emailOrPhone_Data,
                                      DialogSheet theDialog) {
        this.c = c;
        //---------------
        this.myRemoteId = myRemoteId;
        this.theRemoteUrl = theRemoteUrl;
        //---------------
        this.emailOrPhone_local = emailOrPhone;
        this.emailOrPhone_Data_local = emailOrPhone_Data;
        this.theDialog_local = theDialog;

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
        theDialog_local.dismiss();
        if (jsonData == null) {

            Toasty.error(c, "No internet connection!", Toast.LENGTH_SHORT, true).show();
        } else {
            if (jsonData.contains("1010-cyuma")) {
                //-------------
                NDS_boolax_db_adapter db = new NDS_boolax_db_adapter(c);
                db.openToWrite();
                DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
                String date = df.format(Calendar.getInstance().getTime());
                if (db.save_MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_locally("on", myRemoteId,
                        date)) {
                    //-------------------
                    Intent i = new Intent(c, Boolax_favorite_Boo_Booers.class);
                    c.startActivity(i);
                }

            } else {
                Toasty.error(c, "Code U entered is not valid, Resend code again!", Toast.LENGTH_SHORT, true).show();
            }


        }
    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = boolax_resend_connect.connect(theRemoteUrl, myRemoteId, emailOrPhone_local,
                emailOrPhone_Data_local);
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
