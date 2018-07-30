package com.ogeniuspriority.boolax.boolax;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_favorite_send_add_features_info;
import com.ogeniuspriority.boolax.boolax.utilities.InputValidatorHelper;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import mehdi.sakout.fancybuttons.FancyButton;

public class boolax_additional_profile_features extends AppCompatActivity {
    static CircleImageView boolax_event_avatar;
    TextView boolax_username;
    static String remote_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolax_additional_profile_features);
        getSupportActionBar().hide();
        //-----------
        boolax_event_avatar = (CircleImageView) findViewById(R.id.boolax_event_avatar);
        boolax_username = (TextView) findViewById(R.id.boolax_username);
        //--------
        NDS_boolax_db_adapter thDb;
        thDb = new NDS_boolax_db_adapter(boolax_additional_profile_features.this);
        if (!new database_enablers(boolax_additional_profile_features.this).findIfUserCreated_stage2_account_complete()) {


        } else {
            thDb.openToWrite();

            Cursor allUsersSaved = thDb.GET_USER_DATA();
            String username = "";
            String avatar = "";
            if (allUsersSaved.moveToLast()) {
                for (int i = 0; i < allUsersSaved.getCount(); i++) {
                    avatar = allUsersSaved.getString(21);
                    remote_id = allUsersSaved.getString(22);
                    username = allUsersSaved.getString(5);

                }
                boolax_username.setText("Hello, " + username);
                Glide.with(boolax_additional_profile_features.this)
                        .load(Config.BOOLAX_FAVORITE_THE_USERS_AVATARS.toString() + avatar)
                        .apply(new RequestOptions().placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder))
                        .into(boolax_event_avatar);

            }
            if (new database_enablers(boolax_additional_profile_features.this).findIfUserCreated_stage_add_feat_finished()) {

                Intent i = new Intent(boolax_additional_profile_features.this, boolax_phone_email_verify.class);
                startActivity(i);
            } else {

            }

        }
        //--------Save the additional Data to the remote server----------
        final EditText profile_how_attractive_data = (EditText) findViewById(R.id.profile_how_attractive_data);
        final EditText profile_about_life_data = (EditText) findViewById(R.id.profile_about_life_data);
        final EditText profile_about_love_data = (EditText) findViewById(R.id.profile_about_love_data);
        final EditText profile_about_relationship_data = (EditText) findViewById(R.id.profile_about_relationship_data);
        final EditText profile_about_lover_criteria_data = (EditText) findViewById(R.id.profile_about_lover_criteria_data);
        final EditText profile_about_hobbies_data = (EditText) findViewById(R.id.profile_about_hobbies_data);
        final EditText profile_about_religious_affiliation_data = (EditText) findViewById(R.id.profile_about_religious_affiliation_data);
        final EditText profile_about_academics_and_work_data = (EditText) findViewById(R.id.profile_about_academics_and_work_data);
        //---------boolax_create_an_account
        FancyButton boolax_create_an_account = (FancyButton) findViewById(R.id.boolax_create_an_account);
        //---------------------
        boolax_create_an_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //--isNullOrEmpty--
                if (InputValidatorHelper.isNullOrEmpty(profile_how_attractive_data.getText().toString())) {
                    Toasty.error(boolax_additional_profile_features.this, "How attractive field is empty!?", Toast.LENGTH_SHORT, true).show();
                } else if (InputValidatorHelper.isNullOrEmpty(profile_about_life_data.getText().toString())) {
                    Toasty.error(boolax_additional_profile_features.this, "About life field is empty!?", Toast.LENGTH_SHORT, true).show();

                } else if (InputValidatorHelper.isNullOrEmpty(profile_about_love_data.getText().toString())) {
                    Toasty.error(boolax_additional_profile_features.this, "About love field is empty!?", Toast.LENGTH_SHORT, true).show();
                } else if (InputValidatorHelper.isNullOrEmpty(profile_about_relationship_data.getText().toString())) {
                    Toasty.error(boolax_additional_profile_features.this, "About relationships field is empty!?", Toast.LENGTH_SHORT, true).show();

                } else if (InputValidatorHelper.isNullOrEmpty(profile_about_lover_criteria_data.getText().toString())) {
                    Toasty.error(boolax_additional_profile_features.this, "About lover criteria field is empty!?", Toast.LENGTH_SHORT, true).show();

                } else if (InputValidatorHelper.isNullOrEmpty(profile_about_hobbies_data.getText().toString())) {
                    Toasty.error(boolax_additional_profile_features.this, "About hobbies field is empty!?", Toast.LENGTH_SHORT, true).show();

                } else if (InputValidatorHelper.isNullOrEmpty(profile_about_religious_affiliation_data.getText().toString())) {
                    Toasty.error(boolax_additional_profile_features.this, "About religious affiliation field is empty!?", Toast.LENGTH_SHORT, true).show();
                } else if (InputValidatorHelper.isNullOrEmpty(profile_about_academics_and_work_data.getText().toString())) {
                    Toasty.error(boolax_additional_profile_features.this, "About academics and work field is empty!?", Toast.LENGTH_SHORT, true).show();

                } else {

                    new Boolax_favorite_send_add_features_info(boolax_additional_profile_features.this, Config.BOOLAX_FAVORITE_SAVE_THE_PROFILE_ADD_FEATURE.toString(), remote_id,
                            profile_how_attractive_data.getText().toString(),
                            profile_about_life_data.getText().toString(),
                            profile_about_love_data.getText().toString(),
                            profile_about_relationship_data.getText().toString(),
                            profile_about_lover_criteria_data.getText().toString(),
                            profile_about_hobbies_data.getText().toString(), profile_about_religious_affiliation_data.getText().toString()
                            , profile_about_academics_and_work_data.getText().toString()).execute();


                    Toasty.success(boolax_additional_profile_features.this, "Saving...", Toast.LENGTH_LONG, true).show();

                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
