package com.financecalculator.emicalcutator.meghachem.SIKKOConvert;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.financecalculator.emicalcutator.meghachem.R;

public class COUNSIKKOConVTActivity extends AppCompatActivity {

    public TextView f40742D0;
    public TextView f40743E0;
    public TextView f40744F0;
    public ProgressBar f40745G0;
    public EditText f40746H0;
    public TextView f40747I0;
    public TextView f40748J0;
    public TextView f40749K0;
    public String f40750L0 = "Indian Rupee";
    public String f40751M0 = "US Dollar";
    public String f40752N0 = "INR";
    public String f40753O0 = "USD";
    public COUNSIKKOConVTActivity activity = this;

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
        setContentView((int) R.layout.activity_currency_conveter);

        PanichaMV9.dis_ATnative(activity, findViewById(R.id.native_ad_container));
        findViewById(R.id.ic_back).setOnClickListener(new a());
        this.f40748J0 = (TextView) findViewById(R.id.first_countryPicker);
        this.f40749K0 = (TextView) findViewById(R.id.second_countryPicker);
        this.f40742D0 = (TextView) findViewById(R.id.txt_first_currency);
        this.f40743E0 = (TextView) findViewById(R.id.txt_second_currency);
        this.f40744F0 = (TextView) findViewById(R.id.btnConvert);
        this.f40745G0 = (ProgressBar) findViewById(R.id.prgLoading);
        this.f40746H0 = (EditText) findViewById(R.id.et_first_currency);
        this.f40747I0 = (TextView) findViewById(R.id.et_second_currency);
        TextView textView = this.f40742D0;
        textView.setText("(" + this.f40752N0 + ")");
        TextView textView2 = this.f40743E0;
        textView2.setText("(" + this.f40753O0 + ")");
        this.f40748J0.setOnClickListener(new b());
        this.f40749K0.setOnClickListener(new c());
        this.f40744F0.setOnClickListener(new d());
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            COUNSIKKOConVTActivity.this.onBackPressed();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            COUNSIKKOConVTActivity.this.startActivityForResult(new Intent(COUNSIKKOConVTActivity.this, COUNNationListActivity.class), 15);
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            COUNSIKKOConVTActivity.this.startActivityForResult(new Intent(COUNSIKKOConVTActivity.this, COUNNationListActivity.class), 16);
        }
    }

    public class d implements View.OnClickListener {

        public class a implements GetNationData.C0464c {
            public a() {
            }

            public void a(Double d10, Exception exc) {
                COUNSIKKOConVTActivity.this.f40744F0.setVisibility(View.VISIBLE);
                COUNSIKKOConVTActivity.this.f40745G0.setVisibility(View.GONE);
                if (exc != null) {
                    COUNSIKKOConVTActivity.this.f40747I0.setText(exc.getMessage());
                    return;
                }
                COUNSIKKOConVTActivity COUNSIKKOConVTActivity = COUNSIKKOConVTActivity.this;
                COUNSIKKOConVTActivity.f40747I0.setText(GetNationData.e(COUNSIKKOConVTActivity.f40753O0, d10.doubleValue()));
            }
        }

        public d() {
        }

        public void onClick(View view) {
            if (COUNSIKKOConVTActivity.this.f40746H0.getText().toString().length() > 0) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        COUNSIKKOConVTActivity.this.f40744F0.setVisibility(View.GONE);
                        COUNSIKKOConVTActivity.this.f40745G0.setVisibility(View.VISIBLE);
                        double parseDouble = Double.parseDouble(COUNSIKKOConVTActivity.this.f40746H0.getText().toString());
                        COUNSIKKOConVTActivity COUNSIKKOConVTActivity = COUNSIKKOConVTActivity.this;
                        GetNationData.b(parseDouble, COUNSIKKOConVTActivity.f40752N0, COUNSIKKOConVTActivity.f40753O0, new a());
                    }
                });
                return;

            }
            Toast.makeText(COUNSIKKOConVTActivity.this, "Enter Amount", Toast.LENGTH_SHORT).show();
        }
    }


    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i11 == -1) {
            if (i10 == 15) {
                String stringExtra = intent.getStringExtra("cord");
                String stringExtra2 = intent.getStringExtra("name");
                this.f40748J0.setText(stringExtra2);
                TextView textView = this.f40742D0;
                textView.setText("(" + stringExtra + ")");
                this.f40752N0 = stringExtra;
                this.f40750L0 = stringExtra2;
            } else if (i10 == 16) {
                String stringExtra3 = intent.getStringExtra("cord");
                String stringExtra4 = intent.getStringExtra("name");
                this.f40749K0.setText(stringExtra4);
                TextView textView2 = this.f40743E0;
                textView2.setText("(" + stringExtra3 + ")");
                this.f40753O0 = stringExtra3;
                this.f40751M0 = stringExtra4;
            }
        }
    }

}
