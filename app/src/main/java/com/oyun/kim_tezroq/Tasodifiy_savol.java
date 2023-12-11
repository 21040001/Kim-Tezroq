package com.oyun.kim_tezroq;


import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class Tasodifiy_savol {

    public int sayi1(){
        //rastgele sayilari  aliyom soru icin
        Random random=new Random();
        int a=random.nextInt(32);
        return a;
    }
    public int sayi2(){
        //rastgele sayilari  aliyom soru icin
        Random random=new Random();
        int b=random.nextInt(32);
        return b;
    }

    int sayi1=sayi1();
    int sayi2=sayi2();


    public String islem_turu(){
        //rastgele islem seciyorum
        ArrayList<String> islemler=new ArrayList<>();

        islemler.add("-");
       // islemler.add("*");
        //islemler.add("/");
        islemler.add("+");
        int islem_sayisi= sayi1%2;
        String islem=islemler.get(islem_sayisi);
        return islem;
    }
    public String dogru_cevap_varianti(){
        //rastgele dogru cevabi gosterecegimiz secenegi seciyoruz a b c olarak
        ArrayList<String> secenekler_a_b_c=new ArrayList<>();

        secenekler_a_b_c.add("a");
        secenekler_a_b_c.add("b");
        secenekler_a_b_c.add("c");
        int islem_dogru_cevabi_secenegi= sayi1%3;
        String dogru_cevap_secenegi=secenekler_a_b_c.get(islem_dogru_cevabi_secenegi);
        return dogru_cevap_secenegi;
    }


    public void islem_soru(TextView A, TextView B){
        //aldigim sayilari  soru seklinde aktariyorum

        if (sayi1>=sayi2){
            String islem_soru=sayi1+islem_turu()+sayi2;
            A.setText(islem_soru);
            B.setText(islem_soru);
        }else{
            String islem_soru=sayi2+islem_turu()+sayi1;
            A.setText(islem_soru);
            B.setText(islem_soru);
        }


    }
    public int islem_dogru_cevap(){
        // dogru cevabi buluyozuruz
        int islem_cevabi = 0;
        switch (islem_turu()){
            case "-":
                if(sayi1>=sayi2){
                    islem_cevabi=sayi1-sayi2;
                }else {
                    islem_cevabi=sayi2-sayi1;
                }

                break;
            case "+":
                islem_cevabi=sayi1+sayi2;
                break;
            case "*":
                islem_cevabi=sayi1*sayi2;
                break;
            case "/":
                islem_cevabi=sayi1/sayi2;
                break;

        }
        return islem_cevabi;
    }

    public String cevap_varianti_2(){
        int a =islem_dogru_cevap()-3;
        return String.valueOf(a);
    }
    public String cevap_varianti_1(){
        int a =islem_dogru_cevap()+3;
        return String.valueOf(a);
    }

    public int cevap(){
        return Integer.valueOf(islem_dogru_cevap());
    }
    public void hazir_variantlar(TextView A_a,TextView A_b,TextView A_c,TextView B_a,TextView B_b,TextView B_c){
        switch (dogru_cevap_varianti()){

            case "a":
                A_a.setText(String.valueOf(islem_dogru_cevap()));
                B_a.setText(String.valueOf(islem_dogru_cevap()));
                A_b.setText(String.valueOf(cevap_varianti_1()));
                B_b.setText(String.valueOf(cevap_varianti_1()));
                A_c.setText(String.valueOf(cevap_varianti_2()));
                B_c.setText(String.valueOf(cevap_varianti_2()));
                break;
            case "b":
                A_b.setText(String.valueOf(islem_dogru_cevap()));
                B_b.setText(String.valueOf(islem_dogru_cevap()));
                A_a.setText(String.valueOf(cevap_varianti_1()));
                B_a.setText(String.valueOf(cevap_varianti_1()));
                A_c.setText(String.valueOf(cevap_varianti_2()));
                B_c.setText(String.valueOf(cevap_varianti_2()));
                break;
            case "c":
                A_c.setText(String.valueOf(islem_dogru_cevap()));
                B_c.setText(String.valueOf(islem_dogru_cevap()));
                A_b.setText(String.valueOf(cevap_varianti_1()));
                B_b.setText(String.valueOf(cevap_varianti_1()));
                A_a.setText(String.valueOf(cevap_varianti_2()));
                B_a.setText(String.valueOf(cevap_varianti_2()));
                break;
        }


    }



}
