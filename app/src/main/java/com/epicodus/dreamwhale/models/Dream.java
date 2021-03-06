package com.epicodus.dreamwhale.models;

import org.parceler.Parcel;

import java.text.SimpleDateFormat;

@Parcel
public class Dream {
    public Long date;
    public Long dateInverse;
    public String color;
    public String description;
    public boolean isPublic;
    public String pushId;

    public Dream() {}

    public Dream(Long date, String color, String description, boolean isPublic) {
        this.date = date;
        this.color = color;
        this.description = description;
        this.isPublic = isPublic;
        this.dateInverse = date*-1;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public void setPublic(boolean isPublic) {
        this.isPublic = isPublic;
    }

    public boolean getPublic() {
        return isPublic;
    }

    public Long getDate() { return date; }

    public void setPushId(String pushId) {
        this.pushId = pushId;
    }
}
