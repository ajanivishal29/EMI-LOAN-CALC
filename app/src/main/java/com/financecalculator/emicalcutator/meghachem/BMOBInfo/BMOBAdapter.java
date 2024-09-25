package com.financecalculator.emicalcutator.meghachem.BMOBInfo;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.financecalculator.emicalcutator.meghachem.R;

import java.util.ArrayList;

public class BMOBAdapter extends RecyclerView.Adapter<BMOBAdapter.BankHolder> {
    Activity mContext;
    ArrayList<BMOBModel> mListData;

    public BMOBAdapter(Activity context, ArrayList<BMOBModel> arrayList) {
        this.mContext = context;
        this.mListData = arrayList;
    }

    public BankHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new BankHolder(LayoutInflater.from(this.mContext).inflate(R.layout.bankname_item, viewGroup, false));
    }

    public void onBindViewHolder(BankHolder bankHolder, int i) {
        final String title = this.mListData.get(i).getTitle();
        final String balance = this.mListData.get(i).getBalance();
        final String customer = this.mListData.get(i).getCustomer();
        final String statement = this.mListData.get(i).getStatement();
        final int img = this.mListData.get(i).getImg();
        bankHolder.bankTitle.setText(title);
        bankHolder.bankImg.setImageResource(img);
        bankHolder.bankViewName.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(mContext, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(BMOBAdapter.this.mContext, BMOBInfoActivity.class);
                        intent.putExtra("title", title);
                        intent.putExtra("balance", balance);
                        intent.putExtra("customer", customer);
                        intent.putExtra("statement", statement);
                        intent.putExtra("img", img);
                        mContext.startActivity(intent);
                    }
                });
            }
        });
    }

    public int getItemCount() {
        return this.mListData.size();
    }

    public class BankHolder extends RecyclerView.ViewHolder {
        ImageView bankImg;
        TextView bankTitle;
        RelativeLayout bankViewName;

        public BankHolder(View view) {
            super(view);
            this.bankViewName = (RelativeLayout) view.findViewById(R.id.bank_view_name);
            this.bankImg = (ImageView) view.findViewById(R.id.bank_view_img);
            this.bankTitle = (TextView) view.findViewById(R.id.bank_view_title);
        }
    }
}
