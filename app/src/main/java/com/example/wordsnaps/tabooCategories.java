package com.example.wordsnaps;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class tabooCategories extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_taboo_categories);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button rules = (Button) findViewById(R.id.rules);
        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rules(v);
            }
        });
        Button one = (Button) this.<View>findViewById(R.id.one);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one(v);
            }
        });
        Button two = (Button) this.<View>findViewById(R.id.two);
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                two(v);
            }
        });
        Button three = (Button) this.<View>findViewById(R.id.three);
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                three(v);
            }
        });

    }
    protected void rules(View v)
    {
        Intent rulesIntent = new Intent(this, Rules.class);
        startActivity(rulesIntent);

    }
    protected void one(View v)
    {
        Intent oneIntent = new Intent(this, Mix.class);
        startActivity(oneIntent);

    }
    protected void two(View v)
    {
        Intent twoIntent = new Intent(this, Celebrities.class);
        startActivity(twoIntent);

    }
    protected void three(View v)
    {
        Intent threeIntent = new Intent(this, FictionalCharacters.class);
        startActivity(threeIntent);

    }
}
