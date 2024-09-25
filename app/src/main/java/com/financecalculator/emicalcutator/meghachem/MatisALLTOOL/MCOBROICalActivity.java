package com.financecalculator.emicalcutator.meghachem.MatisALLTOOL;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.financecalculator.emicalcutator.meghachem.R;

import java.text.DecimalFormat;
import java.text.ParseException;

public class MCOBROICalActivity extends AppCompatActivity {
    public TextView f41408D0;
    public TextView f41409E0;
    public EditText f41410F0;

    public EditText f41411G0;

    public EditText f41412H0;

    public EditText f41413I0;

    public TextView f41414J0;

    public TextView f41415K0;

    public TextView f41416L0;
    public MCOBROICalActivity activity=this;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            MCOBROICalActivity.this.onBackPressed();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        public void onClick(View view) {
            InputMethodManager inputMethodManager = (InputMethodManager) MCOBROICalActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
            if (MCOBROICalActivity.this.getCurrentFocus() != null) {
                inputMethodManager.hideSoftInputFromWindow(MCOBROICalActivity.this.getCurrentFocus().getWindowToken(), 2);
            }
            PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                @Override
                public void onTasknext() {
                    MCOBROICalActivity.this.b1();
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
                    MCOBROICalActivity.this.d1();
                }
            });
        }
    }


    public final void b1() {
        if (TextUtils.isEmpty(this.f41411G0.getText().toString().replace(",", ""))) {
            this.f41411G0.setError("Enter Investment Amount");
        } else if (TextUtils.isEmpty(this.f41410F0.getText().toString().replace(",", ""))) {
            this.f41410F0.setError("Enter Returned Amount");
        } else if (TextUtils.isEmpty(this.f41412H0.getText().toString())) {
            this.f41412H0.setError("Enter Period In Year");
        } else if (TextUtils.isEmpty(this.f41413I0.getText().toString())) {
            this.f41413I0.setError("Enter Period In Month");
        } else {
            double doubleValue = Double.parseDouble(this.f41411G0.getText().toString().replace(",", ""));
            double doubleValue2 = Double.parseDouble(this.f41410F0.getText().toString().replace(",", ""));
            int parseInt = Integer.parseInt(this.f41412H0.getText().toString());
            int parseInt2 = Integer.parseInt(this.f41413I0.getText().toString());
            double d10 = doubleValue2 - doubleValue;
            this.f41416L0.setText(String.format("%s %% ", new Object[]{Double.valueOf((d10 / doubleValue) * 100.0d)}));
            this.f41414J0.setText(String.format("%s ₹ ", new Object[]{Double.valueOf(d10)}));
            this.f41415K0.setText(String.format("%d yr %d month ", new Object[]{Integer.valueOf(parseInt), Integer.valueOf(parseInt2)}));
        }
    }

    public void d1() {
        try {
            this.f41411G0.setText("");
            this.f41410F0.setText("");
            this.f41413I0.setText("");
            this.f41412H0.setText("");
            this.f41415K0.setText("0");
            this.f41414J0.setText("0 ₹");
            this.f41416L0.setText("0  ₹");
        } catch (Exception e10) {
            e10.printStackTrace();
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
        setContentView((int) R.layout.activity_roical);

        PanichaMV9.dis_ATnative(activity, findViewById(R.id.native_ad_container));
        findViewById(R.id.ic_back).setOnClickListener(new a());
        this.f41411G0 = (EditText) findViewById(R.id.et_invest);
        this.f41410F0 = (EditText) findViewById(R.id.et_returned);
        this.f41412H0 = (EditText) findViewById(R.id.et_year);
        this.f41413I0 = (EditText) findViewById(R.id.et_month);
        this.f41415K0 = (TextView) findViewById(R.id.txt_Maturity_rd);
        this.f41414J0 = (TextView) findViewById(R.id.total_intrest_rd);
        this.f41416L0 = (TextView) findViewById(R.id.tv_roi);
        this.f41408D0 = (TextView) findViewById(R.id.btn_calculate);
        this.f41409E0 = (TextView) findViewById(R.id.btn_reset);
        EditText editText = this.f41411G0;
        editText.addTextChangedListener(new f(editText));
        EditText editText2 = this.f41410F0;
        editText2.addTextChangedListener(new f(editText2));
        this.f41408D0.setOnClickListener(new b());
        this.f41409E0.setOnClickListener(new c());
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
