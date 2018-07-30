package com.ogeniuspriority.boolax.boolax;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.afollestad.materialcamera.MaterialCamera;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.marcoscg.dialogsheet.DialogSheet;
import com.ogeniuspriority.boolax.boolax.m_MySQL.Boolax_favorite_send_basic_account_info;
import com.ogeniuspriority.boolax.boolax.server_enablers.boolax_upload_profile_img_to_server;
import com.ogeniuspriority.boolax.boolax.utilities.Age;
import com.ogeniuspriority.boolax.boolax.utilities.AgeCalculator;
import com.ogeniuspriority.boolax.boolax.utilities.InputValidatorHelper;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import net.alhazmy13.mediapicker.Image.ImagePicker;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import de.hdodenhof.circleimageview.CircleImageView;
import es.dmoral.toasty.Toasty;

public class boolax_basic_profile extends AppCompatActivity {
    EditText Birthday;
    static Calendar myCalendar;
    Date date;
    public static CircleImageView boolax_event_avatar;
    private final static int CAMERA_RQ = 6969;
    public static String remote_id = "";
    static Spinner gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boolax_basic_profile);
        getSupportActionBar().hide();
        //---------------------
        ImageView back_finish = (ImageView) findViewById(R.id.back_finish);
        back_finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        gender = (Spinner) findViewById(R.id.gender);
        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, new String[]{"Male", "Female"});
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        gender.setAdapter(aa);
        //------------
        Birthday = (EditText) findViewById(R.id.Birthday);
        myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                //------
                int weee = monthOfYear + 1;
                Birthday.setText(year + "-" + weee + "-" + dayOfMonth);
                updateLabel();
            }

        };

        Birthday.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new DatePickerDialog(boolax_basic_profile.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        //--
        boolax_event_avatar = (CircleImageView) findViewById(R.id.boolax_event_avatar);
        boolax_event_avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (new database_enablers(boolax_basic_profile.this).findIfUserCreated()) {
                        new DialogSheet(boolax_basic_profile.this)
                                .setTitle("Boolax")
                                .setMessage("Profile Image")
                                .setCancelable(true)
                                .setPositiveButton("From Camera", new DialogSheet.OnPositiveClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        // Your action
                                        new MaterialCamera(boolax_basic_profile.this)
                                                /** all the previous methods can be called, but video ones would be ignored */
                                                .stillShot() // launches the Camera in stillshot mode
                                                .qualityProfile(MaterialCamera.QUALITY_1080P)
                                                .showPortraitWarning(true)
                                                .primaryColorAttr(R.attr.colorPrimary)
                                                .defaultToFrontFacing(true)
                                                .videoPreferredAspect(90f / 90f)
                                                .start(CAMERA_RQ);
                                    }
                                })
                                .setNegativeButton("From Gallery", new DialogSheet.OnNegativeClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        // Your action
                                /*
                                new ImagePicker.Builder(boolax_basic_profile.this)
                                        .mode(ImagePicker.Mode.GALLERY)
                                        .compressLevel(ImagePicker.ComperesLevel.MEDIUM)
                                        .directory(ImagePicker.Directory.DEFAULT)
                                        .extension(ImagePicker.Extension.PNG)
                                        .scale(600, 600)
                                        .allowMultipleImages(false)
                                        .enableDebuggingMode(true)
                                        .build();
                                        */
                                        CropImage.activity()
                                                .setGuidelines(CropImageView.Guidelines.ON)
                                                .start(boolax_basic_profile.this);
                                    }
                                })
                                .setBackgroundColor(Color.parseColor("#cdcdcd")) // Your custom background color
                                .setButtonsColorRes(R.color.colorPrimaryDark)  // Default color is accent
                                .show();
                    } else {
                        Toasty.info(boolax_basic_profile.this, "Profile Image Already Created! Finish to set up account", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception gg){

                }

            }
        });
        //--------------
        NDS_boolax_db_adapter thDb;
        thDb = new NDS_boolax_db_adapter(boolax_basic_profile.this);
        try {
            if (new database_enablers(boolax_basic_profile.this).findIfUserCreated()) {


            } else {
                thDb.openToWrite();

                Cursor allUsersSaved = thDb.GET_USER_DATA();
                if (allUsersSaved.moveToLast()) {
                    for (int i = 0; i < allUsersSaved.getCount(); i++) {
                        String avatar = allUsersSaved.getString(21);
                        remote_id = allUsersSaved.getString(22);
                        String username = allUsersSaved.getString(5);
                        if (username.equalsIgnoreCase("")) {
                            Glide.with(boolax_basic_profile.this)
                                    .load(Config.BOOLAX_FAVORITE_THE_USERS_AVATARS.toString() + avatar)
                                    .apply(new RequestOptions().placeholder(R.mipmap.placeholder).error(R.mipmap.placeholder))
                                    .into(boolax_basic_profile.boolax_event_avatar);

                        }


                    }

                }
                if (new database_enablers(boolax_basic_profile.this).findIfUserCreated_stage2_account_complete()) {
                    Intent i = new Intent(boolax_basic_profile.this, boolax_additional_profile_features.class);
                    startActivity(i);

                } else {

                }

            }
        } catch (Exception fgg) {

        }
        //-------start data save  and continue scripts

        //-------------------Validating tips on the fly---//-----------


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ImagePicker.IMAGE_PICKER_REQUEST_CODE && resultCode == RESULT_OK) {
            List<String> mPaths = (List<String>) data.getSerializableExtra(ImagePicker.EXTRA_IMAGE_PATH);
            //Your Code


// start cropping activity for pre-acquired image saved on the device
            CropImage.activity(data.getData())
                    .start(this);


        }
        if (requestCode == CAMERA_RQ) {

            if (resultCode == RESULT_OK) {
                //Toast.makeText(this, "Saved to: " + data.getDataString(), Toast.LENGTH_LONG).show();
                CropImage.activity(data.getData())
                        .start(this);
            } else if (data != null) {
                Exception e = (Exception) data.getSerializableExtra(MaterialCamera.ERROR_EXTRA);
                e.printStackTrace();
                //Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }
        }
        //--cropping codee
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                //-------------
                File myFile = new File(resultUri.getPath());
                String filename = myFile.getAbsolutePath().substring(myFile.getAbsolutePath().lastIndexOf("/") + 1);

                new boolax_upload_profile_img_to_server(boolax_basic_profile.this, resultUri.getPath(), resultUri.getPath(),
                        "").execute();

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
                Toasty.error(boolax_basic_profile.this, "--" + error.toString(), Toast.LENGTH_SHORT, true).show();

            }
        }
    }

    private void updateLabel() {
        DateFormat df = new SimpleDateFormat("Y-m-d");
        String date = df.format(Calendar.getInstance().getTime());
        //--------------
        String myFormat = "Y-m-d"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.CHINA);

        //Birthday.setText(df.format(myCalendar.getTime()));
    }

    public void account_create_continue(View v) {
        if (!new database_enablers(boolax_basic_profile.this).findIfUserCreated()) {

            final EditText boolax_fname = (EditText) findViewById(R.id.boolax_fname);
            final EditText boolax_lname = (EditText) findViewById(R.id.boolax_lname);
            final EditText boolax_username = (EditText) findViewById(R.id.boolax_username);
            //---gender
            final EditText Birthday = (EditText) findViewById(R.id.Birthday);
            final EditText boolax_country = (EditText) findViewById(R.id.boolax_country);
            final EditText boolax_province = (EditText) findViewById(R.id.boolax_province);
            //---------------
            if (InputValidatorHelper.isNullOrEmpty(boolax_fname.getText().toString())) {
                Toasty.info(boolax_basic_profile.this, "First Name Empty?!", Toast.LENGTH_SHORT).show();
            } else if (InputValidatorHelper.isNullOrEmpty(boolax_lname.getText().toString())) {
                Toasty.info(boolax_basic_profile.this, "Last Name Empty?!", Toast.LENGTH_SHORT).show();
            } else if (InputValidatorHelper.isNullOrEmpty(boolax_username.getText().toString())) {
                Toasty.info(boolax_basic_profile.this, "Username Empty?!", Toast.LENGTH_SHORT).show();
            } else if (InputValidatorHelper.isNullOrEmpty(boolax_country.getText().toString())) {
                Toasty.info(boolax_basic_profile.this, "Country Empty?!", Toast.LENGTH_SHORT).show();
            } else if (InputValidatorHelper.isNullOrEmpty(boolax_province.getText().toString())) {
                Toasty.info(boolax_basic_profile.this, "Province Empty?!", Toast.LENGTH_SHORT).show();
            } else {
                Age age = null;
                try {
                    age = AgeCalculator.main_age_calc_from_dob_v1(Birthday.getText().toString());
                    if (age.years < 100 && age.years > 18) {

                        new Boolax_favorite_send_basic_account_info(boolax_basic_profile.this, Config.BOOLAX_FAVORITE_SAVE_THE_BASIC_PROFILE_INFO.toString(), remote_id,
                                boolax_fname.getText().toString(),
                                boolax_lname.getText().toString(),
                                boolax_username.getText().toString(),
                                Birthday.getText().toString(),
                                boolax_country.getText().toString(),
                                boolax_province.getText().toString(), gender.getSelectedItem().toString()).execute();
                        Toasty.info(boolax_basic_profile.this, "Attempt Saving!....", Toast.LENGTH_LONG).show();
                    } else {
                        Toasty.info(boolax_basic_profile.this, "A valid birthday please!", Toast.LENGTH_SHORT).show();

                    }
                } catch (ParseException e) {

                    Toasty.info(boolax_basic_profile.this, "A valid birthday please!", Toast.LENGTH_SHORT).show();

                    e.printStackTrace();
                }

            }
        } else {
            Toasty.error(boolax_basic_profile.this, "Upload profile image first?!", Toast.LENGTH_SHORT).show();

        }

    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
