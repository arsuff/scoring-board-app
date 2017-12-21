package id.achmiral.scoringboard;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageButton btnExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnExit = (ImageButton) findViewById(R.id.btn_exit);

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertDialog();
            }
        });

    }


    public void alertDialog() {
        AlertDialog tampilKotakAlert;

        tampilKotakAlert = new AlertDialog.Builder(MainActivity.this).create();

        tampilKotakAlert.setTitle("Keluar?");
        tampilKotakAlert.setMessage("Apakah Anda ingin keluar?");
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



}
