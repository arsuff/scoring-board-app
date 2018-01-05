package id.achmiral.scoringboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.achmiral.scoringboard.helper.DatabaseHelper;
import id.achmiral.scoringboard.model.Football;

public class FootballHistoryDetailActivity extends AppCompatActivity {

    Button btnDelete;
    DatabaseHelper db;
    TextView tvTeamA, tvTeamB, tvScoreA, tvScoreB;
    Football football;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_history_detail);

        btnDelete = findViewById(R.id.btn_delete);
        tvTeamA = findViewById(R.id.team_a);
        tvTeamB = findViewById(R.id.team_b);
        tvScoreA = findViewById(R.id.team_a_score);
        tvScoreB = findViewById(R.id.team_b_score);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
            }
        });

        db = new DatabaseHelper(getApplicationContext());

        String football_id_string = getIntent().getStringExtra("football_id_extra");
        Long football_id = Long.parseLong(football_id_string);

        football = db.getFootball(football_id);

        tvTeamA.setText(football.getTeamA().toString());
        tvTeamB.setText(football.getTeamB().toString());
        tvScoreA.setText(String.valueOf(football.getScoreA()));
        tvScoreB.setText(String.valueOf(football.getScoreB()));
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, FootballHistoryActivity.class));
        finish();
    }

    public void alertDialog() {
        AlertDialog tampilKotakAlert;

        tampilKotakAlert = new AlertDialog.Builder(this).create();

        tampilKotakAlert.setTitle("Perhatian");
        tampilKotakAlert.setMessage("Apakah Anda yakin ingin menghapus score?");
        tampilKotakAlert.setButton(AlertDialog.BUTTON_POSITIVE, "Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                db = new DatabaseHelper(getApplicationContext());
                String football_id_string = getIntent().getStringExtra("football_id_extra");
                long football_id = Long.parseLong(football_id_string);
                db.deleteFootball(football_id);
                Intent intent = new Intent(getApplicationContext(), FootballHistoryActivity.class);
                startActivity(intent);
            }
        });

        tampilKotakAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
            }
        });

        tampilKotakAlert.show();
    }
}
