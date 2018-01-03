package id.achmiral.scoringboard;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class VolleyScore extends AppCompatActivity{

    TextView txtScoreA, txtScoreB, txtTeamA, txtTeamB;
    Button btnTambahTeamA, btnKurangTeamA, btnTambahTeamB, btnKurangTeamB;
    int scoreTeamA=0, scoreTeamB=0;
    String pemenangSet1, pemenangSet2, pemenangSet3, pemenangSet4, pemenangSet5, pemenang, teamA, teamB, olahraga = "volley";
    private SQLiteDatabase db =null;
    DatabaseHelper  dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_score);

        dbHelper = new DatabaseHelper(this);
        txtTeamA = (TextView) findViewById(R.id.txt_team_a);
        txtTeamB = (TextView) findViewById(R.id.txt_team_b);
        txtScoreA = (TextView) findViewById(R.id.txt_team_a_score);
        txtScoreB = (TextView) findViewById(R.id.txt_team_b_score);
        btnTambahTeamA = (Button) findViewById(R.id.btn_tambah_team_A);
        btnKurangTeamA = (Button) findViewById(R.id.btn_kurang_team_A);
        btnTambahTeamB = (Button) findViewById(R.id.btn_tambah_team_B);
        btnKurangTeamB = (Button) findViewById(R.id.btn_kurang_team_B);

        dbHelper = new DatabaseHelper(this);
        db = dbHelper.getWritableDatabase();

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
            Toast.makeText(this,"Pemenang set ini adalah '"+pemenang, Toast.LENGTH_SHORT).show();
            dbHelper.cobaInsert(olahraga,teamA, teamB, scoreTeamA, scoreTeamB);
            btnKurangTeamA.setVisibility(View.GONE);
            btnKurangTeamB.setVisibility(View.GONE);
            btnTambahTeamA.setVisibility(View.GONE);
            btnTambahTeamB.setVisibility(View.GONE);
        }
        else if (scoreTeamB>=25 && (scoreTeamB-scoreTeamA>=2)){
            pemenang = "team B";
            Toast.makeText(this,"Pemenang set ini adalah '"+pemenang, Toast.LENGTH_SHORT).show();
            dbHelper.cobaInsert(olahraga,teamA, teamB, scoreTeamA, scoreTeamB);
            btnKurangTeamA.setVisibility(View.GONE);
            btnKurangTeamB.setVisibility(View.GONE);
            btnTambahTeamA.setVisibility(View.GONE);
            btnTambahTeamB.setVisibility(View.GONE);
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

}
