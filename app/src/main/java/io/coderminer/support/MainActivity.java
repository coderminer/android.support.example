package io.coderminer.support;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

import io.coderminer.R;

public class MainActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    private Button mBottomFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBottomFragment = (Button)findViewById(R.id.fragment);
        fab = (FloatingActionButton)findViewById(R.id.fab);
        View bottomSheet = findViewById(R.id.bottom_sheet);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                //fab.animate().scaleX(1 - slideOffset).scaleY(1 - slideOffset).setDuration(0).start();
            }
        });

        ArrayList<String> data = new ArrayList<>();
        for(int i = 0;i<5;i++){
            data.add("Item "+i);
        }

        final MyBottomSheetDialogFragment fragment = MyBottomSheetDialogFragment.newInstance(data);

        mBottomFragment.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                fragment.show(getSupportFragmentManager(),fragment.getTag());
            }
        });

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.list_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ItemAdapter adapter = new ItemAdapter(data);
        recyclerView.setAdapter(adapter);
    }
}
