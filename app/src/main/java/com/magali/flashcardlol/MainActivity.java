package com.magali.flashcardlol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button launchQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        launchQuiz = findViewById(R.id.LauncherButton);

        launchQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> displayedAnswers = new ArrayList<String>();
                ArrayList<Question> questionsList = new ArrayList<>();
                displayedAnswers.add("Annie");
                displayedAnswers.add("Ahri");
                displayedAnswers.add("Sonna");

                ArrayList<String> displayedAnswers2 = new ArrayList<String>();
                displayedAnswers2.add("Morgana");
                displayedAnswers2.add("Kaisa");
                displayedAnswers2.add("Lux");

                Question q = new Question("quel est le nom de ce hero ?", displayedAnswers, R.drawable.ahri);
                Question q2 = new Question("quel est le nom de ce hero ?", displayedAnswers2, R.drawable.morgana);

                questionsList.add(q);
                questionsList.add(q2);

                Random rand = new Random();
                int upperbound = 2;

                navigateToQuiz(questionsList.get(rand.nextInt(upperbound)));

            }
        });
    }

    private void navigateToQuiz(Question q) {

        Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
        intent.putExtra("question", q);
        startActivity(intent);

    }


}