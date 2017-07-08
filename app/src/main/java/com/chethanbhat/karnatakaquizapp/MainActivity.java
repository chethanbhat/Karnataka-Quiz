package com.chethanbhat.karnatakaquizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
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
        TextView results = (TextView)findViewById(R.id.results);
        results.setText("Hello "+ name);

    }

    public void checkQuestionOne(){

    }

    public void getUserName(){
        EditText userNameField = (EditText)findViewById(R.id.user_name);
        name = userNameField.getText().toString();
    }
}
