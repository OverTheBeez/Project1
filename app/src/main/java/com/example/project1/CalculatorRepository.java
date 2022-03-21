package com.example.project1;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class CalculatorRepository {

    private calculatorDAO newCalcDAO;
    private LiveData<List<Calculator>> calculator;

    CalculatorRepository(Application application) {
        CalculatorDatabase calcDB = CalculatorDatabase.getDatabase(application);
        newCalcDAO = calcDB.newCalculatorDAO();

    }

    void insert(Calculator calculator) {
        CalculatorDatabase.databaseWriteExecutor.execute(() -> {
            newCalcDAO.insert(calculator);
        });
    }

    LiveData<List<Calculator>> getAllAnswers() {
        return calculator;
    }
}
