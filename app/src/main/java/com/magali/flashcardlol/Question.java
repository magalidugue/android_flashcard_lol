package com.magali.flashcardlol;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class Question implements Parcelable {

    public String question;
    public ArrayList<String> answers;
    public int pictureId;


    public Question(String question, ArrayList<String> answers, int pictureId) {

        this.question = question;
        this.answers = answers;
        this.pictureId = pictureId;
    }


    public static final Creator<Question> CREATOR = new Creator<Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

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




    protected Question(Parcel in) {
        question = in.readString();
        if(in.readByte() == 0x01) {
            answers = new ArrayList<String>();
            in.readList(answers, String.class.getClassLoader());
        } else {
            Log.i("bug", "ca marche pas");
        }
        pictureId = in.readInt();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(question);
            if(answers == null) {
                dest.writeByte((byte) (0x00));
            } else {
                dest.writeByte((byte) (0x01));
                dest.writeList(answers);
            }
            dest.writeInt(pictureId);
    }



}
