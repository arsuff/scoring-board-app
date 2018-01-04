package id.achmiral.scoringboard.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import id.achmiral.scoringboard.R;
import id.achmiral.scoringboard.holder.BasketHistoryRowHolder;
import id.achmiral.scoringboard.model.Basket;

/**
 * Created by ner46 on 04/01/18.
 */

public class BasketAdapter extends ArrayAdapter<Basket> {

    public BasketAdapter(@NonNull Context context, int resource) {
        super(context, resource);
        this.ctx = context;
        this.resource = resource;
    }

    BasketHistoryRowHolder holder;
    Context ctx;
    int resource;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(ctx).inflate(resource, null);

            holder = new BasketHistoryRowHolder();
            holder.teamA = convertView.findViewById(R.id.team_a_history);
            holder.scoreA = convertView.findViewById(R.id.team_a_score_history);
            holder.teamB = convertView.findViewById(R.id.team_b_history);
            holder.scoreB = convertView.findViewById(R.id.team_b_score_history);

            convertView.setTag(holder);
        }

        holder = (BasketHistoryRowHolder) convertView.getTag();
        Basket basket = getItem(position);

        holder.teamA.setText("" + basket.getTeamA());
        holder.teamB.setText("" + basket.getTeamB());
        holder.scoreA.setText("" + basket.getScoreA());
        holder.scoreB.setText("" + basket.getScoreB());
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
