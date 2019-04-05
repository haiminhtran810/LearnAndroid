package home.learn.hmt.domain.usecase.music

import home.learn.hmt.domain.Constant
import home.learn.hmt.domain.model.Artist
import home.learn.hmt.domain.repository.MusicRepository
import home.learn.hmt.domain.usecase.UseCase
import io.reactivex.Single

class SearchArtistUseCase constructor(private val musicRepository: MusicRepository) :
    UseCase<SearchArtistUseCase.Params, Single<List<Artist>>>() {
    override fun createObservable(params: Params?): Single<List<Artist>> {
        params?.apply {
            return musicRepository.searchArtist(params.keySearch, params.page)
        }
        return Single.error(Throwable(Constant.PARAMS_ERROR))
    }

    override fun onCleared() {}

    data class Params(val keySearch: String, val page: Int)
}