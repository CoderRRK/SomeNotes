package android.coderrrk.somenotes.presentation

import android.coderrrk.testfragment.data.CostDao
import android.coderrrk.testfragment.data.CostRepository
import android.coderrrk.testfragment.data.CostsDb
import androidx.lifecycle.*
import kotlinx.coroutines.launch
import java.lang.RuntimeException

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
