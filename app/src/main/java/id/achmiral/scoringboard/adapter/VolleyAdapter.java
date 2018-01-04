package id.achmiral.scoringboard.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import id.achmiral.scoringboard.R;
import id.achmiral.scoringboard.holder.VolleyHistoryRowHolder;
import id.achmiral.scoringboard.model.Volley;

/**
 * Created by MICHAEL BAGUS on 1/5/2018.
 */

public class VolleyAdapter extends ArrayAdapter<Volley> {
    public VolleyAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.ctx = context;
        this.resource = resource;
    }
    VolleyHistoryRowHolder holder;
    Context ctx;
    int resource;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(resource, null);

            holder = new VolleyHistoryRowHolder();
            holder.teamA = convertView.findViewById(R.id.team_a_vol_history);
            holder.teamB = convertView.findViewById(R.id.team_b_vol_history);
            holder.totalScoreA = convertView.findViewById(R.id.team_a_score_history);
            holder.totalScoreB = convertView.findViewById(R.id.team_b_score_history);

            convertView.setTag(holder);
        }

        holder = (VolleyHistoryRowHolder) convertView.getTag();
        Volley volley = getItem(position);

        holder.teamA.setText("" + volley.getTeamAVol());
        holder.teamB.setText("" + volley.getTeamBVol());
        holder.scoreASet1.setText("" + volley.getScoreASet1());
        holder.scoreBSet1.setText("" + volley.getScoreBSet1());
        holder.scoreASet2.setText("" + volley.getScoreASet2());
        holder.scoreBSet2.setText("" + volley.getScoreBSet2());
        holder.scoreASet3.setText("" + volley.getScoreASet3());
        holder.scoreBSet3.setText("" + volley.getScoreBSet3());
        holder.scoreASet4.setText("" + volley.getScoreASet4());
        holder.scoreBSet4.setText("" + volley.getScoreBSet4());
        holder.scoreASet5.setText("" + volley.getScoreASet5());
        holder.scoreBSet5.setText("" + volley.getScoreBSet5());
        holder.totalScoreA.setText("" + volley.getTotalScoreA());
        holder.totalScoreB.setText("" + volley.getTotalScoreB());
        return convertView;
    }

    @Override
    public int getViewTypeCount() {
        return super.getViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }
}
