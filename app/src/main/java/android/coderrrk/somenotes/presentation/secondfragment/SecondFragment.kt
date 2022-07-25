package android.coderrrk.somenotes.presentation.secondfragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.ProgressDialog
import android.os.Build
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.*
import android.webkit.*
import android.widget.ProgressBar
import androidx.annotation.RequiresApi
import androidx.core.view.get
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.viewbinding.ViewBinding
import androidx.viewbinding.ViewBindings
import kotlinx.android.synthetic.main.second_fragment.*
import somenotes.R
import somenotes.databinding.ActivityMainBinding
import somenotes.databinding.SecondFragmentBinding
import kotlin.system.exitProcess

class SecondFragment:  Fragment(R.layout.second_fragment) {
//    var liveDataString = MutableLiveData<String>()

    lateinit var binding: SecondFragmentBinding
    lateinit var mWebView: WebView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SecondFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        webViewSetup()
    }

    fun webViewSetup(){
       mWebView = binding.webView
       mWebView.webViewClient = WebViewClient()

        mWebView.apply {
            loadUrl("https://rasp.yandex.ru/search/bus/?fromId=" +
                    "c21651&fromName=Котельники&toId=s9745755&toName=Кузьминки&when=сегодня")
            settings.javaScriptEnabled = true

            }
    }
}
































//        binding.setterLiveDataButton.setOnClickListener{
//            binding.testText.setText(binding.setterLiveData.text.toString())
//        }
//
//
//        CoroutineScope(Dispatchers.Main).launch {
//            liveDataString.value = "Chery"
//            binding.getLiveDataButton.setOnClickListener {
//                if(binding.setLiveData.text.equals("Apple")){
//                    liveDataString.value = "Apple"
//                } else if (binding.setLiveData.text.equals("Apple")) {
//                    liveDataString.value = "Chery"
//                }
//
//                binding.setLiveData.setText(liveDataString.value.toString())
//            }
//        }

