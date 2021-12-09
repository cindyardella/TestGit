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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.testgit.AppDatabase;
import com.example.testgit.Model;

import org.json.JSONArray;
import org.json.JSONObject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class HotelFragment extends Fragment {
    RecyclerView recyclerView;
    AppDatabase database;
    LinearLayoutManager linearLayoutManager;
    AdapterData adapterData;
    List<Model> models = new ArrayList<>();
    final String url = "https://api.jikan.moe/v3/search/anime?q=doraemon";
    RequestQueue requestQueue;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hotel_fragment, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvData);
        database = AppDatabase.getInstance(requireContext());
        models = database.ModelDao().getModels();
        linearLayoutManager = new LinearLayoutManager(this.getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        requestQueue = Volley.newRequestQueue(requireContext());
        adapterData = new AdapterData(this.getContext(), (ArrayList<Model>) models);

        recyclerView.setAdapter(adapterData);
        adapterData.notifyDataSetChanged();
        if(models.size()==0) {
            getdata();
        }
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
                        Log.d("TAG", String.valueOf(jsonObject));
                        model.title = jsonObject.getString("title");
                        model.image_url = jsonObject.getString("image_url");
                        model.mal_id = jsonObject.getInt("mal_id");
                        model.airing = jsonObject.getBoolean("airing");
                        model.synopsis = jsonObject.getString("synopsis");
                        model.type = jsonObject.getString("type");
                        model.episodes = jsonObject.getInt("episodes");
                        model.score = jsonObject.getInt("score");
                        model.start_date = jsonObject.getString("start_date");
                        model.end_date = jsonObject.getString("end_date");
                        model.members = jsonObject.getInt("members");
                        model.rated = jsonObject.getString("rated");
                        models.add(model);
                        database.ModelDao().insertModel(model);
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
