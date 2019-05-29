package home.learn.hmt.learnandroid.ui.screen.topRate

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import home.learn.hmt.domain.usecase.movie.GetTopRatedUseCase
import home.learn.hmt.learnandroid.model.MovieItem
import home.learn.hmt.learnandroid.model.mapper.MovieItemMapper
import home.learn.hmt.learnandroid.rx.SchedulerProvider
import home.learn.hmt.learnandroid.ui.base.BaseLoadMoreRefreshViewModel

class TopRateViewModel(
    private val movieItemMapper: MovieItemMapper,
    private val getTopRatedUseCase: GetTopRatedUseCase,

    private val schedulerProvider: SchedulerProvider
) : BaseLoadMoreRefreshViewModel<MovieItem>() {
    var postLivedata: LiveData<PagedList<MovieItem>>? = null

    init {
        val config = PagedList.Config.Builder()
            .setPageSize(30)
            .setEnablePlaceholders(false)
            .build()
        //postLivedata =
    }

    // Load More Code
    override fun loadData(page: Int) {
        addDisposable(getTopRatedUseCase.createObservable(GetTopRatedUseCase.Params(page))
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .map {
                movieItemMapper.mapToPresentation(it)
            }
            .subscribe({
                currentPage.value = page
                if (currentPage.value == 1) listItem.value?.clear()
                if (isRefreshing.value == true) resetLoadMore()
                val newList = listItem.value ?: arrayListOf()
                newList.addAll(it)
                listItem.value = newList
                onLoadSuccess(it?.size ?: 0)
            }, {
                onLoadFailData(it)
            })
        )
    }

    // Paging
    private fun initializePagedListBuilder(config: PagedList.Config): LivePagedListBuilder<String, MovieItem> {
        return null!!
    }
}