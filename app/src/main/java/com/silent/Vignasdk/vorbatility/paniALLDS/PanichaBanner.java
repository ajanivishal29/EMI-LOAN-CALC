package com.silent.Vignasdk.vorbatility.paniALLDS;

import static com.silent.Vignasdk.vorbatility.PanichaMV9.dis_qbanner;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.silent.Vignasdk.vorbatility.PanichaApp;

public class PanichaBanner {
    public static int anBannerCount = 0;
    public static AdView ad_bannerAd = null;
    public static com.facebook.ads.AdView fb_bannnerAd = null;

    public static String getATbannerInt(String adsid) {
        String[] banneradid = adsid.split("&");
        if (anBannerCount == banneradid.length || anBannerCount > banneradid.length) {
            anBannerCount = 0;
        }
        return banneradid[anBannerCount];
    }

    public static void disATbanner(Activity activity, RelativeLayout frameLayout_Native) {
        if (PanichaApp.preferences.getString(PanichaApp.bikky_banneradsT, "").equalsIgnoreCase("admob")) {
            load_stATbannerAdmob(activity, frameLayout_Native);

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_banneradsT, "").equalsIgnoreCase("fb")) {
            load_stATbannerfb(activity, frameLayout_Native);

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_banneradsT, "").equalsIgnoreCase("qureka")) {
            dis_qbanner(activity, frameLayout_Native);
        }
    }

    public static void load_ATbannerAdmob(Activity activity) {
        String placementId = getATbannerInt(PanichaApp.preferences.getString(PanichaApp.bikky_bannerid, ""));

        final AdView admob_Banner = new AdView(activity);
//        admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
        AdSize adSize = getAdSize(activity);
        admob_Banner.setAdSize(adSize);
        admob_Banner.setAdUnitId(placementId);
        AdRequest adRequest = new AdRequest.Builder().build();
        admob_Banner.loadAd(adRequest);
        admob_Banner.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.d("PANICHAHA", "Admob banner ad failed");
            }

            @Override
            public void onAdLoaded() {
                Log.d("PANICHAHA", "Admob banner ad load");
                ad_bannerAd = admob_Banner;

            }
        });
    }

    public static void load_stATbannerAdmob(Activity activity, RelativeLayout adLinLay) {
        String placementId = getATbannerInt(PanichaApp.preferences.getString(PanichaApp.bikky_bannerid, ""));

        final AdView admob_Banner = new AdView(activity);
//        admob_Banner.setAdSize(AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, AdSize.FULL_WIDTH));
        AdSize adSize = getAdSize(activity);
        admob_Banner.setAdSize(adSize);
        admob_Banner.setAdUnitId(placementId);

        AdRequest adRequest = new AdRequest.Builder().build();
        admob_Banner.loadAd(adRequest);
        admob_Banner.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                super.onAdFailedToLoad(loadAdError);
                Log.d("PANICHAHA", "Admob banner ad failed");
            }

            @Override
            public void onAdLoaded() {
                Log.d("PANICHAHA", "Admob banner ad load");
                if (admob_Banner != null) {
                    adLinLay.addView(admob_Banner);
                }

            }
        });
    }

    public static void show_ATadmobbannner(RelativeLayout adLinLay) {
        if (ad_bannerAd != null) {
            adLinLay.removeAllViews();
            adLinLay.addView(ad_bannerAd);
            ad_bannerAd = null;
        }

    }

    private static AdSize getAdSize(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);
        float widthPixels = outMetrics.widthPixels;
        float density = outMetrics.density;
        int adWidth = (int) (widthPixels / density);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(activity, adWidth);
    }


    public static void load_ATbannerfb(Activity activity) {
        String placementId = getATbannerInt(PanichaApp.preferences.getString(PanichaApp.bikky_bannerid, ""));
        final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, placementId, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("PANICHAHA", "Fb Banner Loadedd");
                if (fb_banner != null) {
                    fb_bannnerAd = fb_banner;
                }

            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("PANICHAHA", "FB Banner Failed");
            }

            @Override
            public void onAdClicked(Ad ad) {
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
    }

    public static void load_stATbannerfb(Activity activity, RelativeLayout adLinLay) {
        String placementId = getATbannerInt(PanichaApp.preferences.getString(PanichaApp.bikky_bannerid, ""));
        final com.facebook.ads.AdView fb_banner = new com.facebook.ads.AdView(activity, placementId, com.facebook.ads.AdSize.BANNER_HEIGHT_50);
        com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("PANICHAHA", "Fb Banner Loadedd");
                if (fb_banner != null) {
                    adLinLay.removeAllViews();
                    adLinLay.addView(fb_banner);
                }
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("PANICHAHA", "FB Banner Failed");
            }

            @Override
            public void onAdClicked(Ad ad) {
            }

            @Override
            public void onLoggingImpression(Ad ad) {
            }
        };
        fb_banner.loadAd(fb_banner.buildLoadAdConfig().withAdListener(adListener).build());
    }

    public static void show_bannerfb(RelativeLayout adLinLay) {
        if (fb_bannnerAd != null) {
            adLinLay.addView(fb_bannnerAd);
            fb_bannnerAd = null;
        }
    }

}
