package com.example.project1;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "calculator_table")

public class Calculator {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "calculator")

    public int answer;

    public Calculator(int answer) {
        this.answer = answer;
    }

}
