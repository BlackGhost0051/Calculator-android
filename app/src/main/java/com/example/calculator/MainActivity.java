package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends AppCompatActivity {

    private TextView result;
    boolean symbol = false;
    boolean minus = false;
    String input = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        String resultText = ((TextView) findViewById(R.id.result)).getText().toString();
        outState.putString("result", resultText);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        input = savedInstanceState.getString("result");
        TextView resultTextView = findViewById(R.id.result);
        resultTextView.setText(input);
    }

    public void numberclick(View view)
    {

        input = result.getText().toString();

        switch (view.getId())
        {
            case R.id.num9:
                input = input+"9";
                symbol = true;
                break;

            case R.id.num8:
                input = input+"8";
                symbol = true;
                break;

            case R.id.num7:
                input = input+"7";
                symbol = true;
                break;

            case R.id.num6:
                input = input+"6";
                symbol = true;
                break;

            case R.id.num5:
                input = input+"5";
                symbol = true;
                break;

            case R.id.num4:
                input = input + "4";
                symbol = true;
                break;

            case R.id.num3:
                input = input + "3";
                symbol = true;
                break;

            case R.id.num2:
                input = input + "2";
                symbol = true;
                break;

            case R.id.num1:
                input = input + "1";
                symbol = true;
                break;

            case R.id.num0:
                input = input + "0";
                symbol = true;
                break;

            case R.id.koma:
                input = input + ".";
                break;

            case R.id.plus_minus:
                if(minus){
                    if(!input.isEmpty()){
                        input = input.substring(1);
                        minus = false;
                    } else {
                        minus = false;
                    }
                } else {
                    input = "-" + input;
                    minus = true;
                }
                break;



            case R.id.plus:
                if(symbol){
                    input = input + " + ";
                    symbol = false;
                }
                break;

            case R.id.minus:
                if(symbol) {
                    input = input + " - ";
                    symbol = false;
                }
                break;

            case R.id.division:
                if(symbol) {
                    input = input + " / ";
                    symbol = false;
                }
                break;

            case R.id.x_button:
                if(symbol) {
                    input = input + " * ";
                    symbol = false;
                }
                break;

            case R.id.proc:
                if(symbol) {
                    input = input + "%";
                    symbol = false;
                }
                break;



            case R.id.factorial:
                    input = input + "! ";
                break;

            case R.id.x_3:
                input = input + "^3";
                break;

            case R.id.x_2:
                input = input + "^2";
                break;

            case R.id.log10:
                input = "log10(" + input + ")";
                break;

            case R.id.SQRT:
                input = "sqrt(" + input + ")";
                break;
        }
        result.setText(input);
    }


    public void equalevent(View view)
    {
        input = result.getText().toString();

        if (!input.isEmpty()) {
            Expression e = new Expression(input);
            double v = e.calculate();
            input = String.valueOf(v);
            result.setText(input);
            minus = false;
        }
    }


    public void clear(View view)
    {
        if (!input.isEmpty()) {
            input = input.substring(0, input.length() - 1);
            result.setText(input);
        }
    }

    public void clearAll(View view)
    {
        result.setText("");
        minus = false;
        symbol = false;
    }

}