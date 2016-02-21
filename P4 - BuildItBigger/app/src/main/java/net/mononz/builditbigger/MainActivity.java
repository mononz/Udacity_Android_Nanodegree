package net.mononz.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

import net.mononz.joker.JokeActivity;

public class MainActivity extends AppCompatActivity {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (ProgressBar) findViewById(R.id.progress_wait);
    }

    public void tellJoke(View view) {
        spinner.setVisibility(View.VISIBLE);
        new JokeGrabber(new JokeListener() {
            @Override
            public void onComplete(String joke) {
                spinner.setVisibility(View.GONE);
                Intent intent = new Intent(MainActivity.this, JokeActivity.class);
                intent.putExtra(JokeActivity.JOKE_KEY, joke);
                startActivity(intent);
            }
        }).grabTastyJoke();

    }

}