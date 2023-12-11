package com.oyun.kim_tezroq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class gameover2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gameover2);
    }
    public void yangi_oyin2(View v){
        Intent i = new Intent(gameover2.this, oyinchilar.class);
        startActivity(i);
    }
}