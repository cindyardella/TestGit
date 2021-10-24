package com.example.testgit;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class HotelFragment extends Fragment {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    //ArrayList<Model> models;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotel_fragment, container, false);

       RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvData);

       linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
       recyclerView.setLayoutManager(linearLayoutManager);

       adapterData = new AdapterData(this.getContext(), getMyList());
       recyclerView.setAdapter(adapterData);
       adapterData.notifyDataSetChanged();

       return view;
    }
    private ArrayList<Model> getMyList(){
        ArrayList<Model> models = new ArrayList<>();

        Model m  = new Model();
        m.setNama("Hotel Harper");
        m.setGambar(R.drawable.hotel_harper);
        models.add(m);

        m = new Model();
        m.setNama("Hotel 1");
        m.setGambar(R.drawable.hotel_harper);
        models.add(m);

        m = new Model();
        m.setNama("Hotel 2");
        m.setGambar(R.drawable.hotel_harper);
        models.add(m);

        m = new Model();
        m.setNama("Hotel 3");
        m.setGambar(R.drawable.hotel_harper);
        models.add(m);

        m = new Model();
        m.setNama("Hotel 4");
        m.setGambar(R.drawable.hotel_harper);
        models.add(m);
        return models;
    }
}
