package com.test.provercast.repository.network.entity.api

data class SearchResult(
    val context: Context,
    val items: List<Item>?,
    val kind: String,
    val queries: Queries,
    val searchInformation: SearchInformation,
    val url: Url
)