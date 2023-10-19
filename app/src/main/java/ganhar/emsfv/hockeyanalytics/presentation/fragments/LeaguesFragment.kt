package ganhar.emsfv.hockeyanalytics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.adapetr.LeaguesAdapter
import ganhar.emsfv.hockeyanalytics.adapetr.OnLeagueClickListener
import ganhar.emsfv.hockeyanalytics.databinding.FragmentLeaguesBinding
import ganhar.emsfv.hockeyanalytics.model.LeagueMatchesModel
import ganhar.emsfv.hockeyanalytics.viewmodel.MatchViewModel
import ganhar.emsfv.hockeyanalytics.viewmodel.MatchViewModelFactory

class LeaguesFragment : Fragment(), OnLeagueClickListener {
    private lateinit var binding: FragmentLeaguesBinding
    private lateinit var leaguesAdapter: LeaguesAdapter
    private lateinit var viewModel: MatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLeaguesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MatchViewModelFactory(requireContext())
        )[MatchViewModel::class.java]
        val leaguesData = viewModel.leaguesList

        leaguesAdapter = LeaguesAdapter(leaguesData, this)
        binding.rvLeague.adapter = leaguesAdapter
        binding.rvLeague.layoutManager = LinearLayoutManager(requireContext())
        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.notes.setOnClickListener {
            findNavController().navigate(R.id.action_leaguesFragment_to_notesFragment)
        }
    }

    override fun onLeagueClick(league: LeagueMatchesModel) {
        val action =
            LeaguesFragmentDirections.actionLeaguesFragmentToLeagues2Fragment(league)
        findNavController().navigate(action)
    }
}
