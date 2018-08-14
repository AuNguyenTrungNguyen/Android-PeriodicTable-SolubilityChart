package cnhh.lvtn.bangtuanhoan.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cnhh.lvtn.bangtuanhoan.R;

public class PeriodicDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_periodic_detail);
        setContentView(new RandomCircles(this));
    }
}
