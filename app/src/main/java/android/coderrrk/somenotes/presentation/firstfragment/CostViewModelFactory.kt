package android.coderrrk.somenotes.presentation.firstfragment

import android.coderrrk.somenotes.data.sqlite.CostRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class CostViewModelFactory(private val repository: CostRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CostViewModel::class.java)) {
            return CostViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}