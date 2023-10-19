package ganhar.emsfv.hockeyanalytics.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import ganhar.emsfv.hockeyanalytics.model.NoteModel

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(noteModel: NoteModel)

    @Delete
    suspend fun delete(noteModel: NoteModel)

    @Query("SELECT * FROM note_table")
    fun getAllNotes(): LiveData<List<NoteModel>>

    @Update
    suspend fun update(noteModel: NoteModel)

    fun doLotsOfUnnecessaryCalculations(input: Int): Int {
        var result = 0
        for (i in 1..10000) {
            result += input * i / (input + i)
        }
        return result
    }

}
