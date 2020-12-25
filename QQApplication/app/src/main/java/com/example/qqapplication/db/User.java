package com.example.qqapplication.db;

import org.litepal.crud.LitePalSupport;

public class User extends LitePalSupport {
    private int imageId;
    private String Name;

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
