package com.financecalculator.emicalcutator.meghachem.BMOBInfo;

public class BMOBModel {
    String balance;
    String customer;
    int img;
    String statement;
    String title;

    public BMOBModel(String str, String str2, String str3, int i, String str4) {
        this.img = i;
        this.title = str;
        this.balance = str2;
        this.customer = str3;
        this.statement = str4;
    }

    public int getImg() {
        return this.img;
    }

    public void setImg(int i) {
        this.img = i;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String getBalance() {
        return this.balance;
    }

    public void setBalance(String str) {
        this.balance = str;
    }

    public String getCustomer() {
        return this.customer;
    }

    public void setCustomer(String str) {
        this.customer = str;
    }

    public String getStatement() {
        return this.statement;
    }

    public void setStatement(String str) {
        this.statement = str;
    }
}
