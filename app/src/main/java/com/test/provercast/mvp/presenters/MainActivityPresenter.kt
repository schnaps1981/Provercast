package com.test.provercast.mvp.presenters

import com.test.provercast.R
import com.test.provercast.app.App
import com.test.provercast.mvp.views.MainActivityView
import com.test.provercast.repository.Repository
import com.test.provercast.repository.network.request.ResultWrapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.InjectViewState
import moxy.MvpPresenter
import javax.inject.Inject

@InjectViewState
class MainActivityPresenter : MvpPresenter<MainActivityView>() {
    @Inject
    lateinit var repository: Repository

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        App.instance.inject(this)

        GlobalScope.launch(Dispatchers.Main) {
            viewState.showProgress(show = true)
            val lastResult = repository.fetchDatabase()
            viewState.showProgress(show = false)
            when (lastResult) {
                is ResultWrapper.Success -> viewState.showList(lastResult.value)
                is ResultWrapper.Error -> lastResult.error.message?.let {
                    viewState.showSnackbar(
                        message = it
                    )
                }
                is ResultWrapper.Empty -> viewState.showNoItems(show = true)
            }
        }
    }

    fun search(text: String?) {

        if (text.isNullOrBlank())
            viewState.showSnackbar(R.string.queryIsEmpty)
        else {
            viewState.showNoItems(show = false)
            viewState.showProgress(show = true)

            GlobalScope.launch(Dispatchers.Main) {
                val netResult = repository.fetchNetwork(text)
                viewState.showProgress(show = false)
                when (netResult) {
                    is ResultWrapper.Success -> viewState.showList(netResult.value)
                    is ResultWrapper.Error ->
                        netResult.error.message?.let { viewState.showSnackbar(it)}
                    is ResultWrapper.Empty -> viewState.showSnackbar(R.string.no_items)
                }
            }
        }
    }

}