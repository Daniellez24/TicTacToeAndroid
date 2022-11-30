package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {
    //-1 is no player 1 is x 0 is O
    static int[] cells = new int[]{-10, -10, -10, -10, -10, -10, -10, -10, -10};
    // 1 = X, 0 = o
    static int currentPlayer = 1;
    static int stepsCounter = 0;
    Button btn1;
    Button btn2;
    Button btn3;
    Button btn4;
    Button btn5;
    Button btn6;
    Button btn7;
    Button btn8;
    Button btn9;

    static ImageView lineImg;

    public static void changeCurrentPlayer(ImageView playersText) {
        if (currentPlayer == 1) {
            currentPlayer = 0;
            playersText.setImageResource(R.drawable.oplay);
            return;
        }

        playersText.setImageResource(R.drawable.xplay);
        currentPlayer = 1;
    }


    public static void resetGame(ImageView playerText, Button playAgain, Button[] buttons) {
        cells = new int[]{-10, -10, -10, -10, -10, -10, -10, -10, -10};
        currentPlayer = 1;
        playerText.setImageResource(R.drawable.xplay);

        for (Button btn : buttons) {
            btn.setClickable(true);
            btn.setBackgroundColor(android.R.drawable.btn_default);
        }

        playAgain.setVisibility(View.INVISIBLE);
        playAgain.setEnabled(false);

        lineImg.setRotation(0);
        lineImg.setVisibility(View.GONE);


    }

    public void displayPlayAgainBtn() {
        Button playAgain = findViewById(R.id.playAgainBtn);
        playAgain.setVisibility(View.VISIBLE);
        playAgain.setEnabled(true);
    }


    public boolean isWon() {
        boolean topRow = cells[0] + cells[1] + cells[2] == 0 || cells[0] + cells[1] + cells[2] == 3;
        boolean midRow = cells[3] + cells[4] + cells[5] == 0 || cells[3] + cells[4] + cells[5] == 3;
        boolean bottomRow = cells[6] + cells[7] + cells[8] == 0 || cells[6] + cells[7] + cells[8] == 3;

        boolean leftColumn = cells[0] + cells[3] + cells[6] == 0 || cells[0] + cells[3] + cells[6] == 3;
        boolean midColumn = cells[1] + cells[4] + cells[7] == 0 || cells[1] + cells[4] + cells[7] == 3;
        boolean rightColumn = cells[2] + cells[5] + cells[8] == 0 || cells[2] + cells[5] + cells[8] == 3;

        boolean topLeftBottomRight = cells[0] + cells[4] + cells[8] == 0 || cells[0] + cells[4] + cells[8] == 3;
        boolean topRightBottomLeft = cells[2] + cells[4] + cells[6] == 0 || cells[2] + cells[4] + cells[6] == 3;


        if (topRow) {
            lineImg.setImageResource(R.drawable.mark3);
            lineImg.setRotation(90);
            lineImg.setVisibility(View.VISIBLE);
        } else if (midRow) {
            lineImg.setImageResource(R.drawable.mark4);
            lineImg.setRotation(90);
            lineImg.setVisibility(View.VISIBLE);

        } else if (bottomRow) {
            lineImg.setImageResource(R.drawable.mark5);
            lineImg.setRotation(90);
            lineImg.setVisibility(View.VISIBLE);

        } else if (leftColumn) {
            lineImg.setImageResource(R.drawable.mark3);
            lineImg.setVisibility(View.VISIBLE);

        } else if (midColumn) {
            lineImg.setImageResource(R.drawable.mark4);
            lineImg.setVisibility(View.VISIBLE);


        } else if (rightColumn) {
            lineImg.setImageResource(R.drawable.mark5);
            lineImg.setVisibility(View.VISIBLE);


        } else if (topLeftBottomRight) {
            lineImg.setImageResource(R.drawable.mark1);
            lineImg.setVisibility(View.VISIBLE);


        } else if (topRightBottomLeft) {
            lineImg.setImageResource(R.drawable.mark2);
            lineImg.setVisibility(View.VISIBLE);
        }


        return (topRow || midRow || bottomRow ||
                leftColumn || midColumn || rightColumn ||
                topLeftBottomRight || topRightBottomLeft);
    }

    public void addButtonListener(int i, Button btn, ImageView playersText) {
        cells[i] = currentPlayer;
        stepsCounter++;
        if (currentPlayer == 1) {
            btn.setBackgroundResource(R.drawable.x);
            if (isWon()) {
                playersText.setImageResource(R.drawable.xwin);
                Log.i("IS winning", "X is winning");
                displayPlayAgainBtn();
                return;
            }
        } else {
            btn.setBackgroundResource(R.drawable.o);
            if (isWon()) {
                Log.i("IS winning", "O is winning");
                playersText.setImageResource(R.drawable.owin);
                displayPlayAgainBtn();
                return;
            }
        }

        // out of steps and no one won
        if (stepsCounter == 9) {
            //TODO CHECK WHY THIS IS ALWAYS TRUE
            if (!isWon()) {
                playersText.setImageResource(R.drawable.nowin);
                displayPlayAgainBtn();
                return;
            }
        }

        btn.setClickable(false);
        changeCurrentPlayer(playersText);
        Log.i("This is a cell", Arrays.toString(cells));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playAgain = findViewById(R.id.playAgainBtn);
        playAgain.setVisibility(View.INVISIBLE);
        playAgain.setEnabled(false);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);

        ImageView playersText = findViewById(R.id.playerText);
        lineImg = findViewById(R.id.lineImage);

        btn1.setOnClickListener(view -> addButtonListener(0, btn1, playersText));
        btn2.setOnClickListener(view -> addButtonListener(1, btn2, playersText));
        btn3.setOnClickListener(view -> addButtonListener(2, btn3, playersText));
        btn4.setOnClickListener(view -> addButtonListener(3, btn4, playersText));
        btn5.setOnClickListener(view -> addButtonListener(4, btn5, playersText));
        btn6.setOnClickListener(view -> addButtonListener(5, btn6, playersText));
        btn7.setOnClickListener(view -> addButtonListener(6, btn7, playersText));
        btn8.setOnClickListener(view -> addButtonListener(7, btn8, playersText));
        btn9.setOnClickListener(view -> addButtonListener(8, btn9, playersText));

        playAgain.setOnClickListener(view -> resetGame(playersText, playAgain,
                new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9})
        );

        resetGame(playersText, playAgain, new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9});
    }
}
