package com.picpay.desafio.android.presentation.state

sealed class ViewState<out T> {
    object Loading : ViewState<Nothing>()
    data class Success<T>(val data: T) : ViewState<T>()
    data class Error(
        val t: Throwable
    ) : ViewState<Nothing>()
}
