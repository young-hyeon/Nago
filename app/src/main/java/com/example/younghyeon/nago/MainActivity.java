package com.example.younghyeon.nago;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void one_player_enter (View v){
        Intent intent_one_player = new Intent(this, OnePlayerActivity.class);
        startActivity(intent_one_player);
    }

    public void two_player_enter (View v){
        Intent intent_two_player = new Intent(this, TwoPlayerActivity.class);
        startActivity(intent_two_player);
    }

    public void omok_enter (View v){
        Intent intent_omok = new Intent(this, OmokActivity.class);
        startActivity(intent_omok);
    }

    public void omok_debug_enter (View v){
        Intent intent_omok2 = new Intent(this, OmokDebugActivity.class);
        startActivity(intent_omok2);
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
