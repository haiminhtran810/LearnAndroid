package home.learn.hmt.learnandroid.ui.screen.topRate

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

    /*override fun loadData(page: Int) {
        addDisposable(searchArtistUseCase.createObservable(SearchArtistUseCase.Params("c", page))
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .map {
                artistItemMapper.mapToPresentation(it)
            }
            .subscribe({
                currentPage.value = page
                if (page == 1) {
                    listItem.value?.clear()
                }
                if (isRefreshing.value == true) resetLoadMore()

                val newList = if (listItem.value != null) listItem.value else ArrayList()
                newList?.addAll(it)
                listItem.value = newList
                onLoadSuccess(it.size)
            }, {
                onLoadFailData(it)
            })
        )
    }*/

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