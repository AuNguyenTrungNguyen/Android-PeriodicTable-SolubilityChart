package cnhh.lvtn.bangtuanhoan.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cnhh.lvtn.bangtuanhoan.Model.ChatHoaHoc;
import cnhh.lvtn.bangtuanhoan.Model.Group;
import cnhh.lvtn.bangtuanhoan.R;

public class MainActivity extends AppCompatActivity {

    List<ChatHoaHoc> chatHoaHocList;
    List<Group> groupList;

    TableLayout tableLayout;
    TextView tvId;
    TextView tvKyHieu;
    TextView tvTen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        addData();

        addGroup();

        dynamicTable();

        createSpaceLine();

        dynamicRelative();

        createSpaceLine();

    }

    private void init() {
        chatHoaHocList = new ArrayList<>();
        groupList = new ArrayList<>();
        tableLayout = findViewById(R.id.layout);
    }

    private void dynamicTable() {
        TableRow header = new TableRow(this);

        LayoutInflater l = getLayoutInflater();
        View view;
        TextView tvId;
        TextView tvKyHieu;
        TextView tvTen;

        for (int i = 0; i < 19; i++) {
            view = l.inflate(R.layout.item_chat_hoa_hoc, null);
            tvId = (TextView) view.findViewById(R.id.tv_id);
            tvKyHieu = (TextView) view.findViewById(R.id.tv_ky_hieu);
            tvTen = (TextView) view.findViewById(R.id.tv_ten);
            if (i == 1 || i == 18) {
                tvKyHieu.setText(groupList.get(i - 1).getNameGroup());
                tvKyHieu.setTextSize(20);
                tvKyHieu.setGravity(Gravity.BOTTOM | Gravity.CENTER);
            } else {
                tvKyHieu.setText("");
            }
            tvId.setText("");
            tvTen.setText("");
            view.findViewById(R.id.tv_show).setVisibility(View.INVISIBLE);
            //view.findViewById(R.id.ln_item).setBackgroundResource(R.drawable.background_item_chat_hoa_hoc);
            if (i == 0 || i == 18) {
                view.setBackgroundResource(R.drawable.backgroud_item_empty_first_lantan_3a8a);
            }
            if (i == 1) {
                view.setBackgroundResource(R.drawable.backgroud_item_group);
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            header.addView(view, 120, 190);
        }
        tableLayout.addView(header);

        for (int i = 1; i < 8; i++) {
            TableRow row = new TableRow(this);
            view = l.inflate(R.layout.item_chat_hoa_hoc, null);
            tvId = (TextView) view.findViewById(R.id.tv_id);
            tvKyHieu = (TextView) view.findViewById(R.id.tv_ky_hieu);
            tvTen = (TextView) view.findViewById(R.id.tv_ten);
            tvId.setText("");
            tvTen.setText("");
            tvKyHieu.setText(i + "");
            view.findViewById(R.id.tv_show).setVisibility(View.INVISIBLE);
            view.setBackgroundResource(R.drawable.backgroud_item_cycle_first_actini);
            row.addView(view, 120, 190);

            for (int j = 1; j < 19; j++) {

                View v = l.inflate(R.layout.item_chat_hoa_hoc, null);
                final int position = kiemTraTonTai(i, j);
                tvId = (TextView) v.findViewById(R.id.tv_id);
                tvKyHieu = (TextView) v.findViewById(R.id.tv_ky_hieu);
                tvTen = (TextView) v.findViewById(R.id.tv_ten);

                if (position != -1) {
                    ChatHoaHoc chatHoaHoc = chatHoaHocList.get(position);
                    tvId.setText(String.valueOf(chatHoaHoc.getIdChat()));
                    tvKyHieu.setText(chatHoaHoc.getKyHieuChat());
                    tvTen.setText(chatHoaHoc.getTenChat());
                    LinearLayout layout = v.findViewById(R.id.ln_item);
                    layout.setBackgroundResource(R.drawable.background_item_chat_hoa_hoc);
                    if (position == 4) {
                        layout.setBackgroundResource(R.drawable.backgroud_item_cycle_first_actini);
                    }

                    layout.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            showDialogInfo(position);
                        }
                    });

                } else {
                    tvId.setText("");
                    tvTen.setText("");
                    v.findViewById(R.id.tv_show).setVisibility(View.INVISIBLE);
                    if (i == 1 && (j < 3 || j > 12)
                            || i == 3 && (j > 2 && j < 13)) {
                        if (i == 1 && j == 13) {
                            v.setBackgroundResource(R.drawable.backgroud_item_empty_first_lantan_3a8a);
                        } else {
                            v.setBackgroundResource(R.drawable.backgroud_item_group);
                        }
                        tvKyHieu.setText(groupList.get(j - 1).getNameGroup());
                        tvKyHieu.setTextSize(20);
                        tvKyHieu.setGravity(Gravity.BOTTOM | Gravity.CENTER);
                    } else {
                        tvKyHieu.setText("");
                    }
                }
                row.addView(v, 120, 190);
            }
            tableLayout.addView(row);
        }
    }

    private void showDialogInfo(int position) {
        Toast.makeText(this, chatHoaHocList.get(position).getTenChat(), Toast.LENGTH_SHORT).show();
    }

    private void dynamicRelative() {

        TableRow row = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);

        LayoutInflater vi = getLayoutInflater();
        View v;

        //Create 3 space cell
        for (int i = 0; i < 3; i++) {
            v = inflateView(vi);
            tvId.setText("");
            tvTen.setText("");
            tvKyHieu.setText("");
            v.findViewById(R.id.tv_show).setVisibility(View.INVISIBLE);
            row.addView(v, 120, 190);
        }

        //Create cell "LanTan"
        v = inflateView(vi);
        tvId.setText("");
        tvTen.setText("");
        tvKyHieu.setText("Lantan");
        tvKyHieu.setTextSize(16);
        v.findViewById(R.id.tv_show).setVisibility(View.INVISIBLE);
        v.setBackgroundResource(R.drawable.backgroud_item_empty_first_lantan_3a8a);
        row.addView(v, 120, 190);

        //Data lantan
        for (int i = 58; i < 72; i++) {
            v = inflateView(vi);
            ChatHoaHoc chatHoaHoc = chatHoaHocList.get(i);
            tvId.setText(String.valueOf(chatHoaHoc.getIdChat()));
            tvKyHieu.setText(chatHoaHoc.getKyHieuChat());
            tvTen.setText(chatHoaHoc.getTenChat());
            LinearLayout layout = v.findViewById(R.id.ln_item);
            layout.setBackgroundResource(R.drawable.backgroud_item_group);

            row.addView(v, 120, 190);
        }

        tableLayout.addView(row);

        row = new TableRow(this);

        //Create 3 space cell
        for (int i = 0; i < 3; i++) {
            v = inflateView(vi);
            tvId.setText("");
            tvTen.setText("");
            tvKyHieu.setText("");
            v.findViewById(R.id.tv_show).setVisibility(View.INVISIBLE);
            row.addView(v, 120, 190);
        }

        //Create cell "Actini"
        v = inflateView(vi);
        tvId.setText("");
        tvTen.setText("");
        tvKyHieu.setText("Actini");
        tvKyHieu.setTextSize(16);
        v.findViewById(R.id.tv_show).setVisibility(View.INVISIBLE);
        v.setBackgroundResource(R.drawable.backgroud_item_cycle_first_actini);
        row.addView(v, 120, 190);

        //Data Actini
        for (int i = 90; i < 104; i++) {
            v = inflateView(vi);

            ChatHoaHoc chatHoaHoc = chatHoaHocList.get(i);
            tvId.setText(String.valueOf(chatHoaHoc.getIdChat()));
            tvKyHieu.setText(chatHoaHoc.getKyHieuChat());
            tvTen.setText(chatHoaHoc.getTenChat());
            LinearLayout layout = v.findViewById(R.id.ln_item);
            layout.setBackgroundResource(R.drawable.background_item_chat_hoa_hoc);

            row.addView(v, 120, 190);
        }

        tableLayout.addView(row);

    }

    private void createSpaceLine() {
        TableRow row = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);

        LayoutInflater vi = getLayoutInflater();
        View v = vi.inflate(R.layout.item_chat_hoa_hoc, null);

        TextView tvId = (TextView) v.findViewById(R.id.tv_id);
        TextView tvKyHieu = (TextView) v.findViewById(R.id.tv_ky_hieu);
        TextView tvTen = (TextView) v.findViewById(R.id.tv_ten);

        tvId.setText("");
        tvKyHieu.setText("");
        tvTen.setText("");
        v.findViewById(R.id.tv_show).setVisibility(View.INVISIBLE);
        row.addView(v, 100, 190);
        tableLayout.addView(row);
    }

    private int kiemTraTonTai(int chuKy, int viTri) {

        for (int i = 0; i < chatHoaHocList.size(); i++) {
            ChatHoaHoc chatHoaHoc = chatHoaHocList.get(i);
            if (chatHoaHoc.getChuKy() == chuKy && chatHoaHoc.getVitri() == viTri) {
                return i;
            }
        }

        return -1;
    }

    private void addData() {
        ChatHoaHoc chatHoaHoc = new ChatHoaHoc(1, "H", "Hydro", 1, "IA", 1);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(2, "He", "Heli", 1, "VIII", 18);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(3, "Li", "Liti", 2, "IA", 1);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(4, "Be", "Beri", 2, "IIA", 2);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(5, "B", "Bo", 2, "IIIA", 13);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(6, "C", "Cacbon", 2, "IVA", 14);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(7, "N", "Nitơ", 2, "VA", 15);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(8, "O", "Oxi", 2, "VIA", 16);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(9, "F", "Flo", 2, "VIIA", 17);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(10, "Ne", "Neon", 2, "VIIIA", 18);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(11, "Na", "Natri", 3, "IA", 1);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(12, "Mg", "Magie", 3, "IIA", 2);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(13, "Al", "Nhôm", 3, "IIIA", 13);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(14, "Si", "Silic", 3, "IVA", 14);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(15, "P", "Photpho", 3, "VA", 15);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(16, "S", "Lưu huỳnh", 3, "VIA", 16);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(17, "Cl", "Clo", 3, "VIIA", 17);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(18, "Ar", "Agon", 3, "VIIIA", 18);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(19, "K", "Kali", 4, "IA", 1);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(20, "Ca", "Caxi", 4, "IIA", 2);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(21, "Sc", "Scandi", 4, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(22, "Ti", "Titan", 4, "IVB", 4);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(23, "V", "Vanadi", 4, "VB", 5);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(24, "Cr", "Crom", 4, "VIB", 6);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(25, "Mn", "Mangan", 4, "VIIB", 7);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(26, "Fe", "Sắt", 4, "VIIIB", 8);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(27, "Co", "Coban", 4, "VIIIB", 9);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(28, "Ni", "Niken", 4, "VIIIB", 10);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(29, "Cu", "Đồng", 4, "IB", 11);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(30, "Zn", "Kẽm", 4, "IIB", 12);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(31, "Ga", "Gali", 4, "IIIA", 13);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(32, "Ge", "Gemani", 4, "IVA", 14);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(33, "As", "Asen", 4, "VA", 15);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(34, "Se", "Selen", 4, "VIA", 16);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(35, "Br", "Brom", 4, "VII", 17);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(36, "Kr", "Kripton", 4, "VIIIA", 18);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(37, "Rb", "Rubidi", 5, "IA", 1);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(38, "Sr", "Stronti", 5, "IIA", 2);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(39, "Y", "Ytri", 5, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(40, "Zr", "Ziriconi", 5, "IVB", 4);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(41, "Nb", "Niobi", 5, "VB", 5);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(42, "Mo", "Molipden", 5, "VIB", 6);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(43, "Tc", "Tecnexi", 5, "VIIB", 7);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(44, "Ru", "Ruteni", 5, "VIIIB", 8);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(45, "Rh", "Rodi", 5, "VIIIB", 9);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(46, "Pd", "Paladi", 5, "VIIIB", 10);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(47, "Ag", "Bạc", 5, "IB", 11);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(48, "Cd", "Cadimi", 5, "IIB", 12);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(49, "In", "Indi", 5, "IIIA", 13);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(50, "Sn", "Thiết", 5, "IVA", 14);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(51, "Sb", "Anitimon(Sitbi)", 5, "VA", 15);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(52, "Te", "Telu", 5, "VIA", 16);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(53, "I", "Iot", 5, "VII", 17);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(54, "Xe", "Xenon", 5, "VIIIA", 18);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(55, "Cs", "Xesi", 6, "IA", 1);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(56, "Ba", "Bari", 6, "IIA", 2);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(57, "La", "Lantan", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(58, "Ce", "Xeri", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(59, "Pr", "Prazeodim", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(60, "Nd", "Neodim", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(61, "Pm", "Prometi", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(62, "Sm", "Sanari", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(63, "Eu", "Europi", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(64, "Gd", "Gadolini", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(65, "Tb", "Tebi", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(66, "Dy", "Điprozi", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(67, "Ho", "Honmi", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(68, "Er", "Eribi", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(69, "Tm", "Tuli", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(70, "Yb", "Ytecbi", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(71, "Lu", "Lutexi", 6, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(72, "Hf", "Hafini", 6, "IVB", 4);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(73, "Ta", "Tantan", 6, "VB", 5);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(74, "W", "Wonfam", 6, "VIB", 6);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(75, "Re", "Reni", 6, "VIIB", 7);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(76, "Os", "Osimi", 6, "VIIB", 8);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(77, "Ir", "Iridi", 6, "VIIB", 9);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(78, "Pt", "Platin", 6, "VIIB", 10);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(79, "Au", "Vàng", 6, "IB", 11);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(80, "Hg", "Thủy ngân", 6, "IIB", 12);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(81, "Ti", "Tali", 6, "IIIA", 13);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(82, "Pd", "Chì", 6, "IVA", 14);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(83, "Bi", "Bitmut", 6, "VA", 15);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(84, "Po", "Poloni", 6, "VIA", 16);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(85, "At", "Atatin", 6, "VIIA", 17);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(86, "Rn", "Rondon", 6, "VIIIA", 18);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(87, "Fr", "Fraxi", 7, "IA", 1);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(88, "Ra", "Rađi", 7, "IIA", 2);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(89, "Ac", "Actini", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(90, "Th", "Thori", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(91, "Pa", "Protactini", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(92, "U", "Urana", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(93, "Np", "Neptuni", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(94, "Pu", "Plutoni", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(95, "Am", "Amerixi", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(96, "Cm", "Curi", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(97, "Bk", "Beckeli", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(98, "Cf", "Califoni", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(99, "Es", "Ensteni", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(100, "Fm", "Fecmi", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(101, "Md", "Medelevi", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(102, "No", "Nobeli", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(103, "Lr", "Lorenxi", 7, "IIIB", 3);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(104, "Rf", "Rozofođi", 7, "IV", 4);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(105, "Db", "Đupni", 7, "VB", 5);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(106, "Sg", "Siboqi", 7, "VIB", 6);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(107, "Bh", "Bori", 7, "VIIB", 7);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(108, "Hs", "Hasi", 7, "VIIIB", 8);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(109, "Mt", "Méitneri", 7, "VIIIB", 9);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(110, "Ds", "Darmastati", 7, "VIIIB", 10);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(111, "Rg", "Roentgeni", 7, "IB", 11);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(112, "Cn", "Copenixi", 7, "IIB", 12);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(113, "Nh", "Nihoni", 7, "IIIA", 13);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(114, "Fl", "Flerovi", 7, "IV", 14);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(115, "MC", "Moscovi", 7, "VA", 15);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(116, "Lv", "Livemori", 7, "VIA", 16);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(117, "Ts", "Tenessin", 7, "VIIA", 17);
        chatHoaHocList.add(chatHoaHoc);

        chatHoaHoc = new ChatHoaHoc(118, "Og", "Oganesson", 7, "VIII", 18);
        chatHoaHocList.add(chatHoaHoc);
    }

    private void addGroup() {
        Group group;
        group = new Group(1, "IA");
        groupList.add(group);

        group = new Group(2, "IIA");
        groupList.add(group);

        group = new Group(3, "IIIB");
        groupList.add(group);

        group = new Group(4, "IVB");
        groupList.add(group);

        group = new Group(5, "VB");
        groupList.add(group);

        group = new Group(6, "VIB");
        groupList.add(group);

        group = new Group(7, "VIIB");
        groupList.add(group);

        group = new Group(8, "VIIIB");
        groupList.add(group);

        group = new Group(9, "VIIIB");
        groupList.add(group);

        group = new Group(10, "VIIIB");
        groupList.add(group);

        group = new Group(11, "IB");
        groupList.add(group);

        group = new Group(12, "IIB");
        groupList.add(group);

        group = new Group(13, "IIIA");
        groupList.add(group);

        group = new Group(14, "IVA");
        groupList.add(group);

        group = new Group(15, "VA");
        groupList.add(group);

        group = new Group(16, "VIA");
        groupList.add(group);

        group = new Group(17, "VIIA");
        groupList.add(group);

        group = new Group(18, "VIIIA");
        groupList.add(group);
    }

    private View inflateView(LayoutInflater vi){
        View v = vi.inflate(R.layout.item_chat_hoa_hoc, null);

        tvId = (TextView) v.findViewById(R.id.tv_id);
        tvKyHieu = (TextView) v.findViewById(R.id.tv_ky_hieu);
        tvTen = (TextView) v.findViewById(R.id.tv_ten);

        return v;
    }

}
