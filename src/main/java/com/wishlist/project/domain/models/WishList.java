package com.wishlist.project.domain.models;

public class WishList {
    private long id;
    private long userId;
    private String name;
    private String notes;
    private String code;

    public WishList(String name, String notes, String code) {
        this.name = name;
        this.notes = notes;
        this.code = code;
    }

    public WishList() {

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
}
