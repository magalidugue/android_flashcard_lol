package com.magali.flashcardlol;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        RadioGroup radioGroup = findViewById(R.id.RadioGroup);

        submit = findViewById(R.id.Validate);

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
}