package android.coderrrk.somenotes.presentation.firstfragment

import android.app.Application
import android.coderrrk.somenotes.data.sqlite.CostRepositoryImpl
import android.coderrrk.somenotes.data.sqlite.CostRoomDataBase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import android.coderrrk.somenotes.domain.CostRepository

class CostApplication: Application(){

    val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { CostRoomDataBase.getDatabase(this, applicationScope) }
    val repository by lazy { CostRepositoryImpl(database.costDao()) }

}