package com.test.provercast.repository

import com.test.provercast.repository.network.entity.GoogleSERP
import com.test.provercast.repository.network.request.ResultWrapper

interface Repository {
    suspend fun fetchDatabase() : ResultWrapper<List<GoogleSERP>>
    suspend fun fetchNetwork(query: String): ResultWrapper<List<GoogleSERP>>
}