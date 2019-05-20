package home.learn.hmt.learnandroid.ui.screen.newRelease

import android.os.Bundle
import home.learn.hmt.learnandroid.databinding.FragmentLoadMoreRefreshBinding
import home.learn.hmt.learnandroid.model.MovieItem
import home.learn.hmt.learnandroid.ui.base.BaseLoadMoreRefreshFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewReleaseFragment : BaseLoadMoreRefreshFragment<FragmentLoadMoreRefreshBinding, NewReleaseViewModel, MovieItem>() {
    override val viewModel by viewModel<NewReleaseViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
}