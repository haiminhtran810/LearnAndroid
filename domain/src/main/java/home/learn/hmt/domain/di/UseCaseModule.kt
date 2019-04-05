package home.learn.hmt.domain.di

import home.learn.hmt.domain.usecase.music.GetLyricUseCase
import home.learn.hmt.domain.usecase.music.SearchArtistUseCase
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val useCaseModule = module {
    single<GetLyricUseCase>()
    single<SearchArtistUseCase>()
}