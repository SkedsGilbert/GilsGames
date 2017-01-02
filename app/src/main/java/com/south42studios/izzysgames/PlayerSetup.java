package com.south42studios.izzysgames;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class PlayerSetup extends AppCompatActivity {

    Context mContext = this;

    public final static String PLAYER1MESSAGE = "com.south42studios.izzysgames.P1NAME";
    public final static String PLAYER2MESSAGE = "com.south42studios.izzysgames.P2NAME";

    EditText player1Nametxtb;
    EditText player2Nametxtb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_setup);

        player1Nametxtb = (EditText) findViewById(R.id.player1_name_txtb);
        player2Nametxtb = (EditText) findViewById(R.id.player2_name_txtb);

    }

    public void doneClick(View view) {
        switch (view.getId()) {

            case R.id.done_button:

                if (player1Nametxtb.getText().toString().trim().equals("")
                        || player2Nametxtb.getText().toString().trim().equals("")) {
                    Toast toast = Toast.makeText(mContext, mContext.getText(R.string.blank_names),Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    Intent intent = new Intent(this, MainActivity.class);
                    String message1 = player1Nametxtb.getText().toString().trim();
                    String message2 = player2Nametxtb.getText().toString().trim();
                    intent.putExtra(PLAYER1MESSAGE, message1);
                    intent.putExtra(PLAYER2MESSAGE, message2);
                    startActivity(intent);
                }
                break;
        }
    }
}
