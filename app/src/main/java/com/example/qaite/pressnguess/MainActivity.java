package com.example.qaite.pressnguess;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Choices theChoices = new Choices();
    private TextView tvQuestion;
    private TextView tvShow;
    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    private String correctAnswer;
    private int score = 0;
    private int currentQuestionNumber = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvQuestion = (TextView)findViewById(R.id.textViewQuestion);
        tvShow = (TextView)findViewById(R.id.textViewShow);
        btn1 = (Button)findViewById(R.id.button1);
        btn2 = (Button)findViewById(R.id.button2);
        btn3 = (Button)findViewById(R.id.button3);
        btn4 = (Button)findViewById(R.id.button4);
        updateQuestion();
        updateScore(score);




        final MediaPlayer clarinetSound = MediaPlayer.create(this, R.raw.clarinet);
        Button playSound = (Button)this.findViewById(R.id.buttonPlay);
        playSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clarinetSound.start();
            }
        });

    }
    private void updateQuestion(){
        if(currentQuestionNumber < theChoices.getLength()){
            tvQuestion.setText(theChoices.getQuestion(currentQuestionNumber));
            btn1.setText(theChoices.getChoice(currentQuestionNumber, 1));
            btn2.setText(theChoices.getChoice(currentQuestionNumber, 2));
            btn3.setText(theChoices.getChoice(currentQuestionNumber, 3));
            btn4.setText(theChoices.getChoice(currentQuestionNumber, 4));
            correctAnswer = theChoices.getCorrectAnswer(currentQuestionNumber);
            currentQuestionNumber++;


        }
        else {
            Toast.makeText(MainActivity.this, "That was the last question!", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, HighestScoreActivity.class);
            intent.putExtra("score", score);
            startActivity(intent);
        }
    }

    private void updateScore(int point){
        tvShow.setText("" + score + "/" + theChoices.getLength());
    }

    public void onClick(View view){
        Button answer = (Button) view;
        if (answer.getText() == correctAnswer){
            score = score + 1;
            Toast.makeText(MainActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
        }
        updateScore(score);
        updateQuestion();
    }


}
