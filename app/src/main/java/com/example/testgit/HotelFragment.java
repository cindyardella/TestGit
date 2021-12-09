package com.example.testgit;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONObject;

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
    ArrayList<Model> models = new ArrayList<>();
    final String url = "https://api.jikan.moe/v3/search/anime?q=doraemon";
    RequestQueue requestQueue;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotel_fragment, container, false);

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvData);

        linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        requestQueue = Volley.newRequestQueue(requireContext());
        adapterData = new AdapterData(this.getContext(), models);
        recyclerView.setAdapter(adapterData);
        adapterData.notifyDataSetChanged();
        getdata();
        return view;
    }
    private void getdata() {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray results = (JSONArray) response.get("results");
                    for(int i=0;i<results.length();i++) {
                        Model model = new Model();
                        JSONObject jsonObject = results.getJSONObject(i);
                        String title = jsonObject.getString("title");
                        String image_url = jsonObject.getString("image_url");
                        int mal_id = jsonObject.getInt("mal_id");
                        models.add(model);
                    }
                    adapterData.notifyDataSetChanged();
                } catch (Exception w) {
                    Toast.makeText(requireContext(), w.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(requireContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
