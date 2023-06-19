package com.example.helpfromhomeproject.Domain;

public class VoucherDomain {

    private String company;
    private int pic;

    public VoucherDomain(String company, int pic){
        this.company = company;
        this.pic = pic;
    }

    public String getCompany(){
        return company;
    }
    public void setCompany(){ this.company = company; }

    public int getPic(){
        return pic;
    }
    public void setPic(){ this.pic = pic; }
}


