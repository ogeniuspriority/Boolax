package com.ogeniuspriority.boolax.boolax;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.libizo.CustomEditText;
import com.marcoscg.dialogsheet.DialogSheet;
import com.ogeniuspriority.boolax.boolax.m_MySQL.boolax_resend;
import com.ogeniuspriority.boolax.boolax.m_MySQL.boolax_resend_finalize_log;
import com.ogeniuspriority.boolax.boolax.utilities.InputValidatorHelper;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;
import mehdi.sakout.fancybuttons.FancyButton;

public class boolax_password_verify extends AppCompatActivity {
    String remote_id;
    CircleImageView boolax_event_avatar;
    TextView boolax_username;
    TextView boolax_phone;
    TextView boolax_email;
    String email;
    String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolax_password_verify);
        getSupportActionBar().hide();
        //------------------
        boolax_username = (TextView) findViewById(R.id.boolax_username);
        boolax_event_avatar = (CircleImageView) findViewById(R.id.boolax_event_avatar);

        boolax_phone = (TextView) findViewById(R.id.boolax_phone);
        boolax_email = (TextView) findViewById(R.id.boolax_email);

        //------------------
        NDS_boolax_db_adapter thDb;
        thDb = new NDS_boolax_db_adapter(boolax_password_verify.this);
        if (!new database_enablers(boolax_password_verify.this).findIfUserCreated_stage2_account_complete()) {


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
                    //--------
                    email = allUsersSaved.getString(4);
                    phone = allUsersSaved.getString(23);

                }
                //--
                boolax_phone.setText(phone);
                boolax_email.setText(email);
                boolax_username.setText("Hello, " + username);
                Glide.with(boolax_password_verify.this)
                        .load(Config.BOOLAX_FAVORITE_THE_USERS_AVATARS.toString() + avatar)
                        .apply(new RequestOptions().placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder))
                        .into(boolax_event_avatar);

            }
        }
        ///------------------
        FancyButton boolax_change_phone_nber = (FancyButton) findViewById(R.id.boolax_change_phone_nber);
        FancyButton boolax_change_email = (FancyButton) findViewById(R.id.boolax_change_email);
        //------------------------
        boolax_change_phone_nber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-------------------------
                View view = View.inflate(boolax_password_verify.this, R.layout.boolax_account_resend, null);
                LinearLayout pour_phone = (LinearLayout) view.findViewById(R.id.pour_phone);

                LinearLayout pour_email = (LinearLayout) view.findViewById(R.id.pour_email);
                pour_email.setVisibility(View.GONE);
                //-------------------------
                final DialogSheet theDialog = new DialogSheet(boolax_password_verify.this);
                theDialog.setTitle("Boolax account")
                        .setView(view)
                        .setCancelable(true)
                        .setBackgroundColor(Color.WHITE) // Your custom background color
                        .setButtonsColorRes(R.color.colorPrimary)  // Default color is accent
                        .show();
                FancyButton boolax_resend_code_button_phone = (FancyButton) view.findViewById(R.id.boolax_resend_code_button_phone);
                //------------
                final CustomEditText boolax_resend_code_phone = (CustomEditText) view.findViewById(R.id.boolax_resend_code_phone);
                boolax_resend_code_button_phone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!InputValidatorHelper.phoneIsValid(boolax_resend_code_phone.getText().toString())) {
                            Toasty.info(boolax_password_verify.this, "Invalid phone number must have country code!", Toast.LENGTH_SHORT, true).show();

                        } else {
                            Toasty.info(boolax_password_verify.this, "Attempting to save ...", Toast.LENGTH_LONG, true).show();

                            new boolax_resend(boolax_password_verify.this, Config.BOOLAX_CHANGE_NBER_OR_EMAIL_AND_RESEND.toString(), remote_id, "phone", boolax_resend_code_phone.getText().toString(), theDialog).execute();
                        }
                    }
                });
                //-----------

            }
        });
        //-----------
        boolax_change_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //-------------------------
                View view = View.inflate(boolax_password_verify.this, R.layout.boolax_account_resend, null);
                LinearLayout pour_phone = (LinearLayout) view.findViewById(R.id.pour_phone);
                LinearLayout pour_email = (LinearLayout) view.findViewById(R.id.pour_email);
                FancyButton Boolax_normal_login = (FancyButton) view.findViewById(R.id.Boolax_normal_login);
                //------------
                final CustomEditText boolax_resend_code_email = (CustomEditText) view.findViewById(R.id.boolax_resend_code_email);

                //-----------
                pour_phone.setVisibility(View.GONE);
                //-------------------------
                final DialogSheet theDialog = new DialogSheet(boolax_password_verify.this);
                theDialog.setTitle("Boolax account")
                        .setView(view)
                        .setCancelable(true)
                        .setBackgroundColor(Color.WHITE) // Your custom background color
                        .setButtonsColorRes(R.color.colorPrimary)  // Default color is accent
                        .show();
                Boolax_normal_login.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (!InputValidatorHelper.isValidEmail(boolax_resend_code_email.getText().toString())) {
                            Toasty.info(boolax_password_verify.this, "Email is invalid!", Toast.LENGTH_SHORT, true).show();

                        } else {
                            Toasty.info(boolax_password_verify.this, "Attempting to save ...", Toast.LENGTH_LONG, true).show();
                            new boolax_resend(boolax_password_verify.this, Config.BOOLAX_CHANGE_NBER_OR_EMAIL_AND_RESEND.toString(), remote_id, "email", boolax_resend_code_email.getText().toString(), theDialog).execute();
                        }
                    }
                });
            }
        });
        //-----------
        FancyButton boolax_verify_account_resend_code = (FancyButton) findViewById(R.id.boolax_verify_account_resend_code);
        FancyButton boolax_finalize = (FancyButton) findViewById(R.id.boolax_finalize);
        //-----------------
        final DialogSheet theDialog = new DialogSheet(boolax_password_verify.this);
        theDialog.setTitle("Boolax account")
                .setCancelable(true)
                .setBackgroundColor(Color.WHITE) // Your custom background color
                .setButtonsColorRes(R.color.colorPrimary); // Default color is accent

        boolax_verify_account_resend_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.info(boolax_password_verify.this, "Resending code ...", Toast.LENGTH_LONG, true).show();
                new boolax_resend(boolax_password_verify.this, Config.BOOLAX_ACCOUNT_RESEND_CODE.toString(), remote_id, email, phone, theDialog).execute();


            }
        });
        //--------------------------
        final EditText boolax_verification_code = (EditText) findViewById(R.id.boolax_verification_code);
        boolax_finalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toasty.info(boolax_password_verify.this, "Finalizing ...", Toast.LENGTH_LONG, true).show();
                new boolax_resend_finalize_log(boolax_password_verify.this, Config.BOOLAX_ACCOUNT_VERIFY.toString(), remote_id, boolax_verification_code.getText().toString(), phone, theDialog).execute();


            }
        });
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }
}
