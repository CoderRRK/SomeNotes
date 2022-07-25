package android.coderrrk.somenotes.data.sqlite

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class CostRepositoryImpl(private val costDao: CostDao) {

    val allCosts: Flow<List<CostsDb>> = costDao.getAlphabetizedCosts()

    val allPrice: Flow<List<Double>> = costDao.getAllPrice()


    @WorkerThread
    suspend fun insert(costDb: CostsDb) {
        costDao.insert(costDb)
    }

    @WorkerThread
    suspend fun deleteAll() {
        costDao.deleteAll()
    }

}
