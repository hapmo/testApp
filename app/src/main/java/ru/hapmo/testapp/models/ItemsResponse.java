package ru.hapmo.testapp.models;

import java.util.List;

public class ItemsResponse {

    private int code;

    private List<Item> message;

    public List<Item> getMessage() {
        return message;
    }

    public void setMessage(List<Item> message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}