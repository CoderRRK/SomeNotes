package android.coderrrk.testfragment.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CostDao {

    @Query("SELECT * FROM cost_table ORDER BY cost ASC")
    fun getAlphabetizedCosts(): Flow<List<CostsDb>>
    //заварачиваем во flow

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(costDb: CostsDb)

    @Query("DELETE FROM cost_table")
    suspend fun deleteAll()

}