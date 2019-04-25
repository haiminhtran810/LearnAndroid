package home.learn.hmt.domain.usecase.movie

import home.learn.hmt.domain.Constant
import home.learn.hmt.domain.model.Movie
import home.learn.hmt.domain.repository.MovieRepository
import home.learn.hmt.domain.usecase.UseCase
import io.reactivex.Single

class GetTopRatedUseCase(private val movieRepository: MovieRepository):
    UseCase<GetTopRatedUseCase.Params, Single<List<Movie>>>() {
    override fun createObservable(params: Params?): Single<List<Movie>> {
        params?.let {
            return movieRepository.getTopRated(it.page)
        }
        return Single.error(Throwable(Constant.PARAMS_ERROR))
    }

    override fun onCleared() {
    }

    data class Params(val page:Int)
}