package com.ogeniuspriority.boolax.boolax.m_DataObject;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by USER on 2/6/2017.
 */
public class boolax_chats_get_all_this_meet_chats_connect {
    public static HttpURLConnection connect(String theRemoteUrl,
                                            String me_id,
                                            String Them_id,
                                            String streamOfAlready_saved_messages) {

        try {

            URL url = new URL(theRemoteUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // Log.w("0000",""+Urubuga_Services.whichTypeOfData_Keys[Urubuga_Services.whichTypeOfData-1]);
            //--con properties-
            String data = "";
            data = URLEncoder.encode("me_id", "UTF-8")
                    + "=" + URLEncoder.encode(me_id, "UTF-8");
            data = data + "&" + URLEncoder.encode("Them_id", "UTF-8")
                    + "=" + URLEncoder.encode(Them_id, "UTF-8");
            data = data + "&" + URLEncoder.encode("streamOfAlready_saved_messages", "UTF-8")
                    + "=" + URLEncoder.encode(streamOfAlready_saved_messages, "UTF-8");


            String lastResort = data;
            String urlParameters = lastResort;
            con.setRequestMethod("POST");
            con.setConnectTimeout(15000);
            con.setReadTimeout(15000);
            con.setDoInput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();


            return con;


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
