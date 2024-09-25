package com.financecalculator.emicalcutator.meghachem;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.financecalculator.emicalcutator.meghachem.SIKKOConvert.COUNSIKKOConVTActivity;
import com.silent.Vignasdk.vorbatility.PanichaApp;
import com.silent.Vignasdk.vorbatility.paniALLDS.PanichaInter;
import com.silent.Vignasdk.vorbatility.PanichaMV9;
import com.financecalculator.emicalcutator.meghachem.BMOBInfo.BMOBListActivity;
import com.financecalculator.emicalcutator.meghachem.MatisALLTOOL.MCOBBusinessLoanActivity;
import com.financecalculator.emicalcutator.meghachem.MatisALLTOOL.MCOBFDLoanCALActivity;
import com.financecalculator.emicalcutator.meghachem.MatisALLTOOL.MCOBGSTCalActivity;
import com.financecalculator.emicalcutator.meghachem.MatisALLTOOL.PPFCalculatorActivity;
import com.financecalculator.emicalcutator.meghachem.MatisALLTOOL.MCOBRDLoanCalActivity;
import com.financecalculator.emicalcutator.meghachem.MatisALLTOOL.MCOBROICalActivity;
import com.financecalculator.emicalcutator.meghachem.MatisALLTOOL.MCOBEMICalActivity;

public class DOBARHHActivity extends AppCompatActivity {
    public Activity activity;
    ImageView btn_BankBalance;
    ImageView btn_BusinessLoanCal;
    ImageView btn_FdLoanCal;
    ImageView btn_HomeLoanCal;
    ImageView btn_RdLoanCal;
    ImageView btn_GstnCal;
    ImageView btn_ROICal;
    ImageView btn_PPFCal;
    ImageView btn_EmICalc;
    ImageView btn_currencyconverter;
    public DOBARHHActivity DOBARHHActivity =this;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        activity = this;
        PanichaMV9.dis_ATnative(activity, findViewById(R.id.native_ad_container));
        PanichaMV9.dis_ATsmallnative(activity, findViewById(R.id.small_native));

        init();
        onclick();
    }

    private void onclick() {

        this.btn_BankBalance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DOBARHHActivity.this, BMOBListActivity.class);
                        DOBARHHActivity.this.startActivity(intent);
                    }
                });
            }
        });
        this.btn_HomeLoanCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DOBARHHActivity.this, MCOBEMICalActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        this.btn_BusinessLoanCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DOBARHHActivity.this, MCOBBusinessLoanActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        this.btn_FdLoanCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DOBARHHActivity.this, MCOBFDLoanCALActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        this.btn_RdLoanCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DOBARHHActivity.this, MCOBRDLoanCalActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });
        this.btn_GstnCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DOBARHHActivity.this, MCOBGSTCalActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        this.btn_ROICal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DOBARHHActivity.this, MCOBROICalActivity.class);
                        startActivity(intent);

                    }
                });
            }
        });

        this.btn_PPFCal.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DOBARHHActivity.this, PPFCalculatorActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

        this.btn_EmICalc.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DOBARHHActivity.this, MCOBEMICalActivity.class);
                        intent.putExtra("id",1);
                        startActivity(intent);
                    }
                });


            }
        });
        this.btn_currencyconverter.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PanichaMV9.dis_ATinter(activity, new PanichaInter.Ivorycallback() {
                    @Override
                    public void onTasknext() {
                        Intent intent = new Intent(DOBARHHActivity.this, COUNSIKKOConVTActivity.class);
                        startActivity(intent);
                    }
                });

            }
        });
    }

    public void init() {

        this.btn_BankBalance = (ImageView) findViewById(R.id.btn_BankBalance);
        this.btn_HomeLoanCal = (ImageView) findViewById(R.id.btn_HomeLoanCal);
        this.btn_BusinessLoanCal = (ImageView) findViewById(R.id.btn_BusinessLoanCal);
        this.btn_FdLoanCal = (ImageView) findViewById(R.id.btn_FdLoanCal);
        this.btn_RdLoanCal = (ImageView) findViewById(R.id.btn_RdLoanCal);
        this.btn_GstnCal = (ImageView) findViewById(R.id.btn_GStcalc);
        this.btn_ROICal = (ImageView) findViewById(R.id.btn_ROICalc);
        this.btn_PPFCal = (ImageView) findViewById(R.id.btn_PPFCal);
        this.btn_EmICalc = (ImageView) findViewById(R.id.btn_EmICalc);
        this.btn_currencyconverter = (ImageView) findViewById(R.id.btn_currencyconverter);
    }

    @Override
    public void onBackPressed() {
        if (PanichaApp.preferences.getString(PanichaApp.bikky_exit_interT, "").equalsIgnoreCase("off")) {
            finish();
        } else {
            PanichaMV9.dis_ATexitinter(DOBARHHActivity, () -> finish());
        }
    }
}

