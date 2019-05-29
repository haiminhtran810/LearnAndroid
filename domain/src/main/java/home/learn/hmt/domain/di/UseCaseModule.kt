package home.learn.hmt.domain.di

import home.learn.hmt.domain.usecase.movie.GetTopRatedUseCase
import home.learn.hmt.domain.usecase.movie.TopRatedDataSourceFactory
import home.learn.hmt.domain.usecase.movie.TopRatedKeyedDataSourceUseCase
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val useCaseModule = module {
    single<GetTopRatedUseCase>()
    single<TopRatedDataSourceFactory>()
    single<TopRatedKeyedDataSourceUseCase>()
}