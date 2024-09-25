package com.financecalculator.emicalcutator.meghachem.SIKKOConvert;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.financecalculator.emicalcutator.meghachem.R;
import com.financecalculator.emicalcutator.meghachem.Matisadapt.Currencyadapt;

import java.util.ArrayList;
import java.util.Currency;

public class COUNNationListActivity extends AppCompatActivity implements Currencyadapt.aclick {

    public Currencyadapt f41480D0;
    public RecyclerView f41482F0;
    public RelativeLayout f41483G0;
    public EditText f41484H0;
    public ImageView f41485I0;


    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_country_list);
        findViewById(R.id.ic_back).setOnClickListener(new a());
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rlsearch);
        this.f41483G0 = relativeLayout;
        relativeLayout.setVisibility(View.GONE);
        EditText editText = (EditText) findViewById(R.id.edit_search);
        this.f41484H0 = editText;
        editText.addTextChangedListener(new b());
        ImageView imageView = (ImageView) findViewById(R.id.ic_close);
        this.f41485I0 = imageView;
        imageView.setOnClickListener(new c());
        findViewById(R.id.ic_search).setOnClickListener(new d());
        this.f41482F0 = (RecyclerView) findViewById(R.id.rCountryLIst);
        this.f41480D0 = new Currencyadapt(this, GetNationData.h(), this);
        this.f41482F0.setHasFixedSize(true);
        this.f41482F0.setLayoutManager(new LinearLayoutManager(this));
        this.f41482F0.setAdapter(this.f41480D0);
    }

    @Override
    public void a(String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("cord", str);
        intent.putExtra("name", str2);
        COUNNationListActivity.this.setResult(-1, intent);
        COUNNationListActivity.this.finish();
    }

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            COUNNationListActivity.this.onBackPressed();
        }
    }

    public class b implements TextWatcher {
        public b() {
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
            COUNNationListActivity.this.c1(String.valueOf(charSequence));
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            COUNNationListActivity.this.f41483G0.setVisibility(8);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        public void onClick(View view) {
            COUNNationListActivity.this.f41483G0.setVisibility(0);
        }
    }

    public void c1(String str) {
        ArrayList arrayList = new ArrayList();
        for (Currency next : GetNationData.h()) {
            if (next.getDisplayName().toLowerCase().contains(str.toLowerCase())) {
                arrayList.add(next);
            }
        }
        if (arrayList.isEmpty()) {
            Toast.makeText(this, "No Data Found..", 0).show();
        } else {
            this.f41480D0.F(arrayList);
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
