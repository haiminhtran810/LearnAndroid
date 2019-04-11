package home.learn.hmt.data.di

import home.learn.hmt.data.model.mapper.ArtistEntityMapper
import home.learn.hmt.data.model.mapper.LyricEntityMapper
import home.learn.hmt.data.model.mapper.MovieEntityMapper
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val entityMapperModule = module {
    single<LyricEntityMapper>()
    single<ArtistEntityMapper>()
    single<MovieEntityMapper>()
}