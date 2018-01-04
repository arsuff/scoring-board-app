package id.achmiral.scoringboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    Button btnExit, btnBasket, btnVolley, btnFootball;
    Toolbar mainToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setup app action bar
        mainToolbar = findViewById(R.id.main_toolbar);
        mainToolbar.setTitle("Scoring Board App");
        mainToolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(mainToolbar);

        btnExit = findViewById(R.id.btn_exit);
        btnBasket = findViewById(R.id.btn_basket);

        btnVolley = findViewById(R.id.btn_volley);
        btnFootball = findViewById(R.id.btn_football);

        btnVolley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, VolleyMenuActivity.class);
                startActivity(i);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
            }
        });

        btnBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iBasket = new Intent(MainActivity.this, BasketMenuActivity.class);
                startActivity(iBasket);
            }
        });

        btnFootball.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iFootball = new Intent(MainActivity.this, FootballMenuActivity.class);
                startActivity(iFootball);
            }
        });

    }


    public void alertDialog() {
        AlertDialog tampilKotakAlert;

        tampilKotakAlert = new AlertDialog.Builder(MainActivity.this).create();

        tampilKotakAlert.setTitle("Peringantan");
        tampilKotakAlert.setMessage("Apakah Anda yakin ingin keluar?");
        tampilKotakAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        tampilKotakAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                moveTaskToBack(true);
            }
        });

        tampilKotakAlert.show();
    }


    public void openMenu(View view) {

        switch (view.getId()) {
            case R.id.btn_basket:
                Intent iBasket = new Intent(this, BasketMenuActivity.class);
                startActivity(iBasket);
                break;
        }


    }

    @Override
    public void onBackPressed() {
        alertDialog();

    }
}