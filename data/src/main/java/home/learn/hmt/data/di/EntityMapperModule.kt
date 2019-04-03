package home.learn.hmt.data.di

import home.learn.hmt.data.model.mapper.LyricEntityMapper
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val entityMapperModule = module {
    single<LyricEntityMapper>()
}