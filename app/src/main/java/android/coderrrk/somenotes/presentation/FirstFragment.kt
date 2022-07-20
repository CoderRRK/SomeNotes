package android.coderrrk.somenotes.presentation

import android.app.Activity

import android.coderrrk.testfragment.data.CostsDb

import android.content.Intent

import android.os.Bundle


import android.view.View
import android.widget.Toast

import androidx.fragment.app.Fragment


import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

import androidx.fragment.app.viewModels
import somenotes.R

class FirstFragment: Fragment(R.layout.first_fragment) {

    private val newCostActivityRequestCode = 1
    private val costViewModel: MainViewModel by viewModels {
        MainViewModelFactory((activity?.application as CostApplication).repository)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val recyclerView: RecyclerView? = getView()?.findViewById(R.id.recyclerview)
        val adapter = CostListAdapter()
        recyclerView?.adapter = adapter
        recyclerView?.layoutManager = LinearLayoutManager(activity?.applicationContext)

        costViewModel.allCosts.observe(viewLifecycleOwner, Observer { costDb ->
            costDb?.let { adapter.submitList(it) {} }
        })


        val fab: FloatingActionButton? = getView()?.findViewById(R.id.float_button)
        fab?.setOnClickListener {
            val intent = Intent(activity?.applicationContext, NewCostActivity::class.java)
            startActivityForResult(intent, newCostActivityRequestCode)
        }

        val fab2: FloatingActionButton? = getView()?.findViewById(R.id.float_button2)
        fab2?.setOnClickListener {
            costViewModel.deleteAll(costDb = CostsDb(cost = String()))
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == newCostActivityRequestCode && resultCode == Activity.RESULT_OK) {
            data?.getStringExtra(NewCostActivity.EXTRA_REPLY)?.let{ reply ->
                val costDb = CostsDb(reply)
                costViewModel.insert(costDb)
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


