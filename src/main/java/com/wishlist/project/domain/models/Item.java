package com.wishlist.project.domain.models;

public class Item {
    private String name;
    private long wishListId;
    private String imageUrl;
    private double price;
    private String location;
    private String notes;
    private boolean reserved = false;
    private String date;

    public Item(String name, long wishListId, String imageUrl,
                double price, String location,
                String notes, String date) {
        this.name = name;
        this.wishListId = wishListId;
        this.imageUrl = imageUrl;
        this.price = price;
        this.location = location;
        this.notes = notes;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getWishListId() {
        return wishListId;
    }

    public void setWishListId(long wishListId) {
        this.wishListId = wishListId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isReserved() {
        return reserved;
    }

    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", notes='" + notes + '\'' +
                ", reserved=" + reserved +
                '}';
    }
}

