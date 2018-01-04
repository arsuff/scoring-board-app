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

import id.achmiral.scoringboard.model.Volley;

import id.achmiral.scoringboard.model.Football;


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
    private static final String TABLE_VOLLEY = "volley";

    // Kolom Umum
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";

    // Kolom Basket dan Football
    private static final String TEAM_A = "team_a";
    private static final String TEAM_B = "team_b";
    private static final String SCORE_TEAM_A = "score_team_a";
    private static final String SCORE_TEAM_B = "score_team_b";
    private static final String WINNER = "winner";

    // Kolom Volley
    private static final String TEAM_A_VOL = "team_a";
    private static final String TEAM_B_VOL = "team_b";
    private static final String SCORE_TEAM_A_SET1 = "score_team_a_set1";
    private static final String SCORE_TEAM_A_SET2 = "score_team_a_set2";
    private static final String SCORE_TEAM_A_SET3 = "score_team_a_set3";
    private static final String SCORE_TEAM_A_SET4 = "score_team_a_set4";
    private static final String SCORE_TEAM_A_SET5 = "score_team_a_set5";
    private static final String SCORE_TEAM_B_SET1 = "score_team_b_set1";
    private static final String SCORE_TEAM_B_SET2 = "score_team_b_set2";
    private static final String SCORE_TEAM_B_SET3 = "score_team_b_set3";
    private static final String SCORE_TEAM_B_SET4 = "score_team_b_set4";
    private static final String SCORE_TEAM_B_SET5 = "score_team_b_set5";
    private static final String TOTAL_SCORE_TEAM_A = "total_score_team_a";
    private static final String TOTAL_SCORE_TEAM_B = "total_score_team_b";

    // Create Tabel Basket
    private static final String CREATE_TABLE_BASKET = "CREATE TABLE " + TABLE_BASKET + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TEAM_A + " TEXT, " + TEAM_B + " TEXT, "
            + SCORE_TEAM_A + " INTEGER, " + SCORE_TEAM_B + " INTEGER, "
            + KEY_CREATED_AT + " DATETIME" + ")";

    // Create Tabel Football
    private static final String CREATE_TABLE_FOOTBALL = "CREATE TABLE " + TABLE_FOOTBALL + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TEAM_A + " TEXT, " + TEAM_B + " TEXT, "
            + SCORE_TEAM_A + " INTEGER, " + SCORE_TEAM_B + " INTEGER, "
            + KEY_CREATED_AT + " DATETIME" + ")";

    // Create Tabel Volley
    // TODO: Create table volley
    private static final String CREATE_TABLE_VOLLEY = "CREATE TABLE " + TABLE_VOLLEY + "(" + KEY_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TEAM_A_VOL + " TEXT, " + TEAM_B_VOL + " TEXT, "
            + SCORE_TEAM_A_SET1 + " INTEGER, " + SCORE_TEAM_B_SET1 + " INTEGER, "
            + SCORE_TEAM_A_SET2 + " INTEGER, " + SCORE_TEAM_B_SET2 + " INTEGER, "
            + SCORE_TEAM_A_SET3 + " INTEGER, " + SCORE_TEAM_B_SET3 + " INTEGER, "
            + SCORE_TEAM_A_SET4 + " INTEGER, " + SCORE_TEAM_B_SET4 + " INTEGER, "
            + SCORE_TEAM_A_SET5 + " INTEGER, " + SCORE_TEAM_B_SET5 + " INTEGER, "
            + TOTAL_SCORE_TEAM_A + " INTEGER, " + TOTAL_SCORE_TEAM_B + " INTEGER, "
            + KEY_CREATED_AT + " DATETIME" + ")";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE_BASKET);

        db.execSQL(CREATE_TABLE_VOLLEY);


        db.execSQL(CREATE_TABLE_FOOTBALL);

    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Ketika mengupgrade database baru
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BASKET);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_VOLLEY);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_FOOTBALL);


        // Create table baru
        onCreate(db);
    }

    // ------------------------ "basket" table methods ----------------//

    public List<Basket> getAllBaskets() {
        List<Basket> baskets = new ArrayList<Basket>();

        String selectQuery = "SELECT * FROM " + TABLE_BASKET + " ORDER BY " + KEY_CREATED_AT + " DESC";

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


    // Insert Basket
    public long createBasket(Basket basket) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEAM_A, basket.getTeamA());
        values.put(TEAM_B, basket.getTeamB());
        values.put(SCORE_TEAM_A, basket.getScoreA());
        values.put(SCORE_TEAM_B, basket.getScoreB());
        values.put(KEY_CREATED_AT, getDateTime());

        long basket_id = db.insert(TABLE_BASKET, null, values);

        Log.e("ID Baru coyyyy....", String.valueOf(basket_id));

        return basket_id;
    }

    // Get Single Basket
    public Basket getBasket(long basket_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_BASKET + " WHERE " + KEY_ID + " = "
                             + basket_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null) {
            c.moveToFirst();
        }

        Basket bs = new Basket();

        bs.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        bs.setTeamA(c.getString(c.getColumnIndex(TEAM_A)));
        bs.setTeamB(c.getString(c.getColumnIndex(TEAM_B)));
        bs.setScoreA(c.getInt(c.getColumnIndex(SCORE_TEAM_A)));
        bs.setScoreB(c.getInt(c.getColumnIndex(SCORE_TEAM_B)));
        bs.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

        return bs;
    }

    // Update Basket
    public int updateBasket(Basket bs) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, bs.getId());
        values.put(TEAM_A, bs.getTeamA());
        values.put(TEAM_B, bs.getTeamB());
        values.put(SCORE_TEAM_A, bs.getScoreA());
        values.put(SCORE_TEAM_B, bs.getScoreB());

        return db.update(TABLE_BASKET, values, KEY_ID + " = ? ",
                new String[] { String.valueOf(bs.getId())});
    }

    // Delete Basket
    public void deleteBasket(long basket_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BASKET, KEY_ID + " = ? ",
                new String[] { String.valueOf(basket_id)});
    }

    // =================================================================================

    public List<Football> getAllFootballs() {
        List<Football> footballs = new ArrayList<Football>();

        String selectQuery = "SELECT * FROM " + TABLE_FOOTBALL;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);


        // Looping ke semua baris dan ditambahkan ke list
        if (c.moveToFirst()) {
            do {
                Football football = new Football();
                football.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                football.setTeamA(c.getString(c.getColumnIndex(TEAM_A)));
                football.setTeamB(c.getString(c.getColumnIndex(TEAM_B)));
                football.setScoreA(c.getInt(c.getColumnIndex(SCORE_TEAM_A)));
                football.setScoreB(c.getInt(c.getColumnIndex(SCORE_TEAM_B)));
                football.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

                // tambah bfootball ke list
                footballs.add(football);
            } while (c.moveToNext());
        }

        return footballs;
    }

    // Get Single Football
    public Football getFootball(long football_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_FOOTBALL + " WHERE " + KEY_ID + " = "
                + football_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null) {
            c.moveToFirst();
        }

        Football football = new Football();

        football.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        football.setTeamA(c.getString(c.getColumnIndex(TEAM_A)));
        football.setTeamB(c.getString(c.getColumnIndex(TEAM_B)));
        football.setScoreA(c.getInt(c.getColumnIndex(SCORE_TEAM_A)));
        football.setScoreB(c.getInt(c.getColumnIndex(SCORE_TEAM_B)));
        football.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

        return football;
    }

    // Create Football
    public long createFootball(Football football) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEAM_A, football.getTeamA());
        values.put(TEAM_B, football.getTeamB());
        values.put(SCORE_TEAM_A, football.getScoreA());
        values.put(SCORE_TEAM_B, football.getScoreB());
        values.put(KEY_CREATED_AT, getDateTime());

        long football_id = db.insert(TABLE_FOOTBALL, null, values);

        Log.e("ID Baru coyyyy....", String.valueOf(football_id));

        return football_id;
    }

    // Update Football
    public int updateFootball(Football football) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, football.getId());
        values.put(TEAM_A, football.getTeamA());
        values.put(TEAM_B, football.getTeamB());
        values.put(SCORE_TEAM_A, football.getScoreA());
        values.put(SCORE_TEAM_B, football.getScoreB());

        return db.update(TABLE_FOOTBALL, values, KEY_ID + " = ? ",
                new String[] { String.valueOf(football.getId())});
    }

    // Delete Football
    public void deleteFootball(long football_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_FOOTBALL, KEY_ID + " = ? ",
                new String[] { String.valueOf(football_id)});
    }

    // =================================================================================


    // ------------------------ "volley" table methods ----------------//

    public List<Volley> getAllVolleys() {
        List<Volley> volleys = new ArrayList<Volley>();

        String selectQuery = "SELECT * FROM " + TABLE_VOLLEY;

        Log.e(LOG, selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);


        // Looping ke semua baris dan ditambahkan ke list
        if (c.moveToFirst()) {
            do {
                Volley volley = new Volley();
                volley.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                volley.setTeamAVol(c.getString(c.getColumnIndex(TEAM_A_VOL)));
                volley.setTeamBVol(c.getString(c.getColumnIndex(TEAM_B_VOL)));
                volley.setScoreASet1(c.getInt(c.getColumnIndex(SCORE_TEAM_A_SET1)));
                volley.setScoreBSet1(c.getInt(c.getColumnIndex(SCORE_TEAM_B_SET1)));
                volley.setScoreASet2(c.getInt(c.getColumnIndex(SCORE_TEAM_A_SET2)));
                volley.setScoreBSet2(c.getInt(c.getColumnIndex(SCORE_TEAM_B_SET2)));
                volley.setScoreASet3(c.getInt(c.getColumnIndex(SCORE_TEAM_A_SET3)));
                volley.setScoreBSet3(c.getInt(c.getColumnIndex(SCORE_TEAM_B_SET3)));
                volley.setScoreASet4(c.getInt(c.getColumnIndex(SCORE_TEAM_A_SET4)));
                volley.setScoreBSet4(c.getInt(c.getColumnIndex(SCORE_TEAM_B_SET4)));
                volley.setScoreASet5(c.getInt(c.getColumnIndex(SCORE_TEAM_A_SET5)));
                volley.setScoreBSet5(c.getInt(c.getColumnIndex(SCORE_TEAM_B_SET5)));
                volley.setTotalScoreA(c.getInt(c.getColumnIndex(TOTAL_SCORE_TEAM_A)));
                volley.setTotalScoreB(c.getInt(c.getColumnIndex(TOTAL_SCORE_TEAM_B)));
                volley.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

                // tambah basket ke list
                volleys.add(volley);
            } while (c.moveToNext());
        }

        return volleys;
    }

    // Insert Volley
    public long createVolley(Volley volley) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(TEAM_A_VOL, volley.getTeamAVol());
        values.put(TEAM_B_VOL, volley.getTeamBVol());
        values.put(SCORE_TEAM_A_SET1, volley.getScoreASet1());
        values.put(SCORE_TEAM_B_SET1, volley.getScoreBSet1());
        values.put(SCORE_TEAM_A_SET2, volley.getScoreASet2());
        values.put(SCORE_TEAM_B_SET2, volley.getScoreBSet2());
        values.put(SCORE_TEAM_A_SET3, volley.getScoreASet3());
        values.put(SCORE_TEAM_B_SET3, volley.getScoreBSet3());
        values.put(SCORE_TEAM_A_SET4, volley.getScoreASet4());
        values.put(SCORE_TEAM_B_SET4, volley.getScoreBSet4());
        values.put(SCORE_TEAM_A_SET5, volley.getScoreASet5());
        values.put(SCORE_TEAM_B_SET5, volley.getScoreBSet5());
        values.put(TOTAL_SCORE_TEAM_A, volley.getTotalScoreA());
        values.put(TOTAL_SCORE_TEAM_B, volley.getTotalScoreB());
        values.put(KEY_CREATED_AT, getDateTime());

        long volley_id = db.insert(TABLE_VOLLEY, null, values);

        return volley_id;
    }

    // Get Single Volley
    public Volley getVolley(long volley_id) {
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT * FROM " + TABLE_VOLLEY + " WHERE " + KEY_ID + " = "
                + volley_id;

        Log.e(LOG, selectQuery);

        Cursor c = db.rawQuery(selectQuery, null);

        if (c != null) {
            c.moveToFirst();
        }

        Volley vl = new Volley();

        vl.setId(c.getInt(c.getColumnIndex(KEY_ID)));
        vl.setTeamAVol(c.getString(c.getColumnIndex(TEAM_A_VOL)));
        vl.setTeamBVol(c.getString(c.getColumnIndex(TEAM_B_VOL)));
        vl.setScoreASet1(c.getInt(c.getColumnIndex(SCORE_TEAM_A_SET1)));
        vl.setScoreBSet1(c.getInt(c.getColumnIndex(SCORE_TEAM_B_SET1)));
        vl.setScoreASet2(c.getInt(c.getColumnIndex(SCORE_TEAM_A_SET2)));
        vl.setScoreBSet2(c.getInt(c.getColumnIndex(SCORE_TEAM_B_SET2)));
        vl.setScoreASet3(c.getInt(c.getColumnIndex(SCORE_TEAM_A_SET3)));
        vl.setScoreBSet3(c.getInt(c.getColumnIndex(SCORE_TEAM_B_SET3)));
        vl.setScoreASet4(c.getInt(c.getColumnIndex(SCORE_TEAM_A_SET4)));
        vl.setScoreBSet4(c.getInt(c.getColumnIndex(SCORE_TEAM_B_SET4)));
        vl.setScoreASet5(c.getInt(c.getColumnIndex(SCORE_TEAM_A_SET5)));
        vl.setScoreBSet5(c.getInt(c.getColumnIndex(SCORE_TEAM_B_SET5)));
        vl.setTotalScoreA(c.getInt(c.getColumnIndex(TOTAL_SCORE_TEAM_A)));
        vl.setTotalScoreB(c.getInt(c.getColumnIndex(TOTAL_SCORE_TEAM_B)));
        vl.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATED_AT)));

        return vl;
    }

    // Update Volley
    public int updateVolley(Volley vl) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_ID, vl.getId());
        values.put(TEAM_A_VOL, vl.getTeamAVol());
        values.put(TEAM_B_VOL, vl.getTeamBVol());
        values.put(SCORE_TEAM_A_SET1, vl.getScoreASet1());
        values.put(SCORE_TEAM_B_SET1, vl.getScoreBSet1());
        values.put(SCORE_TEAM_A_SET2, vl.getScoreASet2());
        values.put(SCORE_TEAM_B_SET2, vl.getScoreBSet2());
        values.put(SCORE_TEAM_A_SET3, vl.getScoreASet3());
        values.put(SCORE_TEAM_B_SET3, vl.getScoreBSet3());
        values.put(SCORE_TEAM_A_SET4, vl.getScoreASet4());
        values.put(SCORE_TEAM_B_SET4, vl.getScoreBSet4());
        values.put(SCORE_TEAM_A_SET5, vl.getScoreASet5());
        values.put(SCORE_TEAM_B_SET5, vl.getScoreBSet5());
        values.put(TOTAL_SCORE_TEAM_A, vl.getTotalScoreA());
        values.put(TOTAL_SCORE_TEAM_B, vl.getTotalScoreB());
        values.put(KEY_CREATED_AT, getDateTime());
        return db.update(TABLE_VOLLEY, values, KEY_ID + " = ? ",
                new String[] { String.valueOf(vl.getId())});
    }

    // Delete Basket
    public void deleteVolley(long volley_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_VOLLEY, KEY_ID + " = ? ",
                new String[] { String.valueOf(volley_id)});
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
