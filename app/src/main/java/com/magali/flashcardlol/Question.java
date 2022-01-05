package com.magali.flashcardlol;

import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class Question {

    public String question;
    public ArrayList<String> answers;
    public int pictureId;


    public Question(String question, ArrayList<String> answers, int pictureId) {

        this.question = question;
        this.answers = answers;
        this.pictureId = pictureId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public ArrayList<String> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<String> answers) {
        this.answers = answers;
    }

    public int getPictureId() {
        return pictureId;
    }

    public void setPictureId(int pictureId) {
        this.pictureId = pictureId;
    }
}
