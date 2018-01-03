package id.achmiral.scoringboard;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by MICHAEL BAGUS on 12/22/2017.
 */

public class HistoryVolley extends AppCompatActivity {

    protected Cursor cursor;
    DatabaseHelper dbHelper;
    TextView txtTeamA, txtTeamB, txtScoreTeamA, txtScoreTeamB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_score);

        dbHelper = new DatabaseHelper(this);
        txtTeamA = (TextView) findViewById(R.id.txt_team_a);
        txtTeamB = (TextView) findViewById(R.id.txt_team_b);
        txtScoreTeamA = (TextView) findViewById(R.id.txt_team_a_score);
        txtScoreTeamB = (TextView) findViewById(R.id.txt_team_b_score);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM score WHERE id = '" +
                getIntent().getStringExtra("idPertandingan") + "'",null);
        cursor.moveToFirst();
        if (cursor.getCount()>0)
        {
            cursor.moveToPosition(0);
            txtTeamA.setText(cursor.getString(2).toString());
            txtTeamB.setText(cursor.getString(3).toString());
            txtScoreTeamA.setText(cursor.getString(4).toString());
            txtScoreTeamB.setText(cursor.getString(5).toString());
        }
    }
}
