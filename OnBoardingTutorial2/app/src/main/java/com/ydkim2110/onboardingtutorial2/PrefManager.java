package com.ydkim2110.onboardingtutorial2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Kim Yongdae on 2018-12-05
 * email : ydkim2110@gmail.com
 *
 * The welcome / intro slider should be shown only once when the app is launched for the very first time.
 * If the user launches the app on second time, he should directly go to main screen.
 * To achieve this, we use SharedPreferences to store a boolean value indicating first time launch.
 */
public class PrefManager {

    private static final String TAG = "PrefManager";

    private SharedPreferences mPref;
    private SharedPreferences.Editor mEditor;
    private Context mContext;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "android-welcome";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";

    public PrefManager(Context context) {
        mContext = context;
        mPref = mContext.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        mEditor = mPref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        mEditor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        mEditor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return mPref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

}
