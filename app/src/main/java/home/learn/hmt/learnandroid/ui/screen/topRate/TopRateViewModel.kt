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

    private val PAGE_SIZE = 10
    private val INITIAL_LOAD_SIZE_HINT = 25

   /* private val config = android.arch.paging.PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setInitialLoadSizeHint(INITIAL_LOAD_SIZE_HINT)
        .setPageSize(PAGE_SIZE)
        .build()*/

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
}