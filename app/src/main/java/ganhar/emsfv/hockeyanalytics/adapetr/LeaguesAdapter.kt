package ganhar.emsfv.hockeyanalytics.adapetr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.databinding.ItemLeagueMatchesBinding
import ganhar.emsfv.hockeyanalytics.model.LeagueMatchesModel

class LeaguesAdapter(
    private val data: List<LeagueMatchesModel>,
    private val clickListener: OnLeagueClickListener
) :
    RecyclerView.Adapter<LeaguesAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemLeagueMatchesBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemLeagueMatchesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemBinding = holder.binding
        val league = data[position]

        itemBinding.leagueName.text = league.leagueName
        Glide.with(itemBinding.root)
            .load(league.leagueImg)
            .placeholder(R.drawable.ic_place_holder)
            .error(R.drawable.ic_place_holder)
            .into(itemBinding.leagueImg)

        // Установите обработчик кликов
        itemBinding.root.setOnClickListener {
            clickListener.onLeagueClick(league)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}

interface OnLeagueClickListener {
    fun onLeagueClick(league: LeagueMatchesModel)
}
