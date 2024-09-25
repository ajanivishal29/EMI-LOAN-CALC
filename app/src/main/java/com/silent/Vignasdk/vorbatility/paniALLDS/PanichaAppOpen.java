package com.silent.Vignasdk.vorbatility.paniALLDS;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.silent.Vignasdk.vorbatility.PanichaApp;

import java.util.Date;

public class PanichaAppOpen implements LifecycleObserver, Application.ActivityLifecycleCallbacks {
    private static final String LOG_TAG = "TAGAppOpen";
    public static boolean isShowingAd = false;

    public AppOpenAd appOpenAd = null;
    public long loadTime = 0;
    private Activity currentActivity;
    private AppOpenAd.AppOpenAdLoadCallback loadCallback;
    private PanichaApp myApplication;

    public PanichaAppOpen(PanichaApp loanTime_AppClass) {
        this.myApplication = loanTime_AppClass;
        loanTime_AppClass.registerActivityLifecycleCallbacks(this);
        ProcessLifecycleOwner.get().getLifecycle().addObserver(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public void onActivityPaused(Activity activity) {
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public void onActivityStopped(Activity activity) {
    }

    public void showAdIfAvailable() {
        if (isShowingAd || !isAdAvailable()) {
            Log.d(LOG_TAG, "Can not show ad.");
            fetchAd();
            return;
        }
        Log.d(LOG_TAG, "Will show ad.");
        this.appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
            public void onAdFailedToShowFullScreenContent(AdError adError) {
            }

            public void onAdDismissedFullScreenContent() {
                PanichaAppOpen.this.appOpenAd = null;
                PanichaAppOpen.isShowingAd = false;
                PanichaAppOpen.this.fetchAd();
            }

            public void onAdShowedFullScreenContent() {
                boolean unused = PanichaAppOpen.isShowingAd = true;
            }
        });
        this.appOpenAd.show(this.currentActivity);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        showAdIfAvailable();
        Log.d(LOG_TAG, "onStart");
    }

    public void fetchAd() {
        if (!isAdAvailable()) {
            this.loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(AppOpenAd appOpenAd) {
                    super.onAdLoaded(appOpenAd);
                    PanichaAppOpen.this.appOpenAd = appOpenAd;
                    PanichaAppOpen.this.loadTime = new Date().getTime();
                }

                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    Log.d(PanichaAppOpen.LOG_TAG, "failed to load");
                }
            };
            AppOpenAd.load((Context) this.myApplication, PanichaApp._sharedPRefrences.getString(PanichaApp.app_open, ""), getAdRequest(), 1, this.loadCallback);
        }
    }

    private AdRequest getAdRequest() {
        return new AdRequest.Builder().build();
    }

    private boolean wasLoadTimeLessThanNHoursAgo(long j) {
        return new Date().getTime() - this.loadTime < j * 3600000;
    }

    public boolean isAdAvailable() {
        return this.appOpenAd != null && wasLoadTimeLessThanNHoursAgo(4);
    }

    public void onActivityStarted(Activity activity) {
        this.currentActivity = activity;
    }

    public void onActivityResumed(Activity activity) {
        this.currentActivity = activity;
    }

    public void onActivityDestroyed(Activity activity) {
        this.currentActivity = null;
    }
}
