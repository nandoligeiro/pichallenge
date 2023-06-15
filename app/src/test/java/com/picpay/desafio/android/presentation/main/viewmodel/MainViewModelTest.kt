package com.picpay.desafio.android.presentation.main.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.presentation.state.Result
import com.picpay.desafio.android.domain.user.model.User
import com.picpay.desafio.android.domain.user.usecase.GetUsersOrderedUseCase
import com.picpay.desafio.android.presentation.state.ViewState
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class MainViewModelTest {

    private lateinit var viewModel: MainViewModel

    @Mock
    private lateinit var useCase: GetUsersOrderedUseCase

    @Mock
    private lateinit var user: User

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        Dispatchers.setMain(StandardTestDispatcher())

        MockitoAnnotations.initMocks(this)
        viewModel = spy(MainViewModel(useCase))
    }

    @Test
    fun state_Loading_Test() = runBlockingTest {
        val currentState = viewModel.userState.value
        assertTrue(
            currentState is ViewState.Result.Loading
        )
    }

    @Test
    fun state_Success_Test() = runBlocking {
        whenever(useCase.getOrderedByUserName()).thenReturn(listOf(user))
        viewModel.getUsers()
        viewModel.userState.value.let {
            assertTrue(it is ViewState.Result.Success)
        }
    }

    @Test
    fun state_ERROR_Test() = runBlockingTest {
        whenever(useCase.getOrderedByUserName()).thenThrow(RuntimeException())
        viewModel.getUsers()
        viewModel.userState.value.let {
            assertTrue(it is ViewState.Result.Error)
        }
    }
}
