package com.example.testleboncoin.ui.list

import androidx.databinding.ObservableBoolean
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testleboncoin.data.model.ItemsData
import com.example.testleboncoin.domain.ItemsRepository
import com.example.testleboncoin.utils.AppResult
import com.example.testleboncoin.utils.SingleLiveEvent
import kotlinx.coroutines.launch

class ItemsViewModel(private val repository : ItemsRepository) : ViewModel() {

    val showLoading = ObservableBoolean()
    val itemsList = MutableLiveData<List<ItemsData>>()
    val showError = SingleLiveEvent<String>()

    fun getAllItems() {
        showLoading.set(true)
        viewModelScope.launch {
            val result =  repository.getAllItems()

            showLoading.set(false)
            when (result) {
                is AppResult.Success -> {
                    itemsList.value = result.successData
                    showError.value = null
                }
                is AppResult.Error -> showError.value = result.exception.message
            }
        }
    }
}