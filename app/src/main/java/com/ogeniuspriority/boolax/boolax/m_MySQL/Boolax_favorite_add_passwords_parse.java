package com.ogeniuspriority.boolax.boolax.m_MySQL;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.ogeniuspriority.boolax.boolax.NDS_boolax_db_adapter;
import com.ogeniuspriority.boolax.boolax.boolax_password_verify;
import com.ogeniuspriority.boolax.boolax.database_enablers;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import es.dmoral.toasty.Toasty;

/**
 * Created by USER on 2/6/2017.
 */
public class Boolax_favorite_add_passwords_parse extends AsyncTask<Void, Void, Boolean> {
    Context c;
    public String jsonData_local;
    public String[] remote_id;
    public String[] fname;
    public String[] lname;
    public String[] gender;
    public String[] email;
    public String[] username;
    public String[] regdate;
    public String[] user_phone;
    //----
    public String[] birthdate;
    public String[] country;
    public String[] province;
    public String[] district;
    public String[] how_attractive;
    public String[] about_life;
    //------
    public String[] about_love;
    public String[] love_relationship;
    public String[] lover_criteria;
    public String[] your_hobbies;
    public String[] religious_affiliation;
    public String[] academics_and_work;
    ///----
    public String[] boo_avatar_image;
    public String[] social_media_id;
    public String[] login_type;

    NDS_boolax_db_adapter db;

    public Boolax_favorite_add_passwords_parse(Context c, String jsonData) {
        this.c = c;
        this.jsonData_local = jsonData;
        this.db = new NDS_boolax_db_adapter(c);
        this.db.openToWrite();
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
            //span_count.setText(""+Boolax_favorite_booers_boos_remoteIds.length);
            if (new database_enablers(c).findIfUserCreated_stage2_account_complete()) {
                db.close();
                db.openToWrite();
                //-----

                if (db.update_MYDATABASE_NDS_TABLE_BOOLAX_USER_locally_add_Passwords(remote_id[0],
                        email[0],
                        user_phone[0])) {
                    Intent i = new Intent(c, boolax_password_verify.class);
                    c.getApplicationContext().startActivity(i);


                }

            } else {
                //-----Update the local database profile image
                Toasty.error(c, "Error occured?!", Toast.LENGTH_SHORT, true).show();
            }


        } else {
            Toasty.error(c, "Network problem?!", Toast.LENGTH_SHORT, true).show();
        }
    }

    private Boolean parseData() {
        try {
            //-------------------------------------------

            //------------

            JSONObject posts_JSON = new JSONObject(
                    jsonData_local);
            //------------------
            JSONArray boolax_users_creds_from_social_media = (JSONArray) posts_JSON
                    .get("boolax_data");
            //---All Fresh New Boos Data--To Load
            remote_id = new String[boolax_users_creds_from_social_media.length()];
            fname = new String[boolax_users_creds_from_social_media.length()];
            lname = new String[boolax_users_creds_from_social_media.length()];
            gender = new String[boolax_users_creds_from_social_media.length()];
            email = new String[boolax_users_creds_from_social_media.length()];
            username = new String[boolax_users_creds_from_social_media.length()];
            regdate = new String[boolax_users_creds_from_social_media.length()];
            //----
            birthdate = new String[boolax_users_creds_from_social_media.length()];
            country = new String[boolax_users_creds_from_social_media.length()];
            province = new String[boolax_users_creds_from_social_media.length()];
            district = new String[boolax_users_creds_from_social_media.length()];
            how_attractive = new String[boolax_users_creds_from_social_media.length()];
            about_life = new String[boolax_users_creds_from_social_media.length()];
            //------
            about_love = new String[boolax_users_creds_from_social_media.length()];
            love_relationship = new String[boolax_users_creds_from_social_media.length()];
            lover_criteria = new String[boolax_users_creds_from_social_media.length()];
            your_hobbies = new String[boolax_users_creds_from_social_media.length()];
            religious_affiliation = new String[boolax_users_creds_from_social_media.length()];
            academics_and_work = new String[boolax_users_creds_from_social_media.length()];
            ///----
            boo_avatar_image = new String[boolax_users_creds_from_social_media.length()];
            social_media_id = new String[boolax_users_creds_from_social_media.length()];
            login_type = new String[boolax_users_creds_from_social_media.length()];
            user_phone = new String[boolax_users_creds_from_social_media.length()];
            //---------
            for (int counter = 0; counter < boolax_users_creds_from_social_media.length(); counter++) {
                remote_id[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_id")
                        .toString();


                fname[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_firstname")
                        .toString();
                //----
                //--
                lname[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_lastname")
                        .toString();
                gender[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_gender");

                email[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_email")
                        .toString();
                username[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_username")
                        .toString();
                regdate[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_regdate")
                        .toString();
                //----------
                birthdate[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_birthdate")
                        .toString();
                country[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_country")
                        .toString();
                province[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_province")
                        .toString();
                district[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_district")
                        .toString();
                how_attractive[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_how_attractive")
                        .toString();
                about_life[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_about_life")
                        .toString();
                about_love[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_about_love")
                        .toString();
                love_relationship[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_love_relationship")
                        .toString();
                //------------
                lover_criteria[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_lover_criteria")
                        .toString();
                your_hobbies[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_your_hobbies")
                        .toString();
                religious_affiliation[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_religious_affiliation")
                        .toString();
                academics_and_work[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_academics_and_work")
                        .toString();
                boo_avatar_image[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_avatar_image")
                        .toString();
                //---------
                social_media_id[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_social_media_id")
                        .toString();
                login_type[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_login_type")
                        .toString();
                user_phone[counter] = boolax_users_creds_from_social_media
                        .getJSONObject(
                                counter)
                        .getString(
                                "boo_users_phone")
                        .toString();
                //------------Save This To


            }

            return true;


        } catch (JSONException e) {
            e.printStackTrace();
            Log.w("josn_", e.toString());
        }
        return false;
    }

}
