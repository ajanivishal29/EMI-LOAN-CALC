package com.financecalculator.emicalcutator.meghachem.MatisALLTOOL;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.financecalculator.emicalcutator.meghachem.R;

public class MCOBEMICalActivity extends AppCompatActivity {
    public Activity activity;
    LinearLayout ans;
    float f_ans;
    EditText intrest;
    float n;
    float p;
    EditText principal;
    float r;
    LinearLayout reset;
    TextView result;
    TextView result2;
    EditText time;
    TextView toolbar_name;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_emical);
        activity = this;
        toolbar_name = findViewById(R.id.toolbar_name);
        if (getIntent().hasExtra("id")) {
            toolbar_name.setText("EMI Calculator");
        }

        PanichaMV9.dis_ATnative(activity, findViewById(R.id.native_ad_container));

        this.principal = (EditText) findViewById(R.id.principal);
        this.intrest = (EditText) findViewById(R.id.intrest);
        this.time = (EditText) findViewById(R.id.time);
        this.reset = (LinearLayout) findViewById(R.id.reset);
        this.ans = (LinearLayout) findViewById(R.id.ans);
        this.result = (TextView) findViewById(R.id.result);
        this.result2 = (TextView) findViewById(R.id.result2);
        this.ans.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    ((InputMethodManager) MCOBEMICalActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(MCOBEMICalActivity.this.getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    try {
                        e.printStackTrace();
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (MCOBEMICalActivity.this.principal.getText().toString().isEmpty() || MCOBEMICalActivity.this.intrest.getText().toString().isEmpty() || MCOBEMICalActivity.this.time.getText().toString().isEmpty()) {
                    Toast.makeText(MCOBEMICalActivity.this, "Enter Emi Calculator Value", 0).show();
                    return;
                }

                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        MCOBEMICalActivity MCOBEMICal_activity = MCOBEMICalActivity.this;
                        MCOBEMICal_activity.p = Float.parseFloat(MCOBEMICal_activity.principal.getText().toString());
                        MCOBEMICalActivity MCOBEMICal_activity2 = MCOBEMICalActivity.this;
                        MCOBEMICal_activity2.r = Float.parseFloat(MCOBEMICal_activity2.intrest.getText().toString());
                        MCOBEMICalActivity MCOBEMICal_activity3 = MCOBEMICalActivity.this;
                        MCOBEMICal_activity3.n = Float.parseFloat(MCOBEMICal_activity3.time.getText().toString());
                        MCOBEMICalActivity.this.r /= 1200.0f;
                        float f = 1.0f;
                        for (int i = 0; ((float) i) < MCOBEMICalActivity.this.n * 12.0f; i++) {
                            f *= MCOBEMICalActivity.this.r + 1.0f;
                        }
                        MCOBEMICalActivity MCOBEMICal_activity4 = MCOBEMICalActivity.this;
                        MCOBEMICal_activity4.f_ans = MCOBEMICal_activity4.p * MCOBEMICalActivity.this.r * (f / (f - 1.0f));
                        MCOBEMICalActivity.this.result.setText("" + (MCOBEMICalActivity.this.f_ans + MCOBEMICalActivity.this.p) + " ₹ ");
                        MCOBEMICalActivity.this.result2.setText("" + MCOBEMICalActivity.this.f_ans + " ₹ ");

                    }
                });
            }
        });
        this.reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        MCOBEMICalActivity.this.principal.setText("");
                        MCOBEMICalActivity.this.intrest.setText("");
                        MCOBEMICalActivity.this.time.setText("");
                        MCOBEMICalActivity.this.result.setText("0");
                        MCOBEMICalActivity.this.result2.setText("0");

                    }
                });
            }
        });

        findViewById(R.id.ic_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
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
