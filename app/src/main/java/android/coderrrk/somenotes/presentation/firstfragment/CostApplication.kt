package android.coderrrk.somenotes.presentation.firstfragment

import android.app.Application
import android.coderrrk.somenotes.data.sqlite.CostRepository
import android.coderrrk.somenotes.data.sqlite.CostRoomDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class CostApplication: Application(){

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { CostRoomDataBase.getDatabase(this, applicationScope) }
    val repository by lazy { CostRepository(database.costDao()) }

}