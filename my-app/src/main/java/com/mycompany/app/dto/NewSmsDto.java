//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.mycompany.app.dto;

public class NewSmsDto {
    private String phone;
    private String text;

    public NewSmsDto(String phone, String text) {
        this.phone = phone;
        this.text = text;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
