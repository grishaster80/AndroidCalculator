package com.example.android.mycalc;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SimpleCalc extends AppCompatActivity {
    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,buttonZero,plus,minus,multiplicate,divide,button0,equals,Cbutton;
    public TextView WorkField;
    public int myTmpNum1;
    public String CurrentScreen,CurrentOperator;
    public int operatorNum;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calc);

        buttonZero = (Button)findViewById(R.id._buttonZero);
        button1 = (Button)findViewById(R.id._button1);
        button2 = (Button)findViewById(R.id._button2);
        button1 = (Button)findViewById(R.id._button3);
        button1 = (Button)findViewById(R.id._button4);
        button1 = (Button)findViewById(R.id._button5);
        button1 = (Button)findViewById(R.id._button6);
        button1 = (Button)findViewById(R.id._button7);
        button1 = (Button)findViewById(R.id._button8);
        button1 = (Button)findViewById(R.id._button3);
        plus = (Button)findViewById(R.id._plus);
        minus=(Button)findViewById(R.id._minus);
        multiplicate = (Button)findViewById(R.id._multiplicate);
        equals=(Button)findViewById(R.id._equals);
        Cbutton=(Button)findViewById(R.id._buttonC);
        WorkField = (TextView)findViewById(R.id._WorkField);
        CurrentScreen="";
        operatorNum=0;
    }

    private void updateScreen(){
        WorkField.setText(CurrentScreen);
    }

    public void onClickNumber(View view){
        Button b = (Button) view;
        String num = b.getText().toString();
        CurrentScreen+=num;
        updateScreen();

    }

    public void onClickOperator(View view){
        myTmpNum1 = Integer.parseInt(CurrentScreen);
        CurrentScreen="";
        Button b=(Button)view;
        if(b.getText().toString().equals("+".toString())){
             CurrentOperator = b.getText().toString();
            operatorNum=1;
        }
        else if(b.getText().toString().equals("*".toString())){
            CurrentOperator = b.getText().toString();
            operatorNum=2;
        }
        else if(b.getText().toString().equals("-".toString())){
            CurrentOperator = b.getText().toString();
            operatorNum=3;
        }
        else if(b.getText().toString().equals("/".toString())){
            CurrentOperator = b.getText().toString();
            operatorNum=4;
        }
        Clear();

    }

    public void onClickClear(View view){
        Clear();
    }

    private void Clear(){
        CurrentScreen = "";
        CurrentOperator = "";
        updateScreen();
    }

    public void onClickEquals(View view){
        if (operatorNum==1){
           int tmpInt = Integer.parseInt(CurrentScreen);
           int myAns = tmpInt + myTmpNum1;
           CurrentScreen = String.valueOf(myAns);
            updateScreen();
        }
        else if(operatorNum==2){
            int tmpInt = Integer.parseInt(CurrentScreen);
            myTmpNum1 = myTmpNum1 - tmpInt;
            CurrentScreen = String.valueOf(myTmpNum1);
            updateScreen();
        }
        else if(operatorNum==3){
            int tmpInt = Integer.parseInt(CurrentScreen);
            myTmpNum1 = myTmpNum1 * tmpInt;
            CurrentScreen = String.valueOf(myTmpNum1);
            updateScreen();
        }
        else if(operatorNum==4){
            int tmpInt = Integer.parseInt(CurrentScreen);
            myTmpNum1 = myTmpNum1 / tmpInt;
            CurrentScreen = String.valueOf(myTmpNum1);
            updateScreen();
        }

    }
}
