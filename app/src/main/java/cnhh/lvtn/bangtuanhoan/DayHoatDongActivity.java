package cnhh.lvtn.bangtuanhoan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class DayHoatDongActivity extends AppCompatActivity {

    private List<DayHoatDong> dayHoatDongList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_hoat_dong);

        init();

        addDayHoatDong();
    }

    private void addDayHoatDong() {
        DayHoatDong dayHoatDong;
        dayHoatDong = new DayHoatDong("Li", "+", "Li");
        dayHoatDongList.add(dayHoatDong);
    }

    private void init() {
        dayHoatDongList = new ArrayList<>();
    }
}
