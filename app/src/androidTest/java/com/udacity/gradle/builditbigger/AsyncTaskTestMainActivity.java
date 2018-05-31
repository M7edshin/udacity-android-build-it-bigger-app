package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AsyncTaskTestMainActivity {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testJokeAsyncTask(){

        onView(withId(R.id.btn_tell_joke)).perform(click());
        final TellAJokeAsyncTask tellAJokeAsyncTask = new TellAJokeAsyncTask();

        TellAJokeAsyncTask.OnEventListener onEventListener = new TellAJokeAsyncTask.OnEventListener() {
            @Override
            public void onEvent(String joke) {
                try {
                    String myJoke = tellAJokeAsyncTask.get(30, TimeUnit.SECONDS);
                    assertTrue("There is no joke!!!!", myJoke.length() > 0);
                } catch (Exception e) {
                    Log.i("TAG", e.getMessage());
                }
            }
        };

    }
}
