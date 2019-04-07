package com.example.wordsnaps;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class FictionalCharacters extends AppCompatActivity {

    taboos taboo = new taboos();
    int[] fictionals = taboo.getFictionalImg();
    public int gnum, secPassed = 0;
    CountDownTimer timer = new CountDownTimer(taboo.getMillis(), 1000) {
        @Override
        public void onTick(long millisLeft) {
            secPassed+=1000;
            TextView textViewCorrect = (TextView) findViewById(R.id.timer);
            textViewCorrect.setText("Time Left: " + (taboo.getMillis()-secPassed)/1000);
        }

        @Override
        public void onFinish() {
            TextView textViewCorrect = (TextView) findViewById(R.id.timer);
            textViewCorrect.setText("Done");
            end();
        }
    }.start();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fictional_characters);
        gnum = taboo.genNum();
        TextView textViewCorrect = (TextView) findViewById(R.id.correct_score);
        textViewCorrect.setText("Correct: " + taboo.getCorrect());
        TextView textViewSkip = (TextView) findViewById(R.id.skip_score);
        textViewSkip.setText("Skipped: " + taboo.getSkip());
        ImageView card = (ImageView) findViewById(R.id.card);
        card.setImageResource(fictionals[gnum]);

        Button correct = (Button) findViewById(R.id.correct);
        correct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                correct(v);
            }
        });

        Button skip = (Button) findViewById(R.id.skip);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skip(v);
            }
        });
    }
    protected void correct(View v)
    {
        taboo.setMillis(secPassed);
        taboo.correct();
        Intent correctIntent = new Intent(this, FictionalCharacters.class);
        startActivity(correctIntent);

    }
    protected void skip(View v)
    {
        taboo.setMillis(secPassed);
        taboo.skip();
        Intent skipIntent = new Intent(this, FictionalCharacters.class);
        startActivity(skipIntent);

    }
    protected void end(){
        Intent endIntent = new Intent(this, EndScreen.class);
        startActivity(endIntent);
    }
    }


