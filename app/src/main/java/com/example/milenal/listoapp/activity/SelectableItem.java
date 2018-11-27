package com.example.milenal.listoapp.activity;

public class SelectableItem extends Item {

    private boolean isSelected;

    public SelectableItem(Item item){
        super(item.getName());
        this.isSelected = item.getSelected();
    }

    public boolean isSelected(){
        return isSelected;
    }

    public void setSelected(boolean selected){
        isSelected = selected;
    }
}