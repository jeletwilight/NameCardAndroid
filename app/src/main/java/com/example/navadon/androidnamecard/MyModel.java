package com.example.navadon.androidnamecard;

import android.arch.lifecycle.ViewModel;
import android.media.Image;

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

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public Image getTopBar() {
        return topBar;
    }

    public void setTopBar(Image topBar) {
        this.topBar = topBar;
    }

    public Image getBottomBar() {
        return bottomBar;
    }

    public void setBottomBar(Image bottomBar) {
        this.bottomBar = bottomBar;
    }

    private String name;
    private String nickname;
    private String address;
    private String email;
    private String phone;
    private String line;

    private Image avatar;
    private Image topBar;
    private Image bottomBar;

    public MyModel() {
        this.name = "Name Text";
        this.nickname = "Nickname Text";
        this.address = "Address Text";
        this.email = "Email Text";
        this.phone = "Phone Text";
        this.line = "Line Text";
        this.avatar = null;
        this.topBar = null;
        this.bottomBar = null;
    }


}
