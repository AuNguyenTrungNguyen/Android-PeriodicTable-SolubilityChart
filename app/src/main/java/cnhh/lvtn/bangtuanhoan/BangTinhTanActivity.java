package cnhh.lvtn.bangtuanhoan;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BangTinhTanActivity extends AppCompatActivity {

    private List<Anion> mAnionList;
    private List<Cation> mCationList;
    private List<BangTinhTan> mBangTinhTanList;

    private TableLayout mTbBangTinhTan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bang_tinh_tan);

        init();

        addAnion();

        addCation();

        addTinhTan();

        createTableDynamic();

    }

    private void init() {
        mAnionList = new ArrayList<>();
        mCationList = new ArrayList<>();
        mBangTinhTanList = new ArrayList<>();

        mTbBangTinhTan = findViewById(R.id.tl_bang_tinh_tan);
    }

    private void addAnion() {
        Anion anion = new Anion(1, "Cl", "-");
        mAnionList.add(anion);

        anion = new Anion(2, "Br", "-");
        mAnionList.add(anion);

        anion = new Anion(3, "I", "-");
        mAnionList.add(anion);

        anion = new Anion(4, "NO3", "-");
        mAnionList.add(anion);

        anion = new Anion(5, "CH3COO", "-");
        mAnionList.add(anion);

        anion = new Anion(6, "S", "2-");
        mAnionList.add(anion);

        anion = new Anion(7, "SO3", "2-");
        mAnionList.add(anion);

        anion = new Anion(8, "SO4", "2-");
        mAnionList.add(anion);

        anion = new Anion(9, "CO3", "2-");
        mAnionList.add(anion);

        anion = new Anion(10, "SiO3", "2-");
        mAnionList.add(anion);

        anion = new Anion(11, "CrO4", "2-");
        mAnionList.add(anion);

        anion = new Anion(12, "PO4", "3-");
        mAnionList.add(anion);

        anion = new Anion(13, "OH", "-");
        mAnionList.add(anion);

    }

    private void addCation() {
        Cation cation = new Cation(1, "Li", "+");
        mCationList.add(cation);

        cation = new Cation(2, "Na", "+");
        mCationList.add(cation);

        cation = new Cation(3, "K", "+");
        mCationList.add(cation);

        cation = new Cation(4, "NH4", "+");
        mCationList.add(cation);

        cation = new Cation(5, "Cu", "+");
        mCationList.add(cation);

        cation = new Cation(6, "Ag", "+");
        mCationList.add(cation);

        cation = new Cation(7, "Mg", "2+");
        mCationList.add(cation);

        cation = new Cation(8, "Ca", "2+");
        mCationList.add(cation);

        cation = new Cation(9, "Sr", "2+");
        mCationList.add(cation);

        cation = new Cation(10, "Ba", "2+");
        mCationList.add(cation);

        cation = new Cation(11, "Zn", "2+");
        mCationList.add(cation);

        cation = new Cation(12, "Hg", "2+");
        mCationList.add(cation);

        cation = new Cation(13, "Al", "3+");
        mCationList.add(cation);

        cation = new Cation(14, "Sn", "2+");
        mCationList.add(cation);

        cation = new Cation(15, "Pb", "2+");
        mCationList.add(cation);

        cation = new Cation(16, "Bi", "3+");
        mCationList.add(cation);

        cation = new Cation(17, "Cr", "3+");
        mCationList.add(cation);

        cation = new Cation(18, "Mn", "2+");
        mCationList.add(cation);

        cation = new Cation(19, "Fe", "3+");
        mCationList.add(cation);

        cation = new Cation(20, "Fe", "2+");
        mCationList.add(cation);
    }

    private void addTinhTan() {
        BangTinhTan bangTinhTan;

        bangTinhTan = new BangTinhTan(1, 1, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 2, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 3, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 4, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 5, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 6, "K");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 7, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 8, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 9, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 10, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 11, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 12, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 13, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 14, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 15, "I");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 16, "-");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 17, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 18, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 19, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(1, 20, "T");
        mBangTinhTanList.add(bangTinhTan);

        //-----

        bangTinhTan = new BangTinhTan(2, 1, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 2, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 3, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 4, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 5, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 6, "K");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 7, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 8, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 9, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 10, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 11, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 12, "I");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 13, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 14, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 15, "I");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 16, "-");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 17, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 18, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 19, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(2, 20, "T");
        mBangTinhTanList.add(bangTinhTan);

        //--

        bangTinhTan = new BangTinhTan(3, 1, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 2, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 3, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 4, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 5, "-");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 6, "K");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 7, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 8, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 9, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 10, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 11, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 12, "K");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 13, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 14, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 15, "K");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 16, "-");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 17, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 18, "K");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 19, "-");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(3, 20, "T");
        mBangTinhTanList.add(bangTinhTan);

        //--

        bangTinhTan = new BangTinhTan(4, 1, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 2, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 3, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 4, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 5, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 6, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 7, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 8, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 9, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 10, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 11, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 12, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 13, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 14, "-");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 15, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 16, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 17, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 18, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 19, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(4, 20, "T");
        mBangTinhTanList.add(bangTinhTan);

        //--

        bangTinhTan = new BangTinhTan(5, 1, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 2, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 3, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 4, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 5, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 6, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 7, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 8, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 9, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 10, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 11, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 12, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 13, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 14, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 15, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 16, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 17, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 18, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 19, "T");
        mBangTinhTanList.add(bangTinhTan);

        bangTinhTan = new BangTinhTan(5, 20, "T");
        mBangTinhTanList.add(bangTinhTan);
    }

    private String showIon(String ten, String hoaTri) {

        String result = "";

        for (int i = 0; i < ten.length(); i++) {
            char c = ten.charAt(i);

            if (c >= '0' && c <= '9') {
                result += "<small><sub>" + c + "</sub></small>";
            } else {
                result += c;
            }
        }

        String temp = result + "<small><sup>" + hoaTri + "</sup></small>";
        result = "<b>" + temp + "</b>";

        return result;
    }

    private void createTableDynamic() {
        int lengthAnion = mAnionList.size();
        int lengthCation = mCationList.size();

        //Create header Cation
        TableRow rowHeader = new TableRow(this);
        TextView tvNull = new TextView(getApplicationContext());
        rowHeader.addView(tvNull, 100, 100);

        for (Cation cation : mCationList) {
            TextView tvHeader = new TextView(this);
            tvHeader.setText(Html.fromHtml(showIon(cation.getTenCation(), cation.getHoaTri())));
            tvHeader.setGravity(Gravity.CENTER);
            tvHeader.setTextColor(Color.WHITE);
            rowHeader.addView(tvHeader, 100, 100);
        }
        mTbBangTinhTan.addView(rowHeader);

        for (int i = 1; i <= lengthAnion; i++) {
            TableRow row = new TableRow(this);
//            row.setBackgroundColor(Color.BLUE);
//            TableLayout.LayoutParams layoutParams = new TableLayout.LayoutParams(TableLayout.LayoutParams.WRAP_CONTENT, TableLayout.LayoutParams.WRAP_CONTENT);
//            layoutParams.setMargins(2,2,2,2);
//            row.setLayoutParams(layoutParams);

            //Show name anion
            Anion anion = mAnionList.get(i - 1);
            TextView tvHeader = new TextView(this);
            tvHeader.setText(Html.fromHtml(showIon(anion.getTenAnion(), anion.getHoaTriAnion())));
            tvHeader.setGravity(Gravity.CENTER);
            tvHeader.setTextColor(Color.WHITE);
            row.addView(tvHeader, 150, 100);

            for (int j = 1; j <= lengthCation; j++) {

                TextView tvTinhTan = new TextView(this);
                final String tinhTan = getTinhTan(i, j);

                Log.i("ANTN", "tinhTan: " + tinhTan);

                if (!tinhTan.equals("")) {
                    tvTinhTan.setText(tinhTan);
                    tvTinhTan.setGravity(Gravity.CENTER);
                    tvTinhTan.setBackgroundColor(Color.WHITE);
                }
                row.addView(tvTinhTan, 99, 99);
            }

            mTbBangTinhTan.addView(row);
        }
    }

    private String getTinhTan(int anion, int cation) {
        String result = "";

        for (int i = 0; i < mBangTinhTanList.size(); i++) {
            BangTinhTan bangTinhTan = mBangTinhTanList.get(i);
            if (bangTinhTan.getAnion() == anion && bangTinhTan.getCation() == cation) {
                return bangTinhTan.getTinhTan();
            }
        }
        return result;
    }
}
