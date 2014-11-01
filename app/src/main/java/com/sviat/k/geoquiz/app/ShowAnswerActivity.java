package com.sviat.k.geoquiz.app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ShowAnswerActivity extends ActionBarActivity {

    public static final String EXTRA_ANSWER_SHOWN = "com.sviat.k.geoquiz.app.answer_shown";

    private boolean mAnswer = false;
    private Button mButtonAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_answer);

        mAnswer = getIntent().getBooleanExtra(QuizActivity.EXTRA_ANSWER, false);

        mButtonAnswer = (Button) findViewById(R.id.showAnswerButton);
        mButtonAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAnswer) {
                    Toast.makeText(ShowAnswerActivity.this, R.string.cheat_answer_true, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ShowAnswerActivity.this, R.string.cheat_answer_false, Toast.LENGTH_SHORT).show();
                }

                setCheated(true);
            }
        });
    }

    private void setCheated(boolean cheated) {
        Intent returnData = new Intent();
        returnData.putExtra(EXTRA_ANSWER_SHOWN, cheated);
        setResult(RESULT_OK, returnData);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.show_answer, menu);
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
}
