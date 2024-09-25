package com.silent.Vignasdk.vorbatility;

import android.app.Application;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings;
import com.financecalculator.emicalcutator.meghachem.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

public class PanichaApp extends Application {
    public static PanichaApp panichaApp;
    public static SharedPreferences _sharedPRefrences;
    public static String app_open = "app_open";
    public static String bikky_startT = "bikky_startT";
    public static String bikky_start_appopen = "bikky_start_appopen";
    public static String bikky_qureka_url = "bikky_qureka_url";
    public static String bikky_2Tqureka = "bikky_2Tqureka";
    public static String int_count = "int_count";
    public static String exit_count = "exit_count";
    public static String bikky_down_url = "bikky_down_url";
    public static String bikky_natadsT = "bikky_natadsT";
    public static String bikky_nativeid = "bikky_nativeid";
    public static String bikky_natbannerT = "bikky_natbannerT";
    public static String bikky_natbannerid = "bikky_natbannerid";
    public static String bikky_banneradsT = "bikky_banneradsT";
    public static String bikky_bannerid = "bikky_bannerid";
    public static String bikky_interadsT = "bikky_interadsT";
    public static String bikky_SplashinteradsT = "bikky_SplashinteradsT";
    public static String bikky_splashinterstialid = "bikky_splashinterstialid";

    public static String bikky_interstialid = "bikky_interstialid";
    public static String bikky_exit_interT = "bikky_exit_interT";
    public static String bikky_exit_interid = "bikky_exit_interid";
    public static String bikky_privacy_url = "bikky_privacy_url";
    public static String bikky_ridi_url = "bikky_ridi_url";
    public static String bikky_ridi_pkg = "bikky_ridi_pkg";
    public static SharedPreferences preferences = null;

    public SharedPreferences.Editor editor;
    public String INSTALL_PREF = "install_pref_vd";

    public void PANCOUNT() {
        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.put("packagename", getPackageName());
        client.post(_sharedPRefrences.getString(bikky_down_url, ""), params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode == 200) {
                    Log.e("TAG", "1");
                    SharedPreferences.Editor editor = _sharedPRefrences.edit();
                    editor.putBoolean(INSTALL_PREF, true);
                    editor.apply();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.e("TAG", "0");

            }
        });
    }


    public void onCreate() {
        super.onCreate();
        panichaApp = this;
        this._sharedPRefrences = getSharedPreferences(ConstantID.PREFRENCE, 0);
        preferences = _sharedPRefrences;
        this.editor = preferences.edit();
        AudienceNetworkAds.initialize(this);
        FirebaseApp.initializeApp(this);
        FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
        instance.setConfigSettingsAsync(new FirebaseRemoteConfigSettings.Builder().setMinimumFetchIntervalInSeconds(0).build());
        instance.setDefaultsAsync((int) R.xml.remote_config_defaults);
        instance.fetchAndActivate().addOnCompleteListener(new OnCompleteListener<Boolean>() {
            public void onComplete(Task<Boolean> task) {
                if (task.isSuccessful()) {
                    try {
                        instance.activate();
                        JSONObject jSONObject = new JSONObject(FirebaseRemoteConfig.getInstance().getString("bikkymahat"));
                        Log.e("Firebase", "remote  data get");
                        editor.putString(bikky_down_url, jSONObject.getString("bikky_down_url"));
                        editor.putString(bikky_start_appopen, jSONObject.getString("bikky_start_appopen"));
                        editor.putString(bikky_startT, jSONObject.getString("bikky_startT"));
                        editor.putString(app_open, jSONObject.getString("app_open"));
                        editor.putString(bikky_bannerid, jSONObject.getString("bikky_bannerid"));
                        editor.putString(bikky_interstialid, jSONObject.getString("bikky_interstialid"));
                        editor.putString(bikky_nativeid, jSONObject.getString("bikky_nativeid"));
                        editor.putString(bikky_natbannerid, jSONObject.getString("bikky_natbannerid"));
                        editor.putString(bikky_natadsT, jSONObject.getString("bikky_natadsT"));
                        editor.putString(bikky_banneradsT, jSONObject.getString("bikky_banneradsT"));
                        editor.putString(bikky_interadsT, jSONObject.getString("bikky_interadsT"));
                        editor.putString(bikky_natbannerT, jSONObject.getString("bikky_natbannerT"));
                        editor.putString(bikky_qureka_url, jSONObject.getString("bikky_qureka_url"));
                        editor.putString(bikky_2Tqureka, jSONObject.getString("bikky_2Tqureka"));
                        editor.putString(bikky_SplashinteradsT, jSONObject.getString("bikky_SplashinteradsT"));
                        editor.putString(bikky_splashinterstialid, jSONObject.getString("bikky_splashinterstialid"));
                        editor.putInt(int_count, jSONObject.getInt("int_count"));
                        editor.putInt(exit_count, jSONObject.getInt("exit_count"));
                        editor.putString(bikky_exit_interT, jSONObject.getString("bikky_exit_interT"));
                        editor.putString(bikky_exit_interid, jSONObject.getString("bikky_exit_interid"));
                        editor.putString(bikky_privacy_url, jSONObject.getString("bikky_privacy_url"));
                        editor.putString(bikky_ridi_url, jSONObject.getString("bikky_ridi_url"));
                        editor.putString(bikky_ridi_pkg, jSONObject.getString("bikky_ridi_pkg"));
                        editor.apply();
                        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
                            public void run() {
                                if (!_sharedPRefrences.getBoolean(INSTALL_PREF, false)) {
                                    PANCOUNT();
                                }
                            }
                        }, 400);
                    } catch (Exception e) {
                        e.printStackTrace();


                    }
                } else {
                    Log.e("Firebase", "Firebase response Fail");
                }
            }
        });
    }
}
