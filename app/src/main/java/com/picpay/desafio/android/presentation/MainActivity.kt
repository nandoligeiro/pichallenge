package com.picpay.desafio.android.presentation

import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.R
import com.picpay.desafio.android.domain.model.User
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

        setRecyclerView()
        observeVMEvents()
        getUsers()

    }

    private fun getUsers() {
        viewModel.getUsers()
    }

    private fun setRecyclerView() {
        recyclerView.run {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observeVMEvents() {
        viewModel.userState.observe(this, Observer { state ->
            when (state) {
                is RequestState.Loading -> {
                    showLoading()
                }
                is RequestState.Success -> {
                    notifyAdapter(state.data)
                }
                is RequestState.Error -> {
                    handleError()
                }
            }
        })
    }

    private fun notifyAdapter(users: List<User>) {
        hideLoading()
        userAdapter.users = users
    }

    private fun showLoading() {
        progressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        progressBar.visibility = View.GONE
    }

    private fun handleError() {
        hideLoading()
        recyclerView.visibility = View.GONE
        val message = getString(R.string.error)
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT)
            .show()

    }
}
