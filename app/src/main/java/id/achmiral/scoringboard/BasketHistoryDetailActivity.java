package id.achmiral.scoringboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import id.achmiral.scoringboard.helper.DatabaseHelper;
import id.achmiral.scoringboard.model.Basket;

public class BasketHistoryDetailActivity extends AppCompatActivity {

    Button btnDelete;
    DatabaseHelper db;
    TextView tvTeamA, tvTeamB, tvScoreA, tvScoreB;
    Basket basket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_history_detail);

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

        String basket_id_string = getIntent().getStringExtra("basket_id_extra");
        Long basket_id = Long.parseLong(basket_id_string);

        basket = db.getBasket(basket_id);

        tvTeamA.setText(basket.getTeamA().toString());
        tvTeamB.setText(basket.getTeamB().toString());
        tvScoreA.setText(String.valueOf(basket.getScoreA()));
        tvScoreB.setText(String.valueOf(basket.getScoreB()));

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, BasketHistoryActivity.class));
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
                String basket_id_string = getIntent().getStringExtra("basket_id_extra");
                long basket_id = Long.parseLong(basket_id_string);
                db.deleteBasket(basket_id);
                Intent intent = new Intent(getApplicationContext(), BasketHistoryActivity.class);
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
