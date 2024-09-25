package com.silent.Vignasdk.vorbatility.paniALLDS;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdListener;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.financecalculator.emicalcutator.meghachem.R;
import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.PanichaMV9;

import java.util.ArrayList;
import java.util.List;

public class PanichaNative extends PanichaSmallNative {
    public static int an_nativecount = 0;
    public static ArrayList<NativeAd> ad_nativeAd = new ArrayList<>();
    public static ArrayList<com.facebook.ads.NativeAd> fb_nativeAd = new ArrayList<>();

    //TODO:load static native ads
    public static String getATnativeInt(String adsid) {
        String[] nativeadid = adsid.split("&");
        if (an_nativecount == nativeadid.length || an_nativecount > nativeadid.length) {
            an_nativecount = 0;
        }
        return nativeadid[an_nativecount];
    }

    public static void dis_ATnative(Activity activity, RelativeLayout frameLayout_Native) {
        if (PanichaApp.preferences.getString(PanichaApp.bikky_natadsT, "").equalsIgnoreCase("admob")) {
            if (ad_nativeAd.size() > 0) {
                dis_ATadmobnative(activity, frameLayout_Native);
                load_ATadmobnative(activity);
            } else if (fb_nativeAd.size() > 0) {
                dis_fbnative(activity, frameLayout_Native);
                load_ATadmobnative(activity);
            } else {
                load_stATadmobnative(frameLayout_Native, activity);
            }
        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_natadsT, "").equalsIgnoreCase("fb")) {
            if (fb_nativeAd.size() > 0) {
                dis_fbnative(activity, frameLayout_Native);
                load_fbnative(activity);
            } else if (ad_nativeAd.size() > 0) {
                dis_ATadmobnative(activity, frameLayout_Native);
                load_fbnative(activity);
            } else {
                load_stAtfbnative(frameLayout_Native, activity);
            }
        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_natadsT, "").equalsIgnoreCase("qureka")) {
            PanichaMV9.dis_qnative(activity, frameLayout_Native);
        }
    }

    public static void load_ATadmobnative(Activity activity) {
        String placementId = getATnativeInt(PanichaApp.preferences.getString(PanichaApp.bikky_nativeid, ""));
        new AdLoader.Builder(activity, placementId).forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                Log.d("PANICHAHA", "Admob native ad load");
                if (ad_nativeAd.size() > 0) {
                    ad_nativeAd.clear();
                }
                ad_nativeAd.add(nativeAd);
            }
        }).withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.d("PANICHAHA", "Admob native ad failed");
                Log.e("Error : ", loadAdError.getMessage());
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build().loadAd(new AdRequest.Builder().build());
        an_nativecount++;
    }

    public static void load_stATadmobnative(RelativeLayout frameLayout_Native, Activity activity) {
        String placementId = getATnativeInt(PanichaApp.preferences.getString(PanichaApp.bikky_nativeid, ""));
        new AdLoader.Builder(activity, placementId).forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.admob_native_ads, (ViewGroup) null);
                populateadmobnative(nativeAd, nativeAdView);
                frameLayout_Native.removeAllViews();
                frameLayout_Native.addView(nativeAdView);
            }
        }).withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e("Error : ", loadAdError.getMessage());
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build().loadAd(new AdRequest.Builder().build());
        an_nativecount++;
    }

    public static void dis_ATadmobnative(Activity activity, RelativeLayout frameLayout_Native) {
        NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.admob_native_ads, (ViewGroup) null);
        populateadmobnative(ad_nativeAd.get(0), nativeAdView);
        frameLayout_Native.removeAllViews();
        frameLayout_Native.addView(nativeAdView);
    }

    private static void populateadmobnative(NativeAd nativeAd, NativeAdView adView) {
        adView.setMediaView((MediaView) adView.findViewById(
                R.id.ad_media));
        adView.setHeadlineView(adView.findViewById(R.id.ad_headline));
        adView.setBodyView(adView.findViewById(R.id.ad_body));
        adView.setCallToActionView((TextView) adView.findViewById(R.id.ad_call_to_action));
        adView.setIconView(adView.findViewById(R.id.ad_app_icon));

        ((TextView) adView.getHeadlineView()).setText(nativeAd.getHeadline());
        if (nativeAd.getBody() == null) {
            adView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            adView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) adView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            adView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            adView.getCallToActionView().setVisibility(View.VISIBLE);
            ((TextView) adView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }
        if (nativeAd.getIcon() == null) {
            adView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) adView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            adView.getIconView().setVisibility(View.VISIBLE);
        }
        adView.setNativeAd(nativeAd);
    }

    public static void load_fbnative(Activity activity) {
        String placementId = getATnativeInt(PanichaApp.preferences.getString(PanichaApp.bikky_nativeid, ""));
        final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, placementId);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                // Native ad finished downloading all assets
                Log.d("PANICHAHA", "Native ad finished downloading all assets.");
            }

            @SuppressLint("MissingPermission")
            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("PANICHAHA", "Native ad Failed " + adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("PANICHAHA", "Native ad is loaded and ready to be displayed!");
                if (fb_nativeAd.size() > 0) {
                    fb_nativeAd.clear();
                }
                fb_nativeAd.add(fbnative_Ad);

            }

            @Override
            public void onAdClicked(Ad ad) {
                Log.d("PANICHAHA", "Native ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {

                Log.d("PANICHAHA", "Native ad impression logged!");
            }
        };

        fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
        an_nativecount++;
    }

    public static void load_stAtfbnative(RelativeLayout frameLayout_Native, Activity activity) {
        String placementId = getATnativeInt(PanichaApp.preferences.getString(PanichaApp.bikky_nativeid, ""));
        final com.facebook.ads.NativeAd fbnative_Ad = new com.facebook.ads.NativeAd(activity, placementId);
        NativeAdListener nativeAdListener = new NativeAdListener() {
            @Override
            public void onMediaDownloaded(Ad ad) {
                // Native ad finished downloading all assets
                Log.d("PANICHAHA", "Native ad finished downloading all assets.");
            }

            @SuppressLint("MissingPermission")
            @Override
            public void onError(Ad ad, AdError adError) {
                Log.d("PANICHAHA", "Native ad Failed " + adError.getErrorMessage());

            }

            @Override
            public void onAdLoaded(Ad ad) {
                Log.d("PANICHAHA", "Native ad is loaded and ready to be displayed!");
                populateFBNative(fbnative_Ad, frameLayout_Native, activity);
            }

            @Override
            public void onAdClicked(Ad ad) {

                Log.d("PANICHAHA", "Native ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {

                Log.d("PANICHAHA", "Native ad impression logged!");
            }
        };

        fbnative_Ad.loadAd(fbnative_Ad.buildLoadAdConfig().withAdListener(nativeAdListener).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).build());
        an_nativecount++;
    }

    public static void dis_fbnative(Activity activity, RelativeLayout frameLayout_Native) {
        populateFBNative(fb_nativeAd.get(0), frameLayout_Native, activity);
    }

    public static void populateFBNative(com.facebook.ads.NativeAd nativeAd, RelativeLayout frameLayout_Native, Activity activity) {

        nativeAd.unregisterView();

        // Inflate the Ad view.
        NativeAdLayout nativeAdLayout = (NativeAdLayout) LayoutInflater.from(activity).inflate(R.layout.fb_nativeads, null);
        // adding vie
        frameLayout_Native.addView(nativeAdLayout);

        // Add the AdOptionsView
        LinearLayout adChoicesContainer = nativeAdLayout.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        com.facebook.ads.MediaView nativeAdMedia = nativeAdLayout.findViewById(R.id.native_ad_media);
        ImageView nativeAdIcon = nativeAdLayout.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = nativeAdLayout.findViewById(R.id.native_ad_title);
        TextView nativeAdSocialContext = nativeAdLayout.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = nativeAdLayout.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = nativeAdLayout.findViewById(R.id.native_ad_sponsored_label);
        TextView nativeAdCallToAction = nativeAdLayout.findViewById(R.id.native_ad_call_to_action);

        // Set the Text.
        nativeAdTitle.setText(nativeAd.getAdvertiserName());
        nativeAdBody.setText(nativeAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
        sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

        // Create a list of clickable views
        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);

        // Register the Title and CTA button to listen for clicks.
        nativeAd.registerViewForInteraction(nativeAdLayout, nativeAdMedia, nativeAdIcon, clickableViews);
    }

}
