package id.achmiral.scoringboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import id.achmiral.scoringboard.adapter.BasketAdapter;
import id.achmiral.scoringboard.helper.DatabaseHelper;
import id.achmiral.scoringboard.model.Basket;

public class BasketHistoryActivity extends AppCompatActivity {

    ListView lv_basket_history;
    DatabaseHelper db;
    Toolbar basketHistoryToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basket_history);

        basketHistoryToolbar = findViewById(R.id.basket_history_toolbar);
        basketHistoryToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(basketHistoryToolbar);

        db = new DatabaseHelper(getApplicationContext());

        final List<Basket> baskets = db.getAllBaskets();

        lv_basket_history = findViewById(R.id.list_basket_history);

        BasketAdapter basketAdapter = new BasketAdapter(this, R.layout.basket_history_row );
        basketAdapter.addAll(baskets);
        lv_basket_history.setAdapter(basketAdapter);

        lv_basket_history.setSelected(true);
        lv_basket_history.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Basket basket = baskets.get(position);

                int basket_id = basket.getId();

                Log.d("Item ID Coy", String.valueOf(basket_id));

                Intent i = new Intent(getApplicationContext(), BasketHistoryDetailActivity.class);
                i.putExtra("basket_id_extra", String.valueOf(basket_id));
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(this, BasketMenuActivity.class));
        finish();
    }
}
