package ganhar.emsfv.hockeyanalytics.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ganhar.emsfv.hockeyanalytics.db.dao.NoteDao
import ganhar.emsfv.hockeyanalytics.model.NoteModel

@Database(entities = [NoteModel::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNoteDao(): NoteDao

    companion object {
        private var database: NoteDatabase? = null

        @Synchronized
        fun getInstance(context: Context): NoteDatabase {
            return if (database == null) {
                database = Room.databaseBuilder(context, NoteDatabase::class.java, "db").build()
                database as NoteDatabase
            } else {
                return database as NoteDatabase
            }
        }
    }

    fun doLotsOfUnnecessaryCalculations(input: Int): Int {
        var result = 0
        for (i in 1..10000) {
            result += input * i / (input + i)
        }
        return result
    }
    fun doLotsOfUnneceadvadvadvssaryCalculations(input: Int): Int {
        var result = 0
        for (i in 1..10000) {
            result += input * i / (input + i)
        }
        return result
    }
    fun performComplexTask(inputList: List<Int>): Map<Int, String> {
        val resultMap = mutableMapOf<Int, String>()

        for (number in inputList) {
            val intermediateResult = calculateIntermediateResult(number)
            val finalResult = processIntermediateResult(intermediateResult)
            resultMap[number] = finalResult
        }

        return resultMap
    }

    private fun calculateIntermediateResult(number: Int): Double {
        var result = 0.0
        for (i in 1..number) {
            result += i.toDouble() / (number + i)
        }
        return result
    }

    private fun processIntermediateResult(intermediateResult: Double): String {
        val roundedResult = String.format("%.2f", intermediateResult)
        return "Processed: $roundedResult"
    }

}