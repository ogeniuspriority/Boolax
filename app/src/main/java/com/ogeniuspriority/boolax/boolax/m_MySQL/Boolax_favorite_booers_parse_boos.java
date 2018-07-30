package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.ogeniuspriority.boolax.boolax.m_DataObject.Boolax_favorite_booers_boos_objects;
import com.ogeniuspriority.boolax.boolax.m_UI.Boolax_favorite_booers_custom_adapter_for_boos;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import es.dmoral.toasty.Toasty;

/**
 * Created by USER on 2/6/2017.
 */
public class Boolax_favorite_booers_parse_boos extends AsyncTask<Void, Void, Boolean> {
    Context c;
    String jsonData;
     ArrayList<Boolax_favorite_booers_boos_objects> My_favorite_boolax_boos = new ArrayList<Boolax_favorite_booers_boos_objects>();

     String[] Boolax_favorite_booers_boos_remoteIds;
     String[] Boolax_favorite_booers_boos_PassonStatus;
     String[] Boolax_favorite_booers_boos_Avatar;
     String[] Boolax_favorite_booers_boos_Location_text;
     String[] Boolax_favorite_booers_boos_Username;
     String[] Boolax_favorite_booers_boos_WholeDatastream;
     String[] Boolax_favorite_booers_boos_Age;

    ListView boolax_boos_list;


    public Boolax_favorite_booers_parse_boos(Context c, String jsonData, ListView boolax_boos_list) {
        this.c = c;
        this.jsonData = jsonData;
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
            boolax_boos_list.setAdapter(new Boolax_favorite_booers_custom_adapter_for_boos(c, My_favorite_boolax_boos));
            //-----------
            if(My_favorite_boolax_boos.size()>0) {
                Toasty.success(c, "New Boos to consider!", Toast.LENGTH_SHORT, true).show();
            }else{
                Toasty.info(c, "No new Boos", Toast.LENGTH_SHORT, true).show();
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
            Boolax_favorite_booers_boos_remoteIds = new String[Boollax_favorite_booers_boos_loaded.length()];
            Boolax_favorite_booers_boos_PassonStatus = new String[Boollax_favorite_booers_boos_loaded.length()];
            Boolax_favorite_booers_boos_Avatar = new String[Boollax_favorite_booers_boos_loaded.length()];
            Boolax_favorite_booers_boos_Location_text = new String[Boollax_favorite_booers_boos_loaded.length()];
            Boolax_favorite_booers_boos_Username = new String[Boollax_favorite_booers_boos_loaded.length()];
            Boolax_favorite_booers_boos_WholeDatastream = new String[Boollax_favorite_booers_boos_loaded.length()];
            Boolax_favorite_booers_boos_Age = new String[Boollax_favorite_booers_boos_loaded.length()];
            //----
            for (int counter = 0; counter < Boollax_favorite_booers_boos_loaded.length(); counter++) {
                Boolax_favorite_booers_boos_remoteIds[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_id")
                        .toString();


                Boolax_favorite_booers_boos_PassonStatus[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "PassedOnBoos")
                        .toString();
                //----
                //--
                Boolax_favorite_booers_boos_Avatar[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_avatar_image")
                        .toString();
                Boolax_favorite_booers_boos_Location_text[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_country") + " " + Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_province") + " " + Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_district")
                        .toString();

                Boolax_favorite_booers_boos_Username[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_username")
                        .toString();
                Boolax_favorite_booers_boos_WholeDatastream[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter).toString();
                Boolax_favorite_booers_boos_Age[counter] = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_birthdate")
                        .toString();
                //----------
                Boolax_favorite_booers_boos_objects m = new Boolax_favorite_booers_boos_objects();
                m.set_Boolax_favorite_booers_boo_remoteId(Boolax_favorite_booers_boos_remoteIds[counter]);
                m.set_Boolax_favorite_booers_boo_passedOnStatus(Boolax_favorite_booers_boos_PassonStatus[counter]);
                m.set_Boolax_favorite_booers_boo_Avatar(Boolax_favorite_booers_boos_Avatar[counter]);
                m.set_Boolax_favorite_booers_boo_Location_Text(Boolax_favorite_booers_boos_Location_text[counter]);
                m.set_Boolax_favorite_booers_boo_username(Boolax_favorite_booers_boos_Username[counter]);
                m.set_Boolax_favorite_booers_boo_WholeDataStream(Boolax_favorite_booers_boos_WholeDatastream[counter]);
                m.set_Boolax_favorite_booers_boo_Age(Boolax_favorite_booers_boos_Age[counter]);
                //------------                //-
                My_favorite_boolax_boos.add(m);

            }

            return true;


        } catch (JSONException e) {
            e.printStackTrace();
            Log.w("josn_", e.toString());
        }
        return false;
    }
}
