package com.oyun.kim_tezroq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class gameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
    }

    public void yangi_oyin(View v){
        Intent i = new Intent(gameOver.this, oyinchilar.class);
        startActivity(i);
    }
}