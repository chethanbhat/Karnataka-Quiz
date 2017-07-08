package com.chethanbhat.karnatakaquizapp;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private String name;
    private int marks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** To check all the answers in the quic
     * It checks various questions and puts a output string
     * Sets toast according to marks
     */

    public void gradeAnswers(View view){
        marks = 0;
        getUserName();
        checkQuestionOne();
        checkQuestionTwo();
        checkQuestionThree();
        checkQuestionFour();
        checkQuestionFive();

        TextView results = (TextView)findViewById(R.id.results);
        String outPutString = getString(R.string.output_string,name,marks) ;
        results.setText(outPutString);
        makeToast(marks);

    }

    /** Check answer to question 1
     *
     */

    public void checkQuestionOne(){
        RadioGroup answer1Group = (RadioGroup)findViewById(R.id.question_1_answers);
        int answer = answer1Group.getCheckedRadioButtonId();
        TextView question1 = (TextView)findViewById(R.id.question_1);

        markWrongAnswers(answer == R.id.question_1_choice_3, question1);
    }

    /** Check answer to question 2
     *
     */


    public void checkQuestionTwo(){
        CheckBox answerPartA = (CheckBox)findViewById(R.id.question_2_choice_1);
        CheckBox answerPartB = (CheckBox)findViewById(R.id.question_2_choice_3);
        CheckBox wrongAnswer = (CheckBox)findViewById(R.id.question_2_choice_2);
        TextView question2 = (TextView)findViewById(R.id.question_2);

        markWrongAnswers(answerPartA.isChecked() && answerPartB.isChecked() && !wrongAnswer.isChecked(), question2);
    }

    /** Check answer to question 3
     *
     */
    public void checkQuestionThree(){
        TextView question3 = (TextView)findViewById(R.id.question_3);
        EditText answerField = (EditText)findViewById(R.id.question_3_answer);
        String answer = answerField.getText().toString().toLowerCase();

        markWrongAnswers(answer.equals("bangalore") || answer.equals("bengaluru"), question3);
    }

    /** Check answer to question 4
     *
     */

    public void checkQuestionFour(){
        RadioGroup answer4Group = (RadioGroup)findViewById(R.id.question_4_answers);
        int answer = answer4Group.getCheckedRadioButtonId();
        TextView question4 = (TextView)findViewById(R.id.question_4);

        markWrongAnswers(answer == R.id.question_4_choice_1, question4);
    }

    /**
     *
     */
    public void checkQuestionFive(){
        TextView question5 = (TextView)findViewById(R.id.question_5);
        EditText answerField = (EditText)findViewById(R.id.question_5_answer);
        String answer = answerField.getText().toString().toLowerCase();

        markWrongAnswers(answer.equals("vidhana soudha"), question5);
    }

    /**
     * Marks wrong answer with red to respective questions,
     * Green color to correct answer questions
     * @param condition refers to answer condition
     * @param textView refers to question
     */

    public void markWrongAnswers(boolean condition, TextView textView){
        if(condition){
            textView.setTextColor(Color.GREEN);
            marks+=1;
        }else{
            textView.setTextColor(Color.RED);
        }
    }

    /**
     * Sets user name - global variable
     */

    public void getUserName(){
        EditText userNameField = (EditText)findViewById(R.id.user_name);
        name = userNameField.getText().toString();
    }

    /**
     * Generates toast messaged as per score
     */

    public void makeToast(int score){

        String toastResponse = "";

        switch (score){
            case 0: toastResponse = "Poor :(";
                    break;
            case 1: toastResponse = "Try again ! ";
                break;
            case 2: toastResponse = "Common :D";
                break;
            case 3: toastResponse = "Keep it up :)";
                break;
            case 4: toastResponse = "Good :)";
                break;
            case 5: toastResponse = "Awesome :)";
                break;
        }


        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,toastResponse, duration);
        toast.show();
    }
}
