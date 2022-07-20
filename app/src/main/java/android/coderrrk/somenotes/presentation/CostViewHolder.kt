package android.coderrrk.somenotes.presentation




import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import somenotes.R


class CostViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    private val costItemView: TextView = itemView.findViewById(R.id.textView)

    fun bind(text: String?) {
        costItemView.text = text
    }

    companion object {
        fun create(parent: ViewGroup): CostViewHolder {
            val view: View = LayoutInflater.from(parent.context)
                .inflate(R.layout.recyclerview_item, parent, false)
            return CostViewHolder(view)
        }
    }

}
