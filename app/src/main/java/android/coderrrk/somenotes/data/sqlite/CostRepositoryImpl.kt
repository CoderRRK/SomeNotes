package android.coderrrk.somenotes.data.sqlite

import android.coderrrk.somenotes.domain.CostRepository
import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class CostRepositoryImpl(private var costDao: CostDao): CostRepository {

    override var allCosts: Flow<List<CostsDb>> = costDao.getAlphabetizedCosts()

    override var allPrice: Flow<List<Double>> = costDao.getAllPrice()


    @WorkerThread
    override suspend fun insert(costDb: CostsDb) {
        costDao.insert(costDb)
    }

    @WorkerThread
    override suspend fun deleteAll() {
        costDao.deleteAll()
    }

}
