package com.sviat.k.geoquiz.app;

/**
 * Created by Sviat on 01.11.14.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mAnswer;

    public TrueFalse(int question, boolean answer) {
        mQuestion = question;
        mAnswer = answer;
    }

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int question) {
        mQuestion = question;
    }

    public boolean getAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
