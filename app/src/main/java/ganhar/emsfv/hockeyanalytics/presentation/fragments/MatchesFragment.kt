package ganhar.emsfv.hockeyanalytics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.adapetr.MatchesAdapter
import ganhar.emsfv.hockeyanalytics.databinding.FragmentMatchesBinding
import ganhar.emsfv.hockeyanalytics.viewmodel.MatchViewModel
import ganhar.emsfv.hockeyanalytics.viewmodel.MatchViewModelFactory

class MatchesFragment : Fragment() {

    private lateinit var binding: FragmentMatchesBinding
    private lateinit var matchesAdapter: MatchesAdapter
    private lateinit var viewModel: MatchViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMatchesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MatchViewModelFactory(requireContext())
        )[MatchViewModel::class.java]
        matchesAdapter = MatchesAdapter()

        matchesAdapter.submitData(viewModel.listMatches)

        binding.rvMatches.adapter = matchesAdapter
        binding.rvMatches.layoutManager = LinearLayoutManager(requireContext())
        binding.notes.setOnClickListener {
            findNavController().navigate(R.id.action_matchesFragment_to_notesFragment)
        }
        val backButton: ImageView = binding.back

        backButton.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
