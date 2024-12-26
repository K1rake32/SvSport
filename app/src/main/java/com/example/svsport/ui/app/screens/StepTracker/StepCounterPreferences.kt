package com.example.svsport.ui.app.screens.StepTracker

import android.content.Context
import android.content.SharedPreferences
import kotlin.coroutines.CoroutineContext

object StepCounterPreferences {

    private const val PREFS_NAME = "step_counter_prefs"
    private const val KEY_STEP_COUNT = "step_count"

    private fun getPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
    }

    fun getStepCount(context: Context): Int {
        val preferences = getPreferences(context)
        return preferences.getInt(KEY_STEP_COUNT, 0)  // Возвращаем шаги, если не найдено - 0
    }

    fun saveStepCount(context: Context, stepCount: Int) {
        val preferences = getPreferences(context)
        preferences.edit().putInt(KEY_STEP_COUNT, stepCount).apply()  // Сохраняем шаги
    }
}