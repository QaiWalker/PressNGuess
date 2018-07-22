package com.example.qaite.pressnguess;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class HighestScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highest_score);

        TextView txtScore = findViewById(R.id.textViewCurrentSc);
        TextView txtHigh = findViewById(R.id.textViewHighestSc);

        Intent intent = getIntent();
        int score = intent.getIntExtra("score", 0);

        txtScore.setText("Your Score: " + score);

        SharedPreferences mypref = getPreferences(MODE_PRIVATE);
        int highscore = mypref.getInt("highscore", 0);
        if(highscore >= score){
            txtHigh.setText("High Score: " + highscore);
        } else {
            txtHigh.setText("New High Score: " + score);
            SharedPreferences.Editor editor = mypref.edit();
            editor.putInt("highscore", score);
            editor.commit();
        }


    }
    public void onClick (View view){
        Intent intent = new Intent(HighestScoreActivity.this, MainActivity.class);
        startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.home) {
            Intent intent = new Intent(HighestScoreActivity.this, MainActivity.class);
            startActivity(intent);
        } else if (id == R.id.instrumentSound){
            Intent intent = new Intent(HighestScoreActivity.this, InstrumentsActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}
