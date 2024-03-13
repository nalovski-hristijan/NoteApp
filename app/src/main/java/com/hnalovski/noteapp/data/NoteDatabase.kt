package com.hnalovski.noteapp.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.hnalovski.noteapp.model.Note
import com.hnalovski.noteapp.util.DateConverter
import com.hnalovski.noteapp.util.UUIDConverter

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConverter::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun NoteDao(): NoteDatabaseDao
}