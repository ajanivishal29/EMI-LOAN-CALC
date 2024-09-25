package com.financecalculator.emicalcutator.meghachem.BMOBInfo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.financecalculator.emicalcutator.meghachem.R;

public class BMOBInfoActivity extends AppCompatActivity {
    public Activity activity;
    String balance;
    CardView balanceCard;
    TextView balanceNumber;
    CardView balancephonecall;
    TextView bankname;
    ImageView banksym;
    String customer;
    CardView customerCard;
    TextView customerNumber;
    CardView customerphonecall;
    int img;
    CardView ministatemenphonecall;
    CardView ministatementCard;
    TextView ministatementNumber;
    RelativeLayout sharebalancenumber;
    RelativeLayout sharecustomernumber;
    RelativeLayout sharestatementnumber;
    String statement;
    String title;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_bankinfo);
        activity = this;
        PanichaMV9.dis_ATnative(activity, findViewById(R.id.native_ad_container));
        minit();
        ongobt();
    }

    public void ongobt() {
        this.sharebalancenumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", BMOBInfoActivity.this.title + " to check the bank balance number is :---" + BMOBInfoActivity.this.balance);
                BMOBInfoActivity BNBInfo_Activity = BMOBInfoActivity.this;
                BNBInfo_Activity.startActivity(Intent.createChooser(intent, BNBInfo_Activity.getResources().getText(R.string.app_name)));
            }
        });
        this.sharecustomernumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", BMOBInfoActivity.this.title + " to check the customercare number is :---" + BMOBInfoActivity.this.customer);
                BMOBInfoActivity BNBInfo_Activity = BMOBInfoActivity.this;
                BNBInfo_Activity.startActivity(Intent.createChooser(intent, BNBInfo_Activity.getResources().getText(R.string.app_name)));
            }
        });
        this.sharestatementnumber.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", BMOBInfoActivity.this.title + " to check the ministatement number is :---" + BMOBInfoActivity.this.statement);
                BMOBInfoActivity BNBInfo_Activity = BMOBInfoActivity.this;
                BNBInfo_Activity.startActivity(Intent.createChooser(intent, BNBInfo_Activity.getResources().getText(R.string.app_name)));
            }
        });

        this.balancephonecall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BMOBInfoActivity BNBInfo_Activity = BMOBInfoActivity.this;
                BNBInfo_Activity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + BMOBInfoActivity.this.balance)));
            }
        });
        this.customerphonecall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                BMOBInfoActivity BNBInfo_Activity = BMOBInfoActivity.this;
                BNBInfo_Activity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + BMOBInfoActivity.this.customer)));
            }
        });
        this.ministatemenphonecall.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BMOBInfoActivity BNBInfo_Activity = BMOBInfoActivity.this;
                BNBInfo_Activity.startActivity(new Intent("android.intent.action.DIAL", Uri.parse("tel:" + BMOBInfoActivity.this.statement)));
            }
        });
    }

    public void minit() {
        this.title = getIntent().getStringExtra("title");
        this.balance = getIntent().getStringExtra("balance");
        this.customer = getIntent().getStringExtra("customer");
        this.statement = getIntent().getStringExtra("statement");
        this.img = getIntent().getIntExtra("img", 0);
        ImageView imageView = (ImageView) findViewById(R.id.bankname_view_img);
        this.banksym = imageView;
        imageView.setImageResource(this.img);
        TextView textView = (TextView) findViewById(R.id.bankname_view_title);
        this.bankname = textView;
        textView.setText(this.title);
        this.balanceNumber = (TextView) findViewById(R.id.check_balance_number);
        this.customerNumber = (TextView) findViewById(R.id.customer_care_number);
        this.ministatementNumber = (TextView) findViewById(R.id.mini_statement_number);
        this.balanceCard = (CardView) findViewById(R.id.check_balance_card);
        this.customerCard = (CardView) findViewById(R.id.customer_care_card);
        this.ministatementCard = (CardView) findViewById(R.id.mini_statement_card);
        this.balancephonecall = (CardView) findViewById(R.id.balance_phonecall);
        this.customerphonecall = (CardView) findViewById(R.id.customercare_phonecall);
        this.ministatemenphonecall = (CardView) findViewById(R.id.statement_phonecall);
        this.sharebalancenumber = (RelativeLayout) findViewById(R.id.share1);
        this.sharecustomernumber = (RelativeLayout) findViewById(R.id.share2);
        this.sharestatementnumber = (RelativeLayout) findViewById(R.id.share3);
        this.balanceNumber.setText(this.balance);
        this.customerNumber.setText(this.customer);
        this.ministatementNumber.setText(this.statement);
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
