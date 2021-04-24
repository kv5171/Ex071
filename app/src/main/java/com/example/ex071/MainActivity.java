package com.example.ex071;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    double answer, secNum;
    char sign;
    boolean hasError;
    EditText mathExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mathExercise = (EditText) findViewById(R.id.mathExercise);

        answer = 0;
        secNum = 0;
        hasError = false;
        sign = 'F';
    }

    public void makeCalculation(char newSign){
        String inputedNum = mathExercise.getText().toString();
        if (!inputedNum.equals("")) {
            secNum = Double.parseDouble(inputedNum);
            switch (sign) {
                case 'F':
                    answer = secNum;
                    hasError = false;
                    break;
                case '+':
                    answer = answer + secNum;
                    hasError = false;
                    break;
                case '-':
                    answer = answer - secNum;
                    hasError = false;
                    break;
                case '*':
                    answer = answer * secNum;
                    hasError = false;
                    break;
                case '/':
                    if (secNum == 0){
                        Toast.makeText(this, "Cant divide by 0!", Toast.LENGTH_SHORT).show();
                        hasError = true;
                        answer = 0;
                        newSign = 'F';
                    }
                    else {
                        answer = answer / secNum;
                        hasError = false;
                    }
                    break;
            }
            sign = newSign;
            mathExercise.setText("");
        }
    }

    public void goToCredits(View view) {
        Intent si = new Intent(this, CreditsActivity.class);
        si.putExtra("answer", answer);
        si.putExtra("hasError", hasError);
        startActivity(si);
    }

    public void add(View view) {
        makeCalculation('+');
    }

    public void restartValues(View view) {
        sign = 'F';
        secNum = 0;
        answer = 0;
        hasError = false;
        mathExercise.setText("");
    }

    public void sub(View view) {
        makeCalculation('-');
    }

    public void mul(View view) {
        makeCalculation('*');
    }

    public void div(View view) {
        makeCalculation('/');
    }

    public void showResult(View view) {
        makeCalculation('=');

        if (hasError) {
            mathExercise.setHint("Error!");
            mathExercise.setText("");
        }
        else if ((float)((int)answer) == answer) {
            mathExercise.setText("" + (int)answer);
            mathExercise.setHint("Start enter your math exercise");
        }
        else {
            mathExercise.setText("" + answer);
            mathExercise.setHint("Start enter your math exercise");
        }
    }
}