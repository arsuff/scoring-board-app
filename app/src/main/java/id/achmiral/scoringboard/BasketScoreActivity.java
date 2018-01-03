package id.achmiral.scoringboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import id.achmiral.scoringboard.helper.DatabaseHelper;
import id.achmiral.scoringboard.model.Basket;

public class BasketScoreActivity extends AppCompatActivity {

    int scoreTeamA, scoreTeamB;
    TextView tv_teamA, tv_teamB, tv_scoreA, tv_scoreB;
    DatabaseHelper db;
    Toolbar basketScoreToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_score);

        basketScoreToolbar = findViewById(R.id.basket_score_toolbar);
        basketScoreToolbar.setTitle("Basket Score");
        basketScoreToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(basketScoreToolbar);

        db = new DatabaseHelper(getApplicationContext());
        tv_teamA = findViewById(R.id.team_a);
        tv_teamB = findViewById(R.id.team_b);
        tv_scoreA = findViewById(R.id.team_a_score);
        tv_scoreB = findViewById(R.id.team_b_score);
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

    public void saveScore(View view) {
        String teamA = tv_teamA.getText().toString();
        String teamB = tv_teamB.getText().toString();
        int scoreA = Integer.parseInt(tv_scoreA.getText().toString());
        int scoreB = Integer.parseInt(tv_scoreB.getText().toString());

        Log.d("Score A bro", "Score A: " + scoreA);
        Log.d("Score B bro", "Score B: " + scoreB);

        Basket basket = new Basket(teamA, teamB, scoreA, scoreB);

        db.createBasket(basket);

        scoreTeamA = 0;
        scoreTeamB = 0;

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

        Log.d("Basket Count", "Basket Count: " + db.getAllBaskets().size());
    }
}