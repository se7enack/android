package com.dorkcloud.tictactoe;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

    int activePlayer = 0;

    //2 means unplayed slot
    int[] gameState = {2,2,2,2,2,2,2,2,2};
    int[][] winningPositions = {{0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8}, {2,4,6}};

    public void dropIn(View view) {

        ImageView counter = (ImageView) view;

        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if (gameState[tappedCounter] == 2) {
            gameState[tappedCounter] = activePlayer;

            counter.setTranslationY(-1000f);

            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.green);
                activePlayer = 1;
            } else {
                counter.setImageResource(R.drawable.orange);
                activePlayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(720).setDuration(600);

            for (int[] winningPosition : winningPositions) {

                if (gameState[winningPosition[0]] == gameState[winningPosition[1]] &&
                        gameState[winningPosition[1]] == gameState[winningPosition[2]] &&
                        gameState[winningPosition[0]] !=2){
                        TextView winnerMessage = (TextView) findViewById(R.id.youWinMessage);

                        String user = "Bryson";
                        ImageView winImage = (ImageView) findViewById(R.id.winImage);
                        winImage.setImageDrawable(getResources().getDrawable(R.drawable.b));
                        winImage.setTranslationY(-1000f);
                        winImage.animate().translationYBy(1000f).rotation(360).setDuration(1000);


                        if (gameState[winningPosition[0]] == 0) {
                            user = "Logan";
                            winImage.setImageDrawable(getResources().getDrawable(R.drawable.l));
                            winImage.setTranslationY(-1000f);
                            winImage.animate().translationYBy(1000f).rotation(360).setDuration(1000);
                        }

                        winnerMessage.setText(user + " has won!");
                        FrameLayout layout = (FrameLayout)findViewById(R.id.uWin);
                        layout.setVisibility(View.VISIBLE);



                }
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
