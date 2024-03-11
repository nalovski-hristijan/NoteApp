package com.hnalovski.noteapp.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.hnalovski.noteapp.model.Note

@Dao
interface NoteDatabaseDao {
    @Query("SELECT * from note_table")
    fun getNotes(): List<Note>

    @Query("SELECT * from note_table WHERE id = :id")
    fun getNoteById(id: String): Note

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(note: Note)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(note: Note)

    @Query("DELETE from note_table")
    fun deleteAll()

    @Delete
    fun deleteNote(note: Note)
}