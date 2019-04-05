package home.learn.hmt.learnandroid.ui.screen.home

import androidx.lifecycle.MutableLiveData
import home.learn.hmt.domain.usecase.music.GetLyricUseCase
import home.learn.hmt.learnandroid.model.LyricItem
import home.learn.hmt.learnandroid.model.mapper.LyricItemMapper
import home.learn.hmt.learnandroid.rx.SchedulerProvider
import home.learn.hmt.learnandroid.ui.base.BaseViewModel

class HomeViewModel(
    private val getLyricUseCase: GetLyricUseCase,
    private val schedulerProvider: SchedulerProvider,
    private val lyricItemMapper: LyricItemMapper
) : BaseViewModel() {
    val lyric = MutableLiveData<LyricItem>()
    fun start() {
        compositeDisposable.add(getLyricUseCase.createObservable(GetLyricUseCase.Params("15449912"))
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .map { lyricItemMapper.mapToPresentation(it) }
            .subscribe({
                lyric.value = it
            }, {
                errorMessage.value = it.message
            })
        )
    }
}