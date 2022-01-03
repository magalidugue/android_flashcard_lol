package com.magali.flashcardlol;

import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class Question {
    public String question;
    public ArrayList<String> answers;

    public Question(String question, ArrayList<String> answers) {
        this.question = question;
        this.answers = answers;
    }
}
