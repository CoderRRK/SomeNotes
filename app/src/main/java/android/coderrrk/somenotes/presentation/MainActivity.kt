package android.coderrrk.somenotes.presentation

import android.coderrrk.somenotes.presentation.firstfragment.FirstFragment
import android.coderrrk.somenotes.presentation.secondfragment.SecondFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import somenotes.R
import somenotes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.firstButton.setOnClickListener {
            launchFragment(FirstFragment())
        }

        binding.secondButton.setOnClickListener {
            launchFragment(SecondFragment())
        }
    }

    fun launchFragment(fragment: Fragment){
        supportFragmentManager.popBackStack()
        supportFragmentManager.beginTransaction().addToBackStack(null).
        replace(R.id.container, fragment).commit()
    }
}