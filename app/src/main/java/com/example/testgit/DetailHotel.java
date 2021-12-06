 package com.example.testgit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONArray;
import org.json.JSONObject;

public class DetailHotel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);
        ImageView img = findViewById(R.id.fotoDetail);
        TextView info = findViewById(R.id.infoDetail);
        final String url1 = "https://api.jikan.moe/v3/search/anime?q=doraemon"+getIntent().getExtras().getInt("mal_id");
        RequestQueue requestQueue = Volley.newRequestQueue(this);;
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url1, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    String information = "";
                    Glide.with(getBaseContext())
                            .load(response.getString("image_url"))
                            .into(img);
                    information+="Title : "+response.getString("title")+
                            "\nAiring : "+response.getBoolean("airing")+
                            "\nSynopsis : "+response.getString("synopsis")+
                            "\nType : "+response.getString("type")+
                            "\nEpisodes : "+response.getInt("episodes")+
                            "\nScore : "+response.getInt("score")+
                            "\nStart Date : "+response.getString("start_date")+
                            "\nEnd Date : "+response.getString("end_date")+
                            "\nMembers : "+response.getInt("members")+
                            "\nrated : "+response.getString("rated");
                    info.setText(information);
                } catch (Exception w) {
                    Toast.makeText(getBaseContext(), w.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getBaseContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}