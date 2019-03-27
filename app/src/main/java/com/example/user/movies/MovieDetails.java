package com.example.user.movies;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MovieDetails extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener{

    private TextView rating, duration, casts, date, tickets;
    private Spinner spinnerMovie, spinnerTime;
    private int mYear, mMonth, mDay;
    private Button plus, minus, submit;
    private int ticketsNumber=0,imageNo;
    private ArrayList<MovieData>movies;
    private ArrayAdapter<CharSequence> movieAdapter;
    private boolean dateSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);

        init();
        spinnerMovie.setOnItemSelectedListener(this);
        setAdapter();
    }

    public void init(){
        spinnerMovie=(Spinner) findViewById(R.id.spinnerMovie);
        spinnerTime=(Spinner) findViewById(R.id.spinnerTime);
        rating=(TextView) findViewById(R.id.rating);
        duration=(TextView)findViewById(R.id.duration);
        casts=(TextView)findViewById(R.id.cast);
        date=(TextView)findViewById(R.id.pickDate);
        tickets=(TextView)findViewById(R.id.numofTickets);
        plus=(Button)findViewById(R.id.plus);
        minus=(Button)findViewById(R.id.minus);
        submit=(Button)findViewById(R.id.submit);

        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        date.setText(df.format(Calendar.getInstance().getTime()));
        dateSelected=false;

        date.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        submit.setOnClickListener(this);
    }

    public void setAdapter(){

        Intent i = getIntent();
        int value=i.getIntExtra("movieSpinnerValue",0);

        if(value==0){
            movies=MovieData.createAction();
            movieAdapter=ArrayAdapter.createFromResource(this,R.array.acion,android.R.layout.simple_spinner_item);
        }else if(value==1){
            movies=MovieData.createSuperHero();
            movieAdapter=ArrayAdapter.createFromResource(this,R.array.superhero,android.R.layout.simple_spinner_item);
        } else if(value==2){
            movies=MovieData.createAnimation();
            movieAdapter=ArrayAdapter.createFromResource(this,R.array.animation,android.R.layout.simple_spinner_item);
        }
        movieAdapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinnerMovie.setAdapter(movieAdapter);
    }

    @Override
    public void onClick(View v) {
        if (v == date) {

            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(MovieDetails.this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                {
                    c.set(year, monthOfYear, dayOfMonth);

                    date.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    dateSelected=true;
                }
            }, mYear, mMonth, mDay);

            datePickerDialog.getDatePicker().setMinDate(c.getTimeInMillis());
            c.add(Calendar.DATE, 3);
            datePickerDialog.getDatePicker().setMaxDate(c.getTimeInMillis());
            datePickerDialog.show();
        }

        if(v==minus){
            if(ticketsNumber>0){
                ticketsNumber--;
                tickets.setText(String.valueOf(ticketsNumber));
            }
        }

        if(v == plus){
            ticketsNumber++;
            tickets.setText(String.valueOf(ticketsNumber));
        }

        if(v == submit){
            if(ticketsNumber>0 && dateSelected){
                PostData bookingData = new PostData(spinnerMovie.getSelectedItem().toString(), date.getText().toString(),
                        spinnerTime.getSelectedItem().toString(), tickets.getText().toString(),imageNo);

                Intent i = new Intent(MovieDetails.this,MainActivity.class);
                i.putExtra("bookingData", bookingData);
                i.putExtra("getMain",1);
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        duration.setText(movies.get(position).getDuration());
        rating.setText(movies.get(position).getRating());
        casts.setText(movies.get(position).getCasts());
        imageNo=movies.get(position).getMovieImage();
        ArrayAdapter<CharSequence> adapterTime=ArrayAdapter.createFromResource(this, movies.get(position).getMovieTime(), android.R.layout.simple_spinner_item);
        adapterTime.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinnerTime.setAdapter(adapterTime);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}