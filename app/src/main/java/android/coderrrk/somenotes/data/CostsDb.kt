package android.coderrrk.testfragment.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cost_table")
data class CostsDb(
    @PrimaryKey
    @ColumnInfo(name = "cost") val cost: String, @ColumnInfo(name = "price") val price: Double
)