package com.abhi.abhishekori.myapplication;

import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView TVyourScore,TVcompScore;

    ImageView IVdicefaces;
    Button Broll,Bhold,Breset;
    String your="your";
    String comp = "comp";
    int tempYourScore=0,totalYourScore=0,tempCompScore=0,totalCompScore=0,turn=0;


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

    public int getRandomNumber(){
        return (int)(Math.random()*6);
    }

    public void setDiceFace(int number){
        IVdicefaces.setImageResource(diceFaces[number]);
    }

    public boolean winnerDecided(){
        if(totalCompScore>=100){
            toast("Computer is winner");
            return true;
        }
        if(totalYourScore>=100){
            toast("You are the winner");
            return true;
        }

        return false;
    }

    public void rollClick(String whos){
        int random=getRandomNumber();
        Log.d("random",""+getRandomNumber());

        switch (whos){
            case "your":

                if(random!=0){
                    tempYourScore=tempYourScore+random+1;
                    //updateScore(tempCompScore,your);
                    setDiceFace(random);
                }else{
                    toast("you got 1");
                    tempYourScore=0;
                    turn=1;
                    //totalYourScore=totalCompScore+tempYourScore;
                    updateScore(totalYourScore,your);
                    if(!winnerDecided()){
                        rollClick(comp);
                    }

                }

                break;

            case "comp":
                if(random!=0){
                    tempCompScore=tempCompScore+random+1;
                    toast(""+(random+1));
                    setDiceFace(random);
                    if(tempCompScore>20){
                        holdClick(comp);
                    }else {
                        if(!winnerDecided()){
                            rollClick(comp);
                        }

                    }
                }else{
                    tempCompScore=0;
                    turn=0;
                    updateScore(totalCompScore,your);
                    toast("Your turn now");
                }
                break;
        }

    }
    public void toast(String toastMsg){
        Toast.makeText(getApplicationContext(),toastMsg,Toast.LENGTH_LONG).show();
    }

    public void holdClick(String whos){

        switch (whos){
            case "your":
                toast("the temp score of yours "+tempYourScore);
                totalYourScore=totalYourScore+tempYourScore;
                tempYourScore=0;
                updateScore(totalYourScore,your);
                if(!winnerDecided()){
                    rollClick(comp);
                }

                break;

            case "comp":

                totalCompScore=totalCompScore+tempCompScore;
                updateScore(totalCompScore,comp);
                toast("Your turn now");
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

        switch (whosScore){

            case "your":
                TVyourScore.setText(score+"");
                break;

            case "comp":
                TVcompScore.setText(score+"");
                break;

        }



    }


}
