package com.south42studios.izzysgames;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Context mContext = this;

    Player player1 = new Player();
    Player player2 = new Player();


    private TextView player1_score_txt;
    private TextView player2_score_txt;
    private TextView turn_player_txt;

    /* Button Views*/
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView player1_name_txt = (TextView) findViewById(R.id.player1_name_txt);
        TextView player1_token_txt = (TextView) findViewById(R.id.player1_token_txt);
        player1_score_txt = (TextView) findViewById(R.id.player1_score_txt);

        TextView player2_name_txt = (TextView) findViewById(R.id.player2_name_txt);
        TextView player2_token_txt = (TextView) findViewById(R.id.player2_token_txt);
        player2_score_txt = (TextView) findViewById(R.id.player2_score_txt);

        turn_player_txt = (TextView) findViewById(R.id.turn_player_txt);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        button8 = (Button) findViewById(R.id.button8);
        button9 = (Button) findViewById(R.id.button9);

        /* Test Data */

        Intent intent = getIntent();
        player1.setPlayerName(intent.getStringExtra(PlayerSetup.PLAYER1MESSAGE));
        player1.setPlayerScore(0);
        player1.setPlayerToken("X");
        player1.setPlayerTurn(true);


        player2.setPlayerName(intent.getStringExtra(PlayerSetup.PLAYER2MESSAGE));
        player2.setPlayerScore(0);
        player2.setPlayerToken("O");
        player2.setPlayerTurn(false);

        player1_name_txt.setText(player1.getPlayerName());
        player1_score_txt.setText(String.valueOf(player1.getPlayerScore()));
        player1_token_txt.setText(player1.getPlayerToken());

        player2_name_txt.setText(player2.getPlayerName());
        player2_score_txt.setText(String.valueOf(player2.getPlayerScore()));
        player2_token_txt.setText(player2.getPlayerToken());
        gameRest();


    }


    public void gameBoardClick(View view) {

        switch (view.getId()) {

            case R.id.button1:
                setButtonAction(button1);
                break;

            case R.id.button2:
                setButtonAction(button2);
                break;

            case R.id.button3:
                setButtonAction(button3);
                break;

            case R.id.button4:
                setButtonAction(button4);
                break;

            case R.id.button5:
                setButtonAction(button5);
                break;

            case R.id.button6:
                setButtonAction(button6);
                break;

            case R.id.button7:
                setButtonAction(button7);
                break;

            case R.id.button8:
                setButtonAction(button8);
                break;

            case R.id.button9:
                setButtonAction(button9);
                break;
        }
    }

    private void setButtonAction(Button bttn) {
        bttn.setText(determinePlay());
        checkForWinner();
        bttn.setClickable(false);

    }

    private String determinePlay() {
        String playableToken;
        if (player1.isPlayerTurn()) {
            setTurnName();
            playableToken = player1.getPlayerToken();
            player1.setPlayerTurn(false);
            player2.setPlayerTurn(true);
            setTurnName();
        } else {
            setTurnName();
            playableToken = player2.getPlayerToken();
            player2.setPlayerTurn(false);
            player1.setPlayerTurn(true);
            setTurnName();
        }


        return playableToken;
    }

    public void gameRest() {
        button1.setText("");
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
        player1_score_txt.setText(player1.getPlayerTextScore());
        player2_score_txt.setText(player2.getPlayerTextScore());
        setTurnName();
        setNonPlayableBttns(true);
    }

    public void setTurnName() {
        if (player1.isPlayerTurn()) {
            turn_player_txt.setText(String.format(getString(R.string.player_turn), player1.getPlayerName()));
        } else {
            turn_player_txt.setText(String.format(getString(R.string.player_turn), player2.getPlayerName()));
        }
    }

    public void checkForWinner() {
        String winningToken = "";
        if (button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText()) && !button1.getText().equals("")) {
            winningToken = button1.getText().toString();
            setNonPlayableBttns(false);
//            winnerReset();
        }

        if (button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText()) && !button4.getText().equals("")) {
            winningToken = button4.getText().toString();
            setNonPlayableBttns(false);
//            winnerReset();
        }

        if (button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText()) && !button7.getText().equals("")) {
            winningToken = button7.getText().toString();
            setNonPlayableBttns(false);
//            winnerReset();
        }

        if (button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText()) && !button1.getText().equals("")) {
            winningToken = button1.getText().toString();
            setNonPlayableBttns(false);
//            winnerReset();
        }

        if (button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()) && !button2.getText().equals("")) {
            winningToken = button2.getText().toString();
            setNonPlayableBttns(false);
//            winnerReset();
        }

        if (button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText()) && !button3.getText().equals("")) {
            winningToken = button3.getText().toString();
            setNonPlayableBttns(false);
//            winnerReset();
        }

        if (button1.getText().equals(button5.getText()) && button5.getText().equals(button9.getText()) && !button1.getText().equals("")) {
            winningToken = button1.getText().toString();
            setNonPlayableBttns(false);
//            winnerReset();
        }

        if (button3.getText().equals(button5.getText()) && button5.getText().equals(button7.getText()) && !button3.getText().equals("")) {
            winningToken = button3.getText().toString();
            setNonPlayableBttns(false);
//            winnerReset();
        }

        if (player1.getPlayerToken().equals(winningToken)) {
            turn_player_txt.setText(String.format(getString(R.string.player_wins), player1.getPlayerName()));
            player1.setPlayerScore(player1.getPlayerScore() + 1);
            player1_score_txt.setText(player1.getPlayerTextScore());
            winnerReset(String.format(getString(R.string.player_wins), player1.getPlayerName()));

        } else if (player2.getPlayerToken().equals(winningToken)) {
            turn_player_txt.setText(String.format(getString(R.string.player_wins), player2.getPlayerName()));
            player2.setPlayerScore(player2.getPlayerScore() + 1);
            player2_score_txt.setText(player2.getPlayerTextScore());
            winnerReset(String.format(getString(R.string.player_wins), player2.getPlayerName()));

        } else if (!button1.getText().equals("") && !button2.getText().equals("") && !button3.getText().equals("") &&
                !button4.getText().equals("") && !button5.getText().equals("") && !button6.getText().equals("") &&
                !button7.getText().equals("") && !button8.getText().equals("") && !button9.getText().equals("")) {
            setNonPlayableBttns(false);
            turn_player_txt.setText(getText(R.string.draw_game));
            winnerReset(getString(R.string.draw_game));
        }
    }

    public void setNonPlayableBttns(boolean state) {
        button1.setClickable(state);
        button2.setClickable(state);
        button3.setClickable(state);
        button4.setClickable(state);
        button5.setClickable(state);
        button6.setClickable(state);
        button7.setClickable(state);
        button8.setClickable(state);
        button9.setClickable(state);
    }

    public void winnerReset(String winnerName) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(mContext);
        alertBuilder.setTitle(winnerName);
        alertBuilder.setMessage(R.string.play_again);
        alertBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                gameRest();
            }
        });
        alertBuilder.setNegativeButton(R.string.quit, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(mContext, SetupActivity.class);
                startActivity(intent);
            }
        });

        AlertDialog dialog = alertBuilder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
    }
}





















