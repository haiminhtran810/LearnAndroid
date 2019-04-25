package home.learn.hmt.domain.repository

import home.learn.hmt.domain.model.Movie
import home.learn.hmt.domain.repository.base.Repository
import io.reactivex.Single

interface MovieRepository: Repository {
    fun getTopRated(page: Int): Single<List<Movie>>
}