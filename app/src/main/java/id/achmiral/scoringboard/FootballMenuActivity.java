package id.achmiral.scoringboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import id.achmiral.scoringboard.FootballHistoryActivity;

public class FootballMenuActivity extends AppCompatActivity {

    Button btnFootballHistory, btnFootballNew;
    Toolbar menu_toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menu_toolbar = findViewById(R.id.menu_toolbar);
        menu_toolbar.setTitle("Football Menu");
        menu_toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(menu_toolbar);

        btnFootballHistory = (Button) findViewById(R.id.btn_history);
        btnFootballNew = (Button) findViewById(R.id.btn_new);

        btnFootballNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FootballMenuActivity.this, FootballScoreActivity.class);
                startActivity(i);
            }
        });

        btnFootballHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FootballMenuActivity.this, FootballHistoryActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
