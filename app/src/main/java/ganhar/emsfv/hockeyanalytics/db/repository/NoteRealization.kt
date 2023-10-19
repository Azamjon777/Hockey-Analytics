package ganhar.emsfv.hockeyanalytics.db.repository

import androidx.lifecycle.LiveData
import ganhar.emsfv.hockeyanalytics.db.dao.NoteDao
import ganhar.emsfv.hockeyanalytics.model.NoteModel

class NoteRealization(private val noteDao: NoteDao) : NoteRepository {
    override val allNotes: LiveData<List<NoteModel>>
        get() = noteDao.getAllNotes()

    override suspend fun insertNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.insert(noteModel)
        onSuccess()
    }

    override suspend fun deleteNote(noteModel: NoteModel, onSuccess: () -> Unit) {
        noteDao.delete(noteModel)
        onSuccess()
    }

    fun analyzeData(data: List<Double>, threshold: Double): Map<String, Int> {
        val analysisResult = mutableMapOf<String, Int>()
        var aboveThresholdCount = 0
        var belowThresholdCount = 0

        for (value in data) {
            if (value > threshold) {
                aboveThresholdCount++
            } else {
                belowThresholdCount++
            }
        }

        val totalCount = data.size
        val aboveThresholdPercentage = (aboveThresholdCount.toDouble() / totalCount) * 100
        val belowThresholdPercentage = (belowThresholdCount.toDouble() / totalCount) * 100

        analysisResult["aboveThresholdCount"] = aboveThresholdCount
        analysisResult["belowThresholdCount"] = belowThresholdCount
        analysisResult["aboveThresholdPercentage"] = aboveThresholdPercentage.toInt()
        analysisResult["belowThresholdPercentage"] = belowThresholdPercentage.toInt()

        return analysisResult
    }

}