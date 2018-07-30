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
public class Boolax_favorite_send_basic_account_info_connect {
    public static HttpURLConnection connect(String theRemoteUrl,String myRemoteId,String fname_local,
                                            String lname_local,
                                            String username_local,
                                            String birthday_local,
                                            String country_local,
                                            String province_local,String gender_local) {

        try {

            URL url = new URL(theRemoteUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            // Log.w("0000",""+Urubuga_Services.whichTypeOfData_Keys[Urubuga_Services.whichTypeOfData-1]);
            //--con properties-
            String data = "";
            data = URLEncoder.encode("myRemoteId", "UTF-8")
                    + "=" + URLEncoder.encode(myRemoteId, "UTF-8");
            data = data + "&" + URLEncoder.encode("fname_local", "UTF-8")
                    + "=" + URLEncoder.encode(fname_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("lname_local", "UTF-8")
                    + "=" + URLEncoder.encode(lname_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("username_local", "UTF-8")
                    + "=" + URLEncoder.encode(username_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("birthday_local", "UTF-8")
                    + "=" + URLEncoder.encode(birthday_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("country_local", "UTF-8")
                    + "=" + URLEncoder.encode(country_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("province_local", "UTF-8")
                    + "=" + URLEncoder.encode(province_local, "UTF-8");
            data = data + "&" + URLEncoder.encode("gender_local", "UTF-8")
                    + "=" + URLEncoder.encode(gender_local, "UTF-8");

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
