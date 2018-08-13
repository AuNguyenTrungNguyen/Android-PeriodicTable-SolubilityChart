package cnhh.lvtn.bangtuanhoan.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import cnhh.lvtn.bangtuanhoan.Adapter.DayHoatDongAdapter;
import cnhh.lvtn.bangtuanhoan.Model.DayHoatDong;
import cnhh.lvtn.bangtuanhoan.R;

public class DayHoatDongActivity extends AppCompatActivity {

    private RecyclerView mRvDayHoatDong;
    private List<DayHoatDong> mDayHoatDongList;
    private DayHoatDongAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_hoat_dong);

        init();

        addDayHoatDong();

        mRvDayHoatDong.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private void addDayHoatDong() {
        DayHoatDong dayHoatDong;

        dayHoatDong = new DayHoatDong("Li", "+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("K", "+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Ba", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Ca", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Na", "+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Mg", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Al", "3+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Mn", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Zn", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Cr", "3+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Fe", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Sn", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Pb", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("H", "+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Cu", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Fe", "3+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Ag", "+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Hg", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Pt", "2+");
        mDayHoatDongList.add(dayHoatDong);

        dayHoatDong = new DayHoatDong("Au", "3+");
        mDayHoatDongList.add(dayHoatDong);
    }

    private void init() {
        mRvDayHoatDong = findViewById(R.id.rv_day_hoat_dong);
        mDayHoatDongList = new ArrayList<>();
        mAdapter = new DayHoatDongAdapter(this,  mDayHoatDongList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRvDayHoatDong.setLayoutManager(mLayoutManager);
        mRvDayHoatDong.setHasFixedSize(true);
    }
}
