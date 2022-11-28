package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    //-1 is no player 1 is x 0 is O
    static int[] cells = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
    String currentPlayer = "x";
    static boolean isSomeonePlayed = true;

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public static void resetGame() {
        cells = new int[]{-1, -1, -1, -1, -1, -1, -1, -1, -1};
        String currentPlayer = "x";
        isSomeonePlayed = false;
    }

    public static boolean isWon() {
        if (!isSomeonePlayed) return false;
        return ((cells[0] == cells[2] && cells[2] == cells[3]) ||
                (cells[3] == cells[4] && cells[4] == cells[5]) ||
                (cells[6] == cells[7] && cells[7] == cells[8]) ||
                (cells[0] == cells[3] && cells[3] == cells[6]) ||
                (cells[1] == cells[4] && cells[4] == cells[7]) ||
                (cells[2] == cells[5] && cells[5] == cells[8]) ||
                (cells[0] == cells[4] && cells[4] == cells[8]) ||
                (cells[2] == cells[4] && cells[4] == cells[6])
        );
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("This is a test ", String.valueOf(isWon()));
        //TODO daniellle Add event listners here
        //Give id for each button, when you click on the button :
        // change the cells array
        //call isWon on click
        //is the result of isWon is + finish the game bla bla
    }
}