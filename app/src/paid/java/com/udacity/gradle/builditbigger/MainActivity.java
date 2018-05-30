package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import e.m7eds.jokeandroidlib.JokeActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadTheJoke(View view){
        TellAJokeAsyncTask tellAJokeAsyncTask = new TellAJokeAsyncTask();
        tellAJokeAsyncTask.execute(new TellAJokeAsyncTask.OnEventListener() {
            @Override
            public void onEvent(String joke) {
                Intent myIntent = new Intent(MainActivity.this, JokeActivity.class);
                myIntent.putExtra("JOKE_KEY", joke);
                startActivity(myIntent);
            }
        });
    }

}
