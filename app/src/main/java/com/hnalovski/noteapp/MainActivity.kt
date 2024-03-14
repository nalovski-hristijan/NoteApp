package com.hnalovski.noteapp
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import com.hnalovski.noteapp.data.NotesDataSource
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
fun NotesApp(noteViewModel: NoteViewModel) {
    val notesList = noteViewModel.noteList.collectAsState().value

    NoteScreen(notes = notesList, onAddNote = {
        noteViewModel.addNote(it)
    }, onRemoveNote = {
        noteViewModel.removeNote(it)
    }, onAllNotesDelete = noteViewModel)
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NoteAppTheme {

    }
}