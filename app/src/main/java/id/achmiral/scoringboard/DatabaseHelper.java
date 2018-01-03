package id.achmiral.scoringboard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ner46 on 25/12/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper{

    static final private String DB_NAME = "Sports";
    static final private String DB_TABLE = "basket";
    static final private int DB_VER = 1;

    Context ctx;
    SQLiteDatabase myDb;

    public DatabaseHelper(Context ct) {
        super(ct, DB_NAME, null, DB_VER);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + DB_TABLE + "(_id integer primary key autoincrement, )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
