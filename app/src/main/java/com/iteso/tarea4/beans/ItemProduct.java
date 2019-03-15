package com.iteso.tarea4.beans;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemProduct implements Parcelable {

    private String store;
    private String phone;
    private String title;
    private String description;
    private String code;
    private int image;
    private String location;

    @Override
    public String toString() {
        return "ItemProduct{" +
                "store='" + store + '\'' +
                ", phone='" + phone + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", code='" + code + '\'' +
                ", image=" + image +
                ", location='" + location + '\'' +
                ", category=" + category +
                '}';
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    private int category;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.store);
        dest.writeString(this.phone);
        dest.writeString(this.title);
        dest.writeString(this.description);
        dest.writeString(this.code);
        dest.writeInt(this.image);
        dest.writeString(this.location);
        dest.writeInt(this.category);
    }

    public static final Creator<ItemProduct> CREATOR = new Creator<ItemProduct>() {
        @Override
        public ItemProduct createFromParcel(Parcel source) {
            return new ItemProduct(source);
        }

        @Override
        public ItemProduct[] newArray(int size) {
            return new ItemProduct[size];
        }
    };

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ItemProduct (Parcel in){
        this.store = in.readString();
        this.phone = in.readString();
        this.title = in.readString();
        this.description = in.readString();
        this.code = in.readString();
        this.image = in.readInt();
        this.location = in.readString();
        this.category = in.readInt();
    }

    public ItemProduct(){

    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
