package id.achmiral.scoringboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class BasketScoreActivity extends AppCompatActivity {

    int scoreTeamA, scoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_score);
    }

    public void displayForTeamA(int score) {
        TextView scoreViewTeamA = (TextView) findViewById(R.id.team_a_score);
        scoreViewTeamA.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreViewTeamB = (TextView) findViewById(R.id.team_b_score);
        scoreViewTeamB.setText(String.valueOf(score));
    }

    public void addThreeForTeamA(View view) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    public void subThreeForTeamA(View view) {
        if (scoreTeamA > 0) {
            scoreTeamA = scoreTeamA - 3;
        } else {
            scoreTeamA = 0;
        }
        displayForTeamA(scoreTeamA);
    }

    public void addTwoForTeamA(View view) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    public void subTwoForTeamA(View view) {
        if (scoreTeamA > 0) {
            scoreTeamA = scoreTeamA - 2;
        } else {
            scoreTeamA = 0;
        }
        displayForTeamA(scoreTeamA);
    }

    public void addOneForTeamA(View view) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void subOneForTeamA(View view) {
        if (scoreTeamA > 0) {
            scoreTeamA = scoreTeamA - 1;
        } else {
            scoreTeamA = 0;
        }
        displayForTeamA(scoreTeamA);
    }

    public void addThreeForTeamB(View view) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    public void subThreeForTeamB(View view) {
        if (scoreTeamB > 0) {
            scoreTeamB = scoreTeamB - 3;
        } else {
            scoreTeamB = 0;
        }
        displayForTeamB(scoreTeamB);
    }

    public void addTwoForTeamB(View view) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    public void subTwoForTeamB(View view) {
        if (scoreTeamB > 0) {
            scoreTeamB = scoreTeamB - 2;
        } else {
            scoreTeamB = 0;
        }
        displayForTeamB(scoreTeamB);
    }

    public void addOneForTeamB(View view) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }

    public void subOneForTeamB(View view) {
        if (scoreTeamB > 0) {
            scoreTeamB = scoreTeamB - 1;
        } else {
            scoreTeamB = 0;
        }
        displayForTeamB(scoreTeamB);
    }

    public void resetPoint(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }
}