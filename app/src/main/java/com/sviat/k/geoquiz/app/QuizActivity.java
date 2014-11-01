package com.sviat.k.geoquiz.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends ActionBarActivity {

    private static final String TAG = "QuizActivity";
    private static final String KEY_INDEX = "question_key";
    public static final String EXTRA_ANSWER = "com.sviat.k.geoquiz.ap.answer_value";

    private Button mButtonTrue;
    private Button mButtonFalse;
    private Button mButtonShowAnswer;

    private Button mNextButton;
    private TextView mQuestionTextView;

    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            Log.d(TAG, "savedInstanceState is not null");
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX);
        }

        Log.d(TAG, "onCreate() called");

        setContentView(R.layout.activity_quiz);

        mButtonTrue = (Button) findViewById(R.id.button_true);
        mButtonFalse = (Button) findViewById(R.id.button_false);
        mNextButton = (Button) findViewById(R.id.button_next);
        mButtonShowAnswer = (Button) findViewById(R.id.button_show_answer);

        mButtonTrue.setOnClickListener(new onAnswerClick(true));
        mButtonFalse.setOnClickListener(new onAnswerClick(false));
        mButtonShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(QuizActivity.this, ShowAnswerActivity.class);
                intent.putExtra(EXTRA_ANSWER, mQuestionBank[mCurrentIndex].getAnswer());
                startActivity(intent);
            }
        });

        mQuestionTextView = (TextView) findViewById(R.id.text_question_text);
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextView.setText(question);

        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                int question = mQuestionBank[mCurrentIndex].getQuestion();
                mQuestionTextView.setText(question);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState");
        outState.putInt(KEY_INDEX, mCurrentIndex);
    }

    private class onAnswerClick implements View.OnClickListener {
        private boolean mAnswer;

        public onAnswerClick(boolean answer) {
            mAnswer = answer;
        }

        @Override
        public void onClick(View v) {
            if (mQuestionBank[mCurrentIndex].getAnswer() == mAnswer) {
                Toast.makeText(QuizActivity.this, R.string.toast_correct, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(QuizActivity.this, R.string.toast_incorrect, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
