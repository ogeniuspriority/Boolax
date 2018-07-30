package com.ogeniuspriority.boolax.boolax.m_DataObject;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_actual_lovers_send_msg_connect;
import com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_actual_lovers_send_txt_messages;
import com.vanniktech.emoji.EmojiEditText;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

import es.dmoral.toasty.Toasty;

public class boolax_chats_get_all_this_meet_chats extends AsyncTask<Void, Void, String> {
    Context c;
    //----------------
    String theRemoteUrl;
    String me_id;
    String Them_id;
    String streamOfAlready_saved_messages;
    //---------------------
    ListView boolax_boos_list;

    public boolax_chats_get_all_this_meet_chats(Context c, String theRemoteUrl, String me_id, String Them_id, String streamOfAlready_saved_messages, ListView boolax_boos_list) {
        //---------
        this.c = c;
        this.theRemoteUrl = theRemoteUrl;
        this.me_id = me_id;
        this.Them_id = Them_id;
        this.streamOfAlready_saved_messages = streamOfAlready_saved_messages;
        //-------------
        this.boolax_boos_list = boolax_boos_list;

    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);
        if (jsonData == null) {

        } else {
            Log.w("chat_replies", streamOfAlready_saved_messages + "--" + jsonData);
            new boolax_chats_get_all_this_meet_chats_parse_for_save(c, jsonData,boolax_boos_list).execute();

        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Log.w("chat_replies",streamOfAlready_saved_messages);
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

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = boolax_chats_get_all_this_meet_chats_connect.connect(theRemoteUrl,
                me_id,
                Them_id,
                streamOfAlready_saved_messages);
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
