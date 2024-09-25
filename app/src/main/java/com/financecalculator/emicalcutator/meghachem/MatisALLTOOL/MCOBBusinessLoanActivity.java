package com.financecalculator.emicalcutator.meghachem.MatisALLTOOL;

import android.app.Activity;
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

public class MCOBBusinessLoanActivity extends AppCompatActivity {
    public Activity activity;
    public EditText edtInvestmentReturn;
    public EditText edtMonth;
    public EditText edtOriginalInvestment;
    public EditText edtYear;
    public LinearLayout linearLayoutUIAnswer;
    public LinearLayout linearLayoutUIResults;
    public TextView txtGainLoss;
    public TextView txtInvestmentPeriod;
    public LinearLayout txtReset;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_businessloancalc);
        activity = this;
        PanichaMV9.dis_ATnative(activity, findViewById(R.id.native_ad_container));
        oninit();
        onclick();
    }

    private void onclick() {
        this.linearLayoutUIAnswer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                try {
                    ((InputMethodManager) MCOBBusinessLoanActivity.this.getSystemService("input_method")).hideSoftInputFromWindow(MCOBBusinessLoanActivity.this.getCurrentFocus().getWindowToken(), 0);
                } catch (Exception e) {
                    try {
                        e.printStackTrace();
                    } catch (Exception unused) {
                        return;
                    }
                }
                if (MCOBBusinessLoanActivity.this.edtOriginalInvestment.getText().toString().isEmpty() || MCOBBusinessLoanActivity.this.edtInvestmentReturn.getText().toString().isEmpty() || MCOBBusinessLoanActivity.this.edtYear.getText().toString().isEmpty() || MCOBBusinessLoanActivity.this.edtMonth.getText().toString().isEmpty()) {
                    Toast.makeText(MCOBBusinessLoanActivity.this, "Enter Value", 0).show();
                    return;
                }

                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        double parseDouble = Double.parseDouble(MCOBBusinessLoanActivity.this.edtOriginalInvestment.getText().toString());
                        double parseDouble2 = Double.parseDouble(MCOBBusinessLoanActivity.this.edtInvestmentReturn.getText().toString());
                        int parseInt = Integer.parseInt(MCOBBusinessLoanActivity.this.edtYear.getText().toString());
                        int parseInt2 = Integer.parseInt(MCOBBusinessLoanActivity.this.edtMonth.getText().toString());
                        double d = parseDouble - parseDouble2;
                        TextView textView = MCOBBusinessLoanActivity.this.txtGainLoss;
                        textView.setText("" + d + " ₹ ");
                        TextView textView2 = MCOBBusinessLoanActivity.this.txtInvestmentPeriod;
                        textView2.setText("" + parseInt + " yr " + parseInt2 + " mo ");
                    }
                });
            }
        });
        this.txtReset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        MCOBBusinessLoanActivity.this.edtOriginalInvestment.setText("");
                        MCOBBusinessLoanActivity.this.edtInvestmentReturn.setText("");
                        MCOBBusinessLoanActivity.this.edtYear.setText("");
                        MCOBBusinessLoanActivity.this.edtMonth.setText("");
                        MCOBBusinessLoanActivity.this.txtInvestmentPeriod.setText("0 yr 0 mo");
                        MCOBBusinessLoanActivity.this.txtGainLoss.setText("0");
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

    private void oninit() {
        this.linearLayoutUIResults = (LinearLayout) findViewById(R.id.linearLayoutUIResults);
        this.linearLayoutUIAnswer = (LinearLayout) findViewById(R.id.linearLayoutUIAnswer);
        this.txtReset = (LinearLayout) findViewById(R.id.txtReset);
        this.edtOriginalInvestment = (EditText) findViewById(R.id.edtOriginalInvestment);
        this.edtMonth = (EditText) findViewById(R.id.edtMonth);
        this.edtYear = (EditText) findViewById(R.id.edtYear);
        this.edtInvestmentReturn = (EditText) findViewById(R.id.edtInvestmentReturn);
        this.txtInvestmentPeriod = (TextView) findViewById(R.id.txtInvestmentPeriod);
        this.txtGainLoss = (TextView) findViewById(R.id.txtGainLoss);
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
