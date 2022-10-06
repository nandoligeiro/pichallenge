package com.picpay.desafio.android.presentation.main.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.picpay.desafio.android.BaseViewModel
import com.picpay.desafio.android.common.RequestState
import com.picpay.desafio.android.domain.user.model.toUiUser
import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCase
import com.picpay.desafio.android.presentation.main.model.UiUser
import kotlinx.coroutines.launch

class MainViewModel(private val getUsersUseCase: GetUsersUseCase) : BaseViewModel() {

    private val _userState = MutableLiveData<RequestState<List<UiUser>>>().apply {
        value = RequestState.Loading
    }

    val userState: LiveData<RequestState<List<UiUser>>> = _userState

    fun getUsers() = launch {

        try {
            val users = getUsersUseCase()
            _userState.value = RequestState.Success(users.map { it.toUiUser() })
        } catch (e: Exception) {
            _userState.value = RequestState.Error(
                IllegalStateException("Error getUsers: $e")
            )
        }
    }
}
