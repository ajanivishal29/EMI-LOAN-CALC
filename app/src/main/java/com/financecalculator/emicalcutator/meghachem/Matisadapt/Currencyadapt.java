package com.financecalculator.emicalcutator.meghachem.Matisadapt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.financecalculator.emicalcutator.meghachem.R;
import com.financecalculator.emicalcutator.meghachem.SIKKOConvert.COUNNationListActivity;

import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

public class Currencyadapt extends RecyclerView.Adapter<Currencyadapt.C0463b> {
    public aclick f33783c;
    public Context f33784d;
    public List<Currency> f33785e;

    @NonNull
    @Override
    public C0463b onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new C0463b(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull C0463b holder, int position) {
        holder.f33788H.setText(this.f33785e.get(position).getDisplayName());
        holder.f33789I.setOnClickListener(new a(position));
    }

    @Override
    public int getItemCount() {
        return this.f33785e.size();
    }

    public class a implements View.OnClickListener {

        public final int f33786X;

        public a(int i10) {
            this.f33786X = i10;
        }

        public void onClick(View view) {
            f33783c.a(f33785e.get(this.f33786X).getCurrencyCode(), f33785e.get(this.f33786X).getDisplayName());
        }
    }

    public class C0463b extends RecyclerView.ViewHolder {
        public TextView f33788H;
        public RelativeLayout f33789I;

        public C0463b(View view) {
            super(view);
            this.f33788H = (TextView) view.findViewById(R.id.tData_);
            this.f33789I = (RelativeLayout) view.findViewById(R.id.cv1);
        }
    }

    public Currencyadapt(COUNNationListActivity COUNNationListActivity, List<Currency> list, aclick aVar) {
        this.f33784d = COUNNationListActivity;
        this.f33785e = list;
        this.f33783c = aVar;
    }

    public void F(ArrayList<Currency> arrayList) {
        this.f33785e = arrayList;
        notifyDataSetChanged();
    }

    public interface aclick {
        void a(String str, String str2);
    }

}
