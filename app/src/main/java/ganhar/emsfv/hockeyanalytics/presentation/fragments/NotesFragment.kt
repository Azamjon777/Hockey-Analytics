package ganhar.emsfv.hockeyanalytics.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.adapetr.NoteAdapter
import ganhar.emsfv.hockeyanalytics.databinding.FragmentNotesBinding
import ganhar.emsfv.hockeyanalytics.model.NoteModel
import ganhar.emsfv.hockeyanalytics.viewmodel.MatchViewModel
import ganhar.emsfv.hockeyanalytics.viewmodel.MatchViewModelFactory

class NotesFragment : Fragment(), NoteAdapter.OnNoteItemClickListener {

    private lateinit var viewModel: MatchViewModel

    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(
            this,
            MatchViewModelFactory(requireContext())
        )[MatchViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initial()
    }

    private fun initial() {
        val layoutManager = GridLayoutManager(requireContext(), 1)
        binding.rvNotes.layoutManager = layoutManager
        val adapter = NoteAdapter(this)
        binding.rvNotes.adapter = adapter
        viewModel.initDatabase()
        viewModel.getAllNotes().observe(viewLifecycleOwner) { listNotes ->
            adapter.setList(listNotes)
        }
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_notesFragment_to_addNoteFragment)
        }
        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onNoteItemClick(noteModel: NoteModel) {
        val action = NotesFragmentDirections.actionNotesFragmentToDetailFragment(noteModel)
        findNavController().navigate(action)
    }
}