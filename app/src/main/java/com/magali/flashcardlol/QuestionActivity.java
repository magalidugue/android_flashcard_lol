package com.magali.flashcardlol;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionActivity extends AppCompatActivity {

    private Button submit;
    final int numberOfRadioButton = 3;
    RadioButton radioButtons;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        submit = findViewById(R.id.Validate);
        ImageView heroPictureView = findViewById(R.id.HeroImageView);


        ArrayList<String> displayedAnswers = new ArrayList<String>();
        displayedAnswers.add("Annie");
        displayedAnswers.add("Ahri");
        displayedAnswers.add("Sonna");

        Question displayedQuestion = new Question("quel est le nom de ce hero ?", displayedAnswers, R.drawable.ahri);


        final RadioGroup radioGroup = findViewById(R.id.radioGroup);

        RadioButton[] rbs = new RadioButton[numberOfRadioButton];

        for(int i = 0; i<numberOfRadioButton; i++) {
            rbs[i] = new RadioButton(this);
            rbs[i].setId(View.generateViewId());
            rbs[i].setText(displayedAnswers.get(i) +"");
        }

        for(int i = 0; i<4; i++) {
            int swap_ind1 =((int) (Math.random()*10)% numberOfRadioButton);
            int swap_ind2 =((int) (Math.random()*10)% numberOfRadioButton);
            RadioButton temp = rbs[swap_ind1];
            rbs[swap_ind1] = rbs[swap_ind2];
            rbs[swap_ind2] = temp;
        }
        rbs[0].setChecked(true);

        for (int i = 0; i< numberOfRadioButton; i++) {
            radioGroup.addView(rbs[i]);
        }

        heroPictureView.setImageResource(displayedQuestion.pictureId);

       heroPictureView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayLargerImage(displayedQuestion.pictureId);
            }
        });



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int answerRadioButtonId = radioGroup.getCheckedRadioButtonId();
                Log.v("Reponse", "la réponse est" + answerRadioButtonId);
                if(answerRadioButtonId != -1) {
                    RadioButton answer = findViewById(answerRadioButtonId);
                    if(answer.getText().equals("Ahri")) {
                        Toast.makeText(QuestionActivity.this, "Bonne réponse !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(QuestionActivity.this, "Désolé la réponse était Ahri ", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(QuestionActivity.this, "Veuillez cocher une réponse ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private RadioGroup createRadioButton (final ArrayList<String> answers, int size) {
        final RadioGroup rg = new RadioGroup(this);
        rg.setOrientation(RadioGroup.VERTICAL);
        for(int i = 0; i<size; i++) {
            RadioButton rb = new RadioButton(this);
            rb.setText(answers.get(i) +"");
            rg.addView(rb);
        }
        return rg;
    }

    private void displayLargerImage(int pictureId) {
        Intent intent = new Intent(QuestionActivity.this, LargerImage.class);
        intent.putExtra("pictureId", pictureId);
        startActivity(intent);
    }
}