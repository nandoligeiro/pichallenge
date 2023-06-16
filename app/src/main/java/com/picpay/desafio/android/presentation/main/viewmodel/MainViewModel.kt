package com.picpay.desafio.android.presentation.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.picpay.desafio.android.R
import com.picpay.desafio.android.domain.user.usecase.GetUsersOrderedUseCase
import com.picpay.desafio.android.presentation.main.mapper.UserDomainToUiMapper
import com.picpay.desafio.android.presentation.main.model.UiUser
import com.picpay.desafio.android.presentation.state.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersOrderedUseCase,
    private val userDomainToUiMapper: UserDomainToUiMapper
) : ViewModel() {

    private val _userState = MutableStateFlow<ViewState<List<UiUser>>>(ViewState.Loading)
    val userState: StateFlow<ViewState<List<UiUser>>> = _userState

    fun getUsers() = viewModelScope.launch {

        try {
            val users = getUsersUseCase.getOrderedByUserName()
            _userState.value = ViewState.Success(userDomainToUiMapper.toUiUser(users))
        } catch (e: Exception) {
            _userState.value = ViewState.Error(
                IllegalStateException("${R.string.error_getusers} ${e.message}")
            )
        }
    }
}
