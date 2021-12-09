package com.example.testgit;

import com.bumptech.glide.Glide;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Model {
    @PrimaryKey
    public int mal_id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "image_url")
    public String image_url;

    @ColumnInfo(name = "airing")
    public boolean airing;

    @ColumnInfo(name = "synopsis")
    public String synopsis;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "episodes")
    public int episodes;

    @ColumnInfo(name = "score")
    public int score;

    @ColumnInfo(name = "start_date")
    public String start_date;

    @ColumnInfo(name = "end_date")
    public String end_date;

    @ColumnInfo(name = "members")
    public int members;

    @ColumnInfo(name = "rated")
    public String rated;
}
