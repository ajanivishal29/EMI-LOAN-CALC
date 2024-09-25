package com.financecalculator.emicalcutator.meghachem;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;
import com.silent.Vignasdk.vorbatility.PanichaMV9;

public class DOBARFIRSTActivity extends AppCompatActivity {
    public DOBARFIRSTActivity activity=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tap_to_start);
        PanichaMV9.dis_ATsmallnative(activity, findViewById(R.id.small_native));

        findViewById(R.id.ic_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        startActivity(new Intent(DOBARFIRSTActivity.this, DOBARHHActivity.class));
                    }
                });
            }
        });

        findViewById(R.id.btn_rate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName())));
                } catch (Exception unused) {
                }
            }
        });

        findViewById(R.id.btn_share).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", "Watch live football HD streaming free in this app at: https://play.google.com/store/apps/details?id=" + getPackageName());
                    intent.setType("text/plain");
                    startActivity(intent);
                } catch (Exception unused) {
                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        if (PanichaApp.preferences.getString(PanichaApp.bikky_exit_interT, "").equalsIgnoreCase("off")) {
            PanichaApp.preferences.edit().clear().apply();
            finishAffinity();
            System.exit(0);
        } else {
            PanichaMV9.dis_ATexitinter(this, () -> finish());
        }
    }

}