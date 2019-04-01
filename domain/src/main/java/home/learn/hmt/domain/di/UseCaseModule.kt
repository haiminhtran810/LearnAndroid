package home.learn.hmt.domain.di

import home.learn.hmt.domain.usecase.user.FindUserUseCase
import org.koin.dsl.module.module
import org.koin.experimental.builder.single

val useCaseModule = module {
    single<FindUserUseCase>()
}