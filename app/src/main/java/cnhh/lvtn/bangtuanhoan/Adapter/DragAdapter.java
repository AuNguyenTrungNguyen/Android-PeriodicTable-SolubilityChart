package cnhh.lvtn.bangtuanhoan.Adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import cnhh.lvtn.bangtuanhoan.ControlRecyc.Action;
import cnhh.lvtn.bangtuanhoan.ControlRecyc.ActionView;
import cnhh.lvtn.bangtuanhoan.R;

public class DragAdapter extends RecyclerView.Adapter<DragAdapter.ViewHolder> implements Action{

    private Context context;
    private ArrayList<String> listData;
    int lastPosition = -1;

    public DragAdapter(Context context, ArrayList<String> listData) {
        this.context = context;
        this.listData = listData;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_drag, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.textView.setText(listData.get(i));
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        viewHolder.layout.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @Override
    public void onMove(int oldPosition, int newPosition) {

        if (oldPosition < newPosition) {
            for (int i = oldPosition; i < newPosition; i++) {
                Collections.swap(listData, i, i + 1);
            }
        } else {
            for (int i = oldPosition; i > newPosition; i--) {
                Collections.swap(listData, i, i - 1);
            }
        }
        notifyItemMoved(oldPosition, newPosition);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements ActionView {
        TextView textView;
        LinearLayout layout;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_drag);
            layout = itemView.findViewById(R.id.ln_drag);
        }

        @Override
        public void change() {
            itemView.setBackgroundColor(Color.LTGRAY);
        }

        @Override
        public void clear() {
            itemView.setBackgroundColor(0);
        }
    }
}
