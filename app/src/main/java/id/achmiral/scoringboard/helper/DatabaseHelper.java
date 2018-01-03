package id.achmiral.scoringboard.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import id.achmiral.scoringboard.model.Basket;

/**
 * Created by ner46 on 25/12/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    static final private String DB_NAME = "sports";
    static final private int DB_VER = 1;

    // Logcat tag
    private static final String LOG = "DatabaseHelper";

    // Nama Tabel
    private static final String TABLE_BASKET = "basket";
    private static final String TABLE_FOOTBALL = "football";

    // Kolom Umum
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    // Kolom Basket
    private static final String TEAM_A = "team_a";
    private static final String TEAM_B = "team_b";
    private static final String SCORE_TEAM_A = "score_team_a";
    private static final String SCORE_TEAM_B = "score_team_b";
    private static final String WINNER = "winner";

    // Kolom Football

    // Kolom Volley


    // Create Tabel Basket
    private static final String CREATE_TABLE_BASKET = "CREATE TABLE " + TABLE_BASKET + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TEAM_A + " TEXT, " + TEAM_B + " TEXT, "
            + SCORE_TEAM_A + " INTEGER, " + SCORE_TEAM_B + " INTEGER, "
            + KEY_CREATED_AT + " DATETIME" + ")";

    // Create Tabel Football
    // TODO: Create table football

    // Create Tabel Volley
    // TODO: Create table volley

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_BASKET);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Ketika mengupgrade database baru
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BASKET);

        // Create table baru
        onCreate(db);
    }

    // ------------------------ "basket" table methods ----------------//

    public List<Basket> getAllBaskets() {
        List<Basket> baskets = new ArrayList<Basket>();

        String selectQuery = "SELECT * FROM " + TABLE_BASKET;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);


        // Looping ke semua baris dan ditambahkan ke list
        if (c.moveToFirst()) {
            do {
                Basket basket = new Basket();
                basket.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                basket.setTeamA(c.getString(c.getColumnIndex(TEAM_A)));
                basket.setTeamB(c.getString(c.getColumnIndex(TEAM_B)));
                basket.setScoreA(c.getInt(c.getColumnIndex(SCORE_TEAM_A)));
                basket.setScoreB(c.getInt(c.getColumnIndex(SCORE_TEAM_B)));
                basket.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

                // tambah basket ke list
                baskets.add(basket);
            } while (c.moveToNext());
        }

        return baskets;
    }

    public long createBasket(Basket basket) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEAM_A, basket.getTeamA());
        values.put(TEAM_B, basket.getTeamB());
        values.put(SCORE_TEAM_A, basket.getScoreA());
        values.put(SCORE_TEAM_B, basket.getScoreB());
        values.put(KEY_CREATED_AT, getDateTime());

        long basket_id = db.insert(TABLE_BASKET, null, values);

        return basket_id;
    }


    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen()) {
            db.close();
        }
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();

        return dateFormat.format(date);
    }
}
