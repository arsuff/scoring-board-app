package id.achmiral.scoringboard.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import id.achmiral.scoringboard.R;
import id.achmiral.scoringboard.holder.FootballHistoryRowHolder;
import id.achmiral.scoringboard.model.Football;

/**
 * Created by Arsuff on 05/01/2018.
 */

public class FootballAdapter extends ArrayAdapter<Football> {

    public FootballAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.ctx = context;
        this.resource = resource;
    }

    FootballHistoryRowHolder holder;
    Context ctx;
    int resource;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(resource, null);

            holder = new FootballHistoryRowHolder();
            holder.teamA = convertView.findViewById(R.id.team_a_history);
            holder.scoreA = convertView.findViewById(R.id.team_a_score_history);
            holder.teamB = convertView.findViewById(R.id.team_b_history);
            holder.scoreB = convertView.findViewById(R.id.team_b_score_history);

            convertView.setTag(holder);
        }

        holder = (FootballHistoryRowHolder) convertView.getTag();
        Football football = getItem(position);

        holder.teamA.setText("" + football.getTeamA());
        holder.teamB.setText("" + football.getTeamB());
        holder.scoreA.setText("" + football.getScoreA());
        holder.scoreB.setText("" + football.getScoreB());
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
