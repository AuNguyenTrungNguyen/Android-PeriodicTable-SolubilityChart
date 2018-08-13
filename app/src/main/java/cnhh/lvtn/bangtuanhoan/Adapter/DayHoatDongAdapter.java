package cnhh.lvtn.bangtuanhoan.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import cnhh.lvtn.bangtuanhoan.Model.DayHoatDong;
import cnhh.lvtn.bangtuanhoan.R;

public class DayHoatDongAdapter extends RecyclerView.Adapter<DayHoatDongAdapter.ViewHolder> {

    private Context mContext;
    private List<DayHoatDong> mListData;

    public DayHoatDongAdapter(Context context, List<DayHoatDong> list){
        mContext = context;
        mListData = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_day_hoat_dong, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DayHoatDong dayHoatDong = mListData.get(position);

        String ion = dayHoatDong.getIon();
        String hoaTri = dayHoatDong.getHoaTri();

        String strHoaTri = "<small><sup>" + hoaTri + "</sup></small>";

        holder.tvIon.setText(Html.fromHtml(ion+strHoaTri));
        holder.tvChat.setText(ion);

        if (ion.equals("H")){
            holder.tvChat.setText(Html.fromHtml(ion+"<small><sub>2</sub></small>"));
            holder.tvIon.setText(Html.fromHtml("2"+ion+strHoaTri));
        }

        if(ion.equals("Fe") && hoaTri.equals("3+")){
            holder.tvChat.setText(Html.fromHtml(ion+"<small><sup>2+</sup></small>"));
        }
    }

    @Override
    public int getItemCount() {
        return mListData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvIon;
        TextView tvChat;
        public ViewHolder(View view) {
            super(view);
            tvIon = view.findViewById(R.id.tv_ion);
            tvChat = view.findViewById(R.id.tv_chat);
        }
    }
}
