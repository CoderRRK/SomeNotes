package android.coderrrk.somenotes.presentation.firstfragment

import android.coderrrk.somenotes.data.sqlite.CostRepository
import android.coderrrk.somenotes.data.sqlite.CostsDb
import androidx.lifecycle.*
import kotlinx.coroutines.launch

class CostViewModel (private val repository: CostRepository): ViewModel() {

    val allCosts: LiveData<List<CostsDb>> = repository.allCosts.asLiveData()

    val allSumPrice: LiveData<List<Double>> = repository.allPrice.asLiveData()

    fun insert(costDb: CostsDb) = viewModelScope.launch {
        repository.insert(costDb)
    }

    fun deleteAll() = viewModelScope.launch {
            repository.deleteAll()
    }

}
