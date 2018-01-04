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
import id.achmiral.scoringboard.adapter.VolleyAdapter;
import id.achmiral.scoringboard.helper.DatabaseHelper;
import id.achmiral.scoringboard.model.Basket;
import id.achmiral.scoringboard.model.Volley;

public class VolleyHistoryActivity extends AppCompatActivity {

    ListView lv_volley_history;
    TextView tv_empty;
    DatabaseHelper db;
    Toolbar volleyHistoryToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_history);
        volleyHistoryToolbar = findViewById(R.id.volley_history_toolbar);
        volleyHistoryToolbar.setTitle("Volley Score History");
        volleyHistoryToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(volleyHistoryToolbar);

        db = new DatabaseHelper(getApplicationContext());

        final List<Volley> volleys = db.getAllVolleys();

        lv_volley_history = findViewById(R.id.list_volley_history);

        tv_empty = findViewById(R.id.tv_empty);


        if(db.getAllVolleys().size() == 0) {
            lv_volley_history.setVisibility(View.GONE);
            Toast.makeText(this, "Data History Score Kosong", Toast.LENGTH_LONG).show();
        }

        VolleyAdapter volleyAdapter = new VolleyAdapter(this, R.layout.volley_history_row );
        volleyAdapter.addAll(volleys);
        lv_volley_history.setAdapter(volleyAdapter);

        lv_volley_history.setSelected(true);
        lv_volley_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Volley volley = volleys.get(position);

                int volley_id = volley.getId();

                Log.d("Item ID Coy", String.valueOf(volley_id));

                Intent i = new Intent(getApplicationContext(), VolleyHistoryDetailActivity.class);
                i.putExtra("volley_id_extra", String.valueOf(volley_id));
                startActivity(i);
            }
        });
    }
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, VolleyMenuActivity.class));
        finish();
    }
}
