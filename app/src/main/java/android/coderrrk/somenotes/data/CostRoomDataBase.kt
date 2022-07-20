package android.coderrrk.testfragment.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [CostsDb::class], version = 5)
abstract class CostRoomDataBase : RoomDatabase() {

    abstract fun costDao(): CostDao

    companion object {
        @Volatile
        private var INSTANCE: CostRoomDataBase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): CostRoomDataBase {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CostRoomDataBase::class.java,
                    "cost_database"
                )
                    .fallbackToDestructiveMigration()
                    .addCallback(CostDataBaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }

        private class CostDataBaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)

                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.costDao())
                    }
                }
            }
        }

        suspend fun populateDatabase(costDao: CostDao) {

            costDao.deleteAll()

            var cost = CostsDb("Job №1")
            costDao.insert(cost)

        }
    }
}
