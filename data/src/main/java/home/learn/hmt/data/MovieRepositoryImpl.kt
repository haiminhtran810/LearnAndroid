package home.learn.hmt.data

import home.learn.hmt.data.remote.api.MovieAPI
import home.learn.hmt.domain.model.Movie
import home.learn.hmt.domain.repository.MovieRepository
import io.reactivex.Single

class MovieRepositoryImpl(private val userApi:MovieAPI) : MovieRepository {
    override fun getTopRated(page: Int): Single<List<Movie>> {
        return userApi.getTopRated(page).map {
            it.results
        }
    }
}