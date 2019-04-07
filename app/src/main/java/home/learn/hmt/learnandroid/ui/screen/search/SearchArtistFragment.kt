package home.learn.hmt.learnandroid.ui.screen.search

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.databinding.FragmentSearchArtistBinding
import home.learn.hmt.learnandroid.model.ArtistItem
import home.learn.hmt.learnandroid.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchArtistFragment : BaseFragment<FragmentSearchArtistBinding, SearchArtistViewModel>() {

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
        }

        viewModel?.apply {
            artists.observe(viewLifecycleOwner, Observer {
                adapterSearch.submitList(it)
            })
        }

        viewModel.start()
    }

    fun getSearchValue(value: ArtistItem) {}

    companion object {
        const val TAG = "SearchArtistFragment"
        fun newInstance() = SearchArtistFragment()
    }
}