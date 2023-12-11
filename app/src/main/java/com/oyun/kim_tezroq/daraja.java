package com.oyun.kim_tezroq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class daraja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daraja);


    }
    public void kirish_saviya(View v){
        Intent i= new Intent(daraja.this, oyinchilar.class);
        i.putExtra("saviya","kirish_saviya");
        startActivity(i);
    }
    public void orta_saviya(View v){
        Intent i= new Intent(daraja.this, oyinchilar.class);
        i.putExtra("saviya","orta_saviya");
        startActivity(i);
    }
    public void yuksak_saviya(View v){
        Intent i= new Intent(daraja.this, oyinchilar.class);
        i.putExtra("saviya","orta_saviya");
        startActivity(i);
    }
}