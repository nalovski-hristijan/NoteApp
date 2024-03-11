package com.hnalovski.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.hnalovski.noteapp.data.NotesDataSource
import com.hnalovski.noteapp.model.Note
import com.hnalovski.noteapp.screen.NoteScreen
import com.hnalovski.noteapp.screen.NoteViewModel
import com.hnalovski.noteapp.ui.theme.NoteAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val noteViewModel: NoteViewModel by viewModels()
            NotesApp(noteViewModel)

        }
    }
}

@Composable
fun NotesApp(noteViewModel: NoteViewModel = NoteViewModel()) {
    val notesList = noteViewModel.getAllNotes()

    NoteScreen(notes = notesList, onAddNote = {
        noteViewModel.addNote(it)
    }, onRemoveNote = {
        noteViewModel.removeNote(it)
    })
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppTheme {
        NoteScreen(notes = NotesDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
    }
}