package com.picpay.desafio.android.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.spy
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.domain.model.User
import com.picpay.desafio.android.domain.usecase.GetUsersUseCase
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
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
    private lateinit var useCase: GetUsersUseCase

    @Mock
    private lateinit var user: User

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init() {
        Dispatchers.setMain(TestCoroutineDispatcher())

        MockitoAnnotations.initMocks(this)
        viewModel = spy(MainViewModel(useCase))
    }

    @Test
    fun state_Loading_Test() = runBlockingTest {
        val currentState = viewModel.userState.value
        assertTrue(
            currentState is RequestState.Loading
        )
    }

    @Test
    fun state_Success_Test() = runBlockingTest {
        whenever(useCase()).thenReturn(listOf(user))
        viewModel.getUsers()
        viewModel.userState.value.let {
            assertTrue(it is RequestState.Success)
        }
    }

    @Test
    fun state_ERROR_Test() = runBlockingTest {
        whenever(useCase()).thenThrow(RuntimeException())
        viewModel.getUsers()
        viewModel.userState.value.let {
            assertTrue(it is RequestState.Error)
        }
    }
}
