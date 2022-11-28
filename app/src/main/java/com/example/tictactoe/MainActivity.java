package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    static int[] cells = {-1,-1,-1,-1,-1,-1,-1,-1,-1};

    public static void resetGame(){
        cells = new int[]{-1,-1,-1,-1,-1,-1,-1,-1,-1};
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resetGame();
        Log.i("blabla", Arrays.toString(cells));
    }
}