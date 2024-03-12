package com.hnalovski.noteapp.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hnalovski.noteapp.data.NoteDatabase
import com.hnalovski.noteapp.data.NoteDatabaseDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object AppModule {
    @Singleton
    @Provides
    fun provideNotesDao(noteDatabase: NoteDatabase): NoteDatabaseDao = noteDatabase.NoteDao()

    @Singleton
    @Provides
    fun providesAppDatabase(@ApplicationContext context: Context): NoteDatabase =
        Room.databaseBuilder(context, NoteDatabase::class.java, "note_db").build()
}