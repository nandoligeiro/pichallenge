package com.picpay.desafio.android.presentation

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var progressBar: ProgressBar

    private var userAdapter = UserListAdapter()

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        progressBar = findViewById(R.id.user_list_progress_bar)

        showLoading()
        setRecyclerView()
        observeVMEvents()
        getUsers()

    }

    private fun getUsers(){
        viewModel.getUsers()
    }

    private fun setRecyclerView() {
        recyclerView.run {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observeVMEvents() {
        viewModel.usersData.observe(this, Observer {
            hideLoading()
            userAdapter.users = it
        })

    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
    }


    override fun onResume() {
        super.onResume()


//        service.getUsers()
//            .enqueue(object : Callback<List<User>> {
//                override fun onFailure(call: Call<List<User>>, t: Throwable) {
//                    val message = getString(R.string.error)
//
//                    progressBar.visibility = View.GONE
//                    recyclerView.visibility = View.GONE
//
//                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT)
//                        .show()
//                }
//
//                override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {
//                    progressBar.visibility = View.GONE
//
//                    adapter.users = response.body()!!
//                }
//            })
    }
}
