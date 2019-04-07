package com.example.wordsnaps;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);



        Button playAgain = (Button) (TextView) findViewById(R.id.playAgain);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View c) {

                playAgain(c);
            }
        });

        taboos tabooInfo = new taboos();
        TextView numCorrect = (TextView) findViewById(R.id.numCorrect);
        numCorrect.setText(tabooInfo.getCorrect() + " Correct");
        TextView numSkipped = (TextView) findViewById(R.id.numSkipped);
        numSkipped.setText(tabooInfo.getSkip() + " Skipped");


    }

    protected void playAgain(View c)
    {
        taboos tabooInfo = new taboos();
        tabooInfo.resetNum();
        tabooInfo.resetCorrect();
        tabooInfo.resetSkip();
        tabooInfo.resetMillis();
        Intent playIntent = new Intent(this, tabooCategories.class);
        startActivity(playIntent);
    }
}

