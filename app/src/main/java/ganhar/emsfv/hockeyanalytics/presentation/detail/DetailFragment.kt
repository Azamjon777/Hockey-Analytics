package ganhar.emsfv.hockeyanalytics.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import ganhar.emsfv.hockeyanalytics.databinding.FragmentDetailBinding
import ganhar.emsfv.hockeyanalytics.model.NoteModel

class DetailFragment : Fragment() {

    private lateinit var viewModel: DetailViewModel
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(requireActivity())[DetailViewModel::class.java]

        val args: DetailFragmentArgs by navArgs()
        val noteModel: NoteModel = args.NoteModel


        binding.etTitleDetail.setText(noteModel.title)
        binding.etDescDetail.setText(noteModel.desc)

        binding.btnDelete.setOnClickListener {
            viewModel.delete(noteModel) {}
            requireActivity().onBackPressed()
        }

        binding.btnSave.setOnClickListener {
            val title = binding.etTitleDetail.text.toString()
            val desc = binding.etDescDetail.text.toString()
            if (title.isNotEmpty() && desc.isNotEmpty()) {
                viewModel.delete(noteModel) {}
                viewModel.save(NoteModel(title = title, desc = desc)) {}
                requireActivity().onBackPressed()
            }
        }
        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}
