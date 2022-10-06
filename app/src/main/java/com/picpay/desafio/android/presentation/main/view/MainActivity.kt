package com.picpay.desafio.android.presentation.main.view

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.data.response.user.UserResponse
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.presentation.main.viewmodel.MainViewModel
import com.picpay.desafio.android.common.RequestState
import com.picpay.desafio.android.domain.user.model.User
import com.picpay.desafio.android.presentation.main.model.UiUser
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val userAdapter by lazy { UserListAdapter() }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setRecyclerView()
        observeVMEvents()
        getUsers()
    }

    private fun getUsers() {
        viewModel.getUsers()
    }

    private fun setRecyclerView() {
        binding.recyclerView.run {
            adapter = userAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun observeVMEvents() {
        viewModel.userState.observe(this) { state ->
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
        }
    }

    private fun notifyAdapter(users: List<UiUser>) {
        hideLoading()
        userAdapter.submitList(users)
    }

    private fun showLoading() {
        binding.userListProgressBar.visibility = View.VISIBLE
    }

    private fun hideLoading() {
        binding.userListProgressBar.visibility = View.GONE
    }

    private fun handleError() {
        hideLoading()
        binding.recyclerView.visibility = View.GONE
        val message = getString(R.string.error)
        Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT)
            .show()
    }
}
