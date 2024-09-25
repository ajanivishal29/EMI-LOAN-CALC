package com.financecalculator.emicalcutator.meghachem.MatisALLTOOL;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.financecalculator.emicalcutator.meghachem.R;

public class MCOBRDLoanCalActivity extends AppCompatActivity {
    public Activity activity;
    EditText amount;
    LinearLayout calculate;
    LinearLayout clear;
    TextView in_text;
    TextView interest;
    TextView mat_text;
    TextView maturity;
    EditText rate;
    EditText time;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_rdloan_cal);

        activity = this;
        PanichaMV9.dis_ATnative(activity, findViewById(R.id.native_ad_container));
        this.calculate = (LinearLayout) findViewById(R.id.calculate);
        this.amount = (EditText) findViewById(R.id.amount);
        this.rate = (EditText) findViewById(R.id.rate);
        this.time = (EditText) findViewById(R.id.time);
        this.maturity = (TextView) findViewById(R.id.maturity);
        this.mat_text = (TextView) findViewById(R.id.mat_text);
        this.in_text = (TextView) findViewById(R.id.int_text);
        this.interest = (TextView) findViewById(R.id.interest);
        this.calculate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (MCOBRDLoanCalActivity.this.amount.getText().toString().isEmpty() || MCOBRDLoanCalActivity.this.rate.getText().toString().isEmpty() || MCOBRDLoanCalActivity.this.time.getText().toString().isEmpty()) {
                    Toast.makeText(MCOBRDLoanCalActivity.this, "Pls Enter Value", Toast.LENGTH_SHORT).show();
                    return;
                }

                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        double parseDouble = Double.parseDouble(MCOBRDLoanCalActivity.this.amount.getText().toString());
                        double pow = Math.pow((Double.parseDouble(MCOBRDLoanCalActivity.this.rate.getText().toString()) / 400.0d) + 1.0d, Double.parseDouble(MCOBRDLoanCalActivity.this.time.getText().toString()) * 4.0d) * parseDouble;
                        TextView textView = MCOBRDLoanCalActivity.this.maturity;
                        textView.setText("" + String.format("%.2f", new Object[]{Double.valueOf(pow)}) + " ₹ ");
                        double d = pow - parseDouble;
                        TextView textView2 = MCOBRDLoanCalActivity.this.interest;
                        textView2.setText("" + String.format("%.2f", new Object[]{Double.valueOf(d)}) + " ₹ ");                    }
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
