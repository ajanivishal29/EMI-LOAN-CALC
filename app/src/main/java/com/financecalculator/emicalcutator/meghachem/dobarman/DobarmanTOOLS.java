package com.financecalculator.emicalcutator.meghachem.dobarman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.financecalculator.emicalcutator.meghachem.R;
import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;

public final class DobarmanTOOLS extends AppCompatActivity {

    public Activity activity=this;
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
       setContentView(R.layout.ll_dobarmantoo_s);


        PanichaMV9.dis_ATsmallnative(activity, findViewById(R.id.small_native));
        findViewById(R.id.seminarNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DobarmanTOOLS.this, DobarmanTOOLT.class);
                        startActivity(intent);
                    }
                });
            }
        });
    }
    @Override
    public void onBackPressed() {
        if (PanichaApp.preferences.getString(PanichaApp.bikky_exit_interT, "").equalsIgnoreCase("off")) {
            finish();
        } else {
            PanichaMV9.dis_ATexitinter(this, () -> finish());
        }
    }
}
