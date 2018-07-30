package com.ogeniuspriority.boolax.boolax.m_DataObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ogeniuspriority.boolax.boolax.Config;
import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_actual_lovers_send_txt_messages;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

/**
 * Created by USER on 2/6/2017.
 */
public class My_Community_Upload_image_special extends AsyncTask<Integer, Integer, String> {

    String selectedPath;
    String uploadedfile;
    String myRemoteId;
    String CaptionDescr;
    //------------
    String remoteIdOfReceipient;
    String msgType;
    ListView myMsgs;
    //-----------
    String theLocalId;

    //private Handler mHandler = new Handler();
    Context currCtx;
    int lastIndex_hj;


    public My_Community_Upload_image_special(Context currCtx, String selectedPath,
                                             String uploadedfile,
                                             String remoteIdOfReceipient, String myRemoteId, String CaptionDescr, String msgType, ListView myMsgs, String theLocalId, int lastIndex_hj) {

        this.selectedPath = selectedPath;
        this.uploadedfile = uploadedfile;
        this.myRemoteId = myRemoteId;
        this.CaptionDescr = CaptionDescr;
        //------------
        this.remoteIdOfReceipient = remoteIdOfReceipient;
        this.CaptionDescr = CaptionDescr;
        this.msgType = msgType;
        this.myMsgs = myMsgs;
        this.theLocalId = theLocalId;

        this.currCtx = currCtx;
        this.lastIndex_hj = lastIndex_hj;


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
    protected String doInBackground(Integer... voids) {
        Log.w("Tring", "YesOfC uuu backg in ");

        try {

            return this.doFileUpload_image();
        } catch (IOException e) {
            e.printStackTrace();
            Log.w("Tring", "YesOfC uuu backg " + e.toString());
            return null;
        }

    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);
        Log.w("Tring", "YesOfC uuu " + jsonData);

        if (jsonData == null) {
            //Toasty.error(currCtx, "Suggestion not received!", Toast.LENGTH_SHORT).show();
            //-----------Display on the
            NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(currCtx);
            thDb.openToWrite();
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
                        data_url, actual_message_, chats_archived, chat_remote_id, remoteIdOfReceipient);
                myMsgs.setAdapter(theMessages);
                myMsgs.setSelection(lastIndex_hj);
                //((Activity) currCtx).finish();

            }

        } else {
            if (jsonData.contains("1001")) {
                //Toasty.info(currCtx, "You have blocked this Person! Unblock them!", Toast.LENGTH_SHORT, true).show();

            } else if (jsonData.contains("1000")) {
                //Toasty.info(currCtx, "This Person has blocked you!", Toast.LENGTH_SHORT, true).show();

            } else if (jsonData.contains("1002")) {
                //-------Update the sqlite database--------
                NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(currCtx);
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
                    if (thDb.update_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_with_captions(theLocalId,
                            "1", remote_id___, regdate___, CaptionDescr)) {
                        //-------Retreive this local id---------------
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
                                    data_url, actual_message_, chats_archived, chat_remote_id, remoteIdOfReceipient);
                            myMsgs.setAdapter(theMessages);
                            myMsgs.setSelection(lastIndex_hj);
                            //((Activity) currCtx).finish();

                        }


                    }
                } catch (Exception ss) {

                }
                //Toasty.success(currCtx, "Your message is sent!", Toast.LENGTH_SHORT, true).show();
            } else if (jsonData.contains("1003")) {
                //Toasty.error(currCtx, "Your message is not sent!", Toast.LENGTH_SHORT, true).show();
            }


        }
    }


    private String doFileUpload_image() throws IOException {
        int serverResponseCode = 0;
        HttpURLConnection mHttpURLConnection = null;
        DataOutputStream mOutputStream = null;
        String strLineEnd = "\r\n";
        String strTwoHyphens = "--";
        String strUpLoadServerUri = selectedPath;
        String strBoundary = "*****";
        int bytesRead, bytesAvailable, bufferSize;
        byte[] buffer;
        int maxBufferSize = 30 * 1024 * 1024;
        String responseFromServer = "";
        String jsonString = "";
        String urlString = Config.BOOLAX_ACCOUNT_LOAD_THE_ACTUAL_LOVERS_CHATS_IMGS_MSGS_SEND;
        File sourceFile = new File(
                selectedPath);
        try {

            // open a URL connection to the Servlet
            FileInputStream fileInputStream = new FileInputStream(sourceFile);
            URL url = new URL(urlString);

            // Open a HTTP connection to the URL
            mHttpURLConnection = (HttpURLConnection) url
                    .openConnection();
            mHttpURLConnection.setDoInput(true); // Allow Inputs
            mHttpURLConnection.setDoOutput(true); // Allow Outputs
            mHttpURLConnection.setUseCaches(false); // Don't use a Cached Copy

            mHttpURLConnection.setRequestMethod("POST");
            mHttpURLConnection.setRequestProperty("Connection", "Keep-Alive");
            //mHttpURLConnection.setRequestProperty("ENCTYPE", "multipart/form-data");
            mHttpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=" + strBoundary);
            mHttpURLConnection.setRequestProperty("uploadedfile", uploadedfile);
            mHttpURLConnection.connect();
            HashMap<String, String> postDataParams = new HashMap<String, String>();
            postDataParams.put("myRemoteId", myRemoteId);
            postDataParams.put("CaptionDescr", CaptionDescr);
            postDataParams.put("remoteIdOfReceipient", remoteIdOfReceipient);
            postDataParams.put("msgType", msgType);
            postDataParams.put("theLocalId", theLocalId);


            mOutputStream = new DataOutputStream(mHttpURLConnection.getOutputStream());
            mOutputStream.writeBytes(strTwoHyphens + strBoundary + strLineEnd);
            // mOutputStream.writeBytes(getPostDataString(postDataParams));
            mOutputStream.writeBytes("Content-Disposition: form-data; name=\"uploadedfile\";filename=" + uploadedfile + "&" + getPostDataString(postDataParams) + strLineEnd);
            mOutputStream.writeBytes(strLineEnd);

            // create a buffer of maximum size
            bytesAvailable = fileInputStream.available();

            bufferSize = Math.min(bytesAvailable, maxBufferSize);
            buffer = new byte[bufferSize];

            // read file and write it into form...
            bytesRead = fileInputStream.read(buffer, 0, bufferSize);
            //----------
            while (bytesRead > 0) {
                mOutputStream.write(buffer, 0, bufferSize);
                bytesAvailable = fileInputStream.available();
                bufferSize = Math.min(bytesAvailable, maxBufferSize);
                bytesRead = fileInputStream.read(buffer, 0, bufferSize);
                //-------------------

            }

            // send multipart form data necesssary after file data...
            mOutputStream.writeBytes(strLineEnd);
            mOutputStream.writeBytes(strTwoHyphens + strBoundary + strTwoHyphens + strLineEnd);
            //---

            serverResponseCode = mHttpURLConnection.getResponseCode();
            // close the streams //
            // responseFromServer=
            fileInputStream.close();
            mOutputStream.flush();
            mOutputStream.close();
            //--
            InputStream in = mHttpURLConnection.getInputStream();

            byte data[] = new byte[1024];
            int counter = -1;
            jsonString = "";
            while ((counter = in.read(data)) != -1) {
                jsonString += new String(data, 0, counter);
            }
            responseFromServer = jsonString;


        } catch (MalformedURLException ex) {
            ex.printStackTrace();
            Log.w("Tring", "YesOfC " + ex.toString());

        } catch (Exception e) {
            e.printStackTrace();
            Log.w("Tring", "YesOfC " + e.toString());

        }

        if (serverResponseCode == 200) {


            return jsonString;

        } else {
            //Log.w("good", "Failure");
            return jsonString;
        }

    }

    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (first) {
                first = false;
                result.append("&");
            } else {
                result.append("&");
            }

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }

}
