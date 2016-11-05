package com.abhi.abhishekori.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView TVyourScore,TVcompScore;

    ImageView IVdicefaces;
    Button Broll,Bhold,Breset;
    String your="your";
    String comp = "comp";

    int diceFaces[]={R.drawable.dice1,R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5,R.drawable.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TVyourScore = (TextView) findViewById(R.id.xml_yourScore);
        TVcompScore = (TextView) findViewById(R.id.xml_compScore);
        IVdicefaces = (ImageView) findViewById(R.id.xml_dice);
        Broll = (Button) findViewById(R.id.xml_rollButton);
        Bhold = (Button) findViewById(R.id.xml_holdButton);
        Breset = (Button) findViewById(R.id.xml_resetButton);

        updateScore(0,your);
        updateScore(0,comp);
        IVdicefaces.setImageResource(diceFaces[0]);

        Broll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollClick(your);
            }
        });

        Bhold.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holdClick(your);
            }
        });

        Breset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetClick(your);
            }
        });

    }

    public void rollClick(String whos){

        switch (whos){
            case "your":
                break;

            case "comp":
                break;
        }

    }

    public void holdClick(String whos){

        switch (whos){
            case "your":
                break;

            case "comp":
                break;
        }

    }

    public void resetClick(String whos){

        switch (whos){
            case "your":
                break;

            case "comp":
                break;
        }

    }

    public void updateScore(int score,String whosScore){
        String currentYourScore = TVyourScore.getText().toString();
        String currentCompScore = TVcompScore.getText().toString();
        switch (whosScore){

            case "your":currentYourScore+=score;
                TVyourScore.setText(currentYourScore);
                break;

            case "comp":currentCompScore+=score;
                TVcompScore.setText(currentCompScore);
                break;

        }



    }


}
