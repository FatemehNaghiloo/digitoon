package com.fatemeh.digitoon.model

import android.util.Log
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class RoomConverter {
    var gson = Gson()

    @TypeConverter
    fun fromStringQuestion(value: String?): ArrayList<SearchItem>? {
        val listType: Type = object : TypeToken<ArrayList<SearchItem>?>() {}.type
        return gson.fromJson(value, listType)
    }


    @TypeConverter
    fun fromQuestionArrayListToJson(list: ArrayList<SearchItem?>?): String = gson.toJson(list)


    @TypeConverter
    fun fromStringTaskItem(value: String?): ArrayList<SearchItem?>? {
        val listType: Type = object : TypeToken<ArrayList<SearchItem?>?>() {}.type
        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun fromTaskItemArrayList(list: ArrayList<SearchItem?>?): String? {
        Log.d("qqq", "fromTaskItemArrayList: ${gson.toJson(list)}")
        return gson.toJson(list)
    }



}