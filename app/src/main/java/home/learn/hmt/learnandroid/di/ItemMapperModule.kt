package home.learn.hmt.learnandroid.di

import home.learn.hmt.learnandroid.model.mapper.LyricItemMapper
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val itemMapperModule = module {
    single<LyricItemMapper>()
}