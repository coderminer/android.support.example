package io.coderminer.support;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import io.coderminer.R;


public class MyBottomSheetDialogFragment extends BottomSheetDialogFragment {

    private ArrayList<String> mItems;

    static MyBottomSheetDialogFragment newInstance(ArrayList<String> items){
        MyBottomSheetDialogFragment d = new MyBottomSheetDialogFragment();
        Bundle arg = new Bundle();
        arg.putStringArrayList("item",items);
        d.setArguments(arg);
        return d;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.bottom_dialog,null,false);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        ItemAdapter adapter = new ItemAdapter(mItems);
        recyclerView.setAdapter(adapter);
        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mItems = getArguments().getStringArrayList("item");
    }
}