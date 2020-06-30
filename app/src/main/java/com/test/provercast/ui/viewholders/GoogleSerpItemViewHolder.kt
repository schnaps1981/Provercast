package com.test.provercast.ui.viewholders

import android.text.Html
import android.view.View
import android.view.ViewGroup
import com.test.provercast.global.BaseViewHolder
import com.test.provercast.repository.network.entity.GoogleSERP
import kotlinx.android.synthetic.main.serp_item.view.*

class GoogleSerpItemViewHolder(itemView: View, private val parent: ViewGroup) :
    BaseViewHolder<GoogleSERP>(itemView = itemView) {

    override fun bind(model: GoogleSERP) {
        with(itemView) {
            tvResultDescription.text = model.snippet
            tvResultTitle.text = model.title
            tvResultUrl.text= Html.fromHtml(model.url)
        }

    }
}