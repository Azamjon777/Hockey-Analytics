package ganhar.emsfv.hockeyanalytics.presentation.fragments

import android.content.Context
import android.media.AudioManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.SeekBar
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ganhar.emsfv.hockeyanalytics.R
import ganhar.emsfv.hockeyanalytics.databinding.FragmentStartMenuBinding

class StartMenuFragment : Fragment() {

    private lateinit var binding: FragmentStartMenuBinding
    private lateinit var audioManager: AudioManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.gamesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_matchesFragment)
        }
        binding.leaguesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_leaguesFragment)
        }
        binding.newsBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_newsFragment)
        }
        binding.notesBtn.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_notesFragment)
        }
        binding.settings.setOnClickListener {
            showSoundSettingsDialog()
        }

        audioManager = requireContext().getSystemService(Context.AUDIO_SERVICE) as AudioManager
    }

    private fun showSoundSettingsDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_sound_settings, null)
        val soundSeekBar = dialogView.findViewById<SeekBar>(R.id.soundSeekBar)
        val saveButton = dialogView.findViewById<Button>(R.id.saveButton)

        // Устанавливаем текущую громкость как начальное значение для SeekBar
        val currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC)
        soundSeekBar.progress = currentVolume

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(dialogView)
            .setTitle("Настройка звука")

        val alertDialog = builder.create()
        alertDialog.show()

        saveButton.setOnClickListener {
            val soundLevel = soundSeekBar.progress
            // Устанавливаем новую громкость для потока звука
            audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, soundLevel, 0)
            alertDialog.dismiss()
        }
    }
}
