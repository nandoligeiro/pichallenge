package com.picpay.desafio.android.presentation.main.viewmodel

import com.picpay.desafio.android.BaseViewModel
import com.picpay.desafio.android.common.RequestState
import com.picpay.desafio.android.domain.user.model.toUiUser
import com.picpay.desafio.android.domain.user.usecase.GetUsersUseCase
import com.picpay.desafio.android.presentation.main.model.UiUser
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getUsersUseCase: GetUsersUseCase) : BaseViewModel() {

    private val _userState = MutableStateFlow<RequestState<List<UiUser>>>(RequestState.Loading)
    val userState: StateFlow<RequestState<List<UiUser>>> = _userState

    fun getUsers() = launch {

        try {
            val users = getUsersUseCase.getOrderByUserName()
            _userState.value = RequestState.Success(users.map { it.toUiUser() })
        } catch (e: Exception) {
            _userState.value = RequestState.Error(
                IllegalStateException("Error getUsers: ${e.message}")
            )
        }
    }
}
