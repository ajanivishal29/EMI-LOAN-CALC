package com.silent.Vignasdk.vorbatility.paniALLDS;

import static com.silent.Vignasdk.vorbatility.PanichaMV9.champaneriya_go;
import static com.silent.Vignasdk.vorbatility.PanichaMV9.ivorycallback;

import android.app.Activity;
import android.os.SystemClock;
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

public class PanichaInter extends PanichaSplashInter {

    public static InterstitialAd mInterstitialAd1;
    public static AdRequest adAtreauest;
    public static com.facebook.ads.InterstitialAd FB_interstitialAd1;
    public static int anInterCount = 0;
    public static com.facebook.ads.InterstitialAd FB_interstitialAd2;
    public static InterstitialAd backInterstitialAd;
    public static AdRequest exiadRequest;
    public static int anExitIntCount = 0;
    public static long mLastClickTime = 0;

    //TODO:load inter ad and show
    public static void loadATfacebookInt(Activity activity) {
        String placementId = getATInterInt(PanichaApp.preferences.getString(PanichaApp.bikky_interstialid, ""));
        final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, placementId);
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                Log.d("PANICHAHA", "FB Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                Log.d("PANICHAHA", "FB Inter ad Close.");
                if (ivorycallback != null) {
                    ivorycallback.onTasknext();
                }

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("PANICHAHA", "FB Inter Failed");
            }

            @Override
            public void onAdLoaded(Ad ad) {
                FB_interstitialAd1 = FB_interstitial;
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
        anInterCount++;
    }

    public static void loadATinterAdmob(Activity activity) {
        String placementId = getATInterInt(PanichaApp.preferences.getString(PanichaApp.bikky_interstialid, ""));
        adAtreauest = new AdRequest.Builder().build();
        InterstitialAd.load(activity, placementId, adAtreauest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                Log.d("PANICHAHA", "Admob Inter Loaded");
                mInterstitialAd1 = interstitialAd;
                interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent();
                        Log.d("PANICHAHA", "Admob Inter Close");
                        if (ivorycallback != null) {
                            ivorycallback.onTasknext();
                        }
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
        anInterCount++;
    }

    public static String getATInterInt(String adsid) {
        String[] interadid = adsid.split("&");
        if (anInterCount == interadid.length || anInterCount > interadid.length) {
            anInterCount = 0;
        }
        return interadid[anInterCount];
    }

    public static void dis_ATinter(Activity activity, Ivorycallback showInter1) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        ivorycallback = showInter1;
        if (PanichaApp.preferences.getString(PanichaApp.bikky_interadsT, "").equalsIgnoreCase("admob")) {
            int interCounter = SharedPreference.getInstance(activity).getNumberOfClicks();
            if (interCounter == PanichaApp.preferences.getInt(PanichaApp.int_count, 1) && mInterstitialAd1 != null) {
                SharedPreference.getInstance(activity).storeClicks(1);
                mInterstitialAd1.show(activity);
                loadATinterAdmob(activity);
            } else {
                interCounter = interCounter + 1;
                SharedPreference.getInstance(activity).storeClicks(interCounter);
                if (ivorycallback != null) {
                    ivorycallback.onTasknext();
                }
            }

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_interadsT, "").equalsIgnoreCase("fb")) {
            int interCounter = SharedPreference.getInstance(activity).getNumberOfClicks();
            if (interCounter == PanichaApp.preferences.getInt(PanichaApp.int_count, 1) && FB_interstitialAd1 != null) {
                SharedPreference.getInstance(activity).storeClicks(1);
                FB_interstitialAd1.show();
                loadATfacebookInt(activity);
            } else {
                interCounter = interCounter + 1;
                SharedPreference.getInstance(activity).storeClicks(interCounter);
                if (ivorycallback != null) {
                    ivorycallback.onTasknext();
                }
            }

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_interadsT, "").equalsIgnoreCase("qureka")) {
            int interCounter = SharedPreference.getInstance(activity).getNumberOfClicks();
            if (interCounter == PanichaApp.preferences.getInt(PanichaApp.int_count, 1)) {
                SharedPreference.getInstance(activity).storeClicks(1);
                if (ivorycallback != null) {
                    ivorycallback.onTasknext();
                }
                champaneriya_go(activity);
                if (PanichaApp.preferences.getString(PanichaApp.bikky_2Tqureka, "").equalsIgnoreCase("on")) {
                    champaneriya_go(activity);
                }
            } else {
                interCounter = interCounter + 1;
                SharedPreference.getInstance(activity).storeClicks(interCounter);
                if (ivorycallback != null) {
                    ivorycallback.onTasknext();
                }
            }

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_interadsT, "").equalsIgnoreCase("off")) {
            if (ivorycallback != null) {
                ivorycallback.onTasknext();
            }
        }

    }

    public static String getEcitInterInt(String adsid) {
        String[] interadid = adsid.split("&");
        if (anExitIntCount == interadid.length || anExitIntCount > interadid.length) {
            anExitIntCount = 0;
        }
        return interadid[anExitIntCount];
    }
    //TODO:load back inter

    public static void loadexitfb(Activity activity) {
        String placementId = getEcitInterInt(PanichaApp.preferences.getString(PanichaApp.bikky_exit_interid, ""));
        final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, placementId);
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                Log.d("CricApp123", "FB Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                Log.d("CricApp123", "FB Inter ad Close.");
                if (ivorycallback != null) {
                    ivorycallback.onTasknext();
                }

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("CricApp123", "FB Inter Failed");

            }

            @Override
            public void onAdLoaded(Ad ad) {
                FB_interstitialAd2 = FB_interstitial;
                Log.d("CricApp123", "FB Inter ad Loaded");
            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("CricApp123", "FB Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                Log.d("CricApp123", "FB Interstitial ad impression logged!");
            }
        };
        FB_interstitial.loadAd(FB_interstitial.buildLoadAdConfig().withAdListener(interstitialAdListener).build());
        anExitIntCount++;
    }

    public static void loadexitinterAdmob(Activity activity) {

        String placementId = getEcitInterInt(PanichaApp.preferences.getString(PanichaApp.bikky_exit_interid, ""));
        exiadRequest = new AdRequest.Builder().build();
        InterstitialAd.load(activity, placementId, exiadRequest, new InterstitialAdLoadCallback() {
            @Override
            public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                Log.d("CricApp123", "Admob Inter Loaded");
                backInterstitialAd = interstitialAd;
                interstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        super.onAdDismissedFullScreenContent();
                        Log.d("CricApp123", "Admob Inter Close");
                        if (ivorycallback != null) {
                            ivorycallback.onTasknext();
                        }

                    }

                    @Override
                    public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                        Log.d("CricApp123", "Admob Inter failed to show" + adError.getMessage());
                    }

                    @Override
                    public void onAdShowedFullScreenContent() {

                    }
                });
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                Log.d("CricApp123", "Admob Inter Failed");

            }
        });
        anExitIntCount++;
    }

    public static void dis_ATexitinter(Activity activity, Ivorycallback showInter1) {
        ivorycallback = showInter1;
        if (PanichaApp.preferences.getString(PanichaApp.bikky_exit_interT, "").equalsIgnoreCase("admob")) {

            int interCounter = SharedPreference.getInstance(activity).getbackNumberOfClicks();
            if (interCounter == PanichaApp.preferences.getInt(PanichaApp.exit_count, 1) && backInterstitialAd != null) {
                SharedPreference.getInstance(activity).backstoreClicks(1);
                backInterstitialAd.show(activity);
                loadexitinterAdmob(activity);
            } else {
                interCounter = interCounter + 1;
                SharedPreference.getInstance(activity).backstoreClicks(interCounter);
                if (ivorycallback != null) {
                    ivorycallback.onTasknext();
                }
            }

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_exit_interT, "").equalsIgnoreCase("fb")) {
            int interCounter = SharedPreference.getInstance(activity).getbackNumberOfClicks();
            if (interCounter == PanichaApp.preferences.getInt(PanichaApp.exit_count, 1) && FB_interstitialAd2 != null) {
                SharedPreference.getInstance(activity).backstoreClicks(1);
                FB_interstitialAd2.show();
                loadexitfb(activity);
            } else {
                interCounter = interCounter + 1;
                SharedPreference.getInstance(activity).backstoreClicks(interCounter);
                if (ivorycallback != null) {
                    ivorycallback.onTasknext();
                }
            }

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_exit_interT, "").equalsIgnoreCase("qureka")) {
            int interCounter = SharedPreference.getInstance(activity).getbackNumberOfClicks();
            if (interCounter == PanichaApp.preferences.getInt(PanichaApp.exit_count, 1)) {
                SharedPreference.getInstance(activity).backstoreClicks(1);
                if (ivorycallback != null) {
                    ivorycallback.onTasknext();
                }
                champaneriya_go(activity);
                if (PanichaApp.preferences.getString(PanichaApp.bikky_2Tqureka, "").equalsIgnoreCase("on")) {
                    champaneriya_go(activity);
                }
            } else {
                interCounter = interCounter + 1;
                SharedPreference.getInstance(activity).backstoreClicks(interCounter);
                if (ivorycallback != null) {
                    ivorycallback.onTasknext();
                }
            }

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_exit_interT, "").equalsIgnoreCase("off")) {
            if (ivorycallback != null) {
                ivorycallback.onTasknext();
            }
        }
    }

    public interface Ivorycallback {
        void onTasknext();
    }
}
