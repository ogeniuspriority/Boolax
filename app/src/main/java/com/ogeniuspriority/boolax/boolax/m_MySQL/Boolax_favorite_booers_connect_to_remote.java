package com.ogeniuspriority.boolax.boolax.m_MySQL;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by USER on 2/6/2017.
 */
public class Boolax_favorite_booers_connect_to_remote {
    public static HttpURLConnection connect(String magicUrl, String myRemoteId, String UserGender,String streamOfMyAcknowledgesBoos) {

        try {

            URL url = new URL(magicUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // Log.w("0000",""+Urubuga_Services.whichTypeOfData_Keys[Urubuga_Services.whichTypeOfData-1]);
            //--con properties-
            String data = "";
            data = URLEncoder.encode("streamOfMyAcknowledgesBoos", "UTF-8")
                    + "=" + URLEncoder.encode(streamOfMyAcknowledgesBoos, "UTF-8");
            data = data +"&"+ URLEncoder.encode("myRemoteId", "UTF-8")
                    + "=" + URLEncoder.encode(myRemoteId, "UTF-8");
            data = data +"&"+ URLEncoder.encode("UserGender", "UTF-8")
                    + "=" + URLEncoder.encode(UserGender, "UTF-8");

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
