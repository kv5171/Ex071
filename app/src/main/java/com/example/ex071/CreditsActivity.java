package com.example.ex071;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class CreditsActivity extends AppCompatActivity {
    TextView answerTv;
    boolean hasError;
    double answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        answerTv = (TextView) findViewById(R.id.answerTv);

        Intent gi = getIntent();
        answer = gi.getDoubleExtra("answer", 0);
        hasError = gi.getBooleanExtra("hasError", false);

        if (hasError){
            answerTv.setText("The last calculation answer is: Error");
        }
        else {
            answerTv.setText("The last calculation answer is: " + answer);
        }
    }

    public void goBack(View view) {
        finish();
    }
}