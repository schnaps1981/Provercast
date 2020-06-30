package com.test.provercast.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.test.provercast.R
import com.test.provercast.global.BaseAdapter
import com.test.provercast.global.BaseViewHolder
import com.test.provercast.repository.network.entity.GoogleSERP
import com.test.provercast.repository.network.entity.api.SearchResult
import com.test.provercast.ui.viewholders.GoogleSerpItemViewHolder

class GoogleSerpAdapter : BaseAdapter<GoogleSERP>() {
    private lateinit var itemViewHolder: GoogleSerpItemViewHolder

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<GoogleSERP> {
        itemViewHolder = GoogleSerpItemViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.serp_item, parent, false), parent
        )
        return itemViewHolder
    }
}