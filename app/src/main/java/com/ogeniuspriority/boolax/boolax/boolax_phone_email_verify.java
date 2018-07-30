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
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_favorite_send_add_passwords;
import com.ogeniuspriority.boolax.boolax.utilities.InputValidatorHelper;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import mehdi.sakout.fancybuttons.FancyButton;

public class boolax_phone_email_verify extends AppCompatActivity {
    String remote_id;
    TextView boolax_username;
    CircleImageView boolax_event_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolax_phone_email_verify);
        getSupportActionBar().hide();
        //------------------
        boolax_username = (TextView) findViewById(R.id.boolax_username);
        boolax_event_avatar = (CircleImageView) findViewById(R.id.boolax_event_avatar);
        NDS_boolax_db_adapter thDb;
        thDb = new NDS_boolax_db_adapter(boolax_phone_email_verify.this);
        if (!new database_enablers(boolax_phone_email_verify.this).findIfUserCreated_stage2_account_complete()) {


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
                Glide.with(boolax_phone_email_verify.this)
                        .load(Config.BOOLAX_FAVORITE_THE_USERS_AVATARS.toString() + avatar)
                        .apply(new RequestOptions().placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder))
                        .into(boolax_event_avatar);

            }
        }
        //--------go to the final stage---
        try {
            if (new database_enablers(boolax_phone_email_verify.this).findIfUserCreated_stage_email_added()) {
                Intent i = new Intent(boolax_phone_email_verify.this, boolax_password_verify.class);
                startActivity(i);

            }
        } catch (Exception fk) {

        }
        //-----------
        final EditText boolax_user_phone = (EditText) findViewById(R.id.boolax_user_phone);
        final EditText boolax_user_email = (EditText) findViewById(R.id.boolax_user_email);
        final EditText boolax_password_1 = (EditText) findViewById(R.id.boolax_password_1);
        final EditText boolax_password_2 = (EditText) findViewById(R.id.boolax_password_2);
        //----------
        FancyButton boolax_create_an_account = (FancyButton) findViewById(R.id.boolax_create_an_account);
        boolax_create_an_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!InputValidatorHelper.phoneIsValid(boolax_user_phone.getText().toString())) {
                    Toasty.info(boolax_phone_email_verify.this, "Invalid phone number must have country code!", Toast.LENGTH_SHORT, true).show();

                } else if (!InputValidatorHelper.isValidEmail(boolax_user_email.getText().toString())) {
                    Toasty.info(boolax_phone_email_verify.this, "Email is invalid!", Toast.LENGTH_SHORT, true).show();

                } else if (boolax_password_1.getText().toString().length() < 5 || boolax_password_2.getText().toString().length() < 5) {
                    Toasty.info(boolax_phone_email_verify.this, "Password must be at leats 5 characters!", Toast.LENGTH_SHORT, true).show();

                } else if (InputValidatorHelper.nameIsvalid(boolax_password_1.getText().toString()) || InputValidatorHelper.nameIsvalid(boolax_password_2.getText().toString())) {
                    Toasty.info(boolax_phone_email_verify.this, "Password must start with a letter!", Toast.LENGTH_SHORT, true).show();

                } else if (!boolax_password_1.getText().toString().equals(boolax_password_2.getText().toString())) {
                    Toasty.info(boolax_phone_email_verify.this, "Passwords must be the same!", Toast.LENGTH_SHORT, true).show();

                } else {
                    Toasty.success(boolax_phone_email_verify.this, "Saving...", Toast.LENGTH_SHORT, true).show();
                    new Boolax_favorite_send_add_passwords(boolax_phone_email_verify.this, Config.BOOLAX_FAVORITE_SAVE_CREDS_ADD_PASSWORDS.toString(), remote_id, boolax_user_email.getText().toString(),
                            boolax_password_1.getText().toString(),
                            boolax_user_phone.getText().toString()
                    ).execute();


                }

            }
        });
    }


    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
