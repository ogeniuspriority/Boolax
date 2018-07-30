package com.ogeniuspriority.boolax.boolax.m_DataObject;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.boolax_booers_chats_chatroom;
import com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_actual_lovers_send_txt_messages;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by USER on 2/6/2017.
 */
public class boolax_chats_get_all_this_meet_chats_parse_for_save extends AsyncTask<Void, Void, Boolean> {
    Context c;
    String jsonData;
    ArrayList<Boolax_favorite_booers_boos_objects> My_favorite_boolax_boos = new ArrayList<Boolax_favorite_booers_boos_objects>();

    String[] Boolax_chat_message_id;
    String[] Boolax_chat_message_message;
    String[] Boolax_chat_message_type;
    String[] Boolax_chat_message_status;
    String[] Boolax_chat_message_regdate;
    String[] Boolax_chat_message_sender;
    String[] Boolax_chat_message_receiver;

    String[] Boolax_chat_message_;
    String[] Boolax_chat_message_local_id;
    //-------------
    ListView boolax_boos_list;
    //---------
    static volatile boolean savedSomething = false;


    public boolax_chats_get_all_this_meet_chats_parse_for_save(Context c, String jsonData, ListView boolax_boos_list) {
        this.c = c;
        this.jsonData = jsonData;
        //-----------
        this.boolax_boos_list = boolax_boos_list;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    @Override
    protected Boolean doInBackground(Void... voids) {

        return this.parseData();
    }

    @Override
    protected void onPostExecute(Boolean isParsed) {
        super.onPostExecute(isParsed);
        // swipe_view.setRefreshing(false);
        if (isParsed) {
            //-----------
            if (savedSomething) {
                savedSomething=false;
                NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(c);
                thDb.openToWrite();
                //-------Retreive this local id---------------
                Cursor allSavedMessages = thDb.GET_CHAT_MESSAGES_ALL(boolax_booers_chats_chatroom.remote_id);
                String[] chat_id = new String[allSavedMessages.getCount()], actual_message = new String[allSavedMessages.getCount()],
                        chat_type = new String[allSavedMessages.getCount()], chat_status = new String[allSavedMessages.getCount()],
                        regdate = new String[allSavedMessages.getCount()],
                        chat_sender = new String[allSavedMessages.getCount()],
                        chat_receiver = new String[allSavedMessages.getCount()],
                        who_sent = new String[allSavedMessages.getCount()],
                        data_url = new String[allSavedMessages.getCount()],
                        actual_message_ = new String[allSavedMessages.getCount()],
                        chats_archived = new String[allSavedMessages.getCount()],
                        chat_remote_id = new String[allSavedMessages.getCount()];

                if (allSavedMessages.moveToLast()) {
                    for (int i = 0; i < allSavedMessages.getCount(); i++) {
                        chat_id[i] = allSavedMessages.getString(0);
                        actual_message[i] = allSavedMessages.getString(1);
                        chat_type[i] = allSavedMessages.getString(2);
                        chat_status[i] = allSavedMessages.getString(3);
                        regdate[i] = allSavedMessages.getString(4);
                        chat_sender[i] = allSavedMessages.getString(5);
                        chat_receiver[i] = allSavedMessages.getString(6);
                        who_sent[i] = allSavedMessages.getString(7);
                        data_url[i] = allSavedMessages.getString(8);
                        actual_message_[i] = allSavedMessages.getString(9);
                        chats_archived[i] = allSavedMessages.getString(10);
                        chat_remote_id[i] = allSavedMessages.getString(11);


                        allSavedMessages.moveToPrevious();
                    }
                    ListAdapter theMessages = new custom_adapter_for_actual_lovers_send_txt_messages(c, chat_id, actual_message,
                            chat_type, chat_status,
                            regdate, chat_sender, chat_receiver, who_sent,
                            data_url, actual_message_, chats_archived, chat_remote_id, boolax_booers_chats_chatroom.remote_id);
                    boolax_boos_list.setAdapter(theMessages);
                    boolax_boos_list.setSelection(theMessages.getCount() - 1);

                }
            }


        } else {


        }
    }

    private Boolean parseData() {
        try {
            //-------------------------------------------

            //------------
            JSONObject posts_JSON = new JSONObject(
                    jsonData);
            //------------------
            JSONArray Boollax_favorite_booers_boos_loaded = (JSONArray) posts_JSON
                    .get("My Gorgeous loaded Boos");
            //---All Fresh New Boos Data--To Load
            String[] Boolax_chat_message_id = new String[Boollax_favorite_booers_boos_loaded.length()];
            String[] Boolax_chat_message_message = new String[Boollax_favorite_booers_boos_loaded.length()];
            String[] Boolax_chat_message_type = new String[Boollax_favorite_booers_boos_loaded.length()];
            String[] Boolax_chat_message_status = new String[Boollax_favorite_booers_boos_loaded.length()];
            String[] Boolax_chat_message_regdate = new String[Boollax_favorite_booers_boos_loaded.length()];
            String[] Boolax_chat_message_sender = new String[Boollax_favorite_booers_boos_loaded.length()];
            String[] Boolax_chat_message_receiver = new String[Boollax_favorite_booers_boos_loaded.length()];

            String[] Boolax_chat_message_ = new String[Boollax_favorite_booers_boos_loaded.length()];
            String[] Boolax_chat_message_local_id = new String[Boollax_favorite_booers_boos_loaded.length()];

            //----
            for (int counter = 0; counter < Boollax_favorite_booers_boos_loaded.length(); counter++) {
                Boolax_chat_message_id[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_chat_message_id")
                        .toString();


                Boolax_chat_message_message[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_chat_message_message")
                        .toString();
                //----
                //--
                Boolax_chat_message_type[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_chat_message_type")
                        .toString();
                Boolax_chat_message_status[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_chat_message_status");

                Boolax_chat_message_regdate[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_chat_message_regdate")
                        .toString();
                Boolax_chat_message_sender[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_chat_message_sender")
                        .toString();
                Boolax_chat_message_receiver[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_chat_message_receiver")
                        .toString();
                Boolax_chat_message_[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_chat_message_data_url")
                        .toString();
                Boolax_chat_message_local_id[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_chat_message_local_id")
                        .toString();
                //----------

                //-----------------------save temp boos--
                NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(c);
                thDb.openToWrite();
                //---------------------------


                //------
                try {
                    if (thDb.save_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_locally(
                            Boolax_chat_message_message[counter], Boolax_chat_message_type[counter],
                            (!Boolax_chat_message_type[counter].equalsIgnoreCase("text")) ? "0" : Boolax_chat_message_status[counter], Boolax_chat_message_regdate[counter], Boolax_chat_message_receiver[counter]
                            , Boolax_chat_message_sender[counter], "", Boolax_chat_message_[counter]
                            , Boolax_chat_message_id[counter], ""
                    )) {
                        Log.w("saved_c_msgs", "The remote msgs saved okay! ");
                        savedSomething = true;

                    }
                } catch (Exception ss) {
                    Log.w("saved_err", " " + "--" + Boolax_chat_message_id[counter] + "--" + ss.toString());
                }

            }

            return true;


        } catch (JSONException e) {
            e.printStackTrace();
            Log.w("josn_", e.toString());
        }
        return false;
    }
}
