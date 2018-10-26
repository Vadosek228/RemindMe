package com.vadosek.remindme.dto;

public class RemindDTO {

    private String title;

    public RemindDTO(String title) { //будет заполнять заданное поле
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


