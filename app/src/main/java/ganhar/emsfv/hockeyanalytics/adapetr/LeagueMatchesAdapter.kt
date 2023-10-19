package ganhar.emsfv.hockeyanalytics.adapetr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.databinding.ItemOneMatcheBinding
import ganhar.emsfv.hockeyanalytics.model.MatchModel

class LeagueMatchesAdapter(
    private val data: List<MatchModel>,
    private val onMatchClickListener: OnMatchClickListener
) : RecyclerView.Adapter<LeagueMatchesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemOneMatcheBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemOneMatcheBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemBinding = holder.binding
        val match = data[position]

        itemBinding.tvDate.text = match.totalScoreOrDate
        itemBinding.team1Score.text = match.team1Score.toString()
        itemBinding.team2Score.text = match.team2Score.toString()
        itemBinding.team1Name.text = match.team1Name
        itemBinding.team2Name.text = match.team2Name

        Glide.with(itemBinding.root)
            .load(match.team1Img)
            .placeholder(R.drawable.ic_place_holder)
            .error(R.drawable.ic_place_holder)
            .into(itemBinding.team1Img)

        Glide.with(itemBinding.root)
            .load(match.team2Img)
            .placeholder(R.drawable.ic_place_holder)
            .error(R.drawable.ic_place_holder)
            .into(itemBinding.team2Img)

        itemBinding.root.setOnClickListener {
            onMatchClickListener.onMatchClick(match)
        }

        itemBinding.imgSelected.setOnClickListener {
            onMatchClickListener.onImageClick(match)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

interface OnMatchClickListener {
    fun onMatchClick(match: MatchModel)
    fun onImageClick(match: MatchModel)
}
