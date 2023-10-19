package ganhar.emsfv.hockeyanalytics.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ganhar.emsfv.hockeyanalytics.adapetr.FavouriteMatchesAdapter
import ganhar.emsfv.hockeyanalytics.databinding.FragmentFavouriteBinding
import ganhar.emsfv.hockeyanalytics.model.MatchModel

class FavouriteFragment : Fragment() {

    private lateinit var binding: FragmentFavouriteBinding
    private lateinit var favouriteMatchesAdapter: FavouriteMatchesAdapter
    private val favouriteMatchesList: MutableList<MatchModel> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFavouriteBinding.inflate(inflater, container, false)

        favouriteMatchesAdapter = FavouriteMatchesAdapter(favouriteMatchesList)

        binding.rvFavouriteMatches.adapter = favouriteMatchesAdapter
        binding.rvFavouriteMatches.layoutManager = LinearLayoutManager(requireContext())

        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        val deleteButton: ImageView = binding.delete
        deleteButton.setOnClickListener {
            clearListAndSharedPreferences()
        }

        val args: FavouriteFragmentArgs by navArgs()
        val matchItem = args.MatchModel

        loadMatchesFromSharedPreferences()

        matchItem.let {
            addToLocalListAndSharedPreferences(matchItem)
        }

        return binding.root
    }

    private fun loadMatchesFromSharedPreferences() {
        val sharedPreferences =
            requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("favouriteMatchesList", null)

        val savedMatchesList: MutableList<MatchModel> = if (!json.isNullOrEmpty()) {
            gson.fromJson(json, object : TypeToken<MutableList<MatchModel>>() {}.type)
        } else {
            mutableListOf()
        }

        favouriteMatchesList.addAll(savedMatchesList)
        favouriteMatchesAdapter.notifyDataSetChanged()
    }


    private fun clearListAndSharedPreferences() {
        favouriteMatchesList.clear()
        favouriteMatchesAdapter.notifyDataSetChanged()

        val sharedPreferences =
            requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.remove("favouriteMatchesList")
        editor.apply()
    }

    private fun loadMatchesFromSharedPreferences(matchItem: MatchModel) {
        val sharedPreferences =
            requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("favouriteMatchesList", null)

        val savedMatchesList: MutableList<MatchModel> = if (!json.isNullOrEmpty()) {
            gson.fromJson(json, object : TypeToken<MutableList<MatchModel>>() {}.type)
        } else {
            mutableListOf(matchItem)
        }

        favouriteMatchesList.addAll(savedMatchesList)
        favouriteMatchesAdapter.notifyDataSetChanged()
    }

    private fun addToLocalListAndSharedPreferences(match: MatchModel) {
        favouriteMatchesList.add(match)
        favouriteMatchesAdapter.notifyDataSetChanged()

        val sharedPreferences =
            requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json = gson.toJson(favouriteMatchesList)
        editor.putString("favouriteMatchesList", json)
        editor.apply()
    }

    // Проверяем, есть ли такой элемент уже в списке
    private fun isItemAlreadyAdded(newMatch: MatchModel): Boolean {
        return favouriteMatchesList.any { it.team1Name == newMatch.team1Name && it.team2Name == newMatch.team2Name }
    }
}