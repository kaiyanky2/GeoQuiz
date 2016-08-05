package com.app.wangkaiyan.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";

    private TextView mQuestionTextView;
    private Button mTrueButton;
    private Button mFalseButton;
    private Button mNextButton;

    //问题数组
    private Question[] mQuestionBank = {
            new Question(R.string.q1, true),
            new Question(R.string.q2, false),
            new Question(R.string.q3, false),
            new Question(R.string.q4, true),
            new Question(R.string.q5, true),
    };

    private int mCurrentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        Log.d(TAG, "onCreate called");

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        mNextButton = (Button) findViewById(R.id.next_button);

        //引用组件
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        updateQuestion();

        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });

        //True Button
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(QuizActivity.this, R.string.true_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });

        //False Button
        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(QuizActivity.this, R.string.false_toast, Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });

        //Next Button
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex = (mCurrentIndex + 1) % mQuestionBank.length;
                updateQuestion();
            }
        });
    }

    //更新问题
    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    //判断答案正确与否
    private void checkAnswer(boolean userPressedTrue){
        //正确答案
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageId = 0;

        if(userPressedTrue == answerIsTrue){
            messageId = R.string.true_toast;
        }else{
            messageId = R.string.false_toast;
        }

        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show();
        System.out.println(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }
}