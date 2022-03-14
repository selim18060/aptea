package com.example.testleboncoin

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import com.example.testleboncoin.data.model.ItemsData
import com.example.testleboncoin.domain.ItemsRepository
import com.example.testleboncoin.ui.list.ItemsViewModel
import com.example.testleboncoin.utils.AppResult
import com.nhaarman.mockitokotlin2.doAnswer
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import java.lang.Exception
import java.net.SocketException

@ExperimentalCoroutinesApi
class UserListTest {

    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    val repo = Mockito.mock(ItemsRepository::class.java)
    val vm = ItemsViewModel(repo)

    @Test
    fun testUserList() = runBlocking{

        Mockito.`when`(repo.getAllItems())
            .thenReturn(AppResult.Success(listOf(ItemsData(id = 1, 1,
                "accusamus beatae ad facilis cum similique qui sunt",
                "https://via.placeholder.com/600/92c952",
                "https://via.placeholder.com/150/92c952")))
                )

        vm.getAllItems()

        assert(vm.itemsList.value?.size == 1)
        }


    @Test
    fun testEmptyUserList() = runBlocking {

            Mockito.`when`(repo.getAllItems())
                .thenReturn(AppResult.Success(listOf()))

            vm.getAllItems()

            assert(vm.itemsList.value?.size == 0)
        }

}
