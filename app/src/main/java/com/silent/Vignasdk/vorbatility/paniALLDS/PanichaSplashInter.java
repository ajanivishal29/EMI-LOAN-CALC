package com.silent.Vignasdk.vorbatility.paniALLDS;

import static com.silent.Vignasdk.vorbatility.PanichaMV9.champaneriya_go;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.SharedPreference;

public class PanichaSplashInter extends PanichaNative {

    public static InterstitialAd mInterstitialAd1splash;
    public static AdRequest adAtreauest;
    public static com.facebook.ads.InterstitialAd FB_interstitialAd1splash;

    //TODO:load inter ad and show
    public static void loadATfacebookIntSplash(Activity activity) {
        String placementId = PanichaApp.preferences.getString(PanichaApp.bikky_splashinterstialid, "");
        final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, placementId);
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                Log.d("PANICHAHA", "FB Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                Log.d("PANICHAHA", "FB Inter ad Close.");


            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("PANICHAHA", "FB Inter Failed");
            }

            @Override
            public void onAdLoaded(Ad ad) {
                FB_interstitialAd1splash = FB_interstitial;
                Log.d("PANICHAHA", "FB Inter ad Loaded");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("PANICHAHA", "FB Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d("PANICHAHA", "FB Interstitial ad impression logged!");
            }
        };
        FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
    }

    public static void loadATinterAdmobSplash(Activity activity) {
        String placementId = PanichaApp.preferences.getString(PanichaApp.bikky_splashinterstialid, "");
        adAtreauest = new AdRequest.Builder().build();
        InterstitialAd.load(activity, placementId, adAtreauest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                Log.d("PANICHAHA", "Admob Inter Loaded");
                mInterstitialAd1splash = interstitialAd;
                interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent();
                        Log.d("PANICHAHA", "Admob Inter Close");
                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        Log.d("PANICHAHA", "Admob Inter failed to show" + adError.getMessage());
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

                    }
                });
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                Log.d("PANICHAHA", "Admob Inter Failed");
            }
        });
    }


    public static void dis_ATinterSplash(Activity activity) {
        if (PanichaApp.preferences.getString(PanichaApp.bikky_SplashinteradsT, "").equalsIgnoreCase("admob")) {
            if (mInterstitialAd1splash != null) {
                SharedPreference.getInstance(activity).storeClicks(1);
                mInterstitialAd1splash.show(activity);
                loadATinterAdmobSplash(activity);
            }

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_SplashinteradsT, "").equalsIgnoreCase("fb")) {
            if (FB_interstitialAd1splash != null) {
                SharedPreference.getInstance(activity).storeClicks(1);
                FB_interstitialAd1splash.show();
                loadATfacebookIntSplash(activity);
            }

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_SplashinteradsT, "").equalsIgnoreCase("qureka")) {
            champaneriya_go(activity);
            if (PanichaApp.preferences.getString(PanichaApp.bikky_2Tqureka, "").equalsIgnoreCase("on")) {
                champaneriya_go(activity);
            }


        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_SplashinteradsT, "").equalsIgnoreCase("off")) {

        }
    }

}
