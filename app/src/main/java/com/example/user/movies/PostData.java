package com.example.user.movies;

import android.os.Parcel;
import android.os.Parcelable;

public class PostData implements Parcelable{
    String fromTitle, fromDate, fromTime, fromTickets;
    int fromImage;

    public PostData(String movieTitle, String date, String time, String tickets,int Image){
        this.fromImage=Image;
        this.fromTitle=movieTitle;
        this.fromDate=date;
        this.fromTime=time;
        this.fromTickets=tickets;
    }

    protected PostData(Parcel in) {
        fromTitle = in.readString();
        fromDate = in.readString();
        fromTime = in.readString();
        fromTickets = in.readString();
        fromImage = in.readInt();
    }

    public static final Creator<PostData> CREATOR = new Creator<PostData>() {
        @Override
        public PostData createFromParcel(Parcel in) {
            return new PostData(in);
        }

        @Override
        public PostData[] newArray(int size) {
            return new PostData[size];
        }
    };

    public String getFromTitle() {
        return fromTitle;
    }

    public String getFromDate() {
        return fromDate;
    }

    public String getFromTime() {
        return fromTime;
    }

    public String getFromTickets() {
        return fromTickets;
    }

    public int getFromImage() {
        return fromImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fromTitle);
        dest.writeString(fromDate);
        dest.writeString(fromTime);
        dest.writeString(fromTickets);
        dest.writeInt(fromImage);
    }
}
