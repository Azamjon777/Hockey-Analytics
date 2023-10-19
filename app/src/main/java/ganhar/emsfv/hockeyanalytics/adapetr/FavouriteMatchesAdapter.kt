package ganhar.emsfv.hockeyanalytics.adapetr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.databinding.ItemFavouriteMatchBinding
import ganhar.emsfv.hockeyanalytics.model.MatchModel

class FavouriteMatchesAdapter(
    private val data: List<MatchModel>
) : RecyclerView.Adapter<FavouriteMatchesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemFavouriteMatchBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemFavouriteMatchBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemBinding = holder.binding
        val match = data[position]

        itemBinding.tvDate.text = match.totalScoreOrDate
        itemBinding.team1Score.text = match.team1Score.toString()
        itemBinding.team2Score.text = match.team2Score.toString()

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
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
