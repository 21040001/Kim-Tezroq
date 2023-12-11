package com.oyun.kim_tezroq;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class oyin_maydoni extends AppCompatActivity {
    int islem_cevabi;
    TextView textView7A,textView7B,A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek,B_oyinchi_puani,A_oyinchi_puani;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oyin_maydoni);

        //oyinchi puanlari
        B_oyinchi_puani=findViewById(R.id.b_oyinchi_puani);
        A_oyinchi_puani=findViewById(R.id.a_oyinchi_puani);
        //Variantlar
        A_a_secenek=findViewById(R.id.a_sechenek_A);
        A_b_secenek=findViewById(R.id.b_sechenek_A);
        A_c_secenek=findViewById(R.id.c_sechenek_A);
        B_a_secenek=findViewById(R.id.a_sechenek_B);
        B_b_secenek=findViewById(R.id.b_sechenek_B);
        B_c_secenek=findViewById(R.id.c_sechenek_B);
        //savollar
        textView7B=findViewById(R.id.textView7B);
        textView7A=findViewById(R.id.textView7);


        Tasodifiy_savol savol =new Tasodifiy_savol();
        islem_cevabi=savol.cevap();
        savol.islem_soru(textView7A,textView7B);
        savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);

       /* //rastgele sayilari  aliyom soru icin
        Random random=new Random();
        int a=random.nextInt(32);
        int b=random.nextInt(32);

        //rastgele islem seciyorum
        ArrayList<String> islemler=new ArrayList<>();

        islemler.add("-");
        islemler.add("*");
        islemler.add("/");
        islemler.add("+");
        int islem_sayisi= a%4;
        String islem=islemler.get(islem_sayisi);

        //rastgele dogru cevabi gosterecegimiz secenegi seciyoruz a b c olarak
        ArrayList<String> secenekler_a_b_c=new ArrayList<>();

        secenekler_a_b_c.add("a");
        secenekler_a_b_c.add("b");
        secenekler_a_b_c.add("c");
        int islem_dogru_cevabi_secenegi= a%3;
        String dogru_cevap_secenegi=secenekler_a_b_c.get(islem_dogru_cevabi_secenegi);


        //aldigim sayilari textViewlere soru seklinde aktariyorum
        textView7A.setText(a+""+islem+""+b);
        textView7B.setText(a+""+islem+""+b);
        islem_cevabi = 0;
        switch (islem){
            case "-":
                islem_cevabi=a-b;
                break;
            case "+":
                islem_cevabi=a+b;
                break;
            case "*":
                islem_cevabi=a*b;
                break;
            case "/":
                islem_cevabi=a/b;
                break;

        }

        //sorumuz icin 3 tane secenek haziliyoruz 2 tanesi random 1 si dogru cevap
        int secenek1 = islem_cevabi+3;
        int secenek2 = islem_cevabi-2;
        int dogrusecenek = islem_cevabi;


        //hazirladimiz secenekleri aktariyoruz
        switch (dogru_cevap_secenegi){
            case "a":
                A_a_secenek.setText(String.valueOf(dogrusecenek));
                B_a_secenek.setText(String.valueOf(dogrusecenek));
                A_b_secenek.setText(String.valueOf(secenek1));
                B_b_secenek.setText(String.valueOf(secenek1));
                A_c_secenek.setText(String.valueOf(secenek2));
                B_c_secenek.setText(String.valueOf(secenek2));
                break;
            case "b":
                A_b_secenek.setText(String.valueOf(dogrusecenek));
                B_b_secenek.setText(String.valueOf(dogrusecenek));
                A_a_secenek.setText(String.valueOf(secenek1));
                B_a_secenek.setText(String.valueOf(secenek1));
                A_c_secenek.setText(String.valueOf(secenek2));
                B_c_secenek.setText(String.valueOf(secenek2));
                break;
            case "c":
                A_c_secenek.setText(String.valueOf(dogrusecenek));
                B_c_secenek.setText(String.valueOf(dogrusecenek));
                A_b_secenek.setText(String.valueOf(secenek1));
                B_b_secenek.setText(String.valueOf(secenek1));
                A_a_secenek.setText(String.valueOf(secenek2));
                B_a_secenek.setText(String.valueOf(secenek2));
                break;
        }*/
    }


    //dogru javobga bosilganda puan hisoblagich
    // boshliq ochiqlama b_oyinchi_a bu yerda _ dan oldingi b qaysi oyinchi ekani eng oxiridagi harf esa variantni korsatadi

    public void b_oyinchi_a(View v){
        Tasodifiy_savol savol =new Tasodifiy_savol();
        if(String.valueOf(islem_cevabi)==B_a_secenek.getText()){
            int puan=Integer.valueOf(String.valueOf(B_oyinchi_puani.getText()));
            puan ++;
            B_oyinchi_puani.setText(String.valueOf(puan));
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameover2.class);
                startActivity(i);
            }
        }else{
            int puan=Integer.valueOf(String.valueOf(A_oyinchi_puani.getText()));
            puan ++;
            A_oyinchi_puani.setText(String.valueOf(puan));
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameOver.class);
                startActivity(i);
            }
        }


    }
    public void b_oyinchi_b(View v){
        Tasodifiy_savol savol =new Tasodifiy_savol();
        if(String.valueOf(islem_cevabi)==B_b_secenek.getText()){
            int puan=Integer.valueOf(String.valueOf(B_oyinchi_puani.getText()));
            puan ++;
            B_oyinchi_puani.setText(String.valueOf(puan));
            System.out.println("1");
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameover2.class);
                startActivity(i);
            }
        }else{
            int puan=Integer.valueOf(String.valueOf(A_oyinchi_puani.getText()));
            puan ++;
            A_oyinchi_puani.setText(String.valueOf(String.valueOf(puan)));
            System.out.println("0");
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameOver.class);
                startActivity(i);
            }
        }
    }
    public void b_oyinchi_c(View v){

        Tasodifiy_savol savol =new Tasodifiy_savol();
        if(String.valueOf(islem_cevabi)==B_c_secenek.getText()){
            int puan=Integer.valueOf(String.valueOf(B_oyinchi_puani.getText()));
            puan ++;
            B_oyinchi_puani.setText(String.valueOf(puan));
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameover2.class);
                startActivity(i);
            }
        }else{
            int puan=Integer.valueOf(String.valueOf(A_oyinchi_puani.getText()));
            puan ++;
            A_oyinchi_puani.setText(String.valueOf(String.valueOf(puan)));
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameOver.class);
                startActivity(i);
            }
        }
    }
    public void a_oyinchi_a(View v){

        Tasodifiy_savol savol =new Tasodifiy_savol();
        if(String.valueOf(islem_cevabi)==A_a_secenek.getText()){
            int puan=Integer.valueOf(String.valueOf(A_oyinchi_puani.getText()));
            puan ++;
            A_oyinchi_puani.setText(String.valueOf(puan));
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameOver.class);
                startActivity(i);
            }
        }else{
            int puan=Integer.valueOf(String.valueOf(B_oyinchi_puani.getText()));
            puan ++;
            B_oyinchi_puani.setText(String.valueOf(String.valueOf(puan)));
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameover2.class);
                startActivity(i);
            }
        }
    }
    public void a_oyinchi_b(View v){
        Tasodifiy_savol savol =new Tasodifiy_savol();
        if(String.valueOf(islem_cevabi)==A_b_secenek.getText()){
            int puan=Integer.valueOf(String.valueOf(A_oyinchi_puani.getText()));
            puan ++;
            A_oyinchi_puani.setText(String.valueOf(puan));
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameOver.class);
                startActivity(i);
            }
        }else{
            int puan=Integer.valueOf(String.valueOf(B_oyinchi_puani.getText()));
            puan ++;
            B_oyinchi_puani.setText(String.valueOf(String.valueOf(puan)));
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameover2.class);
                startActivity(i);
            }
        }
    }
    public void a_oyinchi_c(View v){
        Tasodifiy_savol savol =new Tasodifiy_savol();
        if(String.valueOf(islem_cevabi)==A_c_secenek.getText()){
            int puan=Integer.valueOf(String.valueOf(A_oyinchi_puani.getText()));
            puan ++;
            A_oyinchi_puani.setText(String.valueOf(String.valueOf(puan)));
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameOver.class);
                startActivity(i);
            }
        }else{
            int puan=Integer.valueOf(String.valueOf(B_oyinchi_puani.getText()));
            puan ++;
            B_oyinchi_puani.setText(String.valueOf(String.valueOf(puan)));
            islem_cevabi=savol.cevap();
            savol.islem_soru(textView7A,textView7B);
            savol.hazir_variantlar(A_a_secenek,A_b_secenek,A_c_secenek,B_a_secenek,B_b_secenek,B_c_secenek);
            if(puan==10){
                Intent i =new Intent(oyin_maydoni.this,gameover2.class);
                startActivity(i);
            }
        }
    }
}

