package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    //-1 is no player 1 is x 0 is O
    static int[] cells = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    // 1 = X, 0 = o
    static int currentPlayer = 1;
    static int stepsCounter = 0;

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public static void resetGame() {
        cells = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        currentPlayer = 1;
    }

    public static boolean isWon() {
        int winner;
        return (cells[0] + cells[1] + cells[2] == 0 || cells[0] + cells[1] + cells[2] == 3 ||
        cells[3] + cells[4] + cells[5] == 0 || cells[3] + cells[4] + cells[5] == 3 ||
        cells[6] + cells[7] + cells[8] == 0 || cells[6] + cells[7] + cells[8] == 3 ||
        cells[0] + cells[3] + cells[6] == 0 || cells[0] + cells[3] + cells[6] == 3 ||
        cells[1] + cells[4] + cells[7] == 0 || cells[1] + cells[4] + cells[7] == 3 ||
        cells[2] + cells[5] + cells[8] == 0 || cells[2] + cells[5] + cells[8] == 3 ||
        cells[0] + cells[4] + cells[8] == 0 || cells[0] + cells[4] + cells[8] == 3 ||
        cells[2] + cells[4] + cells[6] == 0 || cells[2] + cells[4] + cells[6] == 3);
    }

//    public static void addButtonListener(int i){
//
//            cells[i] = currentPlayer;
//            stepsCounter++;
//            if(currentPlayer == 1) {
//                btn1.setBackgroundResource(R.drawable.x);
//                if(isWon()){
//                    playersText.setImageResource(R.drawable.xwin);
//                }
//            }
//            else {
//                btn1.setBackgroundResource(R.drawable.o);
//                if(isWon()){
//                    playersText.setImageResource(R.drawable.owin);
//                }
//            }
//
//            // out of steps and no one won
//            if(stepsCounter == 9){
//                if(!isWon()){
//                    playersText.setImageResource(R.drawable.nowin);
//                }
//            }
//
//            btn1.setEnabled(false);
//
//
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("This is a test ", String.valueOf(isWon()));
        //TODO danielle Add event listners here
        //Give id for each button, when you click on the button :
        // change the cells array
        //call isWon on click
        //is the result of isWon is + finish the game bla bla
        // check isWon

        Button btn1 = findViewById(R.id.btn1);
        Button btn2 = findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.btn3);
        Button btn4 = findViewById(R.id.btn4);
        Button btn5 = findViewById(R.id.btn5);
        Button btn6 = findViewById(R.id.btn6);
        Button btn7 = findViewById(R.id.btn7);
        Button btn8 = findViewById(R.id.btn8);
        Button btn9 = findViewById(R.id.btn9);

        ImageView playersText = findViewById(R.id.playerText);



        btn1.setOnClickListener(view ->{
            cells[1] = currentPlayer;
            stepsCounter++;
            if(currentPlayer == 1) {
                btn1.setBackgroundResource(R.drawable.x);
                if(isWon()){
                    playersText.setImageResource(R.drawable.xwin);
                }
            }
            else {
                btn1.setBackgroundResource(R.drawable.o);
                if(isWon()){
                    playersText.setImageResource(R.drawable.owin);
                }
            }

            // out of steps and no one won
            if(stepsCounter == 9){
                if(!isWon()){
                    playersText.setImageResource(R.drawable.nowin);
                }
            }

            btn1.setEnabled(false);

        });

        btn2.setOnClickListener(view ->{
            cells[2] = currentPlayer;
            stepsCounter++;
            if(currentPlayer == 1) {
                btn2.setBackgroundResource(R.drawable.x);
                if(isWon()){
                    playersText.setImageResource(R.drawable.xwin);
                }
            }
            else {
                btn2.setBackgroundResource(R.drawable.o);
                if(isWon()){
                    playersText.setImageResource(R.drawable.owin);
                }
            }

            // out of steps and no one won
            if(stepsCounter == 9){
                if(!isWon()){
                    playersText.setImageResource(R.drawable.nowin);
                }
            }

            btn2.setEnabled(false);

        });

        btn3.setOnClickListener(view ->{
            cells[3] = currentPlayer;
            stepsCounter++;
            if(currentPlayer == 1) {
                btn3.setBackgroundResource(R.drawable.x);
                if(isWon()){
                    playersText.setImageResource(R.drawable.xwin);
                }
            }
            else {
                btn3.setBackgroundResource(R.drawable.o);
                if(isWon()){
                    playersText.setImageResource(R.drawable.owin);
                }
            }

            // out of steps and no one won
            if(stepsCounter == 9){
                if(!isWon()){
                    playersText.setImageResource(R.drawable.nowin);
                }
            }

            btn3.setEnabled(false);

        });



    }
}