package id.achmiral.scoringboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class BasketMenuActivity extends AppCompatActivity {

    Button btnNew, btnHistory;
    Toolbar menu_toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Setup app action bar
        menu_toolbar = findViewById(R.id.menu_toolbar);
        menu_toolbar.setTitle("Basket Menu");
        menu_toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(menu_toolbar);

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
