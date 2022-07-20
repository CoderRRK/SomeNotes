package android.coderrrk.somenotes.presentation

import android.app.Application
import android.coderrrk.testfragment.data.CostRepository
import android.coderrrk.testfragment.data.CostRoomDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class CostApplication: Application(){

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { CostRoomDataBase.getDatabase(this, applicationScope) }
    val repository by lazy { CostRepository(database.costDao()) }

}