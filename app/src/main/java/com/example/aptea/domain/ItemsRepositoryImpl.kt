package com.example.aptea.domain

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import com.example.aptea.data.database.ItemsDao
import com.example.aptea.data.model.ItemsData
import com.example.aptea.network.service.ItemsApi
import com.example.aptea.utils.AppResult
import com.example.aptea.utils.NetworkManager.isOnline
import com.example.aptea.utils.Utils.handleApiError
import com.example.aptea.utils.Utils.handleSuccess
import com.example.aptea.utils.noNetworkConnectivityError
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemsRepositoryImpl(
    private val api: ItemsApi,
    private val context: Context,
    private val dao: ItemsDao
) :
    ItemsRepository {

    override suspend fun getAllItems(): AppResult<List<ItemsData>> {
        if (isOnline(context)) {
            return try {
                val response = api.getAllItems()
                if (response.isSuccessful) {
                    //save the data
                    response.body()?.let {
                        withContext(Dispatchers.IO) { dao.add(it) }
                    }
                    handleSuccess(response)
                } else {
                    handleApiError(response)
                }
            } catch (e: Exception) {
                AppResult.Error(e)
            }
        } else {
            //check in db if the data exists
            val data = getItemsDataFromCache()
            return if (data.isNotEmpty()) {
                Log.d(TAG, "from db")
                AppResult.Success(data)
            } else
            //no network
                context.noNetworkConnectivityError()
        }
    }

    private suspend fun getItemsDataFromCache(): List<ItemsData> {
        return withContext(Dispatchers.IO) {
            dao.findAll()
        }
    }

}