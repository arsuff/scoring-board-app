package id.achmiral.scoringboard;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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

import org.w3c.dom.Text;

import id.achmiral.scoringboard.helper.DatabaseHelper;
import id.achmiral.scoringboard.model.Volley;

public class VolleyScore extends AppCompatActivity{

    TextView txtScoreA, txtScoreB, txtTeamA, txtTeamB, tvASet1, tvBSet1, tvASet2, tvBSet2, tvASet3, tvBSet3, tvASet4, tvBSet4, tvASet5, tvBSet5, tvTotalA, tvTotalB;
    Button btnTambahTeamA, btnKurangTeamA, btnTambahTeamB, btnKurangTeamB, btnGantiSet, btnSaveVolley;
    int scoreTeamA=0, scoreTeamB=0, scoreTotalA=0, scoreTotalB=0;
    String menang, pemenang, teamA, teamB, olahraga = "volley";
    DatabaseHelper db;
    Toolbar volleyScoreToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_score);

        volleyScoreToolbar = findViewById(R.id.volley_score_toolbar);
        volleyScoreToolbar.setTitle("Volley Score");
        volleyScoreToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(volleyScoreToolbar);

        db = new DatabaseHelper(getApplicationContext());
        txtTeamA = (TextView) findViewById(R.id.txt_team_a);
        txtTeamB = (TextView) findViewById(R.id.txt_team_b);
        txtScoreA = (TextView) findViewById(R.id.txt_team_a_score);
        txtScoreB = (TextView) findViewById(R.id.txt_team_b_score);
        btnTambahTeamA = (Button) findViewById(R.id.btn_tambah_team_A);
        btnKurangTeamA = (Button) findViewById(R.id.btn_kurang_team_A);
        btnTambahTeamB = (Button) findViewById(R.id.btn_tambah_team_B);
        btnKurangTeamB = (Button) findViewById(R.id.btn_kurang_team_B);
        btnGantiSet = (Button) findViewById(R.id.btn_ganti_set);
        btnSaveVolley = (Button) findViewById(R.id.btn_save_volley);
        tvASet1 = (TextView) findViewById(R.id.tv_a_set1);
        tvBSet1 = (TextView) findViewById(R.id.tv_b_set1);
        tvASet2 = (TextView) findViewById(R.id.tv_a_set2);
        tvBSet2 = (TextView) findViewById(R.id.tv_b_set2);
        tvASet3 = (TextView) findViewById(R.id.tv_a_set3);
        tvBSet3 = (TextView) findViewById(R.id.tv_b_set3);
        tvASet4 = (TextView) findViewById(R.id.tv_a_set4);
        tvBSet4 = (TextView) findViewById(R.id.tv_b_set4);
        tvASet5 = (TextView) findViewById(R.id.tv_a_set5);
        tvBSet5 = (TextView) findViewById(R.id.tv_b_set5);
        tvTotalA = (TextView) findViewById(R.id.tv_score_total_a);
        tvTotalB = (TextView) findViewById(R.id.tv_score_total_b);
        tvASet1.setText("0");
        tvBSet1.setText("0");
        tvASet2.setText("0");
        tvBSet2.setText("0");
        tvASet3.setText("0");
        tvBSet3.setText("0");
        tvASet4.setText("0");
        tvBSet4.setText("0");
        tvASet5.setText("0");
        tvBSet5.setText("0");
        btnGantiSet.setVisibility(View.GONE);


//        dbHelper = new DatabaseHelper(this);
//        db = dbHelper.getWritableDatabase();

        txtTeamA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gantiNamaTeamA();
            }
        });

        txtTeamB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gantiNamaTeamB();
            }
        });

        btnGantiSet.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                tvTotalA.setText(Integer.toString(scoreTotalA));
                tvTotalB.setText(Integer.toString(scoreTotalB));
                if (tvASet1.getText().toString().contains("0") && tvBSet1.getText().toString().contains("0")){
                    tvASet1.setText(Integer.toString(scoreTeamA));
                    tvBSet1.setText(Integer.toString(scoreTeamB));
                    scoreTeamA=0;
                    scoreTeamB=0;
                    txtScoreA.setText("0");
                    txtScoreB.setText("0");
                    btnKurangTeamA.setVisibility(View.VISIBLE);
                    btnTambahTeamA.setVisibility(View.VISIBLE);
                    btnKurangTeamB.setVisibility(View.VISIBLE);
                    btnTambahTeamB.setVisibility(View.VISIBLE);
                }

                else if (tvASet1.getText().toString()!=null && tvBSet1.getText().toString()!=null && tvASet2.getText().toString().contains("0") && tvBSet2.getText().toString().contains("0")){
                    tvASet2.setText(Integer.toString(scoreTeamA));
                    tvBSet2.setText(Integer.toString(scoreTeamB));
                    scoreTeamA=0;
                    scoreTeamB=0;
                    txtScoreA.setText("0");
                    txtScoreB.setText("0");
                    btnKurangTeamA.setVisibility(View.VISIBLE);
                    btnTambahTeamA.setVisibility(View.VISIBLE);
                    btnKurangTeamB.setVisibility(View.VISIBLE);
                    btnTambahTeamB.setVisibility(View.VISIBLE);
                }

                else if (tvASet1.getText().toString()!=null && tvBSet1.getText().toString()!=null && tvASet2.getText().toString()!=null && tvBSet2.getText().toString()!=null && tvASet3.getText().toString().contains("0") && tvBSet3.getText().toString().contains("0")){
                    tvASet3.setText(Integer.toString(scoreTeamA));
                    tvBSet3.setText(Integer.toString(scoreTeamB));
                    scoreTeamA=0;
                    scoreTeamB=0;
                    txtScoreA.setText("0");
                    txtScoreB.setText("0");
                    btnKurangTeamA.setVisibility(View.VISIBLE);
                    btnTambahTeamA.setVisibility(View.VISIBLE);
                    btnKurangTeamB.setVisibility(View.VISIBLE);
                    btnTambahTeamB.setVisibility(View.VISIBLE);
                }

                else if (tvASet1.getText().toString()!=null && tvBSet1.getText().toString()!=null && tvASet2.getText().toString()!=null && tvBSet2.getText().toString()!=null && tvASet3.getText().toString()!=null && tvBSet3.getText().toString()!=null && tvASet4.getText().toString().contains("0") && tvBSet4.getText().toString().contains("0")){
                    tvASet4.setText(Integer.toString(scoreTeamA));
                    tvBSet4.setText(Integer.toString(scoreTeamB));
                    scoreTeamA=0;
                    scoreTeamB=0;
                    txtScoreA.setText("0");
                    txtScoreB.setText("0");
                    btnKurangTeamA.setVisibility(View.VISIBLE);
                    btnTambahTeamA.setVisibility(View.VISIBLE);
                    btnKurangTeamB.setVisibility(View.VISIBLE);
                    btnTambahTeamB.setVisibility(View.VISIBLE);
                }

                else if (tvASet1.getText().toString()!=null && tvBSet1.getText().toString()!=null && tvASet2.getText().toString()!=null && tvBSet2.getText().toString()!=null && tvASet3.getText().toString()!=null && tvBSet3.getText().toString()!=null && tvASet4.getText().toString()==null && tvBSet4.getText().toString()==null && tvASet5.getText().toString().contains("0") && tvBSet5.getText().toString().contains("0")){
                    tvASet5.setText(Integer.toString(scoreTeamA));
                    tvBSet5.setText(Integer.toString(scoreTeamB));
                    txtScoreA.setText("0");
                    txtScoreB.setText("0");
                    btnKurangTeamA.setVisibility(View.GONE);
                    btnTambahTeamA.setVisibility(View.GONE);
                    btnKurangTeamB.setVisibility(View.GONE);
                    btnTambahTeamB.setVisibility(View.GONE);
                }
            btnGantiSet.setVisibility(View.GONE);
            }

        });
    }

    public void tambahScoreA(View view) {
        scoreTeamA = scoreTeamA+1;
        tampilScoreA(scoreTeamA);
    }

    public void kurangScoreA(View view) {
        if (scoreTeamA > 0) {
            scoreTeamA = scoreTeamA - 1;
        } else {
            scoreTeamA = 0;
        }
        tampilScoreA(scoreTeamA);
    }

    public void kurangScoreB(View view) {
        if(scoreTeamB>0) {
            scoreTeamB = scoreTeamB - 1;
        }
        else {
            scoreTeamB=0;
        }
        tampilScoreB(scoreTeamB);
    }

    public void tambahScoreB(View view) {
        scoreTeamB = scoreTeamB+1;
        tampilScoreB(scoreTeamB);
    }

    public void tampilScoreA(int score){
        txtScoreA.setText(String.valueOf(score));
        cekPemenangSet();
    }
    public void tampilScoreB(int score){
        txtScoreB.setText(String.valueOf(score));
        cekPemenangSet();
    }

    public void cekPemenangSet(){
        if (scoreTeamA >=25 && (scoreTeamA-scoreTeamB>=2)){
            pemenang = "team A";
            scoreTotalA=scoreTotalA+1;
            if(scoreTotalA>=3){
                menang= txtTeamA.getText().toString();
            }
//            tvTotalA.setText(scoreTotalA);
            Toast.makeText(this,"Pemenang set ini adalah '"+pemenang, Toast.LENGTH_SHORT).show();
//            dbHelper.cobaInsert(olahraga,teamA, teamB, scoreTeamA, scoreTeamB);
            btnKurangTeamA.setVisibility(View.GONE);
            btnKurangTeamB.setVisibility(View.GONE);
            btnTambahTeamA.setVisibility(View.GONE);
            btnTambahTeamB.setVisibility(View.GONE);
            btnGantiSet.setVisibility(View.VISIBLE);
        }
        else if (scoreTeamB>=25 && (scoreTeamB-scoreTeamA>=2)){
            pemenang = "team B";
            scoreTotalB=scoreTotalB+1;
            if (scoreTotalB>=3){
                menang = txtTeamB.getText().toString();
            }
//            tvTotalB.setText(scoreTotalB);
            Toast.makeText(this,"Pemenang set ini adalah '"+pemenang, Toast.LENGTH_SHORT).show();
//            dbHelper.cobaInsert(olahraga,teamA, teamB, scoreTeamA, scoreTeamB);
            btnKurangTeamA.setVisibility(View.GONE);
            btnKurangTeamB.setVisibility(View.GONE);
            btnTambahTeamA.setVisibility(View.GONE);
            btnTambahTeamB.setVisibility(View.GONE);
            btnGantiSet.setVisibility(View.VISIBLE);
        }
    }

    public void gantiNamaTeamA(){
        final LayoutInflater mInflater = LayoutInflater.from(this);
        View v = mInflater.inflate(R.layout.ganti_nama_team, null);

        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setView(v);
        dialog.setTitle("Ganti Nama Team A");

        final Button btnOK = (Button) v.findViewById(R.id.btn_ok);
        final EditText namaTeamA = (EditText) v.findViewById(R.id.edit_nama_team);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamA = namaTeamA.getText().toString();
                txtTeamA.setText(teamA);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void gantiNamaTeamB(){
        final LayoutInflater mInflater = LayoutInflater.from(this);
        View v = mInflater.inflate(R.layout.ganti_nama_team, null);

        final AlertDialog dialog = new AlertDialog.Builder(this).create();
        dialog.setView(v);
        dialog.setTitle("Ganti Nama Team B");

        final Button btnOK = (Button) v.findViewById(R.id.btn_ok);
        final EditText namaTeamB = (EditText) v.findViewById(R.id.edit_nama_team);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                teamB = namaTeamB.getText().toString();
                txtTeamB.setText(teamB);
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    public void saveScoreVolley(View view) {
        String teamA = txtTeamA.getText().toString();
        String teamB = txtTeamB.getText().toString();
        int scoreASet1 = Integer.parseInt(tvASet1.getText().toString());
        int scoreBSet1 = Integer.parseInt(tvBSet1.getText().toString());
        int scoreASet2 = Integer.parseInt(tvASet2.getText().toString());
        int scoreBSet2 = Integer.parseInt(tvBSet2.getText().toString());
        int scoreASet3 = Integer.parseInt(tvASet3.getText().toString());
        int scoreBSet3 = Integer.parseInt(tvBSet3.getText().toString());
        int scoreASet4 = Integer.parseInt(tvASet4.getText().toString());
        int scoreBSet4 = Integer.parseInt(tvBSet4.getText().toString());
        int scoreASet5 = Integer.parseInt(tvASet5.getText().toString());
        int scoreBSet5 = Integer.parseInt(tvBSet5.getText().toString());
        int totalScoreA = Integer.parseInt(tvTotalA.getText().toString());
        int totalScoreB = Integer.parseInt(tvTotalB.getText().toString());

        Log.d("Score A bro", "Score A: " + totalScoreA);
        Log.d("Score B bro", "Score B: " + totalScoreB);

        Volley volley = new Volley(teamA, teamB, scoreASet1, scoreBSet1, scoreASet2, scoreBSet2, scoreASet3, scoreBSet3, scoreASet4, scoreBSet4, scoreASet5, scoreBSet5, totalScoreA, totalScoreB );

        Long volley_id = db.createVolley(volley);

        if (volley_id != -1){
            Toast.makeText(this, "Point berhasil di simpan", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Point gagal di simpan", Toast.LENGTH_LONG).show();
        }

        scoreTeamA = 0;
        scoreTeamB = 0;

        txtTeamA.setText("Team A");
        txtTeamB.setText("Team B");

        tampilScoreA(scoreTeamA);
        tampilScoreB(scoreTeamB);



        Log.d("Volley Count", "Volley Count: " + db.getAllVolleys().size());
    }
}
