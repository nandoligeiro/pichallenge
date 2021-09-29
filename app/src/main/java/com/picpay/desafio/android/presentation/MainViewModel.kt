package com.picpay.desafio.android.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.usecase.GetUsersUseCase
import kotlinx.coroutines.launch

class MainViewModel(private val getUsersUseCase: GetUsersUseCase) : ViewModel() {

    private val _userState = MutableLiveData<RequestState<List<User>>>().apply {
        value = RequestState.Loading
    }

    val userState: LiveData<RequestState<List<User>>> = _userState

    fun getUsers() = viewModelScope.launch {
        try {
            val users = getUsersUseCase()
            _userState.value = RequestState.Success(users)
        } catch (e: Exception) {
            _userState.value = RequestState.Error(
                IllegalStateException("Error getUsers: $e")
            )
        }
    }
}

sealed class RequestState<out T> {
    object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error(
        val t: Throwable,
        var consumed: Boolean = false
    ) : RequestState<Nothing>()
}