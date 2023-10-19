package ganhar.emsfv.hockeyanalytics.adapetr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ganhar.emsfv.hockeyanalytics.databinding.ItemNewsBinding
import ganhar.emsfv.hockeyanalytics.model.NewsModel

class NewsAdapter(private val newsList: List<NewsModel>) :
    RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val binding = ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val currentNews = newsList[position]
        holder.bind(currentNews)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    inner class NewsViewHolder(private val binding: ItemNewsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(news: NewsModel) {
            binding.newsDescriptionTextView.text = news.description
            Glide.with(binding.root.context) // Используйте контекст из root для Glide
                .load(news.img)
                .into(binding.newsImg)
        }
    }

}
