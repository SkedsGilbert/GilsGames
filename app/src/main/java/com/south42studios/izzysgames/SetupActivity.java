package com.south42studios.izzysgames;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class SetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);
    }

    public void connectionClick(View view) {
        switch (view.getId()) {

            case R.id.local_player_bttn:
                Intent intent = new Intent(this, PlayerSetup.class);
                startActivity(intent);
                break;

            case R.id.blueTooth_player_bttn:
                break;
        }
    }
}
