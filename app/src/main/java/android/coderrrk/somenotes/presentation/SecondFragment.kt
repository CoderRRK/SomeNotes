package android.coderrrk.somenotes.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import somenotes.R
import somenotes.databinding.SecondFragmentBinding

class SecondFragment:  Fragment(R.layout.second_fragment) {
    var liveDataString = MutableLiveData<String>()

    private lateinit var binding: SecondFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SecondFragmentBinding.inflate(layoutInflater)

//        binding.setterLiveDataButton.setOnClickListener{
//            binding.testText.setText(binding.setterLiveData.text.toString())
//        }
//
//
//        CoroutineScope(Dispatchers.Main).launch {
//            liveDataString.value = "Garry"
//            binding.getLiveDataButton.setOnClickListener {
//                if(binding.setLiveData.text.equals("Garry")){
//                    liveDataString.value = "Marry"
//                } else if (binding.setLiveData.text.equals("Marry")) {
//                    liveDataString.value = "Garry"
//                }
//
//                binding.setLiveData.setText(liveDataString.value.toString())
//            }
//        }

    }
}