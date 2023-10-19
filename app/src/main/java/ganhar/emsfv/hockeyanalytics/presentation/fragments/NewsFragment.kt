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
import ganhar.emsfv.hockeyanalytics.adapetr.NewsAdapter
import ganhar.emsfv.hockeyanalytics.databinding.FragmentNewsBinding
import ganhar.emsfv.hockeyanalytics.viewmodel.MatchViewModel
import ganhar.emsfv.hockeyanalytics.viewmodel.MatchViewModelFactory

class NewsFragment : Fragment() {

    private lateinit var viewModel: MatchViewModel
    private lateinit var binding: FragmentNewsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewsBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            MatchViewModelFactory(requireContext())
        )[MatchViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val newsList = viewModel.newsList
        val adapter = NewsAdapter(newsList)

        binding.newsRecyclerView.adapter = adapter
        binding.newsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }

        binding.notes.setOnClickListener {
            findNavController().navigate(R.id.action_newsFragment_to_notesFragment)
        }
    }
}
