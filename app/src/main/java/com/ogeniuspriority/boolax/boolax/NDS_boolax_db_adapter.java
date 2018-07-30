package com.ogeniuspriority.boolax.boolax;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by USER on 9/10/2016.
 */

public class NDS_boolax_db_adapter {

    public static final String MYDATABASE_NDS_NAME = "Boolax_internal_archive_2017.db";
    //----USER CRED TABLE
    public static final int MYDATABASE_VERSION = 1;
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER = "Boolax_internal_archive_2017_user";
    //------------BOOLAX_USER TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_ID = "Boolax_internal_archive_2017_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_FNAME = "Boolax_internal_archive_2017_user_fname";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_LNAME = "Boolax_internal_archive_2017_user_lname";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_GENDER = "Boolax_internal_archive_2017_user_gender";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_EMAIL = "Boolax_internal_archive_2017_user_email";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_PHONE = "Boolax_internal_archive_2017_user_phone";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_USERNAME = "Boolax_internal_archive_2017_user_username";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_REGDATE = "Boolax_internal_archive_2017_user_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_AGE = "Boolax_internal_archive_2017_user_age";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_BIRTHDATE = "Boolax_internal_archive_2017_user_birthdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_COUNTRY = "Boolax_internal_archive_2017_user_country";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_PROVINCE = "Boolax_internal_archive_2017_user_province";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_DISTRICT = "Boolax_internal_archive_2017_user_district";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_BOOLAX_HOW_ATTRACTIVE = "Boolax_internal_archive_2017_user_how_attractive";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_LOGIN_TYPE = "Boolax_internal_archive_2017_user_login_type";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LIFE = "Boolax_internal_archive_2017_user_about_life";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVE = "Boolax_internal_archive_2017_user_about_love";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_RELATIONSHIPS = "Boolax_internal_archive_2017_user_about_relationships";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVER_CRITERIA = "Boolax_internal_archive_2017_user_about_lover_criteria";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_HOBBIES = "Boolax_internal_archive_2017_user_about_hobbies";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_RELIGIOUS_AFFILIATION = "Boolax_internal_archive_2017_user_religious_affiliation";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_ACADEMICS_AND_WORKS = "Boolax_internal_archive_2017_user_academics_and_work";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_AVATAR_IMAGE = "Boolax_internal_archive_2017_user_avatar_image";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_REMOTE_ID = "Boolax_internal_archive_2017_user_remote_id";

    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_INTERESTED_IN = "Boolax_internal_archive_2017_user_interested_in";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_YOUR_WEIGHT = "Boolax_internal_archive_2017_user_your_weight";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_YOUR_HEIGHT = "Boolax_internal_archive_2017_user_your_height";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_SKIN_COLOR = "Boolax_internal_archive_2017_user_your_skin_color";

    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_BOOLAX_USER_TABLE =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_USER + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_FNAME + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_LNAME + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_GENDER + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_EMAIL + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_USERNAME + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_REGDATE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_AGE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_BIRTHDATE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_COUNTRY + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_PROVINCE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_DISTRICT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_BOOLAX_HOW_ATTRACTIVE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_LOGIN_TYPE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LIFE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_RELATIONSHIPS + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVER_CRITERIA + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_HOBBIES + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_RELIGIOUS_AFFILIATION + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_ACADEMICS_AND_WORKS + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_PHONE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_AVATAR_IMAGE + " text ,"

                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_INTERESTED_IN + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_YOUR_WEIGHT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_YOUR_HEIGHT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_SKIN_COLOR + " text ,"

                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_REMOTE_ID + " text  );";
    //--------------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS = "Boolax_internal_archive_2017_temporary_boos";
    //------------BOOLAX_TEMPORARY BOOS TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ID = "Boolax_internal_archive_2017_temporary_boos_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_FNAME = "Boolax_internal_archive_2017_temporary_boos_user_fname";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_LNAME = "Boolax_internal_archive_2017_temporary_boos_user_lname";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_GENDER = "Boolax_internal_archive_2017_temporary_boos_user_gender";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_EMAIL = "Boolax_internal_archive_2017_temporary_boos_user_email";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_USERNAME = "Boolax_internal_archive_2017_temporary_boos_user_username";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REGDATE = "Boolax_internal_archive_2017_temporary_boos_user_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_AGE = "Boolax_internal_archive_2017_temporary_boos_user_age";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_BIRTHDATE = "Boolax_internal_archive_2017_temporary_boos_user_birthdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_COUNTRY = "Boolax_internal_archive_2017_temporary_boos_user_country";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_PROVINCE = "Boolax_internal_archive_2017_temporary_boos_user_province";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_DISTRICT = "Boolax_internal_archive_2017_temporary_boos_user_district";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_HOW_ATTRACTIVE = "Boolax_internal_archive_2017_temporary_boos_user_how_attractive";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_LIFE = "Boolax_internal_archive_2017_temporary_boos_user_about_life";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_LOVE = "Boolax_internal_archive_2017_temporary_boos_user_about_love";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_RELATIONSHIPS = "Boolax_internal_archive_2017_temporary_boos_user_about_relationships";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_ABOUT_LOVER_CRITERIA = "Boolax_internal_archive_2017_temporary_boos_user_about_lover_criteria";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_HOBBIES = "Boolax_internal_archive_2017_temporary_boos_user_about_hobbies";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_RELIGIOUS_AFFILIATION = "Boolax_internal_archive_2017_temporary_boos_user_religious_affiliation";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ACADEMICS_AND_WORKS = "Boolax_internal_archive_2017_temporary_boos_user_academics_and_work";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_AVATAR_IMAGE = "Boolax_internal_archive_2017_temporary_boos_user_avatar_image";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REMOTE_ID = "Boolax_internal_archive_2017_temporary_boos_user_remote_id";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_LIKE_STATUS = "Boolax_internal_archive_2017_temporary_boos_user_like_status";

    static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_INTERESTED_IN = "Boolax_internal_archive_2017_temporary_boos_user_interested_in";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_YOUR_WEIGHT = "Boolax_internal_archive_2017_temporary_boos_user_your_weight";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_YOUR_HEIGHT = "Boolax_internal_archive_2017_temporary_boos_user_your_height";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_SKIN_COLOR = "Boolax_internal_archive_2017_temporary_boos_user_your_skin_color";


    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_FNAME + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_LNAME + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_GENDER + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_EMAIL + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_USERNAME + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REGDATE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_AGE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_BIRTHDATE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_COUNTRY + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_PROVINCE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_DISTRICT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_HOW_ATTRACTIVE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_LIFE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_LOVE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_RELATIONSHIPS + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_ABOUT_LOVER_CRITERIA + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_HOBBIES + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_RELIGIOUS_AFFILIATION + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ACADEMICS_AND_WORKS + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_AVATAR_IMAGE + " text ,"

                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_INTERESTED_IN + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_YOUR_WEIGHT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_YOUR_HEIGHT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_SKIN_COLOR + " text ,"


                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REMOTE_ID + " text unique ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_LIKE_STATUS + " text );";
    //--------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS = "Boolax_internal_archive_2017_booers";
    //------------BOOLAX BOOERS TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ID = "Boolax_internal_archive_2017_booers_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_FNAME = "Boolax_internal_archive_2017_booers_user_fname";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_LNAME = "Boolax_internal_archive_2017_booers_user_lname";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_GENDER = "Boolax_internal_archive_2017_booers_user_gender";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_EMAIL = "Boolax_internal_archive_2017_booers_user_email";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_USERNAME = "Boolax_internal_archive_2017_booers_user_username";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REGDATE = "Boolax_internal_archive_2017_booers_user_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_AGE = "Boolax_internal_archive_2017_booers_user_age";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_BIRTHDATE = "Boolax_internal_archive_2017_booers_user_birthdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_COUNTRY = "Boolax_internal_archive_2017_booers_user_country";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_PROVINCE = "Boolax_internal_archive_2017_booers_user_province";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_DISTRICT = "Boolax_internal_archive_2017_booers_user_district";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_HOW_ATTRACTIVE = "Boolax_internal_archive_2017_booers_user_how_attractive";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_LIFE = "Boolax_internal_archive_2017_booers_user_about_life";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_LOVE = "Boolax_internal_archive_2017_booers_user_about_love";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_RELATIONSHIPS = "Boolax_internal_archive_2017_booers_user_about_relationships";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_ABOUT_LOVER_CRITERIA = "Boolax_internal_archive_2017_booers_user_about_lover_criteria";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_HOBBIES = "Boolax_internal_archive_2017_booers_user_about_hobbies";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_RELIGIOUS_AFFILIATION = "Boolax_internal_archive_2017_booers_user_religious_affiliation";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ACADEMICS_AND_WORKS = "Boolax_internal_archive_2017_booers_user_academics_and_work";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_AVATAR_IMAGE = "Boolax_internal_archive_2017_booers_user_avatar_image";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REMOTE_ID = "Boolax_internal_archive_2017_booers_user_remote_id";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_LIKE_BACK_STATUS = "Boolax_internal_archive_2017_booers_like_back_status";

    static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_INTERESTED_IN = "Boolax_internal_archive_2017_booers_user_interested_in";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_YOUR_WEIGHT = "Boolax_internal_archive_2017_booers_user_your_weight";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_YOUR_HEIGHT = "Boolax_internal_archive_2017_booers_user_your_height";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_SKIN_COLOR = "Boolax_internal_archive_2017_booers_user_your_skin_color";


    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_BOOERS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_FNAME + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_LNAME + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_GENDER + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_EMAIL + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_USERNAME + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REGDATE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_AGE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_BIRTHDATE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_COUNTRY + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_PROVINCE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_DISTRICT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_HOW_ATTRACTIVE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_LIFE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_LOVE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_RELATIONSHIPS + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_ABOUT_LOVER_CRITERIA + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_HOBBIES + " text ,"

                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_INTERESTED_IN + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_YOUR_WEIGHT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_YOUR_HEIGHT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_SKIN_COLOR + " text ,"

                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_RELIGIOUS_AFFILIATION + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ACADEMICS_AND_WORKS + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_AVATAR_IMAGE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REMOTE_ID + " text unique ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_LIKE_BACK_STATUS + " text );";
    //--------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS = "Boolax_internal_archive_2017_actual_lovers";
    //------------BOOLAX ACTUAL LOVERS TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ID = "Boolax_internal_archive_2017_actual_lovers_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_FNAME = "Boolax_internal_archive_2017_actual_lovers_user_fname";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_LNAME = "Boolax_internal_archive_2017_actual_lovers_user_lname";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_GENDER = "Boolax_internal_archive_2017_actual_lovers_user_gender";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_EMAIL = "Boolax_internal_archive_2017_actual_lovers_user_email";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_USERNAME = "Boolax_internal_archive_2017_actual_lovers_user_username";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_REGDATE = "Boolax_internal_archive_2017_actual_lovers_user_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_AGE = "Boolax_internal_archive_2017_actual_lovers_user_age";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_BIRTHDATE = "Boolax_internal_archive_2017_actual_lovers_user_birthdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_COUNTRY = "Boolax_internal_archive_2017_actual_lovers_user_country";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_PROVINCE = "Boolax_internal_archive_2017_actual_lovers_user_province";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_DISTRICT = "Boolax_internal_archive_2017_actual_lovers_user_district";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_HOW_ATTRACTIVE = "Boolax_internal_archive_2017_actual_lovers_user_how_attractive";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_LIFE = "Boolax_internal_archive_2017_actual_lovers_user_about_life";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_LOVE = "Boolax_internal_archive_2017_actual_lovers_user_about_love";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_RELATIONSHIPS = "Boolax_internal_archive_2017_actual_lovers_user_about_relationships";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_ABOUT_LOVER_CRITERIA = "Boolax_internal_archive_2017_actual_lovers_user_about_lover_criteria";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_HOBBIES = "Boolax_internal_archive_2017_actual_lovers_user_about_hobbies";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_RELIGIOUS_AFFILIATION = "Boolax_internal_archive_2017_actual_lovers_user_religious_affiliation";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ACADEMICS_AND_WORKS = "Boolax_internal_archive_2017_actual_lovers_user_academics_and_work";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_AVATAR_IMAGE = "Boolax_internal_archive_2017_actual_lovers_user_avatar_image";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_REMOTE_ID = "Boolax_internal_archive_2017_actual_lovers_user_remote_id";

    static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_INTERESTED_IN = "Boolax_internal_archive_2017_actual_lovers_user_interested_in";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_YOUR_WEIGHT = "Boolax_internal_archive_2017_actual_lovers_user_your_weight";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_YOUR_HEIGHT = "Boolax_internal_archive_2017_actual_lovers_user_your_height";
    static final String MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_SKIN_COLOR = "Boolax_internal_archive_2017_actual_lovers_user_your_skin_color";


    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_FNAME + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_LNAME + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_GENDER + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_EMAIL + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_USERNAME + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_REGDATE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_AGE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_BIRTHDATE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_COUNTRY + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_PROVINCE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_DISTRICT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_HOW_ATTRACTIVE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_LIFE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_LOVE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_RELATIONSHIPS + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_ABOUT_LOVER_CRITERIA + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_HOBBIES + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_RELIGIOUS_AFFILIATION + " text ,"

                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_INTERESTED_IN + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_YOUR_WEIGHT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_YOUR_HEIGHT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_SKIN_COLOR + " text ,"

                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ACADEMICS_AND_WORKS + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_AVATAR_IMAGE + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_REMOTE_ID + " text unique );";
    //--------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES = "Boolax_internal_archive_2017_user_tags_group_invites";
    //------------BOOLAX GROUP INVITES TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_ID = "Boolax_internal_archive_2017_user_tags_group_invites_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_REGDATE = "Boolax_internal_archive_2017_user_tags_group_invites_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_SUMMARY_TEXT = "Boolax_internal_archive_2017_user_tags_group_invites_summary_text";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_VALID_URL = "Boolax_internal_archive_2017_user_tags_group_invites_valid_url";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_ENCRYPTION_KEY = "Boolax_internal_archive_2017_user_tags_group_invites_encryption_key";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_WHICH_CIPHER = "Boolax_internal_archive_2017_user_tags_group_invites_which_cipher";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_REMOTE_ID = "Boolax_internal_archive_2017_user_tags_group_invites_remote_id";

    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_SUMMARY_TEXT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_ENCRYPTION_KEY + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_WHICH_CIPHER + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_REMOTE_ID + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_VALID_URL + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS = "Boolax_internal_archive_2017_quick_boo_contenders";
    //------------BOOLAX QUICK BOO CONTENDERS TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_ID = "Boolax_internal_archive_2017_quick_boo_contenders_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_REGDATE = "Boolax_internal_archive_2017_quick_boo_contenders_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_USER_ID = "Boolax_internal_archive_2017_quick_boo_contenders_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_MOTIVATIONAL_TEXT = "Boolax_internal_archive_2017_quick_boo_contenders_motivational_text";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_ACCEPTANCE = "Boolax_internal_archive_2017_quick_boo_contenders_acceptance";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_REMOTE_ID = "Boolax_internal_archive_2017_quick_boo_contenders_remote_id";

    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_USER_ID + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_MOTIVATIONAL_TEXT + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_REMOTE_ID + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_ACCEPTANCE + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG = "Boolax_internal_archive_2017_user_account_log";
    //------------BOOLAX ACCOUNT LOG TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_ID = "Boolax_internal_archive_2017_user_account_log_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_STATUS = "Boolax_internal_archive_2017_user_account_log_status";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_USER_ID = "Boolax_internal_archive_2017_user_account_log_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_REGDATE = "Boolax_internal_archive_2017_user_account_log_regdate";

    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_STATUS + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_USER_ID + " text ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_REGDATE + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS = "Boolax_internal_archive_2017_chat_wallpapers";
    //------------BOOLAX CHAT WALLPAPERS TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_ID = "Boolax_internal_archive_2017_chat_wallpapers_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_REGDATE = "Boolax_internal_archive_2017_chat_wallpapers_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_PIC_NAME = "Boolax_internal_archive_2017_chat_wallpapers_pic_name";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_TYPE = "Boolax_internal_archive_2017_chat_wallpapers_type";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_USER_ID = "Boolax_internal_archive_2017_chat_wallpapers_user_id";

    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_TYPE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_PIC_NAME + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_USER_ID + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT = "Boolax_internal_archive_2017_user_advertisement";
    //------------BOOLAX ADVERTISEMENT TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_ID = "Boolax_internal_archive_2017_user_advertisement_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_REGDATE = "Boolax_internal_archive_2017_user_advertisement_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_ADVERTISER_ID = "Boolax_internal_archive_2017_user_advertisement_advertiser_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_MOTIVATIONAL_TEXT = "Boolax_internal_archive_2017_user_advertisement_motivational_text";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_MOTIF = "Boolax_internal_archive_2017_user_advertisement_motif";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_STILL_ON = "Boolax_internal_archive_2017_user_advertisement_still_on";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_TAKEN_DATE = "Boolax_internal_archive_2017_user_advertisement_taken_date";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_PROPOSED_TIME = "Boolax_internal_archive_2017_user_advertisement_meet_proposed_time";
    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_ADVERTISER_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_MOTIVATIONAL_TEXT + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_MOTIF + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_STILL_ON + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_TAKEN_DATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_PROPOSED_TIME + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY = "Boolax_internal_archive_2017_chat_history";
    //------------BOOLAX CHAT HISTORY TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_ID = "Boolax_internal_archive_2017_chat_history_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_USER_ID = "Boolax_internal_archive_2017_chat_history_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_MESSAGE_ID = "Boolax_internal_archive_2017_chat_history_message_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_REGDATE = "Boolax_internal_archive_2017_chat_history_regdate";
    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_CHAT_HISTORY =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_USER_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_MESSAGE_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_REGDATE + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE = "Boolax_internal_archive_2017_chat_restore";
    //------------BOOLAX CHAT RESTORE TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_ID = "Boolax_internal_archive_2017_chat_restore_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_BEGIN_DATE = "Boolax_internal_archive_2017_chat_restore_begin_date";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_END_DATE = "Boolax_internal_archive_2017_chat_restore_end_date";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_USER_ID = "Boolax_internal_archive_2017_chat_restore_user_id";
    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_CHAT_RESTORE =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_BEGIN_DATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_END_DATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_USER_ID + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS = "Boolax_internal_archive_2017_messages_chats";
    //------------BOOLAX MESSAGES CHATS TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID = "Boolax_internal_archive_2017_messages_chats_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE = "Boolax_internal_archive_2017_messages_chats_message";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_TYPE = "Boolax_internal_archive_2017_messages_chats_message_type";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS = "Boolax_internal_archive_2017_messages_chats_message_status";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE = "Boolax_internal_archive_2017_messages_chats_message_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER = "Boolax_internal_archive_2017_messages_chats_message_sender";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER = "Boolax_internal_archive_2017_messages_chats_message_reciever";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_WHO_SENT = "Boolax_internal_archive_2017_messages_chats_message_who_sent";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_DATA_URL = "Boolax_internal_archive_2017_messages_chats_message_data_url";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_ = "Boolax_internal_archive_2017_messages_chats_message_message_";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ARCHIVED = "Boolax_internal_archive_2017_messages_chats_message_archived";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID = "Boolax_internal_archive_2017_messages_chats_message_remote_id";
    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_TYPE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_WHO_SENT + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_DATA_URL + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_ + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ARCHIVED + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID + " text unique );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES = "Boolax_internal_archive_2017_gallery_and_profile_images";
    //------------BOOLAX GALLERY AND PROFILE TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_ID = "Boolax_internal_archive_2017_gallery_and_profile_images_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_USER_ID = "Boolax_internal_archive_2017_gallery_and_profile_images_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_ACTUAL_IMAGE = "Boolax_internal_archive_2017_gallery_and_profile_images_actual_image";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_REGDATE = "Boolax_internal_archive_2017_gallery_and_profile_images_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_VISIBILITY = "Boolax_internal_archive_2017_gallery_and_profile_images_visibility";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_IMAGE_FOLDER = "Boolax_internal_archive_2017_gallery_and_profile_images_folder";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_REMOTE_ID = "Boolax_internal_archive_2017_gallery_and_profile_images_remote_id";
    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_USER_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_ACTUAL_IMAGE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_VISIBILITY + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_IMAGE_FOLDER + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES_REMOTE_ID + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS = "Boolax_internal_archive_2017_boolax_events";
    //------------BOOLAX EVENTS TABLE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_ID = "Boolax_internal_archive_2017_boolax_events_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_NAME = "Boolax_internal_archive_2017_boolax_events_name";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_DATE_CREATED = "Boolax_internal_archive_2017_boolax_events_date_created";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_DATE_DUE = "Boolax_internal_archive_2017_boolax_events_date_due";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_PLACE = "Boolax_internal_archive_2017_boolax_events_place";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_ORGANISER = "Boolax_internal_archive_2017_boolax_events_organiser";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_CREATE_AS_GROUP = "Boolax_internal_archive_2017_boolax_events_create_as_group";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_DESCRIPTION = "Boolax_internal_archive_2017_boolax_events_description";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_REMOTE_ID = "Boolax_internal_archive_2017_boolax_events_remote_id";
    //------------BOOLAX_USER CREATE TABLE-------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_NAME + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_DATE_CREATED + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_DATE_DUE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_PLACE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_ORGANISER + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_CREATE_AS_GROUP + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_REMOTE_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS_DESCRIPTION + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS = "Boolax_internal_archive_2017_events_goers";
    //------------BOOLAX EVENTS GOERS FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS_ID = "Boolax_internal_archive_2017_events_goers_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS_REGDATE = "Boolax_internal_archive_2017_events_goers_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS_GOER_ID = "Boolax_internal_archive_2017_events_goers_goer_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS_EVENT_ID = "Boolax_internal_archive_2017_events_goers_event_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS_REMOTE_ID = "Boolax_internal_archive_2017_events_remote_id";
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS_GOER_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS_EVENT_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS_REMOTE_ID + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS = "Boolax_internal_archive_2017_groups";
    //------------BOOLAX GROUPS FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_ID = "Boolax_internal_archive_2017_groups_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_NAME = "Boolax_internal_archive_2017_groups_name";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_PRIVACY = "Boolax_internal_archive_2017_groups_privacy";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_NO = "Boolax_internal_archive_2017_groups_members_no";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_REMOTE_ID = "Boolax_internal_archive_2017_events_remote_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_DATE_CREATED = "Boolax_internal_archive_2017_events_date_created";
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_GROUPS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_NAME + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_PRIVACY + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_DATE_CREATED + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_NO + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_REMOTE_ID + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS = "Boolax_internal_archive_2017_group_admins";
    //------------BOOLAX GROUPS ADMINS FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_ID = "Boolax_internal_archive_2017_group_admins_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_GROUP_ID = "Boolax_internal_archive_2017_group_admins_group_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_USER_ID = "Boolax_internal_archive_2017_group_admins_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_REGDATE = "Boolax_internal_archive_2017_group_admins_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_ACTIVE = "Boolax_internal_archive_2017_group_admins_active";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_REMOTE_ID = "Boolax_internal_archive_2017_group_admins_remote_id";
    //---------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_ADMINS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_GROUP_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_USER_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_ACTIVE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS_REMOTE_ID + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE = "Boolax_internal_archive_2017_data_usage";
    //------------BOOLAX DATA USAGE FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_ID = "Boolax_internal_archive_2017_data_usage_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_SAVE_TO_GALLERY = "Boolax_internal_archive_2017_data_usage_save_to_gallery";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_REGDATE = "Boolax_internal_archive_2017_data_usage_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_USER_ID = "Boolax_internal_archive_2017_data_usage_user_id";
    //---------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_SAVE_TO_GALLERY + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_USER_ID + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD = "Boolax_internal_archive_2017_data_usage_automatically_download";
    //------------BOOLAX DATA USAGE AUTOMATICALLY DOWNLOAD FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD_ID = "Boolax_internal_archive_2017_data_usage_automatically_download_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD_USER_ID = "Boolax_internal_archive_2017_data_usage_automatically_download_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD_ON_WIFI = "Boolax_internal_archive_2017_data_usage_automatically_download_on_wifi";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD_ON_MOBILE_DATA = "Boolax_internal_archive_2017_data_usage_automatically_download_on_mobile_data";
    //---------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD_USER_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD_ON_WIFI + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD_ON_MOBILE_DATA + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS = "Boolax_internal_archive_2017_notifications_settings";
    //------------BOOLAX NOTIFICATIONS SETTINGS FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS_ID = "Boolax_internal_archive_2017_notifications_settings_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS_USER_ID = "Boolax_internal_archive_2017_notifications_settings_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS_NOTIF_SOUND = "Boolax_internal_archive_2017_notifications_settings_notif_sound";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS_CONVERSATION_TONE = "Boolax_internal_archive_2017_notifications_settings_conversation_tone";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS_GROUP_CONVERSATION_TONE = "Boolax_internal_archive_2017_notifications_settings_group_conversation_tone";
    //---------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS_NOTIF_SOUND + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS_CONVERSATION_TONE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS_USER_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS_GROUP_CONVERSATION_TONE + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS = "Boolax_internal_archive_2017_notifications_awesome_triggers";
    //------------BOOLAX NOTIFICATIONS SETTINGS FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_ID = "Boolax_internal_archive_2017_notifications_awesome_triggers_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_NAME_IN_SEARCH_VISIBILITY = "Boolax_internal_archive_2017_notifications_awesome_triggers_name_in_search_visibility";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_SIGN_UP_ALERT = "Boolax_internal_archive_2017_notifications_awesome_triggers_signup_alert";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_LIKE_EVERY_NEW_USER = "Boolax_internal_archive_2017_notifications_awesome_triggers_like_every_new_user";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_LIKE_BACK_EVERY_BODY = "Boolax_internal_archive_2017_notifications_awesome_triggers_like_back_everybody";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_USER_ID = "Boolax_internal_archive_2017_notifications_awesome_triggers_user_id";
    //---------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_AWESOME_TRIGGERS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_NAME_IN_SEARCH_VISIBILITY + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_SIGN_UP_ALERT + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_LIKE_EVERY_NEW_USER + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_LIKE_BACK_EVERY_BODY + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS_USER_ID + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS = "Boolax_internal_archive_2017_internal_notifications";
    //------------BOOLAX NOTIFICATIONS SETTINGS FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_ID = "Boolax_internal_archive_2017_internal_notifications_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_TITLE = "Boolax_internal_archive_2017_internal_notifications_title";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_MESSAGE = "Boolax_internal_archive_2017_internal_notifications_message";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_AVATAR = "Boolax_internal_archive_2017_internal_notifications_avatar";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_UNIQUE_ID = "Boolax_internal_archive_2017_internal_notifications_notif_unique_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_USER_ID = "Boolax_internal_archive_2017_internal_notifications_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_TYPE = "Boolax_internal_archive_2017_internal_notifications_type";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_ACTIVE = "Boolax_internal_archive_2017_internal_notifications_active";
    //---------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_TITLE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_MESSAGE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_AVATAR + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_UNIQUE_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_USER_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_TYPE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS_ACTIVE + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE = "Boolax_internal_archive_2017_bot_structure";
    //------------BOOLAX NOTIFICATIONS SETTINGS FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_ID = "Boolax_internal_archive_2017_bot_structure_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_TITLE = "Boolax_internal_archive_2017_bot_structure_title";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_MESSAGE = "Boolax_internal_archive_2017_bot_structure_message";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_URL = "Boolax_internal_archive_2017_bot_structure_url";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_WHICH_WIN_OR_ACTIVITY = "Boolax_internal_archive_2017_bot_structure_which_win_or_activity";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_IS_DISMISSED = "Boolax_internal_archive_2017_bot_structure_is_dismissed";
    //---------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_TITLE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_MESSAGE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_URL + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_WHICH_WIN_OR_ACTIVITY + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE_IS_DISMISSED + " text );";
    //---------------------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS = "Boolax_internal_archive_2017_group_members";
    //------------BOOLAX NOTIFICATIONS SETTINGS FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_ID = "Boolax_internal_archive_2017_group_members_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_GROUP_ID = "Boolax_internal_archive_2017_group_members_group_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_USER_ID = "Boolax_internal_archive_2017_group_members_user_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_REGDATE = "Boolax_internal_archive_2017_group_members_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_ACTIVE = "Boolax_internal_archive_2017_group_members_active";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_REMOTE_ID = "Boolax_internal_archive_2017_group_members_remote_id";
    //---------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_GROUP_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_USER_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_ACTIVE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS_REMOTE_ID + " text unique );";
    //---------------------
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES = "Boolax_internal_archive_2017_group_chats_messages";
    //------------BOOLAX NOTIFICATIONS SETTINGS FIELDS.
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_ID = "Boolax_internal_archive_2017_group_chats_messages_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_MESSAGE = "Boolax_internal_archive_2017_group_chats_messages_message";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_TYPE = "Boolax_internal_archive_2017_group_chats_messages_type";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_STATUS = "Boolax_internal_archive_2017_group_chats_messages_status";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_REGDATE = "Boolax_internal_archive_2017_group_chats_messages_regdate";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_SENDER = "Boolax_internal_archive_2017_group_chats_messages_sender";

    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_RECEIVER = "Boolax_internal_archive_2017_group_chats_messages_receiver";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_WHO_SENT = "Boolax_internal_archive_2017_group_chats_messages_who_sent";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_DATA_URL = "Boolax_internal_archive_2017_group_chats_messages_data_url";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_LOCAL_ID = "Boolax_internal_archive_2017_group_chats_messages_local_id";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_ARCHIVED = "Boolax_internal_archive_2017_group_chats_messages_archived";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_WHO_ARCHIVED = "Boolax_internal_archive_2017_group_chats_messages_who_archived";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_ME_DELIVERY_STATUS = "Boolax_internal_archive_2017_group_chats_messages_me_delivery_status";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_THEM_DELIVERY_STATUS = "Boolax_internal_archive_2017_group_chats_messages_them_delivery_status";
    public static final String MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_REMOTE_ID = "Boolax_internal_archive_2017_group_chats_messages_remote_id";

    //---------
    private static final String SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES =
            "create table " + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES + " ("
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_ID + " integer primary key autoincrement, "
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_MESSAGE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_TYPE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_STATUS + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_REGDATE + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_SENDER + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_RECEIVER + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_WHO_SENT + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_DATA_URL + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_LOCAL_ID + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_ARCHIVED + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_WHO_ARCHIVED + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_ME_DELIVERY_STATUS + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_THEM_DELIVERY_STATUS + " text  ,"
                    + MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES_REMOTE_ID + " text unique );";

    //--------------------
    //create USERCRED DATABASE----------------


    ///-----------------------------------------------------------------------
    private SQLiteHelper sqLiteHelper;
    private SQLiteDatabase sqLiteDatabase;

    private Context context;

    public NDS_boolax_db_adapter(Context c) {
        context = c;
    }

    public NDS_boolax_db_adapter openToRead() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NDS_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getReadableDatabase();
        return this;
    }

    public NDS_boolax_db_adapter openToWrite() throws android.database.SQLException {
        sqLiteHelper = new SQLiteHelper(context, MYDATABASE_NDS_NAME, null, MYDATABASE_VERSION);
        sqLiteDatabase = sqLiteHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        sqLiteHelper.close();
    }

    public int deleteAll_TABLE_BOOLAX_USER() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_USER, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_TEMPORARY_BOOS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_ACTUAL_LOVERS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_TAGS_GROUP_INVITES() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_QUICK_BOO_CONTENDERS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_ACCOUNT_LOG() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_BOOLAX_ADVERTISEMENT() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_CHAT_HISTORY() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_CHAT_CHAT_RESTORE() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_CHAT_WALLPAPERS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_MESSAGES_CHATS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_BOOLAX_EVENTS_GOERS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_BOOLAX_GROUPS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_GROUPS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_BOOLAX_GROUP_ADMINS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_GROUP_ADMINS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_AWESOME_TRIGGERS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS, null, null);
    }

    public int deleteAll_TABLE_BOOLAX_BOT_STRUCTURE() {
        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE, null, null);
    }

    //--------------

    public boolean update_MYDATABASE_NDS_TABLE_BOOLAX_USER_locally_add_Passwords(String remoteId, String boolax_user_email,
                                                                                 String boolax_user_phone
    ) {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        //------------
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_EMAIL, boolax_user_email);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_PHONE, boolax_user_phone);
        //------------------------------

        //sqLiteDatabase.update(MYDATABASE_BOO_TABLE_USER_CREDS, contentValues, MYDATABASE_BOO_TABLE_USER_CREDS_ID + "=" + LastId, null);
        return sqLiteDatabase.update(MYDATABASE_NDS_TABLE_BOOLAX_USER, contentValues, " " + MYDATABASE_NDS_TABLE_BOOLAX_USER_REMOTE_ID + "=" + remoteId, null) > 0;

    }


    public boolean update_THIS_TEMP_BOO_VISIBILITY(String remoteId
    ) {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        //------------
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_LIKE_STATUS, "some");
        //------------------------------

        //sqLiteDatabase.update(MYDATABASE_BOO_TABLE_USER_CREDS, contentValues, MYDATABASE_BOO_TABLE_USER_CREDS_ID + "=" + LastId, null);
        return sqLiteDatabase.update(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS, contentValues, " " + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REMOTE_ID + "=" + remoteId, null) > 0;

    }

    public boolean update_THIS_BOOER_VISIBILITY(String remoteId
    ) {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        //------------
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_LIKE_BACK_STATUS, "some");
        //------------------------------

        //sqLiteDatabase.update(MYDATABASE_BOO_TABLE_USER_CREDS, contentValues, MYDATABASE_BOO_TABLE_USER_CREDS_ID + "=" + LastId, null);
        return sqLiteDatabase.update(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS, contentValues, " " + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REMOTE_ID + "=" + remoteId, null) > 0;

    }

    public boolean update_MYDATABASE_NDS_TABLE_BOOLAX_USER_locally_add_new_features(String myRemoteId,
                                                                                    String how_attractive_data,
                                                                                    String about_life_data,
                                                                                    String about_love_data,
                                                                                    String about_relationship_data,
                                                                                    String about_lover_criteria_data,
                                                                                    String about_hobbies_data, String about_religious_affiliation_data
            , String about_academics_and_work_data) {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        //------------
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_BOOLAX_HOW_ATTRACTIVE, how_attractive_data);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LIFE, about_life_data);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVE, about_love_data);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_RELATIONSHIPS, about_relationship_data);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVER_CRITERIA, about_lover_criteria_data);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_HOBBIES, about_hobbies_data);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_RELIGIOUS_AFFILIATION, about_religious_affiliation_data);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ACADEMICS_AND_WORKS, about_academics_and_work_data);
        //------------------------------

        //sqLiteDatabase.update(MYDATABASE_BOO_TABLE_USER_CREDS, contentValues, MYDATABASE_BOO_TABLE_USER_CREDS_ID + "=" + LastId, null);
        return sqLiteDatabase.update(MYDATABASE_NDS_TABLE_BOOLAX_USER, contentValues, " " + MYDATABASE_NDS_TABLE_BOOLAX_USER_REMOTE_ID + "=" + myRemoteId, null) > 0;

    }

    //------------------------
    public boolean update_MYDATABASE_NDS_TABLE_BOOLAX_USER_locally(String fname, String lname,
                                                                   String gender, String username,
                                                                   String birthdate, String country, String province,
                                                                   String login_type, String remote_id) {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        //------------
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_FNAME, fname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_LNAME, lname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_GENDER, gender);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_USERNAME, username);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_COUNTRY, country);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_PROVINCE, province);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_LOGIN_TYPE, login_type);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_BIRTHDATE, birthdate);
        //------------------------------

        //sqLiteDatabase.update(MYDATABASE_BOO_TABLE_USER_CREDS, contentValues, MYDATABASE_BOO_TABLE_USER_CREDS_ID + "=" + LastId, null);
        return sqLiteDatabase.update(MYDATABASE_NDS_TABLE_BOOLAX_USER, contentValues, " " + MYDATABASE_NDS_TABLE_BOOLAX_USER_REMOTE_ID + "=" + remote_id, null) > 0;

    }


    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_USER_locally(String fname, String lname,
                                                                 String gender, String email, String username, String regdate, String age,
                                                                 String birthdate, String country, String province, String district,
                                                                 String how_attractive, String login_type, String about_life,
                                                                 String about_love, String about_relationships, String about_lover_criteria,
                                                                 String about_hobbies, String about_religious_affiliation, String about_academics_and_work,
                                                                 String avatar_image, String remote_id

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_FNAME, fname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_LNAME, lname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_GENDER, gender);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_EMAIL, email);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_USERNAME, username);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_REGDATE, regdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_AGE, age);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_BIRTHDATE, birthdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_COUNTRY, country);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_PROVINCE, province);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_DISTRICT, district);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_BOOLAX_HOW_ATTRACTIVE, how_attractive);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_LOGIN_TYPE, login_type);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LIFE, about_life);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVE, about_love);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_RELATIONSHIPS, about_relationships);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVER_CRITERIA, about_lover_criteria);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_HOBBIES, about_hobbies);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_RELIGIOUS_AFFILIATION, about_religious_affiliation);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_ACADEMICS_AND_WORKS, about_academics_and_work);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_AVATAR_IMAGE, avatar_image);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_REMOTE_ID, remote_id);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_USER, null, contentValues) > 0;

    }

    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_locally(String fname, String lname,
                                                                   String gender, String email, String username, String regdate, String age,
                                                                   String birthdate, String country, String province, String district,
                                                                   String how_attractive, String likeback_status, String about_life,
                                                                   String about_love, String about_relationships, String about_lover_criteria,
                                                                   String about_hobbies, String about_religious_affiliation, String about_academics_and_work,
                                                                   String avatar_image, String remote_id,
                                                                   String interested_in, String your_weight, String your_height,
                                                                   String skin_color

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_FNAME, fname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_LNAME, lname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_GENDER, gender);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_EMAIL, email);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_USERNAME, username);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REGDATE, regdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_AGE, age);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_BIRTHDATE, birthdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_COUNTRY, country);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_PROVINCE, province);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_DISTRICT, district);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_HOW_ATTRACTIVE, how_attractive);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_LIFE, about_life);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_LOVE, about_love);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_RELATIONSHIPS, about_relationships);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_ABOUT_LOVER_CRITERIA, about_lover_criteria);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_HOBBIES, about_hobbies);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_RELIGIOUS_AFFILIATION, about_religious_affiliation);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ACADEMICS_AND_WORKS, about_academics_and_work);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_AVATAR_IMAGE, avatar_image);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REMOTE_ID, remote_id);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_LIKE_BACK_STATUS, likeback_status);

        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_INTERESTED_IN, interested_in);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_YOUR_WEIGHT, your_weight);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_YOUR_HEIGHT, your_height);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_SKIN_COLOR, skin_color);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS, null, contentValues) > 0;

    }

    public Cursor GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOERS() {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_FNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_LNAME, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_GENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_EMAIL, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_USERNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_AGE,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_BIRTHDATE, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_COUNTRY,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_PROVINCE, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_DISTRICT,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_HOW_ATTRACTIVE, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_LIFE,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_LOVE,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_RELATIONSHIPS, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_ABOUT_LOVER_CRITERIA,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_HOBBIES, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_RELIGIOUS_AFFILIATION,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ACADEMICS_AND_WORKS, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_AVATAR_IMAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REMOTE_ID, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_LIKE_BACK_STATUS,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_INTERESTED_IN, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_YOUR_WEIGHT,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_YOUR_HEIGHT,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_SKIN_COLOR


        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS, columns,
                " 7>2 AND " + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_LIKE_BACK_STATUS + "='none' order by  " + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ID, null, null, null, null);

        return cursor;
    }

    public Cursor GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_ALL() {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_FNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_LNAME, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_GENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_EMAIL, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_USERNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_AGE,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_BIRTHDATE, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_COUNTRY,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_PROVINCE, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_DISTRICT,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_HOW_ATTRACTIVE, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_LIFE,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_LOVE,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_RELATIONSHIPS, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_ABOUT_LOVER_CRITERIA,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ABOUT_HOBBIES, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_RELIGIOUS_AFFILIATION,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ACADEMICS_AND_WORKS, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_AVATAR_IMAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_REMOTE_ID, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_LIKE_BACK_STATUS,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_INTERESTED_IN, MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_YOUR_WEIGHT,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_YOUR_HEIGHT,
                MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_SKIN_COLOR


        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_BOOERS, columns,
                " 7>2  order by  " + MYDATABASE_NDS_TABLE_BOOLAX_BOOERS_USER_ID, null, null, null, null);

        return cursor;
    }

    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_locally(String regdate, String summary_text,
                                                                               String valid_url, String encryption_key, String which_cipher
            , String remote_id

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_REGDATE, regdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_SUMMARY_TEXT, summary_text);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_VALID_URL, valid_url);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_ENCRYPTION_KEY, encryption_key);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_WHICH_CIPHER, which_cipher);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES_REMOTE_ID, remote_id);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES, null, contentValues) > 0;

    }

    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_locally(String message, String type,
                                                                           String status, String regdate, String reciever
            , String who_sent, String data_url, String message_
            , String remote_id, String archived


    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE, message);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_TYPE, type);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS, status);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE, regdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER, reciever);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER, who_sent);

        //--
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_DATA_URL, data_url);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_, message_);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ARCHIVED, archived);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID, remote_id);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, null, contentValues) > 0;

    }

    //----------------
    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_locally(String regdate, String pic_name,
                                                                            String type, String user_id

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_REGDATE, regdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_PIC_NAME, pic_name);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_TYPE, type);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS_USER_ID, user_id);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS, null, contentValues) > 0;

    }

    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_CHAT_RESTORE_locally(String begin_date, String enddate,
                                                                         String user_id

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_BEGIN_DATE, begin_date);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_END_DATE, enddate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE_USER_ID, user_id);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_RESTORE, null, contentValues) > 0;

    }
    //------------------get my account user data--


    public Cursor GET_USER_DATA() {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_USER_ID, MYDATABASE_NDS_TABLE_BOOLAX_USER_FNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_LNAME
                , MYDATABASE_NDS_TABLE_BOOLAX_USER_GENDER, MYDATABASE_NDS_TABLE_BOOLAX_USER_EMAIL,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_USERNAME, MYDATABASE_NDS_TABLE_BOOLAX_USER_REGDATE,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_AGE, MYDATABASE_NDS_TABLE_BOOLAX_USER_BIRTHDATE,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_COUNTRY, MYDATABASE_NDS_TABLE_BOOLAX_USER_PROVINCE,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_DISTRICT, MYDATABASE_NDS_TABLE_BOOLAX_USER_BOOLAX_HOW_ATTRACTIVE,

                MYDATABASE_NDS_TABLE_BOOLAX_USER_LOGIN_TYPE, MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LIFE,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVE, MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_RELATIONSHIPS,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVER_CRITERIA, MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_HOBBIES,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_RELIGIOUS_AFFILIATION, MYDATABASE_NDS_TABLE_BOOLAX_USER_ACADEMICS_AND_WORKS,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_AVATAR_IMAGE, MYDATABASE_NDS_TABLE_BOOLAX_USER_REMOTE_ID,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_PHONE
        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_USER, columns,
                " 3>1" + " order by  " + MYDATABASE_NDS_TABLE_BOOLAX_USER_ID + " desc", null, null, null, null);

        return cursor;
    }

    public Cursor GET_CHAT_MESSAGES_ALL(String OtherParty) {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_TYPE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS
                , MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_WHO_SENT,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_DATA_URL, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ARCHIVED, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID


        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, columns,
                "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER + "= '" + OtherParty + "' OR " + "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER + "= '" + OtherParty + "' order by  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID + " desc", null, null, null, null);

        return cursor;
    }
    public Cursor GET_CHAT_MESSAGES_ALL_NADA() {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_TYPE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS
                , MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_WHO_SENT,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_DATA_URL, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ARCHIVED, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID


        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, columns,
                " 7>1 "    + " order by  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID + " desc", null, null, null, null);

        return cursor;
    }
    //------------
    public Cursor GET_CHAT_MESSAGES_ALL_SENT(String OtherParty) {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_TYPE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS
                , MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_WHO_SENT,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_DATA_URL, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ARCHIVED, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID


        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, columns,
                "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + "= '1' AND " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER + "='" + OtherParty + "' OR " + "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER + "='" + OtherParty + "' "+ " AND "+MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + "='1'"+" order by  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID + " desc", null, null, null, null);

        return cursor;
    }

    //------------
    public Cursor GET_CHAT_MESSAGES_ALL_NOT_SENT(String OtherParty) {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_TYPE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS
                , MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_WHO_SENT,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_DATA_URL, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ARCHIVED, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID


        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, columns,
                "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + "='0' AND " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER + "='" + OtherParty + "' "+ " OR " + "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER + "='" + OtherParty + "' AND "+MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + "='0'" +  " order by  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID + " desc", null, null, null, null);

        return cursor;
    }

    //------------
    public Cursor GET_CHAT_MESSAGES_ALL_DELIVERED(String OtherParty) {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_TYPE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS
                , MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_WHO_SENT,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_DATA_URL, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ARCHIVED, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID


        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, columns,
                "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + "= '2' AND " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER + "='" + OtherParty + "' OR " + "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER + "='" + OtherParty + "' "+ " AND "+MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + "='2'" +" order by  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID + " desc", null, null, null, null);

        return cursor;
    }

    public Cursor GET_CHAT_MESSAGES_ALL_SEEN(String OtherParty) {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_TYPE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS
                , MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_WHO_SENT,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_DATA_URL, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ARCHIVED, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID


        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, columns,
                "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + "= '3' AND " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER + "='" + OtherParty + "' OR " + "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER + "='" + OtherParty + "' "+ " AND "+MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + "='3'"+" order by  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID + " desc", null, null, null, null);

        return cursor;
    }

    public Cursor GET_CHAT_MESSAGES_ALL_DELETED(String OtherParty) {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_TYPE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS
                , MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_WHO_SENT,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_DATA_URL, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_,
                MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ARCHIVED, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID


        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, columns,
                "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + "= '4' AND " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_RECIEVER + "='" + OtherParty + "' OR " + "  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_SENDER + "='" + OtherParty + "' "+ " AND "+MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS + "='4'"+" order by  " + MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID + " desc", null, null, null, null);

        return cursor;
    }


    //----------
    public Cursor GET_USER_ACCOUNT_DATA() {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_STATUS, MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_USER_ID,
                MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_ID
        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG, columns,
                " 7>1 order by  " + MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_ID + " desc", null, null, null, null);

        return cursor;
    }


    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_CHAT_HISTORY_locally(String user_id, String message_id,
                                                                         String regdate

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_USER_ID, user_id);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_MESSAGE_ID, message_id);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY_REGDATE, regdate);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_USER_CHAT_HISTORY, null, contentValues) > 0;

    }


    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_locally(String log_status, String user_id,
                                                                        String regdate

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_STATUS, log_status);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_USER_ID, user_id);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_REGDATE, regdate);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG, null, contentValues) > 0;

    }

    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_locally_finalize(String log_status, String user_id,
                                                                                 String regdate

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_STATUS, log_status);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_USER_ID, user_id);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG_REGDATE, regdate);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG, null, contentValues) > 0;

    }

    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_LOG_locally(String regdate, String advertiser_id,
                                                                              String motivational_text, String motif,
                                                                              String still_on, String taken_date,
                                                                              String proposedTime

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_REGDATE, regdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_ADVERTISER_ID, advertiser_id);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_MOTIVATIONAL_TEXT, motivational_text);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_MOTIF, motif);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_STILL_ON, still_on);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_TAKEN_DATE, taken_date);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT_PROPOSED_TIME, proposedTime);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG, null, contentValues) > 0;

    }
    //------------BOOLAX_USER CREATE TABLE-------


    public boolean save_MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_locally(String fname, String lname,
                                                                          String gender, String email, String username, String regdate, String age,
                                                                          String birthdate, String country, String province, String district,
                                                                          String how_attractive, String about_life,
                                                                          String about_love, String about_relationships, String about_lover_criteria,
                                                                          String about_hobbies, String about_religious_affiliation, String about_academics_and_work,
                                                                          String avatar_image, String remote_id,
                                                                          String interested_in, String your_weight,
                                                                          String your_height, String skin_color

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_FNAME, fname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_LNAME, lname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_GENDER, gender);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_EMAIL, email);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_USERNAME, username);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_REGDATE, regdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_AGE, age);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_BIRTHDATE, birthdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_COUNTRY, country);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_PROVINCE, province);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_DISTRICT, district);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_HOW_ATTRACTIVE, how_attractive);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_LIFE, about_life);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_LOVE, about_love);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_RELATIONSHIPS, about_relationships);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_ABOUT_LOVER_CRITERIA, about_lover_criteria);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_HOBBIES, about_hobbies);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_RELIGIOUS_AFFILIATION, about_religious_affiliation);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ACADEMICS_AND_WORKS, about_academics_and_work);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_AVATAR_IMAGE, avatar_image);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_REMOTE_ID, remote_id);
        //----------------------------------------------------------------

        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_INTERESTED_IN, interested_in);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_YOUR_WEIGHT, your_weight);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_YOUR_HEIGHT, your_height);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_SKIN_COLOR, skin_color);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS, null, contentValues) > 0;

    }


    public Cursor GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_ACTUAL_LOVERS() {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_FNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_LNAME, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_GENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_EMAIL, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_USERNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_AGE,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_BIRTHDATE, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_COUNTRY,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_PROVINCE, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_DISTRICT,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_HOW_ATTRACTIVE, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_LIFE,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_LOVE,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_RELATIONSHIPS, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_ABOUT_LOVER_CRITERIA,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_HOBBIES, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_RELIGIOUS_AFFILIATION,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ACADEMICS_AND_WORKS, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_AVATAR_IMAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_REMOTE_ID, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ID,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_INTERESTED_IN, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_YOUR_WEIGHT,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_YOUR_HEIGHT, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_SKIN_COLOR

        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS, columns,
                " 7>2" + " order by  " + MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ID, null, null, null, null);

        return cursor;
    }

    public Cursor GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_ACTUAL_LOVERS_ALL() {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_FNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_LNAME, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_GENDER,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_EMAIL, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_USERNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_REGDATE, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_AGE,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_BIRTHDATE, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_COUNTRY,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_PROVINCE, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_DISTRICT,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_HOW_ATTRACTIVE, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_LIFE,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_LOVE,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_RELATIONSHIPS, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_ABOUT_LOVER_CRITERIA,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ABOUT_HOBBIES, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_RELIGIOUS_AFFILIATION,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ACADEMICS_AND_WORKS, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_AVATAR_IMAGE,
                MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_REMOTE_ID, MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS_USER_ID

        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS, columns,
                " 7>2 ", null, null, null, null);

        return cursor;
    }


    public boolean save_MYDATABASE_TEMPORARY_BOOS_locally(String fname, String lname,
                                                          String gender, String email, String username, String regdate, String age,
                                                          String birthdate, String country, String province, String district,
                                                          String how_attractive, String like_status, String about_life,
                                                          String about_love, String about_relationships, String about_lover_criteria,
                                                          String about_hobbies, String about_religious_affiliation, String about_academics_and_work,
                                                          String avatar_image, String remote_id,
                                                          String interested_in, String your_weight, String your_height,
                                                          String skin_color

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_FNAME, fname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_LNAME, lname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_GENDER, gender);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_EMAIL, email);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_USERNAME, username);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REGDATE, regdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_AGE, age);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_BIRTHDATE, birthdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_COUNTRY, country);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_PROVINCE, province);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_DISTRICT, district);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_HOW_ATTRACTIVE, how_attractive);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_LIFE, about_life);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_LOVE, about_love);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_RELATIONSHIPS, about_relationships);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_ABOUT_LOVER_CRITERIA, about_lover_criteria);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_HOBBIES, about_hobbies);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_RELIGIOUS_AFFILIATION, about_religious_affiliation);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ACADEMICS_AND_WORKS, about_academics_and_work);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_AVATAR_IMAGE, avatar_image);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_LIKE_STATUS, like_status);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REMOTE_ID, remote_id);

        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_INTERESTED_IN, interested_in);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_YOUR_WEIGHT, your_weight);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_YOUR_HEIGHT, your_height);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_SKIN_COLOR, skin_color);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS, null, contentValues) > 0;

    }

    public boolean save_MYDATABASE_QUICK_BOO_CONTENDERS_locally(String fname, String lname,
                                                                String gender, String email, String username, String regdate, String age,
                                                                String birthdate, String country, String province, String district

    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_REGDATE, fname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_USER_ID, lname);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_MOTIVATIONAL_TEXT, gender);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_ACCEPTANCE, email);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS_REMOTE_ID, username);

        return sqLiteDatabase.insertOrThrow(MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS, null, contentValues) > 0;

    }

    public Cursor GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS() {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ID,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_FNAME, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_LNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_GENDER, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_EMAIL,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_USERNAME, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REGDATE,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_AGE, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_BIRTHDATE,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_COUNTRY, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_PROVINCE,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_DISTRICT, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_HOW_ATTRACTIVE,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_LIFE,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_LOVE, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_RELATIONSHIPS,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_ABOUT_LOVER_CRITERIA, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_HOBBIES,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_RELIGIOUS_AFFILIATION, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ACADEMICS_AND_WORKS,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_AVATAR_IMAGE, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REMOTE_ID,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_LIKE_STATUS,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_INTERESTED_IN,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_YOUR_WEIGHT,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_YOUR_HEIGHT,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_SKIN_COLOR

        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS, columns,
                " 7>2 AND " + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_LIKE_STATUS + "='none' order by  " + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ID, null, null, null, null);

        return cursor;
    }

    public Cursor GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_ALL() {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ID,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_FNAME, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_LNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_GENDER, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_EMAIL,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_USERNAME, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REGDATE,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_AGE, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_BIRTHDATE,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_COUNTRY, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_PROVINCE,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_DISTRICT, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_HOW_ATTRACTIVE,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_LIFE,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_LOVE, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_RELATIONSHIPS,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_ABOUT_LOVER_CRITERIA, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ABOUT_HOBBIES,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_RELIGIOUS_AFFILIATION, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ACADEMICS_AND_WORKS,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_AVATAR_IMAGE, MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_REMOTE_ID,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_LIKE_STATUS,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_INTERESTED_IN,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_YOUR_WEIGHT,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_YOUR_HEIGHT,
                MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_SKIN_COLOR

        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS, columns,
                " 7>2 " + "  AND " + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_LIKE_STATUS + "='none' OR " + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_LIKE_STATUS + "='some' " + " order by  " + MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS_USER_ID, null, null, null, null);

        return cursor;
    }

    //------------------Get all settings----
    public Cursor GET_ALL_MYDATABASE_NDS_TABLE_BOOLAX_USER() {
        String[] columns = new String[]{MYDATABASE_NDS_TABLE_BOOLAX_USER_ID,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_FNAME, MYDATABASE_NDS_TABLE_BOOLAX_USER_LNAME,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_GENDER, MYDATABASE_NDS_TABLE_BOOLAX_USER_EMAIL,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_USERNAME, MYDATABASE_NDS_TABLE_BOOLAX_USER_REGDATE,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_AGE, MYDATABASE_NDS_TABLE_BOOLAX_USER_BIRTHDATE,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_COUNTRY, MYDATABASE_NDS_TABLE_BOOLAX_USER_PROVINCE,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_DISTRICT, MYDATABASE_NDS_TABLE_BOOLAX_USER_BOOLAX_HOW_ATTRACTIVE,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_LOGIN_TYPE, MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LIFE,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVE, MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_RELATIONSHIPS,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_LOVER_CRITERIA, MYDATABASE_NDS_TABLE_BOOLAX_USER_ABOUT_HOBBIES,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_RELIGIOUS_AFFILIATION, MYDATABASE_NDS_TABLE_BOOLAX_USER_ACADEMICS_AND_WORKS,
                MYDATABASE_NDS_TABLE_BOOLAX_USER_AVATAR_IMAGE, MYDATABASE_NDS_TABLE_BOOLAX_USER_REMOTE_ID

        };
        Cursor cursor = sqLiteDatabase.query(MYDATABASE_NDS_TABLE_BOOLAX_USER, columns,
                "7>2" + " order by  " + MYDATABASE_NDS_TABLE_BOOLAX_USER_ID + " desc limit 1", null, null, null, null);

        return cursor;
    }

    public boolean update_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_(String local_id,
                                                                      String status, String remote_id,
                                                                      String regdate


    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS, status);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID, remote_id);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE, regdate);

        return sqLiteDatabase.update(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, contentValues, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID + "='" + local_id+"' ", null) > 0;

    }
    public boolean update_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_with_captions(String local_id,
                                                                      String status, String remote_id,
                                                                      String regdate,String caption


    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS, status);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID, remote_id);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REGDATE, regdate);
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_MESSAGE_, caption);


        return sqLiteDatabase.update(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, contentValues, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_ID + "='" + local_id+"' ", null) > 0;

    }
    public boolean update_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_with_captions_For_Remote(String local_id,
                                                                                   String status, String remote_id,
                                                                                   String regdate,String caption


    ) throws SQLiteDatabaseCorruptException {
        //-------------
        //---
        ContentValues contentValues = new ContentValues();
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_STATUS, status);


        return sqLiteDatabase.update(MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS, contentValues, MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS_REMOTE_ID + "='" + remote_id+"' ", null) > 0;

    }

    //---Update my local settings good
    public boolean Update_MYDATABASE_NDS_TABLE_BOOLAX_USER_AVATAR(String remote_id, String new_Avatar) {
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        ContentValues contentValues = new ContentValues();
        //---
        contentValues.put(MYDATABASE_NDS_TABLE_BOOLAX_USER_AVATAR_IMAGE, new_Avatar);
        //sqLiteDatabase.update(MYDATABASE_BOO_TABLE_USER_CREDS, contentValues, MYDATABASE_BOO_TABLE_USER_CREDS_ID + "=" + LastId, null);
        return sqLiteDatabase.update(MYDATABASE_NDS_TABLE_BOOLAX_USER, contentValues, MYDATABASE_NDS_TABLE_BOOLAX_USER_REMOTE_ID + "=" + remote_id, null) > 0;

    }


    //-----------delete query from id=====
    public boolean DELETE_MYDATABASE_NDS_TABLE_BOOLAX_USER(String remoteId) {

        return sqLiteDatabase.delete(MYDATABASE_NDS_TABLE_BOOLAX_USER, MYDATABASE_NDS_TABLE_BOOLAX_USER_REMOTE_ID + "=" + remoteId, null) > 0;
    }//---------


    public class SQLiteHelper extends SQLiteOpenHelper {

        public SQLiteHelper(Context context, String name,
                            CursorFactory factory, int version) {
            super(context, name, factory, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            // TODO Auto-generated method stub
            db.execSQL(SCRIPT_CREATE_BOOLAX_USER_TABLE);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_TEMPORARY_BOOS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_BOOERS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_ACTUAL_LOVERS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_TAGS_GROUP_INVITES);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_QUICK_BOO_CONTENDERS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_ACCOUNT_LOG);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_CHAT_WALLPAPERS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_ADVERTISEMENT);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_CHAT_HISTORY);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_CHAT_RESTORE);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_MESSAGES_CHATS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_GALLERY_AND_PROFILE_IMAGES);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_BOOLAX_EVENTS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_EVENTS_GOERS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_GROUPS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_ADMINS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_DATA_USAGE_AUTOMATICALLY_DOWNLOAD);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_NOTIFICATIONS_SETTINGS);
            //------
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_AWESOME_TRIGGERS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_INTERNAL_NOTIFICATIONS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_BOT_STRUCTURE);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_MEMBERS);
            db.execSQL(SCRIPT_CREATE_MYDATABASE_NDS_TABLE_BOOLAX_GROUPS_CHAT_MESSAGES);


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

        }

    }

}

