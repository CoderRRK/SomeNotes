package android.coderrrk.testfragment.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface CostDao {

    @Query("SELECT price AS price FROM cost_table")
    fun getAllPrice(): Flow<List<Double>>
    //заварачиваем во flow

    @Query("SELECT * FROM cost_table ORDER BY cost, price ASC")
    fun getAlphabetizedCosts(): Flow<List<CostsDb>>
    //заварачиваем во flow

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(costDb: CostsDb)

    @Query("DELETE FROM cost_table")
    suspend fun deleteAll()

}