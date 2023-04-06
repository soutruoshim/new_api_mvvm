package com.srhdp.newapimvvm.data.db

import androidx.room.TypeConverter
import com.srhdp.newapimvvm.data.model.Source

class Converters {
    @TypeConverter
    fun fromSource(source: Source):String{
        return source.name
    }
    @TypeConverter
    fun toSource(name:String):Source{
        return Source(name,name)
    }
}