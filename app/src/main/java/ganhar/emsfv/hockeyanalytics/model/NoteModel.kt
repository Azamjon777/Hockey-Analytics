package ganhar.emsfv.hockeyanalytics.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "note_table")
class NoteModel(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo
    var title: String = "",

    @ColumnInfo
    var desc: String = "",

    @ColumnInfo
    var noteDesc: String = ""
) : Serializable{
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