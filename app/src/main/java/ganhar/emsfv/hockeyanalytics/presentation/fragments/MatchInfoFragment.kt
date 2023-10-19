package ganhar.emsfv.hockeyanalytics.presentation.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.databinding.FragmentMatchInfoBinding

class MatchInfoFragment : Fragment() {

    private var _binding: FragmentMatchInfoBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMatchInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args = MatchInfoFragmentArgs.fromBundle(requireArguments())
        val selectedMatch = args.MatchModel

        binding.tvDate.text = selectedMatch.totalScoreOrDate
        binding.team1Scorers.text = selectedMatch.team1ListOfScorers.joinToString("\n")
        binding.team2Scorers.text = selectedMatch.team2ListOfScorers.joinToString("\n")
        binding.team1Name.text = selectedMatch.team1Name
        binding.team2Name.text = selectedMatch.team2Name
        binding.tvScore.text = "${selectedMatch.team1Score} - ${selectedMatch.team2Score}"
        Glide.with(requireContext())
            .load(selectedMatch.team1Img)
            .placeholder(R.drawable.ic_place_holder)
            .error(R.drawable.ic_place_holder)
            .into(binding.team1Img)
        Glide.with(requireContext())
            .load(selectedMatch.team2Img)
            .placeholder(R.drawable.ic_place_holder)
            .error(R.drawable.ic_place_holder)
            .into(binding.team2Img)

        binding.back.setOnClickListener {
            requireActivity().onBackPressed()
        }
        binding.notes.setOnClickListener {
            findNavController().navigate(R.id.action_matchInfoFragment_to_notesFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
