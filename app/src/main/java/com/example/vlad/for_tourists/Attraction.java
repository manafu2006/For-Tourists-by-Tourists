package com.example.vlad.for_tourists;

public class Attraction {

    private String name, location, desc, imageURL, bookingUrl;
    private boolean canBook;

    public Attraction(){

    }

    public Attraction(String name, String location, String desc, String imageURL, String bookingUrl, boolean canBook) {
        this.name = name;
        this.location = location;
        this.desc = desc;
        this.imageURL = imageURL;
        this.bookingUrl = bookingUrl;
        this.canBook = canBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getBookingUrl() {
        return bookingUrl;
    }

    public void setBookingUrl(String bookingUrl) {
        this.bookingUrl = bookingUrl;
    }

    public boolean isCanBook() {
        return canBook;
    }

    public void setCanBook(boolean canBook) {
        this.canBook = canBook;
    }
}
