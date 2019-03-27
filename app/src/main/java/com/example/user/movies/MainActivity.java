package com.example.user.movies;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button superhero, action, animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        superhero=(Button) findViewById(R.id.superhero);
        action=(Button) findViewById(R.id.action);
        animation=(Button) findViewById(R.id.animation);

        superhero.setOnClickListener(this);
        action.setOnClickListener(this);
        animation.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent i = new Intent(MainActivity.this, MovieDetails.class);

        switch (v.getId())
        {
            case R.id.superhero:
                i.putExtra("movieSpinnerValue",0);
                startActivityForResult(i,0);
                break;

            case R.id.action:
                i.putExtra("movieSpinnerValue", 1);
                startActivityForResult(i,0);
                break;

            case R.id.animation:
                i.putExtra("movieSpinnerValue", 2);
                startActivityForResult(i,0);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK){
            setContentView(R.layout.booking);
            PostData bookingdata = data.getParcelableExtra("bookingData");

            TextView title = (TextView)findViewById(R.id.secondTitle);
            title.setText(bookingdata.getFromTitle());

            TextView date = (TextView) findViewById(R.id.secondDate);
            date.setText(bookingdata.getFromDate()+", "+bookingdata.getFromTime());

            TextView tickets = (TextView) findViewById(R.id.secondTickets);
            tickets.setText(bookingdata.getFromTickets());

            ImageView movieImage=(ImageView)findViewById(R.id.movieImage);
            movieImage.setImageResource(bookingdata.getFromImage());
        }
    }

}
