package com.financecalculator.emicalcutator.meghachem.MatisALLTOOL;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.financecalculator.emicalcutator.meghachem.R;

import java.text.DecimalFormat;
import java.text.ParseException;


public class PPFCalculatorActivity extends AppCompatActivity {

    public EditText f41380D0;
    public EditText f41381E0;
    public EditText f41382F0;
    public TextView f41383G0;

    public TextView f41384H0;

    public TextView f41385I0;

    public TextView f41386J0;
    public TextView f41387K0;
    public PPFCalculatorActivity activity =this;

    public DecimalFormat f41388L0 = new DecimalFormat("#,###.0");

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            PPFCalculatorActivity.this.onBackPressed();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            InputMethodManager inputMethodManager = (InputMethodManager) PPFCalculatorActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (PPFCalculatorActivity.this.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(PPFCalculatorActivity.this.getCurrentFocus().getWindowToken(), 2);
            }
            PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                @Override
                public void onTasknext() {
                    PPFCalculatorActivity.this.c1();
                }
            });
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                @Override
                public void onTasknext() {
                    PPFCalculatorActivity.this.d1();
                }
            });
        }
    }


    public void c1() {
        String replace = this.f41380D0.getText().toString().replace(",", "");
        if (TextUtils.isEmpty(replace)) {
            this.f41380D0.setError("Enter Amount");
        } else if (TextUtils.isEmpty(this.f41381E0.getText().toString())) {
            this.f41381E0.setError("Enter Interest");
        } else if (TextUtils.isEmpty(this.f41382F0.getText().toString())) {
            this.f41382F0.setError("Enter year");
        } else {
            double parseDouble = Double.parseDouble(replace);
            double parseDouble2 = Double.parseDouble(this.f41381E0.getText().toString());
            if (parseDouble2 > 100.0d) {
                Toast.makeText(this, "Please Enter Interest Rate Maximum 100", Toast.LENGTH_SHORT).show();
                return;
            }
            double d10 = parseDouble2 / 100.0d;
            double d11 = 0.0d;
            double d12 = 0.0d;
            double d13 = 0.0d;
            for (int i10 = 0; ((double) i10) < Double.parseDouble(this.f41382F0.getText().toString()); i10++) {
                double d14 = (parseDouble + d13) * d10;
                d11 += d14;
                d13 += d14 + parseDouble;
                d12 = d13 - d11;
            }
            Log.e("maturity_amount", "" + d13);
            Log.e("Invest_amount", "" + d12);
            Log.e("total_interest_amount", "" + d11);
            this.f41385I0.setText(this.f41388L0.format(d13) + " ₹");
            this.f41383G0.setText(this.f41388L0.format(d12) + " ₹");
            this.f41384H0.setText(this.f41388L0.format(d11) + " ₹");
        }
    }

    public void d1() {
        this.f41380D0.setText("");
        this.f41381E0.setText("");
        this.f41382F0.setText("");
        this.f41380D0.setError((CharSequence) null);
        this.f41381E0.setError((CharSequence) null);
        this.f41382F0.setError((CharSequence) null);
        this.f41380D0.requestFocus();
        this.f41385I0.setText("0 ₹");
        this.f41383G0.setText("0 ₹");
        this.f41384H0.setText("0 ₹");
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
        setContentView((int) R.layout.activity_ppfcalculator);
        PanichaMV9.dis_ATnative(activity, findViewById(R.id.native_ad_container));
        findViewById(R.id.ic_back).setOnClickListener(new a());
        this.f41380D0 = (EditText) findViewById(R.id.edt_deposit_Amount_fd);
        this.f41381E0 = (EditText) findViewById(R.id.edt_Interest_fd);
        this.f41382F0 = (EditText) findViewById(R.id.Yearfd);
        EditText editText = this.f41380D0;
        editText.addTextChangedListener(new f(editText));
        this.f41385I0 = (TextView) findViewById(R.id.txt_Maturity_rd);
        this.f41383G0 = (TextView) findViewById(R.id.total_investment_rd);
        this.f41384H0 = (TextView) findViewById(R.id.total_intrest_rd);
        TextView textView = (TextView) findViewById(R.id.btn_calculate);
        this.f41386J0 = textView;
        textView.setOnClickListener(new b());
        TextView textView2 = (TextView) findViewById(R.id.btn_reset);
        this.f41387K0 = textView2;
        textView2.setOnClickListener(new c());
    }

    public class f implements TextWatcher {
        public DecimalFormat f33430X;
        public DecimalFormat f33431Y = new DecimalFormat("#,###");
        public boolean f33432Z;
        public EditText f33433a0;

        public f(EditText editText) {
            DecimalFormat decimalFormat = new DecimalFormat("#,###.##");
            this.f33430X = decimalFormat;
            decimalFormat.setDecimalSeparatorAlwaysShown(true);
            this.f33433a0 = editText;
            this.f33432Z = false;
        }

        public void afterTextChanged(Editable editable) {
            this.f33433a0.removeTextChangedListener(this);
            try {
                int length = this.f33433a0.getText().length();
                Number parse = this.f33430X.parse(editable.toString().replace(String.valueOf(this.f33430X.getDecimalFormatSymbols().getGroupingSeparator()), ""));
                int selectionStart = this.f33433a0.getSelectionStart();
                if (this.f33432Z) {
                    this.f33433a0.setText(this.f33430X.format(parse));
                } else {
                    this.f33433a0.setText(this.f33431Y.format(parse));
                }
                int length2 = selectionStart + (this.f33433a0.getText().length() - length);
                if (length2 <= 0 || length2 > this.f33433a0.getText().length()) {
                    EditText editText = this.f33433a0;
                    editText.setSelection(editText.getText().length() - 1);
                } else {
                    this.f33433a0.setSelection(length2);
                }
            } catch (NumberFormatException | ParseException unused) {
            }
            this.f33433a0.addTextChangedListener(this);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            if (charSequence.toString().contains(String.valueOf(this.f33430X.getDecimalFormatSymbols().getDecimalSeparator()))) {
                this.f33432Z = true;
            } else {
                this.f33432Z = false;
            }
        }
    }

}
