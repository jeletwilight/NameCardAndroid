package com.example.navadon.androidnamecard;

import android.arch.lifecycle.ViewModel;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.widget.Button;

public class MyModel extends ViewModel {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }


    public Integer getImgSrc1() {
        return imgSrc1;
    }

    public void setImgSrc1(int imgSrc1) {
        this.imgSrc1 = imgSrc1;
    }

    public int getColorSrc1() {
        return colorSrc1;
    }

    public void setColorSrc1(int colorSrc1) {
        this.colorSrc1 = colorSrc1;
    }

    private int imgSrc1;
    private int colorSrc1;

    private String name;
    private String nickname;
    private String address;
    private String email;
    private String phone;
    private String line;


    public MyModel() {
        this.name = "Name Text";
        this.nickname = "NNNN";
        this.address = "Address Text";
        this.email = "Email Text";
        this.phone = "Phone Text";
        this.line = "Line Text";
    }


}
