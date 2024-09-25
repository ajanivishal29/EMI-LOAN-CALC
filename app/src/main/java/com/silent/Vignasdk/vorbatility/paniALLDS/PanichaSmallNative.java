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
import com.facebook.ads.NativeBannerAd;
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

public class PanichaSmallNative extends PanichaBanner {
    public static int annativebannerCount = 0;

    public static ArrayList<NativeAd> ad_smallnativeAd = new ArrayList<>();
    public static ArrayList<NativeBannerAd> fb_smallnativeAd = new ArrayList<>();


    public static String getATnativebannerInt(String adsid) {
        String[] nativeadid = adsid.split("&");
        if (annativebannerCount == nativeadid.length || annativebannerCount > nativeadid.length) {
            annativebannerCount = 0;
        }
        return nativeadid[annativebannerCount];
    }

    //TODO:load smallnative ads
    public static void dis_ATsmallnative(Activity activity, RelativeLayout frameLayout_Native) {
        if (PanichaApp.preferences.getString(PanichaApp.bikky_natbannerT, "").equalsIgnoreCase("admob")) {
            if (ad_smallnativeAd.size() > 0) {
                show_adATsmallnative(activity, frameLayout_Native);
                load_adsmallnative(activity);
            } else if (fb_smallnativeAd.size() > 0) {
                dis_fbsmallnative(activity, frameLayout_Native);
                load_adsmallnative(activity);
            } else {
                load_stATadmobsmallnative(activity, frameLayout_Native);
            }

        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_natbannerT, "").equalsIgnoreCase("fb")) {
            if (fb_smallnativeAd.size() > 0) {
                dis_fbsmallnative(activity, frameLayout_Native);
                load_fbsmallnative(activity);
            } else if (ad_smallnativeAd.size() > 0) {
                show_adATsmallnative(activity, frameLayout_Native);
                load_fbsmallnative(activity);
            } else {
                load_stATFBsmallnative(activity, frameLayout_Native);
            }
        } else if (PanichaApp.preferences.getString(PanichaApp.bikky_natbannerT, "").equalsIgnoreCase("qureka")) {
            PanichaMV9.dis_nativebanner(activity, frameLayout_Native);
        }
    }

    public static void load_adsmallnative(Activity activity) {
        String placementId = getATnativebannerInt(PanichaApp.preferences.getString(PanichaApp.bikky_natbannerid, ""));
        new AdLoader.Builder(activity, placementId).forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                Log.d("PANICHAHA", "Admob small native ad load");
                if (ad_smallnativeAd.size() > 0) {
                    ad_smallnativeAd.clear();
                }
                ad_smallnativeAd.add(nativeAd);

            }
        }).withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e("Error : ", loadAdError.getMessage());
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build().loadAd(new AdRequest.Builder().build());
        annativebannerCount++;
    }

    public static void load_stATadmobsmallnative(Activity activity, RelativeLayout frameLayout_Native) {
        String placementId = getATnativebannerInt(PanichaApp.preferences.getString(PanichaApp.bikky_natbannerid, ""));
        new AdLoader.Builder(activity, placementId).forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
            public void onNativeAdLoaded(NativeAd nativeAd) {
                NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.admob_smallnativeads_layout, (ViewGroup) null);
                populateAdmobSmallNative(nativeAd, nativeAdView);
                if (frameLayout_Native != null) {
                    frameLayout_Native.removeAllViews();
                }
                frameLayout_Native.addView(nativeAdView);
            }
        }).withAdListener(new AdListener() {
            public void onAdFailedToLoad(LoadAdError loadAdError) {
                Log.e("Error : ", loadAdError.getMessage());
            }
        }).withNativeAdOptions(new NativeAdOptions.Builder().build()).build().loadAd(new AdRequest.Builder().build());
        annativebannerCount++;
    }

    public static void show_adATsmallnative(Activity activity, RelativeLayout frameLayout_Native) {
        NativeAdView nativeAdView = (NativeAdView) activity.getLayoutInflater().inflate(R.layout.admob_smallnativeads_layout, (ViewGroup) null);
        populateAdmobSmallNative(ad_smallnativeAd.get(0), nativeAdView);
        if (frameLayout_Native != null) {
            frameLayout_Native.removeAllViews();
        }
        frameLayout_Native.addView(nativeAdView);
    }

    public static void populateAdmobSmallNative(NativeAd nativeAd, NativeAdView nativeAdView) {
        nativeAdView.setMediaView((MediaView) nativeAdView.findViewById(R.id.ad_media));
        nativeAdView.setHeadlineView(nativeAdView.findViewById(R.id.ad_headline));
        nativeAdView.setBodyView(nativeAdView.findViewById(R.id.ad_body));
        nativeAdView.setCallToActionView(nativeAdView.findViewById(R.id.ad_call_to_action));
        ((TextView) nativeAdView.getHeadlineView()).setText(nativeAd.getHeadline());
        nativeAdView.setIconView(nativeAdView.findViewById(R.id.ad_app_icon));

        if (nativeAd.getBody() == null) {
            nativeAdView.getBodyView().setVisibility(View.INVISIBLE);
        } else {
            nativeAdView.getBodyView().setVisibility(View.VISIBLE);
            ((TextView) nativeAdView.getBodyView()).setText(nativeAd.getBody());
        }
        if (nativeAd.getCallToAction() == null) {
            nativeAdView.getCallToActionView().setVisibility(View.INVISIBLE);
        } else {
            nativeAdView.getCallToActionView().setVisibility(View.VISIBLE);
            ((TextView) nativeAdView.getCallToActionView()).setText(nativeAd.getCallToAction());
        }

        if (nativeAd.getIcon() == null) {
            nativeAdView.getIconView().setVisibility(View.GONE);
        } else {
            ((ImageView) nativeAdView.getIconView()).setImageDrawable(nativeAd.getIcon().getDrawable());
            nativeAdView.getIconView().setVisibility(View.VISIBLE);
        }
        nativeAdView.setNativeAd(nativeAd);
    }

    public static void load_stATFBsmallnative(Activity activity, RelativeLayout frameLayout_Native) {
        String placementId = getATnativebannerInt(PanichaApp.preferences.getString(PanichaApp.bikky_natbannerid, ""));

        final NativeBannerAd fbnative_Ad = new NativeBannerAd(activity, placementId);
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
                populateFBsmallNative(fbnative_Ad, frameLayout_Native, activity);
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
        annativebannerCount++;
    }

    public static void load_fbsmallnative(Activity activity) {
        String placementId = getATnativebannerInt(PanichaApp.preferences.getString(PanichaApp.bikky_natbannerid, ""));

        final NativeBannerAd fbnative_Ad = new NativeBannerAd(activity, placementId);
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
                if (fb_smallnativeAd.size() > 0) {
                    fb_smallnativeAd.clear();
                }
                fb_smallnativeAd.add(fbnative_Ad);
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
        annativebannerCount++;
    }

    public static void dis_fbsmallnative(Activity activity, RelativeLayout frameLayout_Native) {
        populateFBsmallNative(fb_smallnativeAd.get(0), frameLayout_Native, activity);
    }

    public static void populateFBsmallNative(NativeBannerAd nativeBannerAd, RelativeLayout frameLayout_Native, Activity activity) {

        nativeBannerAd.unregisterView();

        // Inflate the Ad view.
        NativeAdLayout nativeAdLayout = (NativeAdLayout) LayoutInflater.from(activity).inflate(R.layout.fb_smallnative_ad_layout, null);
        // adding vie
        frameLayout_Native.addView(nativeAdLayout);

        LinearLayout adChoicesContainer = nativeAdLayout.findViewById(R.id.ad_choices_container);
        AdOptionsView adOptionsView = new AdOptionsView(activity, nativeBannerAd, nativeAdLayout);
        adChoicesContainer.removeAllViews();
        adChoicesContainer.addView(adOptionsView, 0);

        // Create native UI using the ad metadata.
        ImageView nativeAdIcon = nativeAdLayout.findViewById(R.id.native_ad_icon);
        TextView nativeAdTitle = nativeAdLayout.findViewById(R.id.native_ad_title);
        TextView nativeAdSocialContext = nativeAdLayout.findViewById(R.id.native_ad_social_context);
        TextView nativeAdBody = nativeAdLayout.findViewById(R.id.native_ad_body);
        TextView sponsoredLabel = nativeAdLayout.findViewById(R.id.native_ad_sponsored_label);
        TextView nativeAdCallToAction = nativeAdLayout.findViewById(R.id.native_ad_call_to_action);

        nativeAdTitle.setText(nativeBannerAd.getAdvertiserName());
        nativeAdBody.setText(nativeBannerAd.getAdBodyText());
        nativeAdSocialContext.setText(nativeBannerAd.getAdSocialContext());
        nativeAdCallToAction.setVisibility(nativeBannerAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
        nativeAdCallToAction.setText(nativeBannerAd.getAdCallToAction());
        sponsoredLabel.setText(nativeBannerAd.getSponsoredTranslation());

        List<View> clickableViews = new ArrayList<>();
        clickableViews.add(nativeAdTitle);
        clickableViews.add(nativeAdCallToAction);
        nativeBannerAd.registerViewForInteraction(nativeAdLayout, nativeAdIcon, clickableViews);
    }

}
