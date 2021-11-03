package com.wishlist.project.domain.models;

public class Wishlist {
    private long id;
    private long userId;
    private String name;
    private String notes;
    private String code;
    private String date;

    public Wishlist(long userId, String name, String notes, String code, String date) {
        this.userId = userId;
        this.name = name;
        this.notes = notes;
        this.code = code;
        this.date = date;
    }

    public Wishlist() {

    }

    public long getId() {
        return id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
