package com.example.helpfromhomeproject.Domain;

public class FoodItemsDomain {
     static String title;
    int pic;

    public  FoodItemsDomain(String title, int pic){
        this.title = title;
        this.pic = pic;

    }

    public static String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public int getPic(){
        return pic;
    }

    public void setPic(int pic){
        this.pic = pic;
    }
}
