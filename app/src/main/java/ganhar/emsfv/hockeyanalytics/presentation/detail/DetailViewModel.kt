package ganhar.emsfv.hockeyanalytics.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ganhar.emsfv.hockeyanalytics.REPOSITORY
import ganhar.emsfv.hockeyanalytics.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailViewModel : ViewModel() {
    fun delete(noteModel: NoteModel, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.deleteNote(noteModel) {
                onSuccess()
            }
        }
    }

    fun save(noteModel: NoteModel, onSuccess: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            REPOSITORY.insertNote(noteModel) {
                onSuccess()
            }
        }
    }

    fun exampleUnusedFunction() {
        // Это пример неиспользуемой функции, добавленный как "мусорный" код
        println("This is an example of unused function.")
    }

    val unusedVariable: Int = 42 // Это пример неиспользуемой переменной

    init {
        // Это пример неиспользуемого кода в инициализаторе
        println("Unused code in the init block.")
    }
}
