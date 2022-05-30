package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.gridlayout.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean iswinner = false;
    int imageclicked = -1;
    int player=1;             // player1 is cross
    int[][]winningstates={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}                                                                                                                                          };
    int [] gameState = {-1,-1,-1,-1,-1,-1,-1,-1,-1};  // to declare that game hasn't started yet
    public void load(View view) {
            ImageView v = (ImageView) view;
            int tag = Integer.parseInt(v.getTag().toString());              // parseint converts string to int
            imageclicked = gameState[tag];
            if (iswinner == false && imageclicked == -1) {
            if (player == 1) {
                v.setImageResource(R.drawable.cross);
                gameState[tag] = player;
                Toast.makeText(this, tag + " " + "Cross", Toast.LENGTH_SHORT).show();
                player = 2;
            } else {
                v.setImageResource(R.drawable.circle);
                gameState[tag] = player;
                Toast.makeText(this, tag + " " + "Zero", Toast.LENGTH_SHORT).show();
                player = 1;
            }
            for (int[] winningstate : winningstates) {
                if (gameState[winningstate[0]] == gameState[winningstate[1]] && gameState[winningstate[1]] == gameState[winningstate[2]] && gameState[winningstate[0]] > -1) {
                    Toast.makeText(this, "Winner is player " + (player == 1 ? 2 : 1), Toast.LENGTH_SHORT).show();
                    iswinner = true;
                }
            }
            }
    }
    public void reset (View view){
        GridLayout gridLayout = findViewById(R.id.gridLayout);
        int total_images = gridLayout.getChildCount();
        for (int i =0; i<total_images;i++){
            ImageView imageView = (ImageView) gridLayout.getChildAt(i);
            imageView.setImageDrawable(null);
        }
        player=-1;
        iswinner = false;
        imageclicked = -1;
        for (int i =0;i<gameState.length;i++){
            gameState[i] = -1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}