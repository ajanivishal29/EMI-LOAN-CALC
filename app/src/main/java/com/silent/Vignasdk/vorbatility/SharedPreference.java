package com.silent.Vignasdk.vorbatility;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    private static final String APP_PREFS = "intercount";
    private static final String APP_SWIPE = "APP_SWIPE";
    private static final String APP_PREFS1 = "backintercount";
    private static SharedPreference instance;
    private SharedPreferences sharedPrefs, sharedPrefs1;

    private SharedPreference(Context context) {
        sharedPrefs = context.getApplicationContext().getSharedPreferences(APP_PREFS, Context.MODE_PRIVATE);
        sharedPrefs1 = context.getApplicationContext().getSharedPreferences(APP_PREFS1, Context.MODE_PRIVATE);
    }

    public static synchronized SharedPreference getInstance(Context context) {
        if (instance == null)
            instance = new SharedPreference(context);

        return instance;
    }

    public void storeClicks(int count) {

        SharedPreferences.Editor meditor = sharedPrefs.edit();
        meditor.putInt(APP_PREFS, count);
        meditor.apply();
    }

    public int getNumberOfClicks() {
        int clicksNumber = sharedPrefs.getInt(APP_PREFS, 1);
        return clicksNumber;
    }

    public void backstoreClicks(int count) {

        SharedPreferences.Editor meditor = sharedPrefs1.edit();
        meditor.putInt(APP_PREFS1, count);
        meditor.apply();
    }

    public int getbackNumberOfClicks() {
        int clicksNumber = sharedPrefs1.getInt(APP_PREFS1, 1);
        return clicksNumber;
    }

    public void storeSwipepage(boolean count) {

        SharedPreferences.Editor meditor = sharedPrefs.edit();
        meditor.putBoolean(APP_SWIPE, count);
        meditor.apply();
    }

    public boolean getSwipepage() {
        boolean clicksNumber = sharedPrefs.getBoolean(APP_SWIPE, false);
        return clicksNumber;
    }
}
