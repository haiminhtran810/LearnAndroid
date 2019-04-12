package home.learn.hmt.learnandroid.ui.screen.topRated

import android.os.Bundle
import home.learn.hmt.learnandroid.databinding.FragmentLoadMoreRefreshBinding
import home.learn.hmt.learnandroid.model.MovieItem
import home.learn.hmt.learnandroid.ui.base.BaseLoadMoreRefreshFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class TopRatedFragment : BaseLoadMoreRefreshFragment<FragmentLoadMoreRefreshBinding, TopRatedViewModel, MovieItem>() {
    override val viewModel by viewModel<TopRatedViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}