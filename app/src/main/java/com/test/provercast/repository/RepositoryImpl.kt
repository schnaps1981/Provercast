package com.test.provercast.repository

import com.test.provercast.app.App
import com.test.provercast.repository.database.LastResultDatabase
import com.test.provercast.repository.network.entity.GoogleSERP
import com.test.provercast.repository.network.request.GoogleRequest
import com.test.provercast.repository.network.request.ResultWrapper
import kotlinx.coroutines.CoroutineExceptionHandler
import java.lang.Exception
import javax.inject.Inject

class RepositoryImpl : Repository {
    @Inject
    lateinit var api: GoogleRequest

    @Inject
    lateinit var database: LastResultDatabase

    init {
        App.instance.inject(this)
    }

    override suspend fun fetchDatabase(): ResultWrapper<List<GoogleSERP>> {
        return try {
            val data = database.LastResultDao().fetchDatabase()
            if (data.isEmpty()) ResultWrapper.Empty
            ResultWrapper.Success(value = data)
        } catch (e: Exception) {
            ResultWrapper.Error(error = e)
        }
    }

    override suspend fun fetchNetwork(query: String): ResultWrapper<List<GoogleSERP>> {
        return try {
            val response = api.requestSerp(q = query).await()

            if (response.items.isNullOrEmpty())
                ResultWrapper.Empty
            else {
                val result = response.items.map { item ->
                    GoogleSERP(title = item.title, url = item.link, snippet = item.snippet)
                }
                database.LastResultDao().updateLastResult(result = result)
                ResultWrapper.Success(value = result)
            }
        } catch (e: Exception) {
            ResultWrapper.Error(error = e)
        }
    }

}