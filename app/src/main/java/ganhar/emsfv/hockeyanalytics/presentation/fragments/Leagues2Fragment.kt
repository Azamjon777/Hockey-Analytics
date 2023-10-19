package ganhar.emsfv.hockeyanalytics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.adapetr.LeagueMatchesAdapter
import ganhar.emsfv.hockeyanalytics.adapetr.OnMatchClickListener
import ganhar.emsfv.hockeyanalytics.databinding.FragmentLeagues2Binding
import ganhar.emsfv.hockeyanalytics.model.MatchModel

class Leagues2Fragment : Fragment(), OnMatchClickListener {

    private lateinit var binding: FragmentLeagues2Binding
    private lateinit var leagueMatchesAdapter: LeagueMatchesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLeagues2Binding.inflate(inflater, container, false)

        val args: Leagues2FragmentArgs by navArgs()
        val selectedLeague = args.leagueItem
        val listOfMatches = selectedLeague.listOfMatches

        leagueMatchesAdapter = LeagueMatchesAdapter(listOfMatches, this)

        binding.rvLeagues2.adapter = leagueMatchesAdapter
        binding.rvLeagues2.layoutManager = LinearLayoutManager(requireContext())
        binding.notes.setOnClickListener {
            findNavController().navigate(R.id.action_leagues2Fragment_to_notesFragment)
        }
        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }
        return binding.root
    }

    override fun onMatchClick(match: MatchModel) {
        val action = Leagues2FragmentDirections.actionLeagues2FragmentToMatchInfoFragment(match)
        findNavController().navigate(action)
    }

    override fun onImageClick(match: MatchModel) {
        val action = Leagues2FragmentDirections.actionLeagues2FragmentToFavouriteFragment2(match)
        findNavController().navigate(action)
    }
}
