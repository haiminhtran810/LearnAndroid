package home.learn.hmt.learnandroid.ui.base

import androidx.databinding.ViewDataBinding
import home.learn.hmt.learnandroid.R

abstract class BaseLoadMoreRefreshFragment<View : ViewDataBinding, ViewModel : BaseLoadMoreRefreshViewModel<Item>, Item> :
    BaseFragment<View, ViewModel>() {

    override val layoutId: Int
        get() = R.layout.fragment_load_more_refresh

    override fun handleShowLoading(isLoading: Boolean) {
        // use custom loading for load more and refreshing
    }
}