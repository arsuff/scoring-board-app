package id.achmiral.scoringboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnExit, btnBasket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExit = findViewById(R.id.btn_exit);
        btnBasket = findViewById(R.id.btn_basket);

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
            case R.id.btn_football:
                Intent iFootball = new Intent(this, MenuActivity.class);
                startActivity(iFootball);
                break;
            case R.id.btn_basket:
                Intent iBasket = new Intent(this, MenuActivity.class);
                startActivity(iBasket);
                break;
            case R.id.btn_volley:
                Intent iVolley = new Intent(this, MenuActivity.class);
                startActivity(iVolley);
                break;
        }
    }
}
