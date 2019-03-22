package com.example.android_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView txtresult;
    Button btnac, btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnX, btnN, btnP,btnplus, btnequal;

    int resultnumber;
    char op;
    boolean isPressedNumber = false;
    boolean isPressedOp = true;
    boolean isSavedNumber = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
    }

    private void setViews() {
        txtresult = (TextView) findViewById(R.id.txtresult);
        btnac = (Button) findViewById(R.id.btnac);
        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);
        btnX = (Button) findViewById(R.id.btnX);
        btnN = (Button) findViewById(R.id.btnN);
        btnP = (Button) findViewById(R.id.btnP);
        btnplus = (Button) findViewById(R.id.btnplus);
        btnequal = (Button) findViewById(R.id.btnequal);

        btnac.setOnClickListener(this);
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btnX.setOnClickListener(this);
        btnN.setOnClickListener(this);
        btnP.setOnClickListener(this);
        btnplus.setOnClickListener(this);
        btnequal.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnac:
                pressedAC();
                break;
            case R.id.btn0:
                pressedNumber(0);
                break;
            case R.id.btn1:
                pressedNumber(1);
                break;
            case R.id.btn2:
                pressedNumber(2);
                break;
            case R.id.btn3:
                pressedNumber(3);
                break;
            case R.id.btn4:
                pressedNumber(4);
                break;
            case R.id.btn5:
                pressedNumber(5);
                break;
            case R.id.btn6:
                pressedNumber(6);
                break;
            case R.id.btn7:
                pressedNumber(7);
                break;
            case R.id.btn8:
                pressedNumber(8);
                break;
            case R.id.btn9:
                pressedNumber(9);
                break;
            case R.id.btnX:
                pressedX();
                break;
            case R.id.btnN:
                pressedN();
                break;
            case R.id.btnP:
                pressedP();
                break;
            case R.id.btnplus:
                pressedPlus();
                break;
            case R.id.btnequal:
                pressedEqual();
                break;
        }
    }

    private void pressedNumber(int usernumber){
        if(!isPressedNumber){
            txtresult.setText(usernumber + "");
            isPressedNumber = true;
            return;
        }
        txtresult.setText(txtresult.getText().toString() + usernumber);
        isPressedNumber = true;
    }

    private void pressedPlus(){
        if(isSavedNumber){
            int CurrentNumber = Integer.parseInt(txtresult.getText().toString());
            switch (op){
                case '+':
                    resultnumber = resultnumber + CurrentNumber;
                    txtresult.setText(resultnumber + "");
                    op = '+';
                    isPressedOp = true;
                    isSavedNumber = true;
                    isPressedNumber = false;
                    break;
            }
        } else {
            resultnumber = Integer.parseInt(txtresult.getText().toString());
            isSavedNumber = true;
            op = '+';
            isPressedOp = true;
            isPressedNumber = false;
        }
    }

    private void pressedP(){
        if(isSavedNumber){
            int CurrentNumber = Integer.parseInt(txtresult.getText().toString());
            switch (op){
                case '%':
                    resultnumber = resultnumber % CurrentNumber;
                    txtresult.setText(resultnumber + "");
                    op = '%';
                    isPressedOp = true;
                    isSavedNumber = true;
                    isPressedNumber = false;
                    break;
            }
        } else {
            resultnumber = Integer.parseInt(txtresult.getText().toString());
            isSavedNumber = true;
            op = '%';
            isPressedOp = true;
            isPressedNumber = false;
        }
    }

    private void pressedN(){
        if(isSavedNumber){
            int CurrentNumber = Integer.parseInt(txtresult.getText().toString());
            switch (op){
                case '/':
                    resultnumber = resultnumber / CurrentNumber;
                    txtresult.setText(resultnumber + "");
                    op = '/';
                    isPressedOp = true;
                    isSavedNumber = true;
                    isPressedNumber = false;
                    break;
            }
        } else {
            resultnumber = Integer.parseInt(txtresult.getText().toString());
            isSavedNumber = true;
            op = '/';
            isPressedOp = true;
            isPressedNumber = false;
        }
    }

    private void pressedX(){
        if(isSavedNumber){
            int CurrentNumber = Integer.parseInt(txtresult.getText().toString());
            switch (op){
                case '*':
                    resultnumber = resultnumber * CurrentNumber;
                    txtresult.setText(resultnumber + "");
                    op = '*';
                    isPressedOp = true;
                    isSavedNumber = true;
                    isPressedNumber = false;
                    break;
            }
        } else {
            resultnumber = Integer.parseInt(txtresult.getText().toString());
            isSavedNumber = true;
            op = '*';
            isPressedOp = true;
            isPressedNumber = false;
        }
    }

    private void pressedAC(){
        isPressedOp = false;
        isSavedNumber = false;
        isPressedNumber = false;
        txtresult.setText("0");
    }

    private void pressedEqual(){
        if(isSavedNumber && isPressedOp){
            switch (op){
                case '+':
                    resultnumber = resultnumber + Integer.parseInt(txtresult.getText().toString());
                    isSavedNumber = true;
                    isPressedOp = true;
                    isPressedNumber = false;
                    txtresult.setText(resultnumber + "");
                    break;
                case '/':
                    resultnumber = resultnumber / Integer.parseInt(txtresult.getText().toString());
                    isSavedNumber = true;
                    isPressedOp = true;
                    isPressedNumber = false;
                    txtresult.setText(resultnumber + "");
                    break;
                case '%':
                    resultnumber = resultnumber % Integer.parseInt(txtresult.getText().toString());
                    isSavedNumber = true;
                    isPressedOp = true;
                    isPressedNumber = false;
                    txtresult.setText(resultnumber + "");
                    break;
                case '*':
                    resultnumber = resultnumber * Integer.parseInt(txtresult.getText().toString());
                    isSavedNumber = true;
                    isPressedOp = true;
                    isPressedNumber = false;
                    txtresult.setText(resultnumber + "");
                    break;
            }
        } else {

        }
    }

}
