package android.coderrrk.somenotes.presentation

import android.coderrrk.testfragment.data.CostsDb
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class CostListAdapter: ListAdapter<CostsDb, CostViewHolder>(COST_COMPARATOR) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CostViewHolder {
        return CostViewHolder.create(parent)
    }

    override fun onBindViewHolder(holder: CostViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current.cost, current.price.toString())
    }

    companion object {
        private val COST_COMPARATOR = object : DiffUtil.ItemCallback<CostsDb>() {
            override fun areItemsTheSame(oldItem: CostsDb, newItem: CostsDb): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: CostsDb, newItem: CostsDb): Boolean {
                return oldItem.cost == newItem.cost && oldItem.price == newItem.price
            }
        }
    }

}