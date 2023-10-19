package ganhar.emsfv.hockeyanalytics.presentation.addnote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ganhar.emsfv.hockeyanalytics.databinding.FragmentAddNoteBinding
import ganhar.emsfv.hockeyanalytics.model.NoteModel

class AddNoteFragment : Fragment() {

    private lateinit var viewModel: AddNoteViewModel
    private lateinit var binding: FragmentAddNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[AddNoteViewModel::class.java]

        binding.btnAddNote.setOnClickListener {
            val title = binding.etAddTitle.text.toString()
            val desc = binding.etAddDesc.text.toString()
            if (title.isNotEmpty() && desc.isNotEmpty()) {
                viewModel.insert(NoteModel(title = title, desc = desc)) {}
                requireActivity().onBackPressed()
            }
        }
        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
