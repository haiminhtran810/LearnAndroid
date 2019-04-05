package home.learn.hmt.learnandroid.ui.screen.search

import androidx.lifecycle.MutableLiveData
import home.learn.hmt.domain.usecase.music.GetLyricUseCase
import home.learn.hmt.domain.usecase.music.SearchArtistUseCase
import home.learn.hmt.learnandroid.model.ArtistItem
import home.learn.hmt.learnandroid.model.mapper.ArtistItemMapper
import home.learn.hmt.learnandroid.rx.SchedulerProvider
import home.learn.hmt.learnandroid.ui.base.BaseViewModel

class SearchArtistViewModel(
    private val searchArtistUseCase: SearchArtistUseCase,
    private val schedulerProvider: SchedulerProvider,
    private val artistItemMapper: ArtistItemMapper
) : BaseViewModel() {
    val artists = MutableLiveData<List<ArtistItem>>()
    fun start() {
        compositeDisposable.add(searchArtistUseCase.createObservable(SearchArtistUseCase.Params("c", 1))
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .map {
                artistItemMapper.mapToPresentation(it)
            }
            .subscribe({
                artists.value = it
            }, {
                errorMessage.value = it.message
            })
        )
    }
}