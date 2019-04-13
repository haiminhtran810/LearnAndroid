package home.learn.hmt.learnandroid.di

import home.learn.hmt.learnandroid.model.mapper.ArtistItemMapper
import home.learn.hmt.learnandroid.model.mapper.LyricItemMapper
import home.learn.hmt.learnandroid.model.mapper.MovieItemMapper
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val itemMapperModule = module {
    single<LyricItemMapper>()
    single<ArtistItemMapper>()
    single<MovieItemMapper>()
}