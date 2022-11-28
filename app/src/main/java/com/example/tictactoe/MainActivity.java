package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    //-1 is no player 1 is x 0 is O
    static int[] cells = new int[]{-10, -10, -10, -10, -10, -10, -10, -10, -10};
    // 1 = X, 0 = o
    static int currentPlayer = 1;
    static int stepsCounter = 0;

    public static void changeCurrentPlayer(ImageView playersText) {
        if(currentPlayer == 1){
            currentPlayer = 0;
            playersText.setImageResource(R.drawable.oplay);
            return;
        }

        playersText.setImageResource(R.drawable.xplay);
        currentPlayer = 1;
    }

    public static void resetGame() {
        cells = new int[]{-10, -10, -10, -10, -10, -10, -10, -10, -10};
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

    public static void addButtonListener(int i, Button btn, ImageView playersText) {
        cells[i] = currentPlayer;
        stepsCounter++;
        if (currentPlayer == 1) {
            btn.setBackgroundResource(R.drawable.x);
            if (isWon()) {
                Log.i("IS winning", "X is winning");
                playersText.setImageResource(R.drawable.xwin);
                return;
            }
        } else {
            btn.setBackgroundResource(R.drawable.o);
            if (isWon()) {
                Log.i("IS winning", "O is winning");
                playersText.setImageResource(R.drawable.owin);
                return;
            }
        }

        // out of steps and no one won
        if (stepsCounter == 8) {
            if (!isWon()) {
                playersText.setImageResource(R.drawable.nowin);
                return;
            }
        }

        btn.setEnabled(false);
        //TODO check why calling this here is making the game as won every turn
        changeCurrentPlayer(playersText);
        Log.i("This is a test", Arrays.toString(cells));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

        btn1.setOnClickListener(view -> addButtonListener(0, btn1, playersText));
        btn2.setOnClickListener(view -> addButtonListener(1, btn2, playersText));
        btn3.setOnClickListener(view -> addButtonListener(2, btn3, playersText));
        btn4.setOnClickListener(view -> addButtonListener(3, btn4, playersText));
        btn5.setOnClickListener(view -> addButtonListener(4, btn5, playersText));
        btn6.setOnClickListener(view -> addButtonListener(5, btn6, playersText));
        btn7.setOnClickListener(view -> addButtonListener(6, btn7, playersText));
        btn8.setOnClickListener(view -> addButtonListener(7, btn8, playersText));
        btn9.setOnClickListener(view -> addButtonListener(8, btn9, playersText));
    }
}
