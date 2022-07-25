package android.coderrrk.somenotes.presentation.firstfragment

import android.app.Activity
import android.coderrrk.somenotes.data.sqlite.CostsDb
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewModelScope
import somenotes.R
import java.lang.RuntimeException

class FirstFragment: Fragment(R.layout.first_fragment) {

    private val newCostActivityRequestCode = 1

    private val costViewModel: CostViewModel by viewModels {
        CostViewModelFactory((activity?.application as CostApplication).repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerViewAdapter()
        updateSum()

        val fab: FloatingActionButton? = getView()?.findViewById(R.id.float_button)
        fab?.setOnClickListener {
            val intent = Intent(activity?.applicationContext, NewCostActivity::class.java)
            startActivityForResult(intent, newCostActivityRequestCode)
            recyclerViewAdapter()
            updateSum()
        }

        val fab2: FloatingActionButton? = getView()?.findViewById(R.id.float_button2)
        fab2?.setOnClickListener {
            costViewModel.deleteAll()
            }
    }

    fun recyclerViewAdapter(){
        val recyclerView: RecyclerView? = getView()?.findViewById(R.id.recyclerview)
        val adapter = CostListAdapter()
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(activity?.applicationContext)

        costViewModel.allCosts.observe(viewLifecycleOwner, Observer { costDb ->
            costDb?.let { adapter.submitList(it) {} }
        })
    }


    fun updateSum(){
        val sum: TextView? = getView()?.findViewById(R.id.column4)
        costViewModel.allSumPrice.observe(viewLifecycleOwner, Observer { costDb ->
            costDb?.let {
                sum?.text = costDb.sum().toString() + " руб."
                Log.d("Size1", "" + costDb.sum())
            }
        })
        costViewModel.viewModelScope
        costViewModel.allCosts
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newCostActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewCostActivity.EXTRA_REPLY)?.let { reply ->
                val cost = reply
                data?.getStringExtra(NewCostActivity.EXTRA_REPLY2)?.let { reply2 ->
                    val price = reply2
                    if (price.toDoubleOrNull() == null){
                    RuntimeException("Price is null")
                    }else{
                        val costDb = CostsDb(cost, price.toDouble())
                        costViewModel.insert(costDb)
                    }
                }
            }
        }
        else {
            Toast.makeText(
                context,
                R.string.empty_not_saved,
                Toast.LENGTH_LONG
            ).show()
        }
    }
}


