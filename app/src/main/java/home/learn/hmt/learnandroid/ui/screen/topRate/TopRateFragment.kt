package home.learn.hmt.learnandroid.ui.screen.topRate

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import home.learn.hmt.learnandroid.databinding.FragmentLoadMoreRefreshBinding
import home.learn.hmt.learnandroid.model.MovieItem
import home.learn.hmt.learnandroid.ui.base.BaseLoadMoreRefreshFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopRateFragment :
    BaseLoadMoreRefreshFragment<FragmentLoadMoreRefreshBinding, TopRateViewModel, MovieItem>() {

    override val viewModel by viewModel<TopRateViewModel>()

    private lateinit var adapterSearch: TopRateAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapterSearch = TopRateAdapter { getSearchValue(it) }
        viewBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterSearch
        }

        viewModel.apply {
            firstLoad()
            listItem.observe(this@TopRateFragment, Observer {
                adapterSearch.submitList(it)
            })
        }
    }

    private fun getSearchValue(value: MovieItem) {
        Toast.makeText(context, value.id, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val TAG = "TopRateFragment"
        fun newInstance() = TopRateFragment()
    }
}