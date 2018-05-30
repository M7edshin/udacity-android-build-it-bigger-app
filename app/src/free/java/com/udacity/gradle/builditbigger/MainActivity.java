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

        AdView mAdView = findViewById(R.id.adView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
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
