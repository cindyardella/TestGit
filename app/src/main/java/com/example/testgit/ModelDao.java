package com.example.testgit;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface ModelDao {

    @Query("SELECT * FROM Model")
    List<Model> getModels();

    @Insert
    void insertModel(Model... models);

    @Query("SELECT * FROM Model WHERE mal_id = :id")
    Model getModel(int id);
}
