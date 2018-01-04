package id.achmiral.scoringboard;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.achmiral.scoringboard.helper.DatabaseHelper;
import id.achmiral.scoringboard.model.Basket;

public class FootballScoreActivity extends AppCompatActivity {

    int scoreTeamA, scoreTeamB;
    TextView tv_teamA, tv_teamB, tv_scoreA, tv_scoreB;
    String teamA, teamB;
    DatabaseHelper db;
    Toolbar footballScoreToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_score);

        footballScoreToolbar = (Toolbar) findViewById(R.id.basket_score_toolbar);
        footballScoreToolbar.setTitle("Football Score");
        footballScoreToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(footballScoreToolbar);

        db = new DatabaseHelper(getApplicationContext());
        tv_teamA = findViewById(R.id.team_a);
        tv_teamB = findViewById(R.id.team_b);
        tv_scoreA = findViewById(R.id.team_a_score);
        tv_scoreB = findViewById(R.id.team_b_score);

        tv_teamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTeamNameA();
            }
        });

        tv_teamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeTeamNameB();
            }
        });
    }

    public void changeTeamNameA() {
        final LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.ganti_nama_team, null);

        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setView(v);
        dialog.setTitle("Ganti Nama Team A");

        final Button btnOK = v.findViewById(R.id.btn_ok);
        final EditText teamAName = v.findViewById(R.id.edit_nama_team);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamA = teamAName.getText().toString();
                tv_teamA.setText(teamA);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void changeTeamNameB() {
        final LayoutInflater inflater = LayoutInflater.from(this);
        View v = inflater.inflate(R.layout.ganti_nama_team, null);

        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setView(v);
        dialog.setTitle("Ganti Nama Team B");

        final Button btnOK = v.findViewById(R.id.btn_ok);
        final EditText teamBName = v.findViewById(R.id.edit_nama_team);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                teamB = teamBName.getText().toString();
                tv_teamB.setText(teamB);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void displayForTeamA(int score) {
        TextView scoreViewTeamA = (TextView) findViewById(R.id.team_a_score);
        scoreViewTeamA.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreViewTeamB = (TextView) findViewById(R.id.team_b_score);
        scoreViewTeamB.setText(String.valueOf(score));
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

        Long basket_id = db.createBasket(basket);

        if (basket_id != -1){
            Toast.makeText(this, "Point berhasil di simpan", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Point gagal di simpan", Toast.LENGTH_LONG).show();
        }

        scoreTeamA = 0;
        scoreTeamB = 0;

        tv_teamA.setText("Team A");
        tv_teamB.setText("Team B");

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);



        Log.d("Basket Count", "Basket Count: " + db.getAllBaskets().size());
    }
}
