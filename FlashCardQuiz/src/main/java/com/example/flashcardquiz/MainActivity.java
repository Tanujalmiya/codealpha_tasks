package com.example.flashcardquiz;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtQuestion;
    Button btnShowAnswer, btnNext, btnPrevious;

    String[] questions = {
            "What is Android?",
            "Who developed Java?",
            "What is XML?"
    };

    String[] answers = {
            "Android is a mobile operating system.",
            "Java was developed by Sun Microsystems.",
            "XML is used for designing layouts."
    };

    int current = 0;
    boolean showingAnswer = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQuestion = findViewById(R.id.txtQuestion);
        btnShowAnswer = findViewById(R.id.btnShowAnswer);
        btnNext = findViewById(R.id.btnNext);
        btnPrevious = findViewById(R.id.btnPrevious);

        txtQuestion.setText(questions[current]);

        btnShowAnswer.setOnClickListener(v -> {
            if (!showingAnswer) {
                txtQuestion.setText(answers[current]);
                btnShowAnswer.setText("Show Question");
                showingAnswer = true;
            } else {
                txtQuestion.setText(questions[current]);
                btnShowAnswer.setText("Show Answer");
                showingAnswer = false;
            }
        });

        btnNext.setOnClickListener(v -> {
            current = (current + 1) % questions.length;
            txtQuestion.setText(questions[current]);
            btnShowAnswer.setText("Show Answer");
            showingAnswer = false;
        });

        btnPrevious.setOnClickListener(v -> {
            current--;
            if (current < 0)
                current = questions.length - 1;

            txtQuestion.setText(questions[current]);
            btnShowAnswer.setText("Show Answer");
            showingAnswer = false;
        });
    }
}