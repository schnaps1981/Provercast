package com.test.provercast.repository.network.request

import com.test.provercast.app.Constants
import com.test.provercast.repository.network.entity.api.SearchResult
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface GoogleRequest {

    @GET("customsearch/v1")
    fun requestSerp(
        @Query("key") key: String = Constants.API_KEY,
        @Query("cx") cx: String = Constants.API_CX,
        @Query("q") q: String
    ) : Deferred<SearchResult>

}