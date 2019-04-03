package home.learn.hmt.domain.usecase.user

import home.learn.hmt.domain.Constant
import home.learn.hmt.domain.model.Lyric
import home.learn.hmt.domain.repository.MusicRepository
import home.learn.hmt.domain.usecase.UseCase
import io.reactivex.Single

class GetLyricUseCase constructor(private val musicRepository: MusicRepository) :
    UseCase<GetLyricUseCase.Params, Single<Lyric>>() {
    override fun createObservable(params: Params?): Single<Lyric> {
        params?.apply {
            return musicRepository.getLyrics(lyricId)
        }
        return Single.error(Throwable(Constant.PARAMS_ERROR))
    }

    override fun onCleared() {

    }

    data class Params(val lyricId: String)
}