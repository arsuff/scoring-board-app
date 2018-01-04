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
import id.achmiral.scoringboard.model.Volley;

public class VolleyHistoryDetailActivity extends AppCompatActivity {

    Button btnDelete;
    DatabaseHelper db;
    TextView tvTeamA, tvTeamB, tvScoreASet1, tvScoreBSet1, tvScoreASet2, tvScoreBSet2, tvScoreASet3, tvScoreBSet3, tvScoreASet4, tvScoreBSet4, tvScoreASet5, tvScoreBSet5, tvTotalScoreA, tvTotalScoreB;
    Volley volley;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_history_detail);

//        btnDelete = findViewById(R.id.btn_delete);
        tvTeamA = findViewById(R.id.txt_team_a);
        tvTeamB = findViewById(R.id.txt_team_b);
        tvScoreASet1 = findViewById(R.id.tv_a_set1);
        tvScoreBSet1 = findViewById(R.id.tv_b_set1);
        tvScoreASet2 = findViewById(R.id.tv_a_set2);
        tvScoreBSet2 = findViewById(R.id.tv_b_set2);
        tvScoreASet3 = findViewById(R.id.tv_a_set3);
        tvScoreBSet3 = findViewById(R.id.tv_b_set3);
        tvScoreASet4 = findViewById(R.id.tv_a_set4);
        tvScoreBSet4 = findViewById(R.id.tv_b_set4);
        tvScoreASet5 = findViewById(R.id.tv_a_set5);
        tvScoreBSet5 = findViewById(R.id.tv_b_set5);
        tvTotalScoreA = findViewById(R.id.tv_score_total_a);
        tvTotalScoreB = findViewById(R.id.tv_score_total_b);
        btnDelete = findViewById(R.id.btn_delete_vol);


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
            }
        });

        db = new DatabaseHelper(getApplicationContext());

        String volley_id_string = getIntent().getStringExtra("volley_id_extra");
        Long volley_id = Long.parseLong(volley_id_string);

        volley = db.getVolley(volley_id);

        tvTeamA.setText(volley.getTeamAVol().toString());
        tvTeamB.setText(volley.getTeamBVol().toString());
        tvScoreASet1.setText(String.valueOf(volley.getScoreASet1()));
        tvScoreBSet1.setText(String.valueOf(volley.getScoreBSet1()));
        tvScoreASet2.setText(String.valueOf(volley.getScoreASet2()));
        tvScoreBSet2.setText(String.valueOf(volley.getScoreBSet2()));
        tvScoreASet3.setText(String.valueOf(volley.getScoreASet3()));
        tvScoreBSet3.setText(String.valueOf(volley.getScoreBSet3()));
        tvScoreASet4.setText(String.valueOf(volley.getScoreASet4()));
        tvScoreBSet4.setText(String.valueOf(volley.getScoreBSet4()));
        tvScoreASet5.setText(String.valueOf(volley.getScoreASet5()));
        tvScoreBSet5.setText(String.valueOf(volley.getScoreBSet5()));
        tvTotalScoreA.setText(String.valueOf(volley.getTotalScoreA()));
        tvTotalScoreB.setText(String.valueOf(volley.getTotalScoreB()));
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
                String volley_id_string = getIntent().getStringExtra("volley_id_extra");
                long volley_id = Long.parseLong(volley_id_string);
                db.deleteVolley(volley_id);
                Intent intent = new Intent(getApplicationContext(), VolleyHistoryActivity.class);
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
