package android.coderrrk.somenotes.presentation

import android.coderrrk.testfragment.data.CostRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class MainViewModelFactory(private val repository: CostRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CostViewModel::class.java)) {
            return CostViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}