package com.example.user.movies;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class MovieData{

    String movieTitle, rating, casts, duration;
    int movieTime, movieImage;

    public String getRating() {
        return rating;
    }

    public String getCasts() {
        return casts;
    }

    public String getDuration() {
        return duration;
    }

    public int getMovieTime() {
        return movieTime;
    }

    public int getMovieImage() {
        return movieImage;
    }



    public MovieData(String title, String rating, String casts, String duration, int movieTime, int movieImage){
        this.movieTitle=title;
        this.rating=rating;
        this.casts=casts;
        this.duration=duration;
        this.movieTime=movieTime;
        this.movieImage=movieImage;
    }

    public static ArrayList<MovieData> createAction()
    {
        ArrayList<MovieData>movieDetails = new ArrayList<MovieData>();
        movieDetails.add(new MovieData("Mission Impossible: Fallout", "7.2", "Tom Cruise, Rebecca Ferguson", "180 mins",R.array.miTime,R.drawable.mi6));
        movieDetails.add(new MovieData("Rampage", "6.5", "Dwayne Johnson", "150 mins",R.array.rampageTime,R.drawable.rampage));
        movieDetails.add(new MovieData("Jusrassic World: Fallen Kingdom", "7.5", "Chris Pratt, Bryce Dallas", "120 mins",R.array.jurassicTime,R.drawable.jurassic));
        movieDetails.add(new MovieData("Sky Scrapper", "7.0", "Dwayne Johnson, Neve Campbell", "120 mins",R.array.skyTime,R.drawable.sky));
        movieDetails.add(new MovieData("The Meg", "8.2", "Jason Statham, Ruby Rose", "120 mins",R.array.megTime,R.drawable.meg));
        return movieDetails;
    }

    public static ArrayList<MovieData> createSuperHero()
    {
        ArrayList<MovieData>movieDetails = new ArrayList<MovieData>();
        movieDetails.add(new MovieData("Aquaman", "7.5", "Jason Momoa", "180 mins",R.array.aquaTime,R.drawable.auqa));
        movieDetails.add(new MovieData("Avengers: Infinity War", "9.0", "Chris Hemsworth", "150 mins",R.array.avengersTime,R.drawable.ave));
        movieDetails.add(new MovieData("Dead Pool 2", "8.3", "Ryan Reynolds", "120 mins",R.array.deadTime,R.drawable.dead));
        movieDetails.add(new MovieData("Ant Man and the Wasp", "8.5", "Paul Rudd", "120 mins",R.array.antTime,R.drawable.ant));
        return movieDetails;
    }

    public static ArrayList<MovieData> createAnimation()
    {
        ArrayList<MovieData>movieDetails = new ArrayList<MovieData>();
        movieDetails.add(new MovieData("Incredibles 2", "7.2", " ", "90 mins",R.array.incrediblesTime,R.drawable.incre));
        movieDetails.add(new MovieData("Hotel Transylvania 3", "7.5", " ", "120 mins",R.array.hotelTime,R.drawable.hotel));
        movieDetails.add(new MovieData("Peter Rabit", "6.4", " ", "120 mins",R.array.peterTime,R.drawable.peter));
        return movieDetails;
    }

}
