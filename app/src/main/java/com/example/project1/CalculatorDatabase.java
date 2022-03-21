package com.example.project1;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

@Database(entities = {Calculator.class}, version = 1, exportSchema = false)
public abstract class CalculatorDatabase extends RoomDatabase {

    public static Executor databaseWriteExecutor;

    public abstract calculatorDAO newCalculatorDAO();

    private static volatile CalculatorDatabase INSTANCE;

    static CalculatorDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (CalculatorDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            CalculatorDatabase.class, "calculator_table")
                            .build();
                }
            }
        }
        return INSTANCE;
    }


    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }

}
