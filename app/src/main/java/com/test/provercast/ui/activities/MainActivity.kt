package com.test.provercast.ui.activities

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.test.provercast.R
import com.test.provercast.mvp.presenters.MainActivityPresenter
import com.test.provercast.mvp.views.MainActivityView
import com.test.provercast.repository.network.entity.GoogleSERP
import com.test.provercast.ui.adapters.GoogleSerpAdapter
import kotlinx.android.synthetic.main.activity_main.*
import moxy.MvpAppCompatActivity
import moxy.presenter.InjectPresenter

class MainActivity : MvpAppCompatActivity(), MainActivityView {
    @InjectPresenter
    lateinit var presenter: MainActivityPresenter

    private val adapter = GoogleSerpAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecycler()

        ibFind.setOnClickListener {
            presenter.search(etSearchQuery.text.toString())
        }
    }

    private fun initRecycler() {
        rvResultList.layoutManager = LinearLayoutManager(applicationContext)
        rvResultList.adapter = adapter
    }

    override fun showSnackbar(message: String) {
        val parentLayout: View? = findViewById(android.R.id.content)
        parentLayout?.let {
            val snack = Snackbar.make(it, message, Snackbar.LENGTH_INDEFINITE)
            snack.setAction("OK") { snack.dismiss() }
            snack.show()
        }
    }

    override fun showSnackbar(message: Int) {
        val parentLayout: View? = findViewById(android.R.id.content)
        parentLayout?.let {
            val snack = Snackbar.make(it, message, Snackbar.LENGTH_INDEFINITE)
            snack.setAction("OK") { snack.dismiss() }
            snack.show()
        }
    }

    override fun showList(items: List<GoogleSERP>) {
        adapter.updateItems(items)
    }

    override fun showNoItems(show: Boolean) {
        if (show) tvNoItems.visibility = View.VISIBLE else tvNoItems.visibility = View.GONE
    }

    override fun showProgress(show: Boolean) {
        if (show) pbContentLoading.visibility = View.VISIBLE else pbContentLoading.visibility = View.GONE
    }
}