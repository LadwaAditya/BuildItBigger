package com.example.jokeandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {
    private TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);
        jokeTextView = (TextView) findViewById(R.id.jokeTextView);
        String joke = getIntent().getStringExtra(Intent.EXTRA_TEXT);

        jokeTextView.setText(joke);
    }
}
