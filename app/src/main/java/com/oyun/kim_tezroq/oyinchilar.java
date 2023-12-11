package com.oyun.kim_tezroq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class oyinchilar extends AppCompatActivity {

    EditText textedit_A,textedit_B;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyinchilar);


    }
    public void davom_et(View v){

        Intent intent = getIntent();
        String saviya=intent.getStringExtra("saviya");

        textedit_A=findViewById(R.id.editText_A);
        textedit_B=findViewById(R.id.editText_B);
        Intent i = new Intent(oyinchilar.this, oyin_maydoni.class);
        i.putExtra("saviya",saviya);
        i.putExtra("editText_A",  String.valueOf(textedit_A));
        i.putExtra("editText_B",  String.valueOf(textedit_B));
        startActivity(i);
    }
}