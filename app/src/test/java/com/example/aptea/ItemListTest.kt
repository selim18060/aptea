package com.example.aptea

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.aptea.data.model.ItemsData
import com.example.aptea.domain.ItemsRepository
import com.example.aptea.ui.list.ItemsViewModel
import com.example.aptea.utils.AppResult
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

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
