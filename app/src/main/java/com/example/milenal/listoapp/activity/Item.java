package com.example.milenal.listoapp.activity;

import java.io.Serializable;

public class Item implements Serializable {

    private String name;
    private Boolean isSelected = Boolean.FALSE;

    public Item(String name) {
        this.name = name;
    }

    public Item() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null)
            return false;

        Item itemCompare = (Item) obj;
        if(itemCompare.getName().equals(this.getName()))
            return true;

        return false;
    }
}