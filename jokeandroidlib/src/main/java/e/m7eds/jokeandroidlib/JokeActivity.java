package e.m7eds.jokeandroidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import e.m7eds.jokeslibrary.Joke;


public class JokeActivity extends AppCompatActivity {

    private TextView tv_joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        tv_joke = findViewById(R.id.tv_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra("JOKE_KEY");

        tv_joke.setText(joke);

    }

}
