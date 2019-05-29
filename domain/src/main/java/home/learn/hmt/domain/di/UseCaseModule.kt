package home.learn.hmt.domain.di

import home.learn.hmt.domain.usecase.movie.GetTopRatedUseCase
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val useCaseModule = module {
    single<GetTopRatedUseCase>()
}