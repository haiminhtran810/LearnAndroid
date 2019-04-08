package home.learn.hmt.learnandroid.ui.screen.search

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.databinding.FragmentSearchArtistBinding
import home.learn.hmt.learnandroid.model.ArtistItem
import home.learn.hmt.learnandroid.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchArtistFragment : BaseFragment<FragmentSearchArtistBinding, SearchArtistViewModel>() {

    private var currentPage: Int = INITIAL_PAGE
    private var isReloading = false

    override val viewModel by viewModel<SearchArtistViewModel>()

    override val layoutId: Int
        get() = R.layout.fragment_search_artist

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapterSearch = SearchArtistAdapter(itemClickListener = {
            getSearchValue(it)
        })

        viewBinding.apply {
            rwSearch.apply {
                adapter = adapterSearch
                layoutManager = LinearLayoutManager(context)
            }

            refreshView.setOnRefreshListener {
                viewModel?.start()
            }

        }

        viewModel?.apply {
            artists.observe(viewLifecycleOwner, Observer {
                adapterSearch.submitList(it)
                viewBinding.refreshView.isRefreshing = false
            })
        }

        viewModel.start()
    }

    private fun resetData() {
        currentPage = INITIAL_PAGE

    }

    private fun getSearchValue(value: ArtistItem) {
        Toast.makeText(context, value.artistName, Toast.LENGTH_SHORT).show()
    }

    companion object {
        private const val INITIAL_PAGE = 1
        const val TAG = "SearchArtistFragment"
        fun newInstance() = SearchArtistFragment()
    }
}