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
public class Boolax_request_user_creds_connect {
    public static HttpURLConnection connect(String theRemoteUrl_local, String names_local, String email_local, String userid_local, String login_type_local, String gender_local, String birthday_local, String photo_local, String login_api_local) {

        try {

            URL url = new URL(theRemoteUrl_local);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // Log.w("0000",""+Urubuga_Services.whichTypeOfData_Keys[Urubuga_Services.whichTypeOfData-1]);
            //--con properties-
            String data = "";
            data = URLEncoder.encode("names_local", "UTF-8")
                    + "=" + URLEncoder.encode(names_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("email_local", "UTF-8")
                    + "=" + URLEncoder.encode(email_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("userid_local", "UTF-8")
                    + "=" + URLEncoder.encode(userid_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("login_type_local", "UTF-8")
                    + "=" + URLEncoder.encode(login_type_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("gender_local", "UTF-8")
                    + "=" + URLEncoder.encode(gender_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("birthday_local", "UTF-8")
                    + "=" + URLEncoder.encode(birthday_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("photo_local", "UTF-8")
                    + "=" + URLEncoder.encode(photo_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("login_api_local", "UTF-8")
                    + "=" + URLEncoder.encode(login_api_local, "UTF-8");

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
