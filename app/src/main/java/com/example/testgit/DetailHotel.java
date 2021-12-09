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
import com.example.testgit.AppDatabase;
import com.example.testgit.Model;

import org.json.JSONArray;
import org.json.JSONObject;

public class DetailHotel extends AppCompatActivity {
    AppDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_hotel);
        ImageView img = findViewById(R.id.fotoDetail);
        TextView info = findViewById(R.id.infoDetail);
        database = AppDatabase.getInstance(this);
        Model model = database.ModelDao().getModel(getIntent().getExtras().getInt("mal_id"));
        String information = "";
        Glide.with(getBaseContext())
                .load(model.image_url)
                .into(img);
        information+="Title : "+model.title+
                "\nAiring : "+model.airing+
                "\nSynopsis : "+model.synopsis+
                "\nType : "+model.type+
                "\nEpisodes : "+model.episodes+
                "\nScore : "+model.score+
                "\nStart Date : "+model.start_date+
                "\nEnd Date : "+model.end_date+
                "\nMembers : "+model.members+
                "\nrated : "+model.rated;
        info.setText(information);

    }
}