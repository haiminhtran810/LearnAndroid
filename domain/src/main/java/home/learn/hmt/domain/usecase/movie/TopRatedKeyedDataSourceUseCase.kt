package home.learn.hmt.domain.usecase.movie

import android.arch.paging.PageKeyedDataSource
import home.learn.hmt.domain.model.Movie
import home.learn.hmt.domain.repository.MovieRepository

class TopRatedKeyedDataSourceUseCase(private val movieRepository: MovieRepository) : PageKeyedDataSource<Int, Movie>() {
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        callback.onResult(movieRepository.getTopRated(1).map {
            it
        }.blockingGet(), null, 2)
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        callback.onResult(movieRepository.getTopRated(1).map {
            it
        }.blockingGet(), params.key + 1)
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
    }

}