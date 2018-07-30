package com.ogeniuspriority.boolax.boolax.m_DataObject;

import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_actual_lovers_send_txt_messages;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class boolax_chats_msgs_download_audio extends AsyncTask<Integer, Integer, Boolean> {
    int downloadedSize;
    int totalSize;

    Context currCtx;
    String dwnload_file_path;
    String filename_audio;
    String remoteIdOfReceipient;
    String myRemoteId;
    String CaptionDescr;
    String msgType;
    ListView myMsgs;
    String theLocalId;
    String chats_remote_id;
    String regdate;
    //-------\
    int theIndex;

    public boolax_chats_msgs_download_audio(Context currCtx, String dwnload_file_path,
                                            String filename_audio,
                                            String remoteIdOfReceipient, String myRemoteId, String CaptionDescr, String msgType,
                                            ListView myMsgs, String theLocalId, String regdate
            , String chats_remote_id,int theIndex) {
        this.currCtx = currCtx;
        this.dwnload_file_path = dwnload_file_path;
        this.filename_audio = filename_audio;
        this.remoteIdOfReceipient = remoteIdOfReceipient;
        this.myRemoteId = myRemoteId;
        this.CaptionDescr = CaptionDescr;
        this.msgType = msgType;
        this.myMsgs = myMsgs;
        this.theLocalId = theLocalId;
        this.chats_remote_id = chats_remote_id;
        this.regdate = regdate;
        //-------
        this.theIndex=theIndex;

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.w("Tring", "YesOfC uuu ");

    }

    @Override
    protected void onPostExecute(Boolean jsonData) {

        if (jsonData) {


            //-------Update the sqlite database--------
            NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(currCtx);
            thDb.openToWrite();
            try {
                //--------

                if (thDb.update_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_with_captions_For_Remote(theLocalId,
                        "1", chats_remote_id, regdate, CaptionDescr)) {
                    //-------Retreive this local id---------------
                    Log.w("trying to downl","Downloaded successfully!");
                    Log.w("Trying", " Media Msgs! Medias download "+"--"+chats_remote_id);
                    //-------Retreive this local id---------------
                    Cursor allSavedMessages = thDb.GET_CHAT_MESSAGES_ALL(remoteIdOfReceipient);
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

                        ListAdapter theMessages = new custom_adapter_for_actual_lovers_send_txt_messages(currCtx, chat_id, actual_message,
                                chat_type, chat_status,
                                regdate, chat_sender, chat_receiver, who_sent,
                                data_url, actual_message_, chats_archived, chat_remote_id, myRemoteId);
                        myMsgs.setAdapter(theMessages);
                        myMsgs.setSelection(theIndex);


                    }


                }
            } catch (Exception ss) {

            }
        }

    }


    @Override
    protected Boolean doInBackground(Integer... integers) {

        Log.w("Tring", "YesOfC uuu backg in ");
        return this.downloadFileImages(dwnload_file_path, filename_audio);

    }

    private boolean downloadFileImages(String dwnload_file_path, String filename_audio) {

        try {
            URL url = new URL(dwnload_file_path);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);

            //connect
            urlConnection.connect();

            //set the path where we want to save the file
            File SDCardRoot = Environment.getExternalStorageDirectory();
            //create a new file, to save the downloaded file
            File directory = new File(SDCardRoot, "/boolax_audios/");

            if (!directory.exists()) {
                directory.mkdir();
            }

            File file = new File(directory, filename_audio);

            FileOutputStream fileOutput = new FileOutputStream(file);

            //Stream used for reading the data from the internet
            InputStream inputStream = urlConnection.getInputStream();

            //this is the total size of the file which we are downloading
            totalSize = urlConnection.getContentLength();


            //create a buffer...
            byte[] buffer = new byte[1024 * 20];
            int bufferLength = 0;

            while ((bufferLength = inputStream.read(buffer)) > 0) {
                fileOutput.write(buffer, 0, bufferLength);
                downloadedSize = bufferLength;
                // update the progressbar //

            }
            //close the output stream when complete //
            fileOutput.close();
            //-----


        } catch (final MalformedURLException e) {

            e.printStackTrace();
            return false;
        } catch (final IOException e) {

            e.printStackTrace();
            return false;
        } catch (final Exception e) {

            return false;
        }

        return true;
    }
}
