package home.learn.hmt.learnandroid.ui.screen.search

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.databinding.FragmentLoadMoreRefreshBinding
import home.learn.hmt.learnandroid.databinding.FragmentSearchArtistBinding
import home.learn.hmt.learnandroid.model.ArtistItem
import home.learn.hmt.learnandroid.ui.base.BaseFragment
import home.learn.hmt.learnandroid.ui.base.BaseLoadMoreRefreshFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchArtistFragment :
    BaseLoadMoreRefreshFragment<FragmentLoadMoreRefreshBinding, SearchArtistViewModel, ArtistItem>() {

    override val viewModel by viewModel<SearchArtistViewModel>()

    private lateinit var adapterSearch: SearchArtistAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        adapterSearch = SearchArtistAdapter { getSearchValue(it) }
        viewBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapterSearch
        }

        viewModel.apply {
            firstLoad()
            listItem.observe(this@SearchArtistFragment, Observer {
                adapterSearch.submitList(it)
            })
        }
    }

    private fun getSearchValue(value: ArtistItem) {
        Toast.makeText(context, value.artistName, Toast.LENGTH_SHORT).show()
    }

    companion object {
        const val TAG = "SearchArtistFragment"
        fun newInstance() = SearchArtistFragment()
    }
}