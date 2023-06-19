package com.example.helpfromhomeproject.Domain;

import java.util.List;

public class TopPicksDomain {
    private String title;
    private int pic;
    private String price;
    private String distance;

    private String description;



    public TopPicksDomain(String title, int pic, String price, String distance, String description ){
        this.title = title;
        this.pic = pic;
        this.price = price;
        this.distance = distance;
        this.description = description;

    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}


