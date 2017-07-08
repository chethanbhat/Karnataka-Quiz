package com.chethanbhat.karnatakaquizapp;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private String name;
    private int marks = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gradeAnswers(View view){
        getUserName();
        checkQuestionOne();
        checkQuestionTwo();

        TextView results = (TextView)findViewById(R.id.results);
        String outPutString = "Hello " + name + ", You have scored " + marks + " marks out of 5" ;
        results.setText(outPutString);

    }

    public void checkQuestionOne(){

        RadioGroup answer1Group = (RadioGroup)findViewById(R.id.question_1_answers);
        int answer = answer1Group.getCheckedRadioButtonId();

        TextView question1 = (TextView)findViewById(R.id.question_1);


        if (answer == R.id.question_1_choice_3 )
        {
            question1.setTextColor(Color.GREEN);
            marks +=1;
        }
        else
        {
          question1.setTextColor(Color.RED);
        }

    }

    public void checkQuestionTwo(){

        CheckBox answerPartA = (CheckBox)findViewById(R.id.question_2_choice_1);
        CheckBox answerPartB = (CheckBox)findViewById(R.id.question_2_choice_3);

        TextView question2 = (TextView)findViewById(R.id.question_2);

        if (answerPartA.isChecked() && answerPartB.isChecked())
        {
            question2.setTextColor(Color.GREEN);
            marks +=1;
        }
        else
        {
            question2.setTextColor(Color.RED);
        }

    }

    public void checkQuestionThree(){


        TextView question3 = (TextView)findViewById(R.id.question_3);
        EditText answer = (EditText)findViewById(R.id.question_3_answer);


        if (true)
        {
            question3.setTextColor(Color.GREEN);
            marks +=1;
        }
        else
        {
            question3.setTextColor(Color.RED);
        }

    }


    public void getUserName(){
        EditText userNameField = (EditText)findViewById(R.id.user_name);
        name = userNameField.getText().toString();
    }
}
