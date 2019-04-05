package home.learn.hmt.learnandroid.ui.screen.search

import android.os.Bundle
import home.learn.hmt.learnandroid.R
import home.learn.hmt.learnandroid.databinding.FragmentSearchArtistBinding
import home.learn.hmt.learnandroid.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchArtistFragment : BaseFragment<FragmentSearchArtistBinding, SearchArtistViewModel>() {

    override val viewModel by viewModel<SearchArtistViewModel>()

    override val layoutId: Int
        get() = R.layout.fragment_search_artist

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.start()
    }

    companion object {
        const val TAG = "SearchArtistFragment"
        fun newInstance() = SearchArtistFragment()
    }
}