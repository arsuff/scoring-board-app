package id.achmiral.scoringboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BasketMenuActivity extends AppCompatActivity {

    Button btnNew, btnHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnNew = findViewById(R.id.btn_new);
        btnHistory = findViewById(R.id.btn_history);

        btnNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iNew = new Intent(BasketMenuActivity.this, BasketScoreActivity.class);
                startActivity(iNew);
            }
        });

        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iHistory = new Intent(BasketMenuActivity.this, BasketHistoryActivity.class);
                startActivity(iHistory);
            }
        });
    }


}
