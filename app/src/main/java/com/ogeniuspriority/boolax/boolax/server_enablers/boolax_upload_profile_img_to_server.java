package com.ogeniuspriority.boolax.boolax.server_enablers;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.ogeniuspriority.boolax.boolax.Config;
import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_favorite_parse_user_creds_data_Profile_ini;

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

/**
 * Created by USER on 2/6/2017.
 */
public class boolax_upload_profile_img_to_server extends AsyncTask<Void, Void, String> {
    Context c;

    String selectedPath;
    String uploadedfile;
    String MyRemoteId;
    NDS_boolax_db_adapter db;
    ProgressDialog dialog;


    public boolax_upload_profile_img_to_server(Context c, String selectedPath,
                                               String uploadedfile,
                                               String MyRemoteId) {
        this.c = c;
        this.selectedPath = selectedPath;
        this.uploadedfile = uploadedfile;
        this.MyRemoteId = MyRemoteId;
        db = new NDS_boolax_db_adapter(c);
        db.openToWrite();
        //--------
        dialog = ProgressDialog.show(c, "",
                "Saving Profile Image. Please wait...", true);


    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);

    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.show();


    }

    @Override
    protected String doInBackground(Void... voids) {
        try {

            return this.doFileUpload_image();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);
        dialog.dismiss();

        if (jsonData == null) {

            Toast.makeText(c, "Network error!", Toast.LENGTH_SHORT).show();
        } else {
            //parse the json--
            new Boolax_favorite_parse_user_creds_data_Profile_ini(c, jsonData).execute();


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
        String urlString = Config.BOOLAX_FAVORITE_THE_USERS_AVATARS_UPLOAD_TO_REMOTE;
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
            postDataParams.put("myRemoteId", MyRemoteId);


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
            Log.w("good", ""+ex.toString());

        } catch (Exception e) {
            e.printStackTrace();
            Log.w("good", ""+e.toString());

        }

        if (serverResponseCode == 200) {
            Log.w("good", ""+jsonString);

            return jsonString;

        } else {
            Log.w("good", ""+jsonString);
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
