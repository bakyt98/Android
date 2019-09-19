package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.function.DoubleToIntFunction;

enum Sign{
    PLUS, MINUS, MULT, DIV
}

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Sign sign;
    private EditText inputNumber;

    private Button buttonNumber1, buttonNumber2, buttonNumber3, buttonNumber4,
            buttonNumber5, buttonNumber6, buttonNumber7, buttonNumber8, buttonNumber9,
            buttonNumber0, buttonPlus, buttonEqual, buttonC, buttonMult, buttonMinus,
            buttonDiv, buttonDot, buttonSqr, buttonSqrt;

    private double result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonNumber1 = findViewById(R.id.buttonNumber1);
        buttonNumber2 = findViewById(R.id.buttonNumber2);
        buttonNumber3 = findViewById(R.id.buttonNumber3);
        buttonNumber4 = findViewById(R.id.buttonNumber4);
        buttonNumber5 = findViewById(R.id.buttonNumber5);
        buttonNumber6 = findViewById(R.id.buttonNumber6);
        buttonNumber7 = findViewById(R.id.buttonNumber7);
        buttonNumber8 = findViewById(R.id.buttonNumber8);
        buttonNumber9 = findViewById(R.id.buttonNumber9);
        buttonNumber0 = findViewById(R.id.buttonNumber0);
        inputNumber = findViewById(R.id.numberInput);
        buttonPlus = findViewById(R.id.buttonPlus);
        buttonEqual = findViewById(R.id.buttonEqual);
        buttonC = findViewById(R.id.buttonC);
        buttonMult = findViewById(R.id.buttonMult);
        buttonMinus = findViewById(R.id.buttonMinus);
        buttonDiv = findViewById(R.id.buttonDiv);
        buttonDot = findViewById(R.id.buttonDot);
        buttonSqr = findViewById(R.id.buttonSqr);
        buttonSqrt = findViewById(R.id.buttonSqrt);



        buttonNumber1.setOnClickListener(this);
        buttonNumber2.setOnClickListener(this);
        buttonNumber3.setOnClickListener(this);
        buttonNumber4.setOnClickListener(this);
        buttonNumber5.setOnClickListener(this);
        buttonNumber6.setOnClickListener(this);
        buttonNumber7.setOnClickListener(this);
        buttonNumber8.setOnClickListener(this);
        buttonNumber9.setOnClickListener(this);
        buttonNumber0.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonMult.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonSqr.setOnClickListener(this);
        buttonSqrt.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.buttonPlus: {
                sign = Sign.PLUS;
                inputNumber.append("+");
                break;
            }
            case R.id.buttonMult: {
                sign = Sign.MULT;
                inputNumber.append("*");
                break;
            }
            case R.id.buttonDiv: {
                sign = Sign.DIV;
                inputNumber.append("/");
                break;
            }
            case R.id.buttonMinus: {
                sign = Sign.MINUS;
                inputNumber.append("-");
                break;
            }
            case R.id.buttonEqual: {
                if (sign == Sign.PLUS) {
                    String[] numbers = inputNumber.getText().toString().split("\\+");
                    result = Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                }
                else if (sign == Sign.MINUS) {
                    String[] numbers = inputNumber.getText().toString().split("-");
                    result = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                }
                else if (sign == Sign.MULT) {
                    String[] numbers = inputNumber.getText().toString().split("\\*");
                    result = Double.parseDouble(numbers[0])* Double.parseDouble(numbers[1]);
                }
                else if (sign == Sign.DIV) {
                    String[] numbers = inputNumber.getText().toString().split("/");
                    result = Double.parseDouble(numbers[0])/Double.parseDouble(numbers[1]);
                }
                inputNumber.setText(result+"");
                break;
            }
            case R.id.buttonC: {
                inputNumber.setText("");
                break;
            }
            case R.id.buttonSqr: {
                result = Math.pow(Double.parseDouble(inputNumber.getText().toString()), 2);
                inputNumber.setText(result+"");
                break;
            }
            case R.id.buttonSqrt: {
                result = Math.sqrt(Double.parseDouble(inputNumber.getText().toString()));
                inputNumber.setText(result+"");
                break;
            }
            default: {
                inputNumber.append(((Button)findViewById(view.getId())).getText());
            }

        }

    }
}
