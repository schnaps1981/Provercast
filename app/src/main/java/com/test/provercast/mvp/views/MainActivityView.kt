package com.test.provercast.mvp.views

import com.test.provercast.repository.network.entity.GoogleSERP
import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType

interface MainActivityView: MvpView {

    @StateStrategyType(SingleStateStrategy::class)
    fun showSnackbar(message: String)

    @StateStrategyType(SingleStateStrategy::class)
    fun showSnackbar(message: Int)

    @StateStrategyType(SingleStateStrategy::class)
    fun showList(items : List<GoogleSERP>)

    @StateStrategyType(SingleStateStrategy::class)
    fun showNoItems(show : Boolean)

    @StateStrategyType(SkipStrategy::class)
    fun showProgress(show : Boolean)

}