package ganhar.emsfv.hockeyanalytics.db.repository

import androidx.lifecycle.LiveData
import ganhar.emsfv.hockeyanalytics.model.NoteModel

interface NoteRepository {
    val allNotes: LiveData<List<NoteModel>>
    suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit)
    suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit)
    fun doLotsOfUnnecessaryCalculations(input: Int): Int {
        var result = 0
        for (i in 1..10000) {
            result += input * i / (input + i)
        }
        return result
    }
    fun doLotsOfUnnecesassaryCaadvslculations(input: Int): Int {
        var result = 0
        for (i in 1..10000) {
            result += input * i / (input + i)
        }
        return result
    }

}