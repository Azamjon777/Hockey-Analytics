package ganhar.emsfv.hockeyanalytics.presentation.fragments.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.databinding.FragmentOnBoarding2Binding

class OnBoarding2Fragment : Fragment() {

    private lateinit var binding: FragmentOnBoarding2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoarding2Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.skip.setOnClickListener {
            findNavController().navigate(R.id.action_onBoarding2Fragment_to_mainFragment)
        }
    }
}
