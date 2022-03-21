package com.example.project1;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface calculatorDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Calculator calculator);

    @Query("DELETE FROM calculator_table")
    void deleteAll();
}
