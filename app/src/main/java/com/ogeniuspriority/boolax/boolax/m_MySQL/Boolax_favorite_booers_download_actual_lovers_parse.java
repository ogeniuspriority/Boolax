package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.m_DataObject.Boolax_favorite_booers_boos_objects;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by USER on 2/6/2017.
 */
public class Boolax_favorite_booers_download_actual_lovers_parse extends AsyncTask<Void, Void, Boolean> {
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


    public Boolax_favorite_booers_download_actual_lovers_parse(Context c, String jsonData) {
        this.c = c;
        this.jsonData = jsonData;
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
            if (My_favorite_boolax_boos.size() > 0) {
                // Toasty.success(c, "New Boos to consider!", Toast.LENGTH_SHORT, true).show();
            } else {
                //Toasty.info(c, "No new Boos", Toast.LENGTH_SHORT, true).show();
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
                //-----------------------save temp boos--
                NDS_boolax_db_adapter thDb = new NDS_boolax_db_adapter(c);
                thDb.openToWrite();
                //---------------------------
                String fname = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_firstname")
                        .toString();
                String lname = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_lastname")
                        .toString();
                String gender = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_gender")
                        .toString();
                String email = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_email")
                        .toString();
                String username = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_username")
                        .toString();
                String regdate = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_regdate")
                        .toString();
                String age = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_age")
                        .toString();
                String birthdate = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_birthdate")
                        .toString();
                String country = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_country")
                        .toString();
                String province = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_province")
                        .toString();
                String district = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_district")
                        .toString();
                String how_attractive = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_how_attractive")
                        .toString();
                String like_status = "none";
                String about_life = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_about_life")
                        .toString();
                String about_love = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_about_love")
                        .toString();
                String about_relationships = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_love_relationship")
                        .toString();
                String about_lover_criteria = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_lover_criteria")
                        .toString();
                String about_hobbies = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_your_hobbies")
                        .toString();
                String about_religious_affiliation = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_religious_affiliation")
                        .toString();
                String about_academics_and_work = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_academics_and_work")
                        .toString();
                String avatar_image = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_avatar_image")
                        .toString();
                String remote_id = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_id")
                        .toString();
                //----------------
                String interested_in = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_interested_in")
                        .toString();
                String your_weight = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_your_weight")
                        .toString();
                String your_height = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_your_height")
                        .toString();
                String skin_color = Boollax_favorite_booers_boos_loaded
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_your_skin_color")
                        .toString();

                //------
                try {
                    if (thDb.save_MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_locally(fname, lname,
                            gender, email, username, regdate, age,
                            birthdate, country, province, district,
                            how_attractive, about_life,
                            about_love, about_relationships, about_lover_criteria,
                            about_hobbies, about_religious_affiliation, about_academics_and_work,
                            avatar_image, remote_id,interested_in,your_weight,
                            your_height,skin_color

                            )) {
                        Log.w("saved_", "The actual lovers saved okay!");

                    }
                } catch (Exception ss) {
                    Log.w("saved_err", " "+ss.toString());
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
