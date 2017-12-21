package id.achmiral.scoringboard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MICHAEL BAGUS on 12/21/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "scoring.db";
    private static final int DATABASE_VERSION = 1;

    public static final String TABLE_SKOR = "score";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE "+ TABLE_SKOR + "(id INTEGER PRIMARY KEY AUTOINCREMENT, olahraga text, teamA text, teamB text, scoreTeamASet1 integer, scoreTeamBSet1 integer, " +
                "scoreTeamASet2 integer, scoreTeamBSet2 integer, scoreTeamASet3 integer, scoreTeamBSet3 integer, " +
                "scoreTeamASet4 integer, scoreTeamBSet4 integer, scoreTeamASet5 integer, scoreTeamBSet5 integer, totalScoreTeamA, " +
                "totalScoreTeamB, pemenang text )");
    }

    public void resetScore(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from score");
    }

    public void insertDataScore(String olahraga, String teamA, String teamB, int scoreTeamASet1, int scoreTeamBSet1, int totalScoreTeamA, int totalScoreTeamB) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("insert into score (olahraga, teamA, teamB, scoreTeamASet1, scoreTeamBSet1, totalScoreTeamA, totalScoreTeamB, ) " +
                "values ('"+olahraga+"','"+teamA+"','"+teamB+"','"+scoreTeamASet1+"','"+scoreTeamBSet1+"','"+totalScoreTeamA+"','"+totalScoreTeamB+"') ");
    }


    public void updateDataScore(int id, int scoreTeamASet2, int scoreTeamBSet2, int scoreTeamASet3, int scoreTeamBSet3, int scoreTeamASet4, int scoreTeamBSet4, int scoreTeamASet5, int scoreTeamBSet5, int totalScoreTeamA, int totalScoreTeamB){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("update score set scoreTeamASet2 ='"+scoreTeamASet2+"',scoreTeamBSet2 ='"+scoreTeamBSet2+"',scoreTeamASet3 ='"+scoreTeamASet3+"',scoreTeamBSet3 ='"+scoreTeamBSet3+"',scoreTeamASet4 ='"+scoreTeamASet4+"',scoreTeamBSet4 ='"+scoreTeamASet4+"',scoreTeamBSet4 ='"+scoreTeamBSet4+"',scoreTeamASet5 ='"+scoreTeamASet5+"',scoreTeamBSet5 ='"+scoreTeamBSet5+"' where id ='"+id+"'");
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS score");
        onCreate(db);
    }
}
