package com.financecalculator.emicalcutator.meghachem.MatisALLTOOL;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.financecalculator.emicalcutator.meghachem.R;

public class MCOBGSTCalActivity extends AppCompatActivity {

    public TextView f40796D0;
    public EditText f40797E0;
    public EditText f40798F0;
    public M4 f40799G0;
    public boolean f40800H0 = false;
    public TextView f40801I0;
    public TextView f40802J0;
    public TextView f40803K0;
    public TextView f40804L0;
    public TextView f40805M0;
    public TextView f40806N0;
    public MCOBGSTCalActivity activity=this;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            MCOBGSTCalActivity.this.onBackPressed();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            ((InputMethodManager) MCOBGSTCalActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);
            PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                @Override
                public void onTasknext() {
                    if (MCOBGSTCalActivity.this.c1()) {
                        double parseDouble = Double.parseDouble(MCOBGSTCalActivity.this.f40798F0.getText().toString()) / 2.0d;
                        TextView textView = MCOBGSTCalActivity.this.f40804L0;
                        textView.setText(MCOBGSTCalActivity.this.f40797E0.getText() + " ₹");
                        Double a10 = MCOBGSTCalActivity.this.f40799G0.a(MCOBGSTCalActivity.this.f40797E0.getText().toString(), MCOBGSTCalActivity.this.f40798F0.getText().toString());
                        MCOBGSTCalActivity.this.f40803K0.setText(String.format("%s ₹", new Object[]{Double.valueOf(M4.e(a10.doubleValue(), 2))}));
                        MCOBGSTCalActivity.this.f40802J0.setText(String.format("%s %% = %s ₹", new Object[]{Double.valueOf(parseDouble), Double.valueOf(M4.e(a10.doubleValue() / 2.0d, 2))}));
                        MCOBGSTCalActivity.this.f40805M0.setText(String.format("%s %% = %s ₹", new Object[]{Double.valueOf(parseDouble), Double.valueOf(M4.e(a10.doubleValue() / 2.0d, 2))}));
                        MCOBGSTCalActivity gSTCalActivity = MCOBGSTCalActivity.this;
                        gSTCalActivity.f40806N0.setText(String.format("%s ₹", new Object[]{gSTCalActivity.f40799G0.c(MCOBGSTCalActivity.this.f40797E0.getText().toString(), MCOBGSTCalActivity.this.f40798F0.getText().toString())}));
                        MCOBGSTCalActivity.this.f40800H0 = true;
                    }
                }
            });

        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            ((InputMethodManager) MCOBGSTCalActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(view.getWindowToken(), 0);

            PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                @Override
                public void onTasknext() {
                    if (MCOBGSTCalActivity.this.c1()) {
                        if (MCOBGSTCalActivity.this.c1()) {
                            double parseDouble = Double.parseDouble(MCOBGSTCalActivity.this.f40798F0.getText().toString()) / 2.0d;
                            MCOBGSTCalActivity gSTCalActivity = MCOBGSTCalActivity.this;
                            gSTCalActivity.f40804L0.setText(String.format("%s ₹", new Object[]{Double.valueOf(M4.e(gSTCalActivity.f40799G0.b(MCOBGSTCalActivity.this.f40797E0.getText().toString(), MCOBGSTCalActivity.this.f40798F0.getText().toString()).doubleValue(), 2))}));
                            Double d10 = MCOBGSTCalActivity.this.f40799G0.d(MCOBGSTCalActivity.this.f40797E0.getText().toString(), MCOBGSTCalActivity.this.f40798F0.getText().toString());
                            MCOBGSTCalActivity.this.f40803K0.setText(String.format("%s ₹", new Object[]{Double.valueOf(M4.e(d10.doubleValue(), 2))}));
                            MCOBGSTCalActivity.this.f40802J0.setText(String.format("%s %% = %s ₹", new Object[]{Double.valueOf(parseDouble), Double.valueOf(M4.e(d10.doubleValue() / 2.0d, 2))}));
                            MCOBGSTCalActivity.this.f40805M0.setText(String.format("%s %% = %s ₹", new Object[]{Double.valueOf(parseDouble), Double.valueOf(M4.e(d10.doubleValue() / 2.0d, 2))}));
                            MCOBGSTCalActivity gSTCalActivity2 = MCOBGSTCalActivity.this;
                            gSTCalActivity2.f40806N0.setText(String.format("%s ₹", new Object[]{gSTCalActivity2.f40797E0.getText()}));
                            MCOBGSTCalActivity.this.f40800H0 = true;
                        }
                    }
                }
            });
        }
    }

    public boolean c1() {
        if (TextUtils.isEmpty(this.f40797E0.getText().toString())) {
            this.f40797E0.setError("Enter Amount");
            return false;
        } else if (this.f40798F0.getText().length() != 0) {
            return true;
        } else {
            this.f40798F0.setError("Enter Rate");
            return false;
        }
    }

    @Override
    public void onBackPressed() {
        if (PanichaApp.preferences.getString(PanichaApp.bikky_exit_interT, "").equalsIgnoreCase("off")) {
            finish();
        } else {
            PanichaMV9.dis_ATexitinter(this, () -> finish());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_gstcal);

        PanichaMV9.dis_ATnative(activity, findViewById(R.id.native_ad_container));

        this.f40799G0 = new M4();
        findViewById(R.id.ic_back).setOnClickListener(new a());
        this.f40796D0 = (TextView) findViewById(R.id.btn_add_gst);
        this.f40801I0 = (TextView) findViewById(R.id.btn_sub_gst);
        this.f40797E0 = (EditText) findViewById(R.id.et_initial_amount);
        this.f40798F0 = (EditText) findViewById(R.id.et_rate_gst);
        this.f40804L0 = (TextView) findViewById(R.id.tv_net_amount);
        this.f40803K0 = (TextView) findViewById(R.id.tv_gst_amount);
        this.f40806N0 = (TextView) findViewById(R.id.tv_total_amount);
        this.f40802J0 = (TextView) findViewById(R.id.tv_cgst);
        this.f40805M0 = (TextView) findViewById(R.id.tv_sgst);
        this.f40796D0.setOnClickListener(new b());
        this.f40801I0.setOnClickListener(new c());
    }
}
