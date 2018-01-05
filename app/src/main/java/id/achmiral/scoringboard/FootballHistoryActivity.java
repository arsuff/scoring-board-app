package id.achmiral.scoringboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import id.achmiral.scoringboard.adapter.BasketAdapter;
import id.achmiral.scoringboard.adapter.FootballAdapter;
import id.achmiral.scoringboard.helper.DatabaseHelper;
import id.achmiral.scoringboard.model.Basket;
import id.achmiral.scoringboard.model.Football;

public class FootballHistoryActivity extends AppCompatActivity {

    ListView lv_football_history;
    TextView tv_empty;
    DatabaseHelper db;
    Toolbar footballHistoryToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_football_history);

        footballHistoryToolbar = findViewById(R.id.football_history_toolbar);
        footballHistoryToolbar.setTitle("Football Score History");
        footballHistoryToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(footballHistoryToolbar);

        db = new DatabaseHelper(getApplicationContext());

        final List<Football> footballs = db.getAllFootballs();

        lv_football_history = findViewById(R.id.list_football_history);

        tv_empty = findViewById(R.id.tv_empty);


        if(db.getAllFootballs().size() == 0) {
            lv_football_history.setVisibility(View.GONE);
            Toast.makeText(this, "Data History Score Kosong", Toast.LENGTH_LONG).show();
        }

        FootballAdapter footballAdapter = new FootballAdapter(this, R.layout.basket_history_row );
        footballAdapter.addAll(footballs);
        lv_football_history.setAdapter(footballAdapter);

        lv_football_history.setSelected(true);
        lv_football_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Football football = footballs.get(position);

                int football_id = football.getId();

                Log.d("Item ID Coy", String.valueOf(football_id));

                Intent i = new Intent(getApplicationContext(), FootballHistoryDetailActivity.class);
                i.putExtra("football_id_extra", String.valueOf(football_id));
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, FootballMenuActivity.class));
        finish();
    }
}
