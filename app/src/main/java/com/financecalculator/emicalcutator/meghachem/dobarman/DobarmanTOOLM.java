package com.financecalculator.emicalcutator.meghachem.dobarman;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.financecalculator.emicalcutator.meghachem.R;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;

public final class DobarmanTOOLM extends AppCompatActivity {
    public ProgressDialog progress;
    public Activity activity=this;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.ll_dobarmantool_m);

        PanichaMV9.dis_ATinterSplash(activity);
        progress = new ProgressDialog(this, R.style.MyAlertDialogStyle);
        progress.setMessage("Please Wait Loading data");
        this.progress.setProgressStyle(0);
        this.progress.setIndeterminate(true);
        this.progress.setCancelable(false);
        this.progress.setProgress(0);
        this.progress.show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progress.dismiss();
            }
        }, 3500L);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                PanichaMV9.dis_ATsmallnative(activity, findViewById(R.id.small_native));
            }
        }, 2000);

        findViewById(R.id.seminarNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DobarmanTOOLM.this, DobarmanTOOLN.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            PanichaMV9.loadAllATADS(activity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onBackPressed() {
        finishAffinity();
    }
}
