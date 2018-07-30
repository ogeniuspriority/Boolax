package com.ogeniuspriority.boolax.boolax;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by USER on 2/22/2018.
 */

public class database_enablers {
    Context c;
    NDS_boolax_db_adapter thDb;

    public database_enablers(Context cIn) {
        this.thDb = new NDS_boolax_db_adapter(cIn);
        this.c = cIn;
        this.thDb.openToWrite();
    }

    public boolean findIfUserCreated() {
        int reality_counter = 0;
        Cursor allUsersSaved = thDb.GET_USER_DATA();
        if (allUsersSaved.moveToLast()) {
            for (int i = 0; i < allUsersSaved.getCount(); i++) {
                String user_id = allUsersSaved.getString(0);
                String remote_id = allUsersSaved.getString(22);
                reality_counter++;

            }

        }
        return (reality_counter == 0) ? true : false;
    }

    public boolean findIfUserCreated_stage2_account_complete() {
        String gender = "";
        int reality_counter = 0;
        Cursor allUsersSaved = thDb.GET_USER_DATA();
        if (allUsersSaved.moveToLast()) {
            for (int i = 0; i < allUsersSaved.getCount(); i++) {
                String user_id = allUsersSaved.getString(0);
                String remote_id = allUsersSaved.getString(22);
                gender = allUsersSaved.getString(3);
                reality_counter++;

            }

        }
        return (gender.equalsIgnoreCase("")) ? false : true;
    }

    public boolean findIfUserCreated_stage_add_feat_finished() {
        String how_attractive = "";
        int reality_counter = 0;
        Cursor allUsersSaved = thDb.GET_USER_DATA();
        if (allUsersSaved.moveToLast()) {
            for (int i = 0; i < allUsersSaved.getCount(); i++) {
                String user_id = allUsersSaved.getString(0);
                String remote_id = allUsersSaved.getString(22);
                how_attractive = allUsersSaved.getString(12);
                reality_counter++;

            }

        }
        return (how_attractive.equalsIgnoreCase("")) ? false : true;
    }

    public boolean findIfUserCreated_stage_email_added() {
        String phone = "";
        int reality_counter = 0;
        Cursor allUsersSaved = thDb.GET_USER_DATA();
        if (allUsersSaved.moveToLast()) {
            for (int i = 0; i < allUsersSaved.getCount(); i++) {
                String user_id = allUsersSaved.getString(0);
                String remote_id = allUsersSaved.getString(22);
                phone = allUsersSaved.getString(23);
                reality_counter++;

            }

        }
        return (phone.equalsIgnoreCase("")) ? false : true;
    }

    public boolean findIfThereIsCompleteAccount() {
        String theOnStatus = "";
        int reality_counter = 0;
        Cursor allUsersSaved = thDb.GET_USER_ACCOUNT_DATA();
        if (allUsersSaved.moveToFirst()) {
            for (int i = 0; i < allUsersSaved.getCount(); i++) {

                theOnStatus = allUsersSaved.getString(0);

                reality_counter++;

            }

        }

        return (theOnStatus.equalsIgnoreCase("on")) ? true : false;
    }

    public boolean findIfSocialMediaWasUsed() {
        String theOnStatus = "";
        int reality_counter = 0;
        Cursor allUsersSaved = thDb.GET_USER_DATA();
        if (allUsersSaved.moveToLast()) {
            for (int i = 0; i < allUsersSaved.getCount(); i++) {

                theOnStatus = allUsersSaved.getString(13);

                reality_counter++;

            }

        }
        return (theOnStatus.equalsIgnoreCase("normal_means")) ? false : true;
    }
}
