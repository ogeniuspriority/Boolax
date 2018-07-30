package com.ogeniuspriority.boolax.boolax;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by USER on 1/4/2018.
 */

public class boolax_boos_adapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public boolax_boos_adapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                boolax_boos tab1 = new boolax_boos();
                return tab1;
            case 1:
                boolax_booers tab2 = new boolax_booers();
                return tab2;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
