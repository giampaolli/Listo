package com.example.milenal.listoapp.model;

public class Roover {

    private String itemProgression;

    public Roover(){}

    public  Roover(String item){
        this.itemProgression = item;
    }

    public String getItemProgression() {
        return itemProgression;
    }

    public void setItemProgression(String itemProgression) {
        this.itemProgression = itemProgression;
    }
}
