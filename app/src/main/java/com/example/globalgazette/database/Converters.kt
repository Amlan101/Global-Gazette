package com.example.globalgazette.database

import androidx.room.TypeConverter
import com.example.globalgazette.models.Source

class Converters {

    // This function is used to write to the database since it recognizes String, not Source datatype
    @TypeConverter
    fun fromSource(source: Source): String{
        return source.name
    }

    // This function is used to read from the database and convert it to Source datatype
    @TypeConverter
    fun toSource(name: String): Source{
        return Source(name, name)
    }
}