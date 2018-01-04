package id.achmiral.scoringboard.model;

/**
 * Created by MICHAEL BAGUS on 1/3/2018.
 */

public class Volley {
    int id;
    String teamAVol, teamBVol, winnerVol;
    int scoreASet1, scoreASet2, scoreASet3, scoreASet4, scoreASet5, totalscoreA, scoreBSet1, scoreBSet2, scoreBSet3, scoreBSet4, scoreBSet5, totalscoreB;
    String created_at;

    public Volley() {

    }

    public Volley(String teamAVol, String teamBVol, int scoreASet1, int scoreBSet1, int scoreASet2, int scoreBSet2, int scoreASet3, int scoreBSet3, int scoreASet4, int scoreBSet4, int scoreASet5, int scoreBSet5, int totalscoreA, int totalscoreB) {
        this.teamAVol = teamAVol;
        this.teamBVol = teamBVol;
        this.scoreASet1 = scoreASet1;
        this.scoreBSet1 = scoreBSet1;
        this.scoreASet2 = scoreASet2;
        this.scoreBSet2 = scoreBSet2;
        this.scoreASet3 = scoreASet3;
        this.scoreBSet3 = scoreBSet3;
        this.scoreASet4 = scoreASet4;
        this.scoreBSet4 = scoreBSet4;
        this.scoreASet5 = scoreASet5;
        this.scoreBSet5 = scoreBSet5;
        this.totalscoreA = totalscoreA;
        this.totalscoreB = totalscoreB;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamAVol() {
        return teamAVol;
    }

    public void setTeamAVol(String teamAVol) {
        this.teamAVol = teamAVol;
    }

    public String getTeamBVol() {
        return teamBVol;
    }

    public void setTeamBVol(String teamBVol) {
        this.teamBVol = teamBVol;
    }

    public int getScoreASet1() {
        return scoreASet1;
    }

    public void setScoreASet1(int scoreASet1) {
        this.scoreASet1 = scoreASet1;
    }

    public int getScoreBSet1() {
        return scoreBSet1;
    }

    public void setScoreBSet1(int scoreBSet1) {
        this.scoreBSet1 = scoreBSet1;
    }

    public int getScoreASet2() {
        return scoreASet2;
    }

    public void setScoreASet2(int scoreASet2) {
        this.scoreASet2 = scoreASet2;
    }

    public int getScoreBSet2() {
        return scoreBSet2;
    }

    public void setScoreBSet2(int scoreBSet2) {
        this.scoreBSet2 = scoreBSet2;
    }

    public int getScoreASet3() {
        return scoreASet3;
    }

    public void setScoreASet3(int scoreASet3) {
        this.scoreASet3 = scoreASet3;
    }

    public int getScoreBSet3() {
        return scoreBSet3;
    }

    public void setScoreBSet3(int scoreBSet3) {
        this.scoreBSet3 = scoreBSet3;
    }

    public int getScoreASet4() {
        return scoreASet4;
    }

    public void setScoreASet4(int scoreASet4) {
        this.scoreASet4 = scoreASet4;
    }

    public int getScoreBSet4() {
        return scoreBSet4;
    }

    public void setScoreBSet4(int scoreBSet4) {
        this.scoreBSet4 = scoreBSet4;
    }

    public int getScoreASet5() {
        return scoreASet5;
    }

    public void setScoreASet5(int scoreASet5) {
        this.scoreASet5 = scoreASet5;
    }

    public int getScoreBSet5() {
        return scoreBSet5;
    }

    public void setScoreBSet5(int scoreBSet5) {
        this.scoreBSet5 = scoreBSet5;
    }

    public int getTotalScoreA() {
        return totalscoreA;
    }

    public void setTotalScoreA(int totalscoreA) {
        this.totalscoreA = totalscoreA;
    }

    public int getTotalScoreB() {
        return totalscoreB;
    }

    public void setTotalScoreB(int totalscoreB) {
        this.totalscoreB = totalscoreB;
    }

    public void setCreatedAt(String created_at) {
        this.created_at = created_at;
    }

}
