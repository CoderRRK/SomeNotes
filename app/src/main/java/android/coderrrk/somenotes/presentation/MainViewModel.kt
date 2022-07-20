package android.coderrrk.somenotes.presentation

import android.coderrrk.testfragment.data.CostRepository
import android.coderrrk.testfragment.data.CostsDb
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class MainViewModel (private val repository: CostRepository): ViewModel() {

    val allCosts: LiveData<List<CostsDb>> = repository.allCosts.asLiveData()

    fun insert(costDb: CostsDb) = viewModelScope.launch {
        repository.insert(costDb)
    }

    fun deleteAll(costDb: CostsDb) = viewModelScope.launch {
        repository.deleteAll(costDb)
    }

}
