package id.achmiral.scoringboard;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import id.achmiral.scoringboard.helper.DatabaseHelper;

/**
 * Created by MICHAEL BAGUS on 12/22/2017.
 */

public class ListHistoryVolleyActivity extends AppCompatActivity {
    String[] daftar;
    private ListView listView;
    private SQLiteDatabase db =null;
    private DatabaseHelper dbhelper =null;
    Menu menu;
    protected Cursor cursor;
    public static ListHistoryVolleyActivity lhva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_history);

        lhva = this;
        dbhelper = new DatabaseHelper(this);
        db = dbhelper.getWritableDatabase();

        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db = dbhelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM score",null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for (int cc=0; cc < cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        listView = (ListView)findViewById(R.id.list_history);
        listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        listView.setSelected(true);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String idPertandingan = listView.getItemAtPosition(position).toString();
                Intent i = new Intent(getApplicationContext(), HistoryVolley.class);
                i.putExtra("idPertandingan", idPertandingan);
                startActivity(i);
            }
        });
    }
}
