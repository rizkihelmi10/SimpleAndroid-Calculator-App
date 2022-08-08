package com.example.calculator_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText calc, res;
    private String cur, result;
    private Button but0, but1, but2, but3, but4, but5, but6, but7, but8, but9, butdel, butplus, butdiv, butmin, butcom, buteq, butac, butX;
    private boolean dotInsert, opInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calc = (EditText) findViewById(R.id.calculate);
        res = (EditText) findViewById(R.id.calcuResult);

        cur = "";
        result = "";
        dotInsert = false;
        opInsert = false;


        but0 = (Button) findViewById(R.id.Btn0);
        but1 = (Button) findViewById(R.id.Btn1);
        but2 = (Button) findViewById(R.id.Btn2);
        but3 = (Button) findViewById(R.id.Btn3);
        but4 = (Button) findViewById(R.id.Btn4);
        but5 = (Button) findViewById(R.id.Btn5);
        but6 = (Button) findViewById(R.id.Btn6);
        but7 = (Button) findViewById(R.id.Btn7);
        but8 = (Button) findViewById(R.id.Btn8);
        but9 = (Button) findViewById(R.id.Btn9);
        butdel = (Button) findViewById(R.id.BtnBkspc);
        butplus = (Button) findViewById(R.id.BtnPlus);
        butdiv = (Button) findViewById(R.id.BtnDiv);
        butX = (Button) findViewById(R.id.BtnX);
        butmin = (Button) findViewById(R.id.BtnMin);
        butcom = (Button) findViewById(R.id.BtnCom);
        buteq = (Button) findViewById(R.id.BtnEq);
        butac = (Button) findViewById(R.id.BtnAc);

        but0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = cur + "0";
                dispOne();

            }
        });
        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = cur + "1";
                dispOne();

            }
        });
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = cur + "2";
                dispOne();

            }
        });
        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = cur + "3";
                dispOne();

            }
        });
        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = cur + "4";
                dispOne();

            }
        });
        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = cur + "5";
                dispOne();

            }
        });
        but6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = cur + "6";
                dispOne();

            }
        });
        but7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = cur + "7";
                dispOne();

            }
        });
        but8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = cur + "8";
                dispOne();

            }
        });
        but9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cur = cur + "9";
                dispOne();

            }
        });

        butcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              if(cur.isEmpty()){
                  cur = "0.";
                  dotInsert = true;
              }

              if(dotInsert == false) {
                  cur = cur + ".";
                  dotInsert = true;
              }

              dispOne();
            }
        });

        butac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearall();
                dispOne();
                dispTwo();
            }
        });

        butdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deletenumber();
                dispOne();
            }
        });

        butdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dotInsert = false;

                if(!cur.isEmpty()){
                    if(cur.substring(cur.length()-1, cur.length()).equals(".")){
                        deletenumber();
                    }
                    if(opInsert == false){
                        cur = cur + "÷";
                        opInsert = true;
                    }
                }

                dispOne();
            }
        });

        butplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dotInsert = false;

                if(!cur.isEmpty()){
                    if(cur.substring(cur.length()-1, cur.length()).equals(".")){
                        deletenumber();
                    }
                    if(opInsert == false){
                        cur = cur + "+";
                        opInsert = true;
                    }
                }
                dispOne();
            }
        });

        butX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dotInsert = false;

                if(!cur.isEmpty()){
                    if(cur.substring(cur.length()-1, cur.length()).equals(".")){
                        deletenumber();
                    }
                    if(opInsert == false){
                        cur = cur + "*";
                        opInsert = true;
                    }
                }
                dispOne();
            }
        });

        butmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dotInsert = false;

                if(!cur.isEmpty()){
                    if(cur.substring(cur.length()-1, cur.length()).equals(".")){
                        deletenumber();
                    }
                    if(opInsert == false){
                        cur = cur + "-";
                        opInsert = true;
                    }
                }
                dispOne();
            }
        });

        buteq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opInsert == true && !cur.substring(cur.length()-1,cur.length()).equals("")){
                    String [] tokens = cur.split("");

                    switch (tokens[1].charAt(0)){

                        case '+':
                            result = Double.toString(Double.parseDouble(tokens[0]) + Double.parseDouble(tokens[2]));
                            break;
                        case '-' :
                            result = Double.toString(Double.parseDouble(tokens[0]) - Double.parseDouble(tokens[2]));
                            break;
                        case '*' :
                            result = Double.toString(Double.parseDouble(tokens[0]) * Double.parseDouble(tokens[2]));
                            break;
                        case '÷' :
                            result = Double.toString(Double.parseDouble(tokens[0]) / Double.parseDouble(tokens[2]));
                            break;
                    }
                    dispTwo();
                }

            }

        });

    }

    public void dispOne(){
        calc.setText(cur);
    }

    public void dispTwo(){
        res.setText(result);
    }

    public void clearall (){
        cur = "";
        result = "";
        dotInsert = false;
    }

    public void deletenumber (){
        if(!cur.isEmpty()){
            if(cur.substring(cur.length()-1, cur.length()).equals(".")){
                dotInsert = false;
            }
            if(cur.substring(cur.length()-1, cur.length()).equals(".")){
                cur = cur.substring(0, cur.length()-3);
                opInsert = false;
            } else{
                cur = cur.substring(0, cur.length()-1);
            }
            cur = cur.substring(0, cur.length()-1);
        }
    }


}