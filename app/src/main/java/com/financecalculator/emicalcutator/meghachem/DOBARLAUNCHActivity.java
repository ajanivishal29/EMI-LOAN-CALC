package com.financecalculator.emicalcutator.meghachem;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.silent.Vignasdk.vorbatility.SharedPreference;
import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaAppOpen;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.ump.ConsentForm;
import com.google.android.ump.ConsentInformation;
import com.google.android.ump.ConsentRequestParameters;
import com.google.android.ump.UserMessagingPlatform;

import java.util.concurrent.atomic.AtomicBoolean;


public class DOBARLAUNCHActivity extends AppCompatActivity {

    private Activity activity;
    private final AtomicBoolean isMobileAdsInitializeCalled = new AtomicBoolean(false);
    private ConsentInformation consentInformation;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.splash_activity);
        activity = this;
        SharedPreference.getInstance(activity).storeClicks(1);
        SharedPreference.getInstance(activity).backstoreClicks(1);
        try {
            if (PanichaApp.preferences != null) {
                PanichaApp.preferences.edit().clear().commit();
            }
        } catch (Exception e) {

        }

        if (isNetworkConnected()) {
            ConsentRequestParameters params = new ConsentRequestParameters
                    .Builder()
                    .build();
            consentInformation = UserMessagingPlatform.getConsentInformation(this);
            consentInformation.requestConsentInfoUpdate(this, params, (ConsentInformation.OnConsentInfoUpdateSuccessListener) () -> {
                        // TODO: Load and show the consent form.
                        UserMessagingPlatform.loadAndShowConsentFormIfRequired(
                                this,
                                (ConsentForm.OnConsentFormDismissedListener) loadAndShowError -> {
                                    if (loadAndShowError != null) {
                                        // Consent gathering failed.
                                        Log.w(TAG, String.format("%s: %s", loadAndShowError.getErrorCode(), loadAndShowError.getMessage()));
                                    }
                                    if (consentInformation.canRequestAds()) {
                                        initializeMobileAdsSdk();
                                    }
                                }
                        );
                    },
                    (ConsentInformation.OnConsentInfoUpdateFailureListener) requestConsentError -> {
                        // Consent gathering failed.
                        Log.e("Cccccc", "Failed");
                        Log.w(TAG, String.format("%s: %s", requestConsentError.getErrorCode(), requestConsentError.getMessage()));
                    });
            if (consentInformation.canRequestAds()) {
                initializeMobileAdsSdk();
            }
            return;
        }
        try {
            AlertDialog create = new AlertDialog.Builder(this).create();
            create.setTitle("Internet");
            create.setMessage("Internet not available, Cross check your internet connectivity and try again");
            create.setIcon(android.R.drawable.ic_dialog_alert);
            create.setButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent("android.settings.SETTINGS");
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            });
            create.show();
        } catch (Exception e) {
            Log.d("", "Show Dialog: " + e.getMessage());
        }

    }

    private void initializeMobileAdsSdk() {
        if (isMobileAdsInitializeCalled.getAndSet(true)) {
            return;
        }
        // Initialize the Google Mobile Ads SDK.
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {
                Log.e("Cccccc", "cos");
                init();
            }
        });

    }

    public void init() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(3000);
                    runOnUiThread(new Runnable() {
                        public void run() {
                            if (!PanichaApp.preferences.getString(PanichaApp.app_open, "").isEmpty()) {
                                new PanichaAppOpen(PanichaApp.panichaApp).fetchAd();
                            }
                            PanichaMV9.loadsplashinter(activity);
                            if (PanichaApp.preferences.getString(PanichaApp.bikky_startT, "").equalsIgnoreCase("admob")) {
                                PanichaMV9.DiaplayAppopen(activity);
                            } else if (PanichaApp.preferences.getString(PanichaApp.bikky_startT, "").equalsIgnoreCase("fb")) {
                                PanichaMV9.DisplaySplashFBInter(activity);
                            } else if (PanichaApp.preferences.getString(PanichaApp.bikky_startT, "").equalsIgnoreCase("qureka")) {
                                PanichaMV9.onnext(activity);
                                PanichaMV9.champaneriya_go(activity);
                            } else if (PanichaApp.preferences.getString(PanichaApp.bikky_startT, "").equalsIgnoreCase("off")) {
                                PanichaMV9.onnext(activity);
                            }
                        }
                    });
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null && connectivityManager.getActiveNetworkInfo().isConnected();
    }

}