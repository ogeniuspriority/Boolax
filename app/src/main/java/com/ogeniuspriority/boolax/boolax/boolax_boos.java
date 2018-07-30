package com.ogeniuspriority.boolax.boolax;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.marcoscg.dialogsheet.DialogSheet;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_favorite_booers_download_boos;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_favorite_like_this_boo_remote;
import com.ogeniuspriority.boolax.boolax.m_UI.My_Boolax_boxes_find_avatars;
import com.ogeniuspriority.boolax.boolax.m_UI.custom_adapter_for_boos;

import de.hdodenhof.circleimageview.CircleImageView;
import mehdi.sakout.fancybuttons.FancyButton;

/**
 * Created by USER on 1/4/2018.
 */

public class boolax_boos extends Fragment {

    public static ListView boolax_boos_list;
    public SwipeRefreshLayout pull_to_refresh;
    String username = "";
    String avatar = "";
    String remote_id_me = "";
    static volatile String temp_boos_ids = "";
    String gender = "";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.boolax_boos, container, false);
        boolax_boos_list = (ListView) v.findViewById(R.id.boolax_boos_list);
        pull_to_refresh = (SwipeRefreshLayout) v.findViewById(R.id.pull_to_refresh);
        //-------------------------
        //----the internal database here-------------
        //---------finding my credentials
        final NDS_boolax_db_adapter thDb;
        thDb = new NDS_boolax_db_adapter(getContext());
        thDb.openToWrite();

        Cursor allUsersSaved = thDb.GET_USER_DATA();

        if (allUsersSaved.moveToLast()) {
            for (int i = 0; i < allUsersSaved.getCount(); i++) {
                avatar = allUsersSaved.getString(21);
                remote_id_me = allUsersSaved.getString(22);
                username = allUsersSaved.getString(5);
                gender = allUsersSaved.getString(3);

            }

        }
        //--------Find all ids in temp boos table----------------------------------------

        Cursor all_temp_boos = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_ALL();
        if (all_temp_boos.moveToLast()) {
            for (int i = 0; i < all_temp_boos.getCount(); i++) {
                String curr_id = all_temp_boos.getString(21);

                if (temp_boos_ids.equalsIgnoreCase("")) {
                    temp_boos_ids = temp_boos_ids + "0~" + curr_id;

                } else {
                    temp_boos_ids = temp_boos_ids + "~" + curr_id;
                }
                all_temp_boos.moveToPrevious();

            }

        }
        //--------Find all ids in  booers table----------------------------------------
        Cursor all_booers = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_ALL();
        if (all_booers.moveToLast()) {
            for (int i = 0; i < all_booers.getCount(); i++) {
                String curr_id = all_booers.getString(20);
                if (temp_boos_ids.equalsIgnoreCase("")) {
                    temp_boos_ids = temp_boos_ids + curr_id;
                } else {
                    temp_boos_ids = temp_boos_ids + "~" + curr_id;
                }
                all_booers.moveToPrevious();
            }
        }
        //--------Find all ids in  boos table----------------------------------------
        Cursor all_boos = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_ACTUAL_LOVERS_ALL();
        if (all_boos.moveToLast()) {
            for (int i = 0; i < all_boos.getCount(); i++) {
                String curr_id = all_boos.getString(20);
                if (temp_boos_ids.equalsIgnoreCase("")) {
                    temp_boos_ids = temp_boos_ids + curr_id;

                } else {
                    temp_boos_ids = temp_boos_ids + "~" + curr_id;
                }
                all_boos.moveToPrevious();
            }
        }
        //----------
        Log.w("temp_boos_ids", temp_boos_ids);
        //-------------
        new Boolax_favorite_booers_download_boos(getActivity(), Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS, gender, remote_id_me, boolax_boos_list, pull_to_refresh, temp_boos_ids).execute();

        pull_to_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //------------
                Cursor allUsersSaved = thDb.GET_USER_DATA();

                if (allUsersSaved.moveToLast()) {
                    for (int i = 0; i < allUsersSaved.getCount(); i++) {
                        avatar = allUsersSaved.getString(21);
                        remote_id_me = allUsersSaved.getString(22);
                        username = allUsersSaved.getString(5);
                        gender = allUsersSaved.getString(3);

                    }

                }
                //--------Find all ids in temp boos table----------------------------------------
                Cursor all_temp_boos = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_ALL();
                if (all_temp_boos.moveToLast()) {
                    for (int i = 0; i < all_temp_boos.getCount(); i++) {
                        String curr_id = all_temp_boos.getString(21);

                        if (temp_boos_ids.equalsIgnoreCase("")) {
                            temp_boos_ids = temp_boos_ids + "0~" + curr_id;

                        } else {
                            temp_boos_ids = temp_boos_ids + "~" + curr_id;
                        }
                        all_temp_boos.moveToPrevious();

                    }

                }
                //--------Find all ids in  booers table----------------------------------------
                Cursor all_booers = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_ALL();
                if (all_booers.moveToLast()) {
                    for (int i = 0; i < all_booers.getCount(); i++) {
                        String curr_id = all_booers.getString(20);
                        if (temp_boos_ids.equalsIgnoreCase("")) {
                            temp_boos_ids = temp_boos_ids + curr_id;
                        } else {
                            temp_boos_ids = temp_boos_ids + "~" + curr_id;
                        }
                        all_booers.moveToPrevious();
                    }
                }
                //--------Find all ids in  boos table----------------------------------------
                Cursor all_boos = thDb.GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_ACTUAL_LOVERS_ALL();
                if (all_boos.moveToLast()) {
                    for (int i = 0; i < all_boos.getCount(); i++) {
                        String curr_id = all_boos.getString(20);
                        if (temp_boos_ids.equalsIgnoreCase("")) {
                            temp_boos_ids = temp_boos_ids + curr_id;

                        } else {
                            temp_boos_ids = temp_boos_ids + "~" + curr_id;
                        }
                        all_boos.moveToPrevious();
                    }
                }
                new Boolax_favorite_booers_download_boos(getActivity(), Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS, gender, remote_id_me, boolax_boos_list, pull_to_refresh, temp_boos_ids).execute();


            }
        });
        //-----------------Open the popup
        boolax_boos_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                //---------------------------------
                TextView boolax_boo_name = (TextView) view.findViewById(R.id.boolax_boo_name);
                TextView boolax_boo_age = (TextView) view.findViewById(R.id.boolax_boo_age);
                TextView boolax_boo_location_text = (TextView) view.findViewById(R.id.boolax_boo_location_text);
                TextView boo_add_stream = (TextView) view.findViewById(R.id.boo_add_stream);
                CircleImageView boolax_boo_avatar = (CircleImageView) view.findViewById(R.id.boolax_boo_avatar);
                //------------Java split function---
                String Str = boo_add_stream.getText().toString();
                int i = 0;

                String fname = "";
                String lname = "";
                String gender = "";
                String email = "";
                String username = "";
                String regdate = "";
                String age = "";
                String birthdate = "";
                String country = "";
                String province = "";
                String district = "";
                String how_attractive = "";
                String like_status = "";
                String about_life = "";
                String about_love = "";
                String about_relationships = "";
                String about_lover_criteria = "";
                String about_hobbies = "";
                String about_religious_affiliation = "";
                String about_academics_and_work = "";
                String avatar_image = "";
                String remote_id = "";
                String interested_in = "";
                String your_height = "";
                String your_weight = "";
                String your_skin_color = "";
                for (String retval : Str.split("~")) {
                    System.out.println(retval);
                    switch (i) {
                        case 0:
                            fname = retval;
                            break;
                        case 1:
                            lname = retval;
                            break;
                        case 2:
                            gender = retval;
                            break;
                        case 3:
                            email = retval;
                            break;
                        case 4:
                            username = retval;
                            break;
                        case 5:
                            regdate = retval;
                            break;
                        case 6:
                            age = retval;
                            break;
                        case 7:
                            birthdate = retval;
                            break;
                        case 8:
                            country = retval;
                            break;
                        case 9:
                            province = retval;
                            break;
                        case 10:
                            district = retval;
                            break;
                        case 11:
                            how_attractive = retval;
                            break;
                        case 12:
                            like_status = retval;
                            break;
                        case 13:
                            about_life = retval;
                            break;
                        case 14:
                            about_love = retval;
                            break;
                        case 15:
                            about_relationships = retval;
                            break;
                        case 16:
                            about_lover_criteria = retval;
                            break;
                        case 17:
                            about_hobbies = retval;
                            break;
                        case 18:
                            about_religious_affiliation = retval;
                            break;
                        case 19:
                            about_academics_and_work = retval;
                            break;
                        case 20:
                            avatar_image = retval;
                            break;
                        case 21:
                            remote_id = retval;
                            break;
                        case 22:
                            interested_in = retval;
                            break;
                        case 23:
                            your_height = retval;
                            break;
                        case 24:
                            remote_id = retval;
                            break;
                        case 25:
                            your_weight = retval;
                            break;
                        case 26:
                            your_skin_color = retval;
                            break;
                    }

                    i++;
                }
                //----------------------
                final DialogSheet MyBoos_popup = new DialogSheet(getContext())
                        .setCancelable(false).setView(R.layout.boo_favorite_booers_boos_pop_up);
                // Access dialog custom inflated view
                View inflatedView = MyBoos_popup.getInflatedView();
                //----------------Other Views----------------
                TextView boo_names = (TextView) inflatedView.findViewById(R.id.boo_names);
                boo_names.setText(fname + " " + lname + ", " + username);

                TextView boo_residence = (TextView) inflatedView.findViewById(R.id.boo_residence);
                boo_residence.setText(boolax_boo_location_text.getText().toString());

                TextView boo_interested_in_data = (TextView) inflatedView.findViewById(R.id.boo_interested_in_data);
                boo_interested_in_data.setText("" + interested_in);

                TextView boo_height_data = (TextView) inflatedView.findViewById(R.id.boo_height_data);
                boo_height_data.setText("" + your_height);

                TextView boo_weight_data = (TextView) inflatedView.findViewById(R.id.boo_weight_data);
                boo_weight_data.setText("" + your_weight);

                TextView boo_skin_color_data = (TextView) inflatedView.findViewById(R.id.boo_skin_color_data);
                boo_skin_color_data.setText("" + your_skin_color);

                TextView boo_religion_data = (TextView) inflatedView.findViewById(R.id.boo_religion_data);
                boo_religion_data.setText("" + about_religious_affiliation);

                TextView boo_profession_data = (TextView) inflatedView.findViewById(R.id.boo_profession_data);
                boo_profession_data.setText("" + about_academics_and_work);

                TextView boo_lover_criteriadata = (TextView) inflatedView.findViewById(R.id.boo_lover_criteriadata);
                boo_lover_criteriadata.setText("" + about_lover_criteria);

                TextView boo_about_relationships_data = (TextView) inflatedView.findViewById(R.id.boo_about_relationships_data);
                boo_about_relationships_data.setText("" + about_relationships);

                TextView boo_how_attractive_you_feel = (TextView) inflatedView.findViewById(R.id.boo_how_attractive_you_feel);
                boo_how_attractive_you_feel.setText("" + how_attractive);

                TextView boo_about_love = (TextView) inflatedView.findViewById(R.id.boo_about_love);
                boo_about_love.setText("" + about_love);

                TextView boo_about_hobbies = (TextView) inflatedView.findViewById(R.id.boo_about_hobbies);
                boo_about_hobbies.setText("" + about_hobbies);

                TextView boo_about_life = (TextView) inflatedView.findViewById(R.id.boo_about_life);
                boo_about_life.setText("" + about_life);

                ImageView boo_avatar = (ImageView) inflatedView.findViewById(R.id.boo_avatar);
                //boo_avatar.setImageMatrix(boolax_boo_avatar.getImageMatrix());
                //-------------------------------
                new My_Boolax_boxes_find_avatars(getContext(), Config.BOOLAX_FAVORITE_BOOERS_GET_BOOS_AVATARS_DATA_URL.toString(), remote_id, boo_avatar).execute();


                FancyButton boo_like = (FancyButton) inflatedView.findViewById(R.id.boo_like);
                //-----------


                final String finalRemote_id1 = remote_id;
                boo_like.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new Boolax_favorite_like_this_boo_remote(getContext(), Config.BOOLAX_ACCOUNT_LIKE_THIS_TEMP_BOO.toString(), remote_id_me, finalRemote_id1, view, MyBoos_popup,"1",pull_to_refresh).execute();

                    }
                });
                //-----------------------------------
                FancyButton pass_on = (FancyButton) inflatedView.findViewById(R.id.boo_pass_on);
                final String finalRemote_id = remote_id;
                pass_on.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        new Boolax_favorite_like_this_boo_remote(getContext(), Config.BOOLAX_ACCOUNT_LIKE_THIS_TEMP_BOO.toString(), remote_id_me, finalRemote_id, view, MyBoos_popup,"0",pull_to_refresh).execute();

                    }
                });
                MyBoos_popup.show();
                ((custom_adapter_for_boos) boolax_boos_list.getAdapter()).notifyDataSetChanged();
            }

        });
        //-----------------------
        return v;
    }
}
