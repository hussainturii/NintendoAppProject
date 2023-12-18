package com.example.myapplication.nintendo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class tictactoe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);

    }
        boolean game = true;
        int activePlayer = 0;
        int gameTurn[] = {9, 9, 9, 9, 9, 9, 9, 9, 9}; // null array

        // array of possible win positions
        int winningPositions[][] = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
                {2, 4, 6}, {0, 4, 8},
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}};
        TextView status = findViewById(R.id.status);

        public void OnClick (View view){
            if (game != true) {
                gameReset(view);
            }
            ImageView img = (ImageView) view;
            int tapped = Integer.parseInt(img.getTag().toString());
            if (gameTurn[tapped] == 9) {
                gameTurn[tapped] = activePlayer;
                if (activePlayer == 0) {
                    img.setImageResource(R.drawable.o);
                    activePlayer = 1;
                    status.setText("X's turn, Tap to play");
                } else {
                    img.setImageResource(R.drawable.x);
                    activePlayer = 0;
                    status.setText("O's turn, Tap to play");
                }

            }
            checkWin(); //check for a win
            checkGameDrawn(); //check for a draw
        }

        public void checkWin ()
        {
            // check for winning positions
            for (int[] winningPosition : winningPositions) {
                if (gameTurn[winningPosition[0]] == gameTurn[winningPosition[1]] &&
                        gameTurn[winningPosition[1]] == gameTurn[winningPosition[2]] &&
                        gameTurn[winningPosition[0]] != 9) {

                    //announce a winner
                    String winner;
                    game = false; //restarts the game after someone has won it
                    if (gameTurn[winningPosition[0]] == 0) {
                        winner = "O has won!";
                    } else {
                        winner = "X has won!";
                    }
                    status.setText(winner);
                    return;
                }
            }
        }
        public void checkGameDrawn () {
            for (int cell : gameTurn) {
                if (cell == 9) {
                    return; // there are still empty cells left on the grid
                }
            }

            // if the game reaches this point, it means that the game is drawn
            status.setText("Game drawn!");
        }
        public void redo (View view)//reset button
        {
            gameReset(view);
        }
        public void gameReset (View view)
        {
            activePlayer = 0;
            game = true;
            // Reset all grid cells to their initial empty state
            for (int i = 0; i < gameTurn.length; i++) {
                gameTurn[i] = 9; // 9 represents an empty cell
            }

            ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);
            ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);

            status.setText("Tap to play");
        }


}