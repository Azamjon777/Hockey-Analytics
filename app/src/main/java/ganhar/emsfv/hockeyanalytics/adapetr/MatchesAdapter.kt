package ganhar.emsfv.hockeyanalytics.adapetr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ganhar.emsfv.hockeyanalytics.databinding.ItemMatchesBinding
import ganhar.emsfv.hockeyanalytics.model.MatchModel

class MatchesAdapter : RecyclerView.Adapter<MatchesAdapter.ViewHolder>() {
    private val data: MutableList<MatchModel> = mutableListOf()

    fun submitData(newData: List<MatchModel>) {
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: ItemMatchesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemMatchesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val match = data[position]
        val itemBinding = holder.binding

        itemBinding.tvDate.text = match.totalScoreOrDate
        itemBinding.team1Name.text = match.team1Name
        itemBinding.team2Name.text = match.team2Name

        Glide.with(itemBinding.root)
            .load(match.team1Img)
            .into(itemBinding.team1Img)

        Glide.with(itemBinding.root)
            .load(match.team2Img)
            .into(itemBinding.team2Img)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
