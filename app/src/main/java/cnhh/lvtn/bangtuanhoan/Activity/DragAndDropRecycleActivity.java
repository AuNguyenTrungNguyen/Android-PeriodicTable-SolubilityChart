package cnhh.lvtn.bangtuanhoan.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import java.util.ArrayList;

import cnhh.lvtn.bangtuanhoan.Adapter.DayHoatDongAdapter;
import cnhh.lvtn.bangtuanhoan.Adapter.DragAdapter;
import cnhh.lvtn.bangtuanhoan.ControlRecyc.MyItemTouch;
import cnhh.lvtn.bangtuanhoan.R;

public class DragAndDropRecycleActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<String> list;
    private DragAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag_and_drop_recycle);


        list = new ArrayList<>();
        for (int i = 0; i < 1000; i++){
            list.add("Item: " + i);
        }

        recyclerView = findViewById(R.id.rv_drag);
        adapter = new DragAdapter(this,  list);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);

        ItemTouchHelper.Callback callback =
                new MyItemTouch(adapter);
        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }

    public void test(View view) {
        for (int i = 0; i < list.size(); i++) {
            Log.i("ANTN", "I: " + i + " - data: " + list.get(i));
        }
    }
}
