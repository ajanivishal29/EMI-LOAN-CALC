package com.silent.Vignasdk.vorbatility;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.browser.customtabs.CustomTabsIntent;
import androidx.cardview.widget.CardView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.financecalculator.emicalcutator.meghachem.dobarman.DobarmanTOOLM;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.appopen.AppOpenAd;
import com.financecalculator.emicalcutator.meghachem.R;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;

import java.util.List;
import java.util.Random;

public class PanichaMV9 extends PanichaInter {
    public static Ivorycallback ivorycallback;

    public static void DiaplayAppopen(Activity activity) {
        try {
            AppOpenAd.AppOpenAdLoadCallback loadCallback = new AppOpenAd.AppOpenAdLoadCallback() {
                public void onAdLoaded(AppOpenAd appOpenAd) {
                    Log.d("PANICHAHA", "load ");
                    appOpenAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        public void onAdShowedFullScreenContent() {
                        }

                        public void onAdDismissedFullScreenContent() {
                            onnext(activity);
                        }

                        public void onAdFailedToShowFullScreenContent(com.google.android.gms.ads.AdError adError) {
                            onnext(activity);
                        }
                    });
                    appOpenAd.show(activity);
                }

                public void onAdFailedToLoad(LoadAdError loadAdError) {
                    Log.d("PANICHAHA", "failed " + loadAdError.getResponseInfo());
                    onnext(activity);
                }
            };
            AppOpenAd.load(activity, PanichaApp.preferences.getString(PanichaApp.bikky_start_appopen, ""), new AdRequest.Builder().build(), 1, loadCallback);
        } catch (Exception unused) {
            onnext(activity);

        }
    }

    public static void onnext(Activity activity) {
        activity.startActivity(new Intent(activity, DobarmanTOOLM.class));
        activity.finish();
    }

    public static void DisplaySplashFBInter(Activity activity) {
        final com.facebook.ads.InterstitialAd FB_interstitial = new com.facebook.ads.InterstitialAd(activity, PanichaApp.preferences.getString(PanichaApp.bikky_start_appopen, ""));
        InterstitialAdListener interstitialAdListener = new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                Log.d("PANICHAHA", "FB Interstitial ad displayed.");
            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                Log.d("PANICHAHA", "FB Inter ad Close.");
                onnext(activity);
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("PANICHAHA", "FB Inter Failed" + adError.getErrorMessage());
                onnext(activity);
            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("PANICHAHA", "FB Inter ad Loaded");
                FB_interstitial.show();
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

    public static void loadsplashinter(Activity activity) {
        if (PanichaApp.preferences.getString(PanichaApp.bikky_SplashinteradsT, "").equalsIgnoreCase("admob")) {
            loadATinterAdmobSplash(activity);
        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_SplashinteradsT, "").equalsIgnoreCase("fb")) {
            loadATfacebookIntSplash(activity);
        }
    }

    public static void loadAllATADS(Activity activity) {
        if (PanichaApp.preferences.getString(PanichaApp.bikky_interadsT, "").equalsIgnoreCase("admob")) {
            loadATinterAdmob(activity);
        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_interadsT, "").equalsIgnoreCase("fb")) {
            loadATfacebookInt(activity);
        }

        if (PanichaApp.preferences.getString(PanichaApp.bikky_natadsT, "").equalsIgnoreCase("admob")) {
            load_ATadmobnative(activity);
        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_natadsT, "").equalsIgnoreCase("fb")) {
            load_fbnative(activity);
        }

        if (PanichaApp.preferences.getString(PanichaApp.bikky_natbannerT, "").equalsIgnoreCase("admob")) {
            load_adsmallnative(activity);
        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_natbannerT, "").equalsIgnoreCase("fb")) {
            load_fbsmallnative(activity);
        }
        if (PanichaApp.preferences.getString(PanichaApp.bikky_banneradsT, "").equalsIgnoreCase("admob")) {
            load_ATbannerAdmob(activity);
        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_banneradsT, "").equalsIgnoreCase("fb")) {
            load_ATbannerfb(activity);
        }

        if (PanichaApp.preferences.getString(PanichaApp.bikky_exit_interT, "").equalsIgnoreCase("admob")) {
            loadexitinterAdmob(activity);
        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_exit_interT, "").equalsIgnoreCase("fb")) {
            loadexitfb(activity);
        }
    }

    public static void dis_qbanner(final Activity activity, RelativeLayout frameLayout) {
        frameLayout.removeAllViews();
        frameLayout.addView((RelativeLayout) activity.getLayoutInflater().inflate(R.layout.q_banner, (ViewGroup) null));
        ((ImageView) frameLayout.findViewById(R.id.rm_bnr)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    builder.setToolbarColor(activity.getColor(R.color.green)).setShowTitle(true);
                    CustomTabsIntent build = builder.build();
                    build.intent.setPackage("com.android.chrome");
                    build.launchUrl(activity, Uri.parse(PanichaApp.preferences.getString(PanichaApp.bikky_qureka_url, "")));

                } catch (Exception unused) {
                }
            }
        });
    }

    public static void champaneriya_go(Context context2) {
        List<ResolveInfo> list;
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setShowTitle(true);
        CustomTabsIntent build = builder.build();
        Intent data = new Intent().setAction("android.intent.action.VIEW").addCategory("android.intent.category.BROWSABLE").setType("text/plain").setData(Uri.fromParts("http", "", (String) null));
        if (Build.VERSION.SDK_INT >= 23) {
            list = context2.getPackageManager().queryIntentActivities(data, 65536);
            if (list.size() == 0) {
                list = context2.getPackageManager().queryIntentActivities(data, 131072);
            }
        } else {
            list = context2.getPackageManager().queryIntentActivities(data, 65536);
        }
        try {
            if (list.size() > 0) {
                build.intent.setPackage(list.get(0).activityInfo.packageName);
                build.launchUrl(context2, Uri.parse(PanichaApp.preferences.getString(PanichaApp.bikky_qureka_url, "")));
                return;
            }
            context2.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(PanichaApp.preferences.getString(PanichaApp.bikky_qureka_url, ""))));
        } catch (ActivityNotFoundException e) {
            Log.d("TAG", e.getMessage());
        }
    }


    public static void dis_qnative(final Activity activity, RelativeLayout frameLayout) {
        RelativeLayout frameLayout2 = (RelativeLayout) activity.getLayoutInflater().inflate(R.layout.q_nativead, (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(frameLayout2);
        ((ImageView) frameLayout2.findViewById(R.id.native_img)).setImageResource(new int[]{R.drawable.nat1, R.drawable.nat2, R.drawable.nat3, R.drawable.nat4, R.drawable.nat5}[new Random().nextInt(5)]);
        ((CardView) frameLayout.findViewById(R.id.rm_nv1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    builder.setToolbarColor(activity.getColor(R.color.green)).setShowTitle(true);
                    CustomTabsIntent build = builder.build();
                    build.intent.setPackage("com.android.chrome");
                    build.launchUrl(activity, Uri.parse(PanichaApp.preferences.getString(PanichaApp.bikky_qureka_url, "")));

                } catch (Exception unused) {
                }
            }
        });
    }

    public static void dis_nativebanner(final Activity activity, RelativeLayout frameLayout) {
        RelativeLayout frameLayout2 = (RelativeLayout) activity.getLayoutInflater().inflate(R.layout.q_nativebannerad, (ViewGroup) null);
        frameLayout.removeAllViews();
        frameLayout.addView(frameLayout2);
        ((ImageView) frameLayout2.findViewById(R.id.native_img)).setImageResource(new int[]{R.drawable.natban1, R.drawable.natban2, R.drawable.natban3, R.drawable.natban4, R.drawable.natban5}[new Random().nextInt(5)]);
        ((CardView) frameLayout.findViewById(R.id.rm_nv1)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
                    builder.setToolbarColor(activity.getColor(R.color.green)).setShowTitle(true);
                    CustomTabsIntent build = builder.build();
                    build.intent.setPackage("com.android.chrome");
                    build.launchUrl(activity, Uri.parse(PanichaApp.preferences.getString(PanichaApp.bikky_qureka_url, "")));

                } catch (Exception unused) {
                }
            }
        });
    }

}
