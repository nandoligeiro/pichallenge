package com.picpay.desafio.android.domain.result

sealed class DomainResult<out T> {
    data class Success<T>(val data: T) : DomainResult<T>()
    data class Error(val t: Throwable) : DomainResult<Nothing>()
}
