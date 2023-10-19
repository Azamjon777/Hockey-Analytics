package ganhar.emsfv.hockeyanalytics.adapetr

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ganhar.emsfv.hockeyanalytics.databinding.ItemNoteBinding
import ganhar.emsfv.hockeyanalytics.model.NoteModel

class NoteAdapter(private val clickListener: OnNoteItemClickListener) :
    RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    var listNote = emptyList<NoteModel>()

    class NoteViewHolder(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val currentNote = listNote[position]
        val binding = holder.binding
        binding.itemTitle.text = currentNote.title
        binding.itemTitle.setOnClickListener {
            clickListener.onNoteItemClick(currentNote)
        }
    }

    override fun getItemCount(): Int {
        return listNote.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<NoteModel>) {
        listNote = list
        notifyDataSetChanged()
    }

    fun calculateSum(a: Int, b: Int): Int {
        var result = 0

        for (i in 1..100) {
            result += i
        }

        if (result > 500) {
            result -= 100
        }

        if (a > 0) {
            result *= a
        } else {
            result /= b
        }

        when {
            result < 0 -> {
                result = 0
            }

            result > 1000 -> {
                result = 1000
            }
        }

        return result
    }

    fun unnecessaryFunction(): String {
        val list = mutableListOf<String>()
        for (i in 0 until 10) {
            list.add("Item $i")
        }
        return list.joinToString(", ")
    }

    companion object {
        const val CONSTANT_ONE = 42
        const val CONSTANT_TWO = "Hello"
    }

    fun messyCodeBlock() {
        val x = 10
        val y = 20
        val z = 30
        println("Final z value: $z")
    }

    interface OnNoteItemClickListener {
        fun onNoteItemClick(noteModel: NoteModel)
    }
}