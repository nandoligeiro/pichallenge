package com.picpay.desafio.android.presentation

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.R
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject


class MainViewModel (private val getUsersUseCase: GetUsersUseCase) : ViewModel() {

    private val _userData = MutableLiveData<List<User>>()
    val usersData: LiveData<List<User>> = _userData

    fun getUsers() = viewModelScope.launch {
        try {
            val users = getUsersUseCase()
            _userData.value = users
        } catch (e: Exception) {
            Log.d("MainViewModel", e.toString())
        }
    }
}
