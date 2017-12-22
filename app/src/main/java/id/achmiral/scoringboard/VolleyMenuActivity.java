package id.achmiral.scoringboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class VolleyMenuActivity extends AppCompatActivity {

    Button btnVolleyHistory, btnVolleyNew;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        btnVolleyHistory = (Button) findViewById(R.id.btn_history);
        btnVolleyNew = (Button) findViewById(R.id.btn_new);

        btnVolleyNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VolleyMenuActivity.this,VolleyScore.class);
                startActivity(i);
            }
        });

        btnVolleyHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(VolleyMenuActivity.this, ListHistoryVolleyActivity.class);
                startActivity(i);
            }
        });
    }
}
