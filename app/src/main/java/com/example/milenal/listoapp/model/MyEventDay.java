package com.example.milenal.listoapp.model;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import com.applandeo.materialcalendarview.EventDay;

import java.util.Calendar;

public class MyEventDay extends EventDay implements Parcelable {

    private String note;

    public MyEventDay(Calendar day, int imageResource, String note){
        super(day, imageResource);
        this.note = note;
    }

    public String getNote(){
        return note;
    }

    private MyEventDay(Parcel in){
        super((Calendar) in.readSerializable(), in.readInt());
        note = in.readString();
    }

    public static final Creator<MyEventDay> CREATOR = new Creator<MyEventDay>() {
        @Override
        public MyEventDay createFromParcel(Parcel source) {
            return new MyEventDay(source);
        }

        @Override
        public MyEventDay[] newArray(int size) {
            return new MyEventDay[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeSerializable(getCalendar());
        parcel.writeInt((int) getImageDrawable());
        parcel.writeString(note);
    }
}