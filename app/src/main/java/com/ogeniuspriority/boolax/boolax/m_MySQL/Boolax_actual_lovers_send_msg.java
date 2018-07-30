package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.boolax_booers_chats_chatroom;
import com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_actual_lovers_send_txt_messages;
import com.vanniktech.emoji.EmojiEditText;

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
public class Boolax_actual_lovers_send_msg extends AsyncTask<Void, Void, String> {
    Context c;
    //----------------
    String myRemoteId;
    String me_id;
    String theRemoteUrl;
    String receiver_id;
    String messageType;
    String message_url;
    String streamOfAlready_saved_messages;
    String theActualMessage;
    static volatile String local_actual_msg_id;

    EmojiEditText comment_2017_send_data;
    ListView boolax_boos_list;

    public Boolax_actual_lovers_send_msg(Context c, String theRemoteUrl, String me_id, String receiver_id, String messageType, String message_url, String streamOfAlready_saved_messages, String theActualMessage, EmojiEditText comment_2017_send_data, ListView boolax_boos_list) {
        this.c = c;
        this.me_id = me_id;
        this.receiver_id = receiver_id;
        //---------------
        this.myRemoteId = myRemoteId;
        this.messageType = messageType;
        this.theRemoteUrl = theRemoteUrl;
        this.message_url = message_url;
        this.streamOfAlready_saved_messages = streamOfAlready_saved_messages;

        this.theActualMessage = theActualMessage;
        this.comment_2017_send_data = comment_2017_send_data;
        //---------
        this.boolax_boos_list = boolax_boos_list;

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        //---------Save to local Database--
        NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(c);
        thDb.openToWrite();
        try {
            DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
            String date = df.format(Calendar.getInstance().getTime());
            if (thDb.save_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_locally(theActualMessage,
                    "text", "0", "", receiver_id, me_id, "", "",
                    date, "")) {

                //-------Retreive this local id---------------
                Cursor allNotSentTxtMsgs = thDb.GET_CHAT_MESSAGES_ALL_NOT_SENT(receiver_id);
                if (allNotSentTxtMsgs.moveToFirst()) {
                    for (int i = 0; i < allNotSentTxtMsgs.getCount(); i++) {
                        local_actual_msg_id = allNotSentTxtMsgs.getString(0);


                    }

                }
                comment_2017_send_data.setText("");
                Log.w("saved_message", "saved okay!"+receiver_id+"--ddd "+local_actual_msg_id);

            }
        } catch (Exception ss) {

        }

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
            //-----------Display on the
            NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(c);
            thDb.openToWrite();
            //-------Retreive this local id---------------
            Cursor allSavedMessages = thDb.GET_CHAT_MESSAGES_ALL(receiver_id);
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
                ListAdapter theMessages=new custom_adapter_for_actual_lovers_send_txt_messages(c, chat_id, actual_message,
                        chat_type, chat_status,
                        regdate, chat_sender, chat_receiver, who_sent,
                        data_url, actual_message_, chats_archived, chat_remote_id,receiver_id);
                boolax_boos_list.setAdapter(theMessages);
                boolax_boos_list.setSelection(theMessages.getCount() - 1);

            }


            //-------------
        } else {
            if (jsonData.contains("1001")) {
                Toasty.info(c, "You have blocked this Person! Unblock them!", Toast.LENGTH_SHORT, true).show();

            } else if (jsonData.contains("1000")) {
                Toasty.info(c, "This Person has blocked you!", Toast.LENGTH_SHORT, true).show();

            } else if (jsonData.contains("1002")) {
                //-------Update the sqlite database--------
                NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(c);
                thDb.openToWrite();
                try {
                    //--------
                    String value = jsonData;
                    //The key argument here must match that used in the other activity
                    int i__ = 0;
                    String remote_id___ = "";
                    String regdate___ = "";
                    for (String retval : value.split("~")) {
                        System.out.println(retval);
                        switch (i__) {
                            case 0:

                                break;
                            case 1:
                                remote_id___ = retval;
                                break;
                            case 2:
                                regdate___ = retval;
                                break;
                        }
                        i__++;
                    }
                    if (thDb.update_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_(local_actual_msg_id,
                            "1", remote_id___, regdate___)) {
                        Log.w("saved_message", "saved okay finalized!"+local_actual_msg_id+"---"+remote_id___+"---"+regdate___);
                        //-------Retreive this local id---------------
                        //-------Retreive this local id---------------
                        Cursor allSavedMessages = thDb.GET_CHAT_MESSAGES_ALL(receiver_id);
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

                            ListAdapter theMessages=new custom_adapter_for_actual_lovers_send_txt_messages(c, chat_id, actual_message,
                                    chat_type, chat_status,
                                    regdate, chat_sender, chat_receiver, who_sent,
                                    data_url, actual_message_, chats_archived, chat_remote_id,receiver_id);
                            boolax_boos_list.setAdapter(theMessages);
                            boolax_boos_list.setSelection(theMessages.getCount() - 1);

                        }


                    }
                } catch (Exception ss) {

                }
                Toasty.success(c, "Your message is sent!", Toast.LENGTH_SHORT, true).show();
            } else if (jsonData.contains("1003")) {
                Toasty.error(c, "Your message is not sent!", Toast.LENGTH_SHORT, true).show();
            }


        }
    }

    private String downloadData() throws UnsupportedEncodingException {

        HttpURLConnection con = Boolax_actual_lovers_send_msg_connect.connect(theRemoteUrl, me_id, receiver_id, messageType, message_url, streamOfAlready_saved_messages, theActualMessage, local_actual_msg_id);
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
